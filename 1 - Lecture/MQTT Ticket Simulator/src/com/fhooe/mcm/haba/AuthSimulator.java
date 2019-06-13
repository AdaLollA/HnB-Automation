package com.fhooe.mcm.haba;

import org.eclipse.paho.client.mqttv3.*;

import java.util.*;

public class AuthSimulator implements MqttCallback {
    MqttClient sender = null;

    Map<String, AuthCode> codes = new HashMap<>();

    public AuthSimulator() throws MqttException {
        this.codes.put(RFID.PHONE_1, null);
        this.codes.put(RFID.PHONE_2, null);

        this.sender = new MqttClient("tcp://192.168.12.1:1883", MqttClient.generateClientId());
        this.sender.connect();
    }

    public static void main(String[] args) throws MqttException, InterruptedException {

        MqttClient client = new MqttClient("tcp://192.168.12.1:1883", MqttClient.generateClientId());
        client.connect();
        System.out.println("RFID 2Factor Auth Code Simulator started");
        client.subscribe(Topic.RFID_RECOGNIZED);
        client.subscribe(Topic.CODE_CHECK);
        client.setCallback(new AuthSimulator());
        client.setTimeToWait(1);

        System.out.println("RFID 2Factor Auth Code Simulator running successfully");
        AuthSimulator.debug();
        while (true);
    }

    private static void debug() {
        /*Random rand2 = new Random();

        String code = String.valueOf(rand2.nextInt(9999 - 1000 + 1) + 1000);
        System.out.println("Debug Code sent: " + code);
        MqttMessage message = new MqttMessage(code.getValue());
        client.publish("rfid_2factor_code", message);*/
    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println(throwable.fillInStackTrace());
        System.out.println("Connection to MQTT broker lost!");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        String payload = new String(mqttMessage.getPayload());
        System.out.println("Message received: " + payload);
        System.out.println("Topic: " + s);

        this.recognized(s, payload);
        this.codeCheck(s, payload);
    }

    private void codeCheck(String topic, String pin) throws MqttException {
        if (topic.equals(Topic.CODE_CHECK)) {
            for (AuthCode code : this.codes.values()) {
                if (code != null && code.isSame(pin)) {
                    MqttMessage message;
                    message = new MqttMessage(code.createResponse());
                    this.sender.publish(Topic.CODE_CHECK_RESULT, message);
                    break;
                }
            }
        }
    }

    private void recognized(String topic, String rfID) throws MqttException {
        if (topic.equals(Topic.RFID_RECOGNIZED)
        && this.codes.containsKey(rfID)) {

            AuthCode code = new AuthCode(rfID);
            this.codes.put(rfID, code);
            MqttMessage message = new MqttMessage(code.getValue());
            this.sender.publish(Topic.TWO_FACTOR_CODE, message);
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}



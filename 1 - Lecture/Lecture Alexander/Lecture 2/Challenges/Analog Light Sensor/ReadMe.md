# Challenge: Analog Light Sensor
## Alexander Stelzhammer, S1810455024

This task was done with the help of Iris. To see her side of the documentation, please refer to [her documentation](../../../../Lecture%20Iris/Lecture%202/ReadMe.md#Analog%20Light%20Sensor).

### Task
Using an analog light sensor the current brightness should be plotted as both a gauge and as a chart.

### Setup
#### Light Sensor Configuration 
First, the light sensor needs to be configured. It uses the topic "light" (resulting in a total topic of "node1/light") to send a MQTT-message only if the value changed by more than 10.
The code can be seen below:
```c++
analog(light).with_precision(10);
```


#### Node-RED Setup
On node red, we subscribe to the topic "node1/light" to receive the messages sent by the light sensor. This message is then forwarded to the gauge and line chart display.
The configuration can be seen below:
![node_red_setup]

The exported JSON can be seen below:
```json
[
    {
        "id": "df453bf3.51ee98",
        "type": "mqtt in",
        "z": "b11e94d5.1453c",
        "name": "",
        "topic": "node1/light",
        "qos": "2",
        "datatype": "auto",
        "broker": "77293117.a8a4b",
        "x":170,
        "y":120,
        "wires":[
            [
                "5979e31d.90e28c",
                "9509ab7.bae1158"
            ]
        ]
    },
    {
        "id": "77293117.a8a4b",
        "type": "mqtt-broker",
        "z": "",
        "broker": "localhost",
        "port": "1883",
        "clientid": "",
        "usetls":false,
        "compatmode":true,
        "keepalive": "60",
        "cleansession":true,
        "birthTopic": "",
        "birthQos": "0",
        "birthPayload": "",
        "willTopic": "",
        "willQos": "0",
        "willPayload": ""
    }
]
```

[node_red_setup]: ./Challenge_LightSensor_NodeRED.PNG
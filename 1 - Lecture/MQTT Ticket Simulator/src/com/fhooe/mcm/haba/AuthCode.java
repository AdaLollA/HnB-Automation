package com.fhooe.mcm.haba;


import java.util.Date;
import java.util.Random;

public class AuthCode {
    private Date validUntil;
    private String value;
    private String phoneID;
    private static Random rand = new Random();

    public AuthCode() {
        Date now = new Date();
        this.validUntil = new Date(now.getTime() + (60 * 1000));
        this.value = AuthCode.generate();
    }

    public AuthCode(String rfID) {
        this();
        if (rfID == RFID.PHONE_1) { // lorenz
            this.phoneID = PhoneID.PHONE_1;
        } else if (rfID == RFID.PHONE_2) { // iris
            this.phoneID = PhoneID.PHONE_2;
        }
    }

    private static String generate() {
        return String.valueOf(
                rand.nextInt(9999 - 1000 + 1) + 1000
        );
    }

    public byte[] getValue() {
        return this.value.getBytes();
    }

    public boolean isSame(String code) {
        return this.value.equals(code);
    }

    public boolean stillValid() {
        return this.validUntil.after(new Date());
    }

    public byte[] createResponse() {
        String response;
        if (this.stillValid()) {
            response = "off";
        } else {
            response = "on";
        }
        return (response).getBytes();
    }
}

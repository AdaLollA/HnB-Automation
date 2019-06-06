package com.fhooe.mcm.haba;


import java.util.Date;
import java.util.Random;

public class AuthCode {
    private Date validUntil;
    private String value;
    private static Random rand = new Random();

    public AuthCode() {
        Date now = new Date();
        this.validUntil = new Date(now.getTime() + (60 * 1000));
        this.value = AuthCode.generate();
    }

    private static String generate() {
        return String.valueOf(
                rand.nextInt(9999 - 1000 + 1) + 1000
        );
    }

    public byte[] getValue() {
        return value.getBytes();
    }

    public boolean stillValid() {
        return this.validUntil.after(new Date());
    }

    public byte[] createResponse(String phoneID) {
        String response;
        if (this.stillValid()) {
            response = "pressed";
        } else {
            response = "depressed";
        }
        return (phoneID + ";" + response).getBytes();
    }
}

package com.sky;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Call {
    private String caller;
    private String receiver;
    private BigInteger callTime;

    public Call(String caller, String receiver, BigInteger callTime) {
        this.callTime = callTime;
        this.caller = caller;
        this.receiver = receiver;
    }
}

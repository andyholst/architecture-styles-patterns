package com.design.component;

public class PortImpl implements Port {
    @Override
    public boolean validateMessage(byte[] message) {
        return message.length > 0;
    }
}

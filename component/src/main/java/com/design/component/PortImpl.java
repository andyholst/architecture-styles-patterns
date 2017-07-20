package com.design.component;

public class PortImpl implements Port {
    @Override
    public boolean validateMessage(byte[] message) {
        return message.length > 0;
    }

    @Override
    public boolean writeMessage(byte[] message, Connector connector) {
        if (validateMessage(message)){
            connector.sendMessage(message);
            return true;
        }
        return false;
    }

    @Override
    public byte[] readMessage(byte[] message) {
        if (validateMessage(message)) {
            return message;
        }
        return new byte[0];
    }
}

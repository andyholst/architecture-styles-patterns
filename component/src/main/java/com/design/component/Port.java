package com.design.component;

public interface Port {
    boolean validateMessage(byte[] message);
    boolean writeMessage(byte[] message, Connector connector);
    byte[] readMessage(byte[] message);
}

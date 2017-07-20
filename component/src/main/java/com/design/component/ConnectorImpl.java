package com.design.component;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectorImpl implements Connector {

    private final Queue<byte[]> messageQueue;

    public ConnectorImpl() {
        messageQueue = new LinkedList<>();
    }

    @Override
    public void sendMessage(byte[] message) {
        messageQueue.add(message);
    }

    @Override
    public byte[] readMessage() {
        if (!messageQueue.isEmpty()) {
           return messageQueue.remove();
        }
        return new byte[0];
    }
}

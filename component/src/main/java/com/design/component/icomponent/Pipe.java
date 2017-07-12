package com.design.component.icomponent;

import java.util.LinkedList;
import java.util.Queue;

public class Pipe implements Connector {

    private byte[] message;

    Queue<byte[]> queue;

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    private boolean closed;

    public Pipe() {
        this.queue = new LinkedList<>();
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }

    @Override
    public void sendMessage() {
        if (message != null) {
            queue.add(message);
            message = null;
        }
    }

    public Queue<byte[]> getQueue() {
        return queue;
    }

    public boolean isClosed() {
        return closed;
    }
}

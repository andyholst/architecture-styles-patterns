package com.design.component.icomponent;

import java.util.LinkedList;
import java.util.Queue;

public class Pipe implements Connector {

    Queue<byte[]> queue;

    public boolean isPipeMessagePrepared() {
        return pipeMessagePrepared;
    }

    public void setPipeMessagePrepared(boolean pipeMessagePrepared) {
        this.pipeMessagePrepared = pipeMessagePrepared;
    }

    boolean pipeMessagePrepared;

    public void setClosed(boolean closed) {
        this.closed = closed;
    }


    private boolean closed;

    public Pipe() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void sendMessage(byte[] message) {
        if (message != null) {
            queue.add(message);
        }
    }

    public Queue<byte[]> getQueue() {
        return queue;
    }

    public boolean isClosed() {
        return closed;
    }
}

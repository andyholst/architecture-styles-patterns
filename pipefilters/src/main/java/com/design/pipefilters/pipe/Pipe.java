package com.design.pipefilters.pipe;

import com.design.component.Connector;

import java.util.LinkedList;
import java.util.Queue;

public class Pipe implements Connector {

    private Queue<byte[]> queue;
    private boolean pipeMessagePrepared;
    private boolean closed;

    public Pipe() {
        this.queue = new LinkedList<>();
    }

    public boolean isPipeMessagePrepared() {
        return pipeMessagePrepared;
    }

    public void setPipeMessagePrepared(boolean pipeMessagePrepared) {
        this.pipeMessagePrepared = pipeMessagePrepared;
    }

    @Override
    public void sendMessage(byte[] message) {
        if (message != null) {
            queue.add(message);
        }
    }

    @Override
    public byte[] readMessage() {
        if (!queue.isEmpty()) {
            return queue.remove();
        }
        return new byte[0];
    }

    public Queue<byte[]> getQueue() {
        return queue;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}

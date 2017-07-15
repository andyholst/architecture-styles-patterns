package com.design.pipefilter;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class PipeTest {

    @Test
    public void testPipe() {
        Pipe pipe = new Pipe();

        pipe.setPipeMessagePrepared(false);
        pipe.setClosed(false);

        assertEquals(false, pipe.isPipeMessagePrepared());
        assertEquals(false, pipe.isClosed());

        pipe.sendMessage("hello".getBytes());

        StringBuilder stringBuilder = new StringBuilder();

        while (!pipe.getQueue().isEmpty()) {
            stringBuilder.append(new String(pipe.getQueue().remove(), StandardCharsets.UTF_8));
        }

        assertEquals("hello", stringBuilder.toString());
    }
}

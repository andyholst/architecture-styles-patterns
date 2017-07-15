package com.design.pipefilters.filters;

import com.design.pipefilters.pipe.Pipe;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertNotNull;

public class CoreComponentTest {

    @Test
    public void testValidateMessage() {
        Pipe pipe = new Pipe();
        CoreComponent coreComponent = new CoreComponent(pipe);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.reset();

        coreComponent.appendMessage(byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testNextBytes() {
        Pipe pipe = new Pipe();
        CoreComponent coreComponent = new CoreComponent(pipe);

        byte[] bytes = coreComponent.setNextBytes();

        assertNotNull(bytes);
    }
}
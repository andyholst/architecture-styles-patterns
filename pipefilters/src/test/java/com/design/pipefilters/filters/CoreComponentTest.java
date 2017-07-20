package com.design.pipefilters.filters;

import com.design.component.PortImpl;
import com.design.pipefilters.pipe.Pipe;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class CoreComponentTest {

    @Test
    public void testValidateMessage() {
        Pipe pipe = new Pipe();
        CoreComponent coreComponent = new CoreComponent(pipe, new PortImpl());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.reset();

        coreComponent.appendMessage(byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testRunCoreComponentWithEmptyMessage() {
        Pipe pipe = new Pipe();
        CoreComponent coreComponent = new CoreComponent(pipe, new PortImpl());

        coreComponent.pipe.setPipeMessagePrepared(true);

        coreComponent.run();
    }
}
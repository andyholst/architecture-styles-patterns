package com.design.component;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComponentTest {

    @Test
    public void componentTest() {
        Component component = new ComponentImpl();

        assertNotNull(component.getConnector());
        assertNotNull(component.getPort());

        component.getPort().writeMessage("hello".getBytes(), component.getConnector());

        assertEquals(0, component.getPort().readMessage("".getBytes()).length);

        assertEquals("hello".getBytes().length, component.getPort().readMessage("hello".getBytes()).length);
        assertEquals(new byte[0].length, component.getPort().readMessage("".getBytes()).length);

        assertEquals(true, component.getPort().validateMessage("hello".getBytes()));
        assertEquals(false, component.getPort().validateMessage(new ByteArrayOutputStream().toByteArray()));

        assertEquals("hello", new String(component.getConnector().readMessage(), StandardCharsets.UTF_8));
    }

    @Test
    public void componentTestEmpty() {
        Component component = new ComponentImpl();

        assertNotNull(component.getConnector());
        assertNotNull(component.getPort());

        component.getPort().writeMessage("".getBytes(), component.getConnector());

        assertEquals(0, component.getPort().readMessage("".getBytes()).length);

        assertEquals("", new String(component.getConnector().readMessage(), StandardCharsets.UTF_8));
    }
}
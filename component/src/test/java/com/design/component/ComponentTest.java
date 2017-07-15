package com.design.component;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComponentTest {

    @Test
    public void componentTest() {
        Component component = new ComponentImpl();

        assertNotNull(component.getConnector());
        assertNotNull(component.getPort());

        component.getConnector().sendMessage("hello".getBytes());

        assertEquals(true, component.getPort().validateMessage("hello".getBytes()));
        assertEquals(false, component.getPort().validateMessage(new ByteArrayOutputStream().toByteArray()));
    }

}
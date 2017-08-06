/*
 * MIT License
 *
 * Copyright (c) 2017 Andy Holst
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.design.component;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComponentTestCase {

    /*@Test
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

        assertEquals(false, component.getPort().writeMessage("".getBytes(), component.getConnector()));

        assertEquals(0, component.getPort().readMessage("".getBytes()).length);

        assertEquals("", new String(component.getConnector().readMessage(), StandardCharsets.UTF_8));
    }*/
}
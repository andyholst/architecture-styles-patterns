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

import com.design.component.client.ClientComponent;
import com.design.component.core.CoreComponent;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class ComponentTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testComponentCommunication() {

        String jsonMessage = "{\"string\": \"This is a string\"}";

        ClientComponent clientComponent = new ClientComponent();

        CoreComponent coreComponent = new CoreComponent();

        clientComponent.attachComponent(coreComponent);

        clientComponent.sendMessage("".getBytes());

        clientComponent.sendMessage(jsonMessage.getBytes());

        assertEquals(jsonMessage, new String(coreComponent.getRecievedMessage(), StandardCharsets.UTF_8));

        coreComponent.attachComponent(clientComponent);

        coreComponent.sendMessage(jsonMessage.getBytes());

        assertEquals(jsonMessage, new String(clientComponent.getRecievedMessage(), StandardCharsets.UTF_8));

    }

}
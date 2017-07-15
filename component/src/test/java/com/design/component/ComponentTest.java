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
import com.design.pipefilter.Pipe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComponentTest {

    @Test
    public void testComponentCommunicationThroughPipeFilter() throws InterruptedException {
        String message = "012345678910";

        Pipe pipe = new Pipe();

        ClientComponent clientComponent = new ClientComponent();

        clientComponent.setConnector(pipe);

        CoreComponent coreComponent = new CoreComponent(pipe);

        assertEquals("", coreComponent.getMessage());

        clientComponent.start();

        coreComponent.start();

        while (!coreComponent.isPipeClosed()) {
            // Waiting
        }

        assertEquals(true, coreComponent.isPipeClosed());
        assertEquals(false, coreComponent.getMessage().isEmpty());

        assertEquals(message, coreComponent.getMessage());
    }
}
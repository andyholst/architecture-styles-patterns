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

package com.design.pipefilters;

import com.design.pipefilters.filters.ClientComponent;
import com.design.pipefilters.filters.CoreComponent;
import com.design.pipefilters.pipe.Pipe;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PipeFilterTest {

    @Test
    public void testComponentCommunicationThroughPipeFilter() throws InterruptedException {
        // test pipe and filters
        String message = "012345678910";

        Pipe pipe = new Pipe();

        pipe.sendMessage(null);

        ClientComponent clientComponent = new ClientComponent();

        clientComponent.setConnector(pipe);

        assertNull(clientComponent.getPort());
        assertNotNull(clientComponent.getConnector());

        CoreComponent coreComponent = new CoreComponent(pipe);

        assertNotNull(coreComponent.getPort());
        assertNotNull(coreComponent.getConnector());

        Assert.assertEquals("", coreComponent.getMessage());

        clientComponent.start();

        coreComponent.start();

        while (!coreComponent.isPipeClosed()) {
            // Waiting
        }

        Assert.assertEquals(true, coreComponent.isPipeClosed());
        Assert.assertEquals(false, coreComponent.getMessage().isEmpty());

        Assert.assertEquals(message, coreComponent.getMessage());
    }
}
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

import com.design.component.PortImpl;
import com.design.pipefilters.filters.ClientComponent;
import com.design.pipefilters.filters.CoreComponent;
import com.design.pipefilters.pipe.Pipe;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PipeFilterTestCase {

    @Test
    public void testComponentCommunicationThroughPipeFilter() throws InterruptedException, TimeoutException {
        String message = "012345678910";

        Pipe pipe = new Pipe();

        assertEquals("".length(), pipe.readMessage().length);

        pipe.sendMessage(null);
        pipe.setPipeMessagePrepared(false);

        ClientComponent clientComponent = new ClientComponent(pipe, new PortImpl());

        assertNotNull(clientComponent.getPort());
        assertNotNull(clientComponent.getConnector());

        CoreComponent coreComponent = new CoreComponent(pipe, new PortImpl());

        assertNotNull(coreComponent.getPort());
        assertNotNull(coreComponent.getConnector());

        Assert.assertEquals("", coreComponent.getMessage());

        clientComponent.start();

        LocalDateTime localDateTime = LocalDateTime.now();

        while (!clientComponent.isPipeMessagePrepared()) {
            LocalDateTime localDateTimeNow = LocalDateTime.now();
            if (ChronoUnit.SECONDS.between(localDateTime, localDateTimeNow) > 60) {
                throw new TimeoutException();
            }
        }

        coreComponent.start();

        localDateTime = LocalDateTime.now();

        while (!coreComponent.isPipeClosed()) {
            LocalDateTime localDateTimeNow = LocalDateTime.now();
            if (ChronoUnit.SECONDS.between(localDateTime, localDateTimeNow) > 60) {
                throw new TimeoutException();
            }
        }

        Assert.assertEquals(true, coreComponent.isPipeClosed());
        Assert.assertEquals(false, coreComponent.getMessage().isEmpty());

        Assert.assertEquals(message, coreComponent.getMessage());
    }

    @Test
    public void testComponentCommunicationThroughPipeFilterWithNullData() throws InterruptedException, TimeoutException {

        Pipe pipe = new Pipe();

        pipe.sendMessage(null);
        pipe.setPipeMessagePrepared(false);

        CoreComponent coreComponent = new CoreComponent(pipe, new PortImpl());

        assertNotNull(coreComponent.getPort());
        assertNotNull(coreComponent.getConnector());

        Assert.assertEquals("", coreComponent.getMessage());

        coreComponent.start();

        LocalDateTime localDateTime = LocalDateTime.now();

        while (!coreComponent.isPipeClosed()) {
            LocalDateTime localDateTimeNow = LocalDateTime.now();
            if (ChronoUnit.SECONDS.between(localDateTime, localDateTimeNow) > 60) {
                throw new TimeoutException();
            }
        }

        Assert.assertEquals(true, coreComponent.isPipeClosed());
        Assert.assertEquals(true, coreComponent.getMessage().isEmpty());
    }
}
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

package com.design.pipefilters.filters;

import com.design.component.Component;
import com.design.component.Connector;
import com.design.component.Port;
import com.design.component.PortImpl;
import com.design.pipefilters.pipe.Pipe;

import java.nio.charset.StandardCharsets;

public class CoreComponent extends Thread implements Component {

    private StringBuilder message;
    private Pipe pipe;
    private Port port;

    public CoreComponent(Pipe pipe) {
        this.pipe = pipe;
        message = new StringBuilder();
        port = new PortImpl();
    }

    public boolean isPipeClosed() {
        return pipe.isClosed();
    }

    public String getMessage() {
        return message.toString().trim();
    }

    @Override
    public void run() {
        while (!pipe.isClosed()) {
            if (pipe.isPipeMessagePrepared()) {
                byte[] bytes = pipe.getQueue().remove();

                if (port.validateMessage(bytes)) {
                    message.append(new String(bytes, StandardCharsets.UTF_8));
                }

                if (pipe.getQueue().isEmpty()) {
                    pipe.setClosed(true);
                }
            }
        }
    }

    @Override
    public Connector getConnector() {
        return pipe;
    }

    @Override
    public Port getPort() {
        return port;
    }
}

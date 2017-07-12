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

package com.design.component.core;


import com.design.component.icomponent.Component;
import com.design.component.icomponent.Pipe;

import java.nio.charset.StandardCharsets;

public class CoreComponent extends Thread implements Component {
    StringBuilder message;
    Pipe pipe;

    public CoreComponent(Pipe pipe) {
        this.pipe = pipe;
        this.message = new StringBuilder();
    }

    public String getMessage() {
        return message.toString();
    }

    @Override
    public void run() {
        while (!pipe.isClosed() || !pipe.getQueue().isEmpty()) {
            if (!pipe.getQueue().isEmpty()) {
                message.append(new String(pipe.getQueue().remove(), StandardCharsets.UTF_8));
                pipe.setClosed(true);
            }
        }
    }
}

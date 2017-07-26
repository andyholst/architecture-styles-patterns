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

package com.design.layered;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.nio.charset.StandardCharsets;

public class BusinessLayer implements Layer {

    private byte[] message;

    BusinessLayer(ClientLayer clientLayer) {
        message = clientLayer.getMessage();
    }

    public boolean clientJsonMessageValid() {
        try {
            JsonParser jsonParser = new JsonParser();
            jsonParser.parse(new String(message, StandardCharsets.UTF_8));
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }
}

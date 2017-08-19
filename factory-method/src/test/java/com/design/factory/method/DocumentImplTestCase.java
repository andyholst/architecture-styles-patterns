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

package com.design.factory.method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentImplTestCase {

    private Document document;

    private void init() {
        document = new DocumentImpl();
    }

    @Test
    public void testOpen() throws Exception {
        init();
        assertEquals(null, document.getState());
        document.open();
        assertEquals(DocumentImpl.DocumentEnum.OPEN, DocumentImpl.DocumentEnum.valueOf(document.getState()));
    }

    @Test
    public void testClose() throws Exception {
        init();
        assertEquals(null, document.getState());
        document.close();
        assertEquals(DocumentImpl.DocumentEnum.CLOSED, DocumentImpl.DocumentEnum.valueOf(document.getState()));
    }

    @Test
    public void testSave() throws Exception {
        init();
        assertEquals(null, document.getState());
        document.save();
        assertEquals(DocumentImpl.DocumentEnum.SAVED, DocumentImpl.DocumentEnum.valueOf(document.getState()));
    }

    @Test
    public void testRevert() throws Exception {
        init();
        assertEquals(null, document.getState());
        document.revert();
        assertEquals(DocumentImpl.DocumentEnum.REVERTED, DocumentImpl.DocumentEnum.valueOf(document.getState()));
    }

}
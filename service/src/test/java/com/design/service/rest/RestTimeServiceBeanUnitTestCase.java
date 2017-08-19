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

package com.design.service.rest;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestTimeServiceBeanUnitTestCase {
    @Test
    public void testCurrentTime() {
        Time time = new RestTimeServiceBean();
        String currentTime = time.getCurrentTime();
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

        Matcher matcher = pattern.matcher(currentTime);

        assertEquals(true, matcher.matches());
    }

    @Test
    public void testRestServiceBeanTest() {
        RestTimeServiceBean restTimeServiceBean = new RestTimeServiceBean();

        String currentTime = restTimeServiceBean.getCurrentSystemTime();

        assertEquals(true, !currentTime.isEmpty());

        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

        Matcher matcher = pattern.matcher(currentTime);

        assertEquals(true, matcher.matches());
    }
}
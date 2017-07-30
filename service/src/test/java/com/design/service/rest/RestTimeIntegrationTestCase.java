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

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.net.MalformedURLException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class RestTimeIntegrationTestCase {
    private static final Logger log = Logger.getLogger(RestTimeIntegrationTestCase.class.getName());

    @EJB(mappedName = "java:app/rest/RestTimeServiceBean")
    private static TimeLocalBusiness timeLocalBusiness;

    @Deployment
    public static JavaArchive createDeployment() throws MalformedURLException {
        final JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "rest.jar").addPackage(
                TimeImpl.class.getPackage());
        log.info(archive.toString(true));
        return archive;
    }

    @Test
    public void testRestTimeServiceBean() {
        String currentSystemTime = timeLocalBusiness.getCurrentTime();

        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

        Matcher matcher = pattern.matcher(currentSystemTime);

        assertEquals(true, matcher.matches());
    }

}

package com.pi4j.test.provider;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: UNITTEST :: Unit/Integration Tests
 * FILENAME      :  ManualProvidersTest.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2019 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.Pi4J;
import com.pi4j.exception.Pi4JException;
import com.pi4j.io.i2c.I2CProvider;
import com.pi4j.io.pwm.PwmProvider;
import com.pi4j.test.About;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class ManualProvidersTest {

    @Before
    public void beforeTest() throws Pi4JException {
        // Initialize Pi4J with AUTO-DETECT disabled
        // we don't want to load any detected Pi4J binding/io libraries
        // in the class path for this test case
        Pi4J.initialize(false);
    }

    @After
    public void afterTest()  {
        try {
            Pi4J.terminate();
        } catch (Pi4JException e) { /* do nothing */ }
    }

    @Test
    public void testProvidersNotNull() throws Pi4JException {
        // ensure that the io collection in the Pi4J context is not NULL
        assertNotNull(Pi4J.context().providers());
    }

    @Test
    public void testProvidersCount() throws Exception {

        // create our own custom provider implementation classes
        PwmProvider pwmProvider = new TestPwmProvider();
        I2CProvider i2CProvider = new TestI2CProvider();

        // add the custom providers to the Pi4J context
        Pi4J.providers().add(pwmProvider, i2CProvider);

        // ensure that no io were detected/loaded into the Pi4J context
        assertEquals(Pi4J.context().providers().all().size(), 2);

        // print out the detected Pi4J io libraries found on the class path
        About about = new About();
        about.enumerateProviders("2 CUSTOM PROVIDERS (added via API)");
    }
}

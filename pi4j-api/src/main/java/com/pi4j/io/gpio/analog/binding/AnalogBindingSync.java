package com.pi4j.io.gpio.analog.binding;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  AnalogBindingSync.java
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

import com.pi4j.io.exception.IOBoundsException;
import com.pi4j.io.exception.IOIllegalValueException;
import com.pi4j.io.gpio.analog.AnalogChangeEvent;
import com.pi4j.io.gpio.analog.AnalogOutput;

public class AnalogBindingSync extends AnalogBindingBase implements AnalogBinding<AnalogOutput> {

    /**
     * Default Constructor
     * @param output Variable argument list of analog outputs
     */
    public AnalogBindingSync(AnalogOutput ... output){
        super(output);
    }

    @Override
    public void process(AnalogChangeEvent event) {
        outputs.forEach((output)->{
            try {
                ((AnalogOutput)output).value(event.value());
            } catch (IOIllegalValueException e) {
                e.printStackTrace();
            } catch (IOBoundsException e) {
                e.printStackTrace();
            }
        });
    }
}

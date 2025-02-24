package com.pi4j.io.gpio.digital.impl;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  DefaultDigitalOutputBuilder.java
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

import com.pi4j.config.impl.AddressConfigBuilderBase;
import com.pi4j.io.gpio.digital.DigitalOutputBuilder;
import com.pi4j.io.gpio.digital.DigitalOutputConfig;
import com.pi4j.io.gpio.digital.DigitalState;

public class DefaultDigitalOutputBuilder
        extends AddressConfigBuilderBase<DigitalOutputBuilder, DigitalOutputConfig>
        implements DigitalOutputBuilder {

    /**
     * PRIVATE CONSTRUCTOR
     */
    protected DefaultDigitalOutputBuilder(){
        super();
    }

    @Override
    public DigitalOutputBuilder shutdown(DigitalState state) {
        this.properties.put(DigitalOutputConfig.SHUTDOWN_STATE_KEY, state.toString());
        return this;
    }

    @Override
    public DigitalOutputBuilder initial(DigitalState state) {
        this.properties.put(DigitalOutputConfig.INITIAL_STATE_KEY, state.toString());
        return this;
    }

    @Override
    public DigitalOutputConfig build() {
        DigitalOutputConfig config = new DefaultDigitalOutputConfig(properties);
        return config;
    }
}

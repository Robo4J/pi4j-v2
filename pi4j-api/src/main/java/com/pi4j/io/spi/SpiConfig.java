package com.pi4j.io.spi;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  SpiConfig.java
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

import com.pi4j.config.impl.DeviceConfigBase;
import com.pi4j.io.IOConfig;

public class SpiConfig extends DeviceConfigBase<SpiConfig> implements IOConfig<SpiConfig> {

    SpiMode mode = Spi.DEFAULT_SPI_MODE;
    int speed = Spi.DEFAULT_SPI_SPEED;

    public SpiConfig(){
        super();
    }

    public SpiConfig(String device) {
        //super(device);
    }

    public SpiConfig(String device, int speed) {
        //super(device);
        this.speed = speed;
    }

    public SpiConfig(String device, int speed, SpiMode mode) {
        //super(device);
        this.speed = speed;
        this.mode = mode;
    }

    public SpiMode mode() { return this.mode; };
    public SpiConfig mode(SpiMode mode) { this.mode = mode; return this; }

    public int speed() { return this.speed; };
    public SpiConfig speed(int speed) { this.speed = speed; return this; }
}

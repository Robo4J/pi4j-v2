package com.pi4j.provider;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  ProviderType.java
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

import com.pi4j.config.Config;
import com.pi4j.io.IO;
import com.pi4j.io.gpio.analog.*;
import com.pi4j.io.gpio.digital.*;
import com.pi4j.io.i2c.I2CConfig;
import com.pi4j.io.i2c.I2CProvider;
import com.pi4j.io.pwm.Pwm;
import com.pi4j.io.pwm.PwmConfig;
import com.pi4j.io.pwm.PwmProvider;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialProvider;
import com.pi4j.io.spi.Spi;
import com.pi4j.io.spi.SpiProvider;

public enum ProviderType {

    ANALOG_INPUT(AnalogInputProvider.class, AnalogInput.class, AnalogInputConfig.class),
    ANALOG_OUTPUT(AnalogOutputProvider.class, AnalogOutput.class, AnalogOutputConfig.class),
    DIGITAL_INPUT(DigitalInputProvider.class, DigitalInput.class, DigitalInputConfig.class),
    DIGITAL_OUTPUT(DigitalOutputProvider.class, DigitalOutput.class, DigitalOutputConfig.class),
    PWM(PwmProvider.class, Pwm.class, PwmConfig.class),
    I2C(I2CProvider.class, com.pi4j.io.i2c.I2C.class, I2CConfig.class),
    SPI(SpiProvider.class, Spi.class, I2CConfig.class),
    SERIAL(SerialProvider.class, Serial.class, SerialConfig.class);

    private Class<? extends Provider> providerClass;
    private Class<? extends IO> ioClass;
    private Class<? extends Config> configClass;

    ProviderType(Class<? extends Provider> providerClass, Class<? extends IO> ioClass, Class<? extends Config> configClass) {
        this.providerClass = providerClass;
        this.ioClass = ioClass;
        this.configClass = configClass;
    }

    public Class<? extends Provider> getProviderClass() {
        return providerClass;
    }
    public Class<? extends IO> getIOClass() {
        return ioClass;
    }
    public Class<? extends Config> getConfigClass() {
        return configClass;
    }

    public boolean isType(ProviderType type){
        return type == this;
    }

    public static Class<? extends IO> getIOClass(ProviderType type){
        for(var typeInstance : ProviderType.values()){
            if(typeInstance.equals(type)){
                return typeInstance.getIOClass();
            }
        }
        return null;
    }

    public static Class<? extends Provider> getProviderClass(ProviderType type){
        for(var typeInstance : ProviderType.values()){
            if(typeInstance.equals(type)){
                return typeInstance.getProviderClass();
            }
        }
        return null;
    }

    public static Class<? extends Config> getConfigClass(ProviderType type){
        for(var typeInstance : ProviderType.values()){
            if(typeInstance.equals(type)){
                return typeInstance.getConfigClass();
            }
        }
        return null;
    }

    public static ProviderType getProviderType(String name){
        for(var type : ProviderType.values()){
            if(type.name().equalsIgnoreCase(name)){
                return type;
            }
        }
        return null;
    }

    public static ProviderType getProviderType(Class<? extends Provider> providerClass){
        for(var type : ProviderType.values()){
            if(type.getProviderClass().isAssignableFrom(providerClass)){
                return type;
            }
        }
        return null;
    }

    public static ProviderType getProviderTypeByIOClass(Class<? extends IO> ioClass){
        for(var type : ProviderType.values()){
            if(type.getIOClass().isAssignableFrom(ioClass)){
                return type;
            }
        }
        return null;
    }

    public static ProviderType getProviderTypeByConfigClass(Class<? extends Config> configClass){
        for(var type : ProviderType.values()){
            if(type.getConfigClass().isAssignableFrom(configClass)){
                return type;
            }
        }
        return null;
    }
}

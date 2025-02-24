package com.pi4j.io.gpio.analog.impl;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  AnalogConfigBase.java
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

import com.pi4j.config.impl.AddressConfigBase;
import com.pi4j.io.gpio.analog.AnalogConfig;
import com.pi4j.io.gpio.analog.AnalogRange;

import java.util.Map;

public abstract class AnalogConfigBase<CONFIG_TYPE extends AnalogConfig>
        extends AddressConfigBase<CONFIG_TYPE>
        implements AnalogConfig<CONFIG_TYPE> {

    // private configuration properties
    protected AnalogRange range = new DefaultAnalogRange();

    /**
     * PRIVATE CONSTRUCTOR
     */
    protected AnalogConfigBase(){
        super();
    }

    /**
     * PRIVATE CONSTRUCTOR
     * @param properties
     */
    protected AnalogConfigBase(Map<String,String> properties){
        super(properties);

        // load range value property
        if(properties.containsKey(RANGE_MIN_KEY) || properties.containsKey(RANGE_MAX_KEY)){
            // load optional range properties
            Integer min = null;
            Integer max = null;
            if(properties.containsKey(RANGE_MIN_KEY))
                min = Integer.parseInt(properties.get(RANGE_MIN_KEY));
            if(properties.containsKey( RANGE_MAX_KEY))
                max = Integer.parseInt(properties.get(RANGE_MAX_KEY));

            // create new range from loaded properties
            if(min != null || max != null)
                this.range = new DefaultAnalogRange(min, max);
        }
    }

    @Override
    public AnalogRange range() {
        return this.range;
    }
}

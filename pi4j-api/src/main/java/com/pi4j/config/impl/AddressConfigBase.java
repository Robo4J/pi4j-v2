package com.pi4j.config.impl;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  AddressConfigBase.java
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

import com.pi4j.config.AddressConfig;
import com.pi4j.config.Config;
import com.pi4j.config.ConfigBase;
import com.pi4j.config.exception.ConfigMissingRequiredKeyException;

import java.util.Map;

public abstract class AddressConfigBase<CONFIG_TYPE extends Config>
        extends ConfigBase<CONFIG_TYPE>
        implements AddressConfig<CONFIG_TYPE> {

    // private configuration properties
    protected Integer address = null;

    /**
     * PRIVATE CONSTRUCTOR
     */
    protected AddressConfigBase(){
        super();
    }

    /**
     * PRIVATE CONSTRUCTOR
     * @param properties
     */
    protected AddressConfigBase(Map<String,String> properties){
        super(properties);

        // load address property
        if(properties.containsKey(ADDRESS_KEY)){
            this.address = Integer.parseInt(properties.get(ADDRESS_KEY));
        } else {
            throw new ConfigMissingRequiredKeyException(ADDRESS_KEY);
        }
    }

    public Integer address() {
        return this.address;
    };
}

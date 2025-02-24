package com.pi4j.io.gpio.analog;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  AnalogBase.java
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

import com.pi4j.context.Context;
import com.pi4j.io.gpio.GpioBase;
import com.pi4j.io.gpio.analog.binding.AnalogBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AnalogBase<ANALOG_TYPE extends Analog<ANALOG_TYPE, CONFIG_TYPE>, CONFIG_TYPE extends AnalogConfig<CONFIG_TYPE>>
        extends GpioBase<ANALOG_TYPE, CONFIG_TYPE>
        implements Analog<ANALOG_TYPE, CONFIG_TYPE> {

    // internal listeners collection
    protected List<AnalogChangeListener> listeners = Collections.synchronizedList(new ArrayList<>());

    // internal bindings collection
    protected List<AnalogBinding> bindings = Collections.synchronizedList(new ArrayList<>());

    public AnalogBase(CONFIG_TYPE config){
        super(config);
    }

    @Override
    public ANALOG_TYPE addListener(AnalogChangeListener... listener) {
        listeners.addAll(Arrays.asList(listener));
        return (ANALOG_TYPE)this;
    }

    @Override
    public ANALOG_TYPE removeListener(AnalogChangeListener... listener) {
        listeners.removeAll(Arrays.asList(listener));
        return (ANALOG_TYPE)this;
    }

    @Override
    public ANALOG_TYPE bind(AnalogBinding... binding) {
        bindings.addAll(Arrays.asList(binding));
        return (ANALOG_TYPE)this;
    }

    @Override
    public ANALOG_TYPE unbind(AnalogBinding ... binding) {
        bindings.removeAll(Arrays.asList(binding));
        return (ANALOG_TYPE)this;
    }

    /**
     * Dispatch AnalogInputEvent on analog input changes
     * @param event AnalogInputEvent
     */
    protected void dispatch(AnalogChangeEvent event){
        listeners.forEach((listener) -> {
            listener.onChange(event);
        });
        bindings.forEach((binding) -> {
            binding.process(event);
        });
    }

    @Override
    public ANALOG_TYPE terminate(Context context){
        // remove all listeners
        listeners.clear();

        // remove all bindings
        bindings.clear();

        // return this instance
        return (ANALOG_TYPE) this;
    }

}

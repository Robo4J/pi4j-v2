package com.pi4j.annotation.processor.register;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  DigitalChangeListenerProcessor.java
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

import com.pi4j.annotation.Register;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.Digital;
import com.pi4j.io.gpio.digital.DigitalChangeListener;
import com.pi4j.registry.exception.RegistryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class DigitalChangeListenerRegistrationProcessor implements RegisterProcessor<DigitalChangeListener> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean isEligible(Context context, Object instance, Register annotation, Field field) throws Exception {

        // make sure this field is of type 'DigitalChangeListener'
        if(!DigitalChangeListener.class.isAssignableFrom(field.getType()))
            return false;

        // make sure the field instance is not null; the 'DigitalChangeListener' must have an instance already defined
        if(field.get(instance) == null){
            return false;
        }

        // this processor can process this annotated instance
        return true;
    }

    @Override
    public DigitalChangeListener process(Context context, Object instance, Register annotation, Field field) throws Exception {

        DigitalChangeListener listener = (DigitalChangeListener) field.get(instance);
        if(listener != null) {

            // test to determine if the I/O instance exists in the registry by 'ID'
            if(!context.registry().exists(annotation.value(), Digital.class))
                throw new RegistryNotFoundException(annotation.value());

            // get I/O instance from registry
            Digital io = context.registry().get(annotation.value(), Digital.class);

            // add the obtained annotated listener instance to the I/O instance
            io.addListener(listener);
        }

        // in this case we don't want to assign the annotated instance value, so we return null
        return null;
    }
}

package com.pi4j.annotation.processor.injector;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  InjectorProcessor.java
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

import com.pi4j.annotation.Inject;
import com.pi4j.annotation.processor.FieldProcessor;
import com.pi4j.context.Context;

import java.lang.reflect.Field;

public interface InjectorProcessor<T> extends FieldProcessor<Inject, T> {

    Class<T> getTargetType();

    @Override
    default Class<Inject> annotationType() {
        return Inject.class;
    }

    @Override
    default boolean isEligible(Context context, Object instance, Inject annotation, Field field) throws Exception {

        // make sure this field is of the correct target type
        if(!getTargetType().isAssignableFrom(field.getType()))
            return false;

        // make sure the field instance is null; we wont inject existing instantiated objects
        if(field.get(instance) != null){
            return false;
        }

        // this processor can process this annotated instance
        return true;
    }
}

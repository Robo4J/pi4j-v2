package com.pi4j.annotation.processor;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  FieldProcessor.java
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

import com.pi4j.annotation.Processor;
import com.pi4j.context.Context;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public interface FieldProcessor<A extends Annotation, T> extends Processor<A, T> {
    @Override
    default boolean isEligible(Context context, Object instance, A annotation, Method method) throws Exception {
        // this annotation processor only supports 'Field' based annotated instances
        return false;
    }

    @Override
    default void process(Context context, Object instance, A annotation, Method method) throws Exception {
        // this annotation processor only supports 'Field' based annotated instances
        return;
    }
}

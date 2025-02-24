package com.pi4j.annotation.processor.injector;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  ProviderInjector.java
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
import com.pi4j.context.Context;
import com.pi4j.provider.Provider;
import com.pi4j.provider.exception.ProviderNotFoundException;
import com.pi4j.util.StringUtil;

import java.lang.reflect.Field;

public class ProviderInjector implements InjectorProcessor<Provider> {

    @Override
    public Class<Provider> getTargetType() { return Provider.class; }

    @Override
    public Provider process(Context context, Object instance, Inject annotation, Field field) throws Exception {
        String id = null;
        Class<? extends Provider> providerClass = null;

//        // validate that the 'ID' (value) attribute is not empty on this field annotation
//        if (StringUtil.isNullOrEmpty(annotation.value()) && annotation.type() == void.class)
//            throw new AnnotationException("Missing required '@Inject' annotation 'value <ID>' or 'type' attribute for 'Provider' instance.");

        // <<1>> inject instance by user defined ID property
        if(StringUtil.isNotNullOrEmpty(annotation.value())){
            id = annotation.value().trim();
        }

        // <<2>> alternatively, inject by user defined class type property
        if(annotation.type() != null && annotation.type() != void.class && Provider.class.isAssignableFrom(annotation.type())){
            providerClass = annotation.type();
        }

        // <<3>> alternatively, if no user defined class type property was defined, then we can infer the type based on the target field
        if(providerClass == null && field.getType() != null && Provider.class.isAssignableFrom(field.getType())){
            providerClass = (Class<? extends Provider>) field.getType();
        }

        if(id != null && !id.isEmpty()) {
            if(providerClass == null) {
                // get provider instance using ID only
                return context.providers().get(id);
            }
            else {
                // get provider instance using ID and Provider Class
                return context.providers().get(id, providerClass);
            }
        }

        if(providerClass != null){
            // get default provider instance using only Provider Class
            return context.providers().getDefault(providerClass);
        }

        // unable to inject anything
        throw new ProviderNotFoundException("ID=" + id + "; CLASS=" + providerClass);
    }
}

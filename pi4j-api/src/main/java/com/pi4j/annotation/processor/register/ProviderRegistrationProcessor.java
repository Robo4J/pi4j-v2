package com.pi4j.annotation.processor.register;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  ProviderProcessor.java
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
import com.pi4j.annotation.exception.AnnotationException;
import com.pi4j.context.Context;
import com.pi4j.provider.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class ProviderRegistrationProcessor implements RegisterProcessor<Provider> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean isEligible(Context context, Object instance, Register annotation, Field field) throws Exception {

        // make sure this field is of type 'Provider'
        if(!Provider.class.isAssignableFrom(field.getType()))
            return false;

        // this processor can process this annotated instance
        return true;
    }

    @Override
    public Provider process(Context context, Object instance, Register annotation, Field field) throws Exception {

        // make sure the field instance is NOT null; we can only register instantiated custom providers
        if(field.get(instance) == null)
            throw new AnnotationException("This @Register annotated instance is null; it must NOT be NULL " +
                    "to register a this provider instance.  If you just want to access an existing provider instance, " +
                    "use the '@Inject(id)' annotation instead.");

        // get provider instance
        var provider = (Provider) field.get(instance);

        // add provider instance to Pi4J runtime
        if(provider != null) context.providers().add(provider);

        // in this case we don't want to assign the annotated instance value, so we return null
        return null;
    }
}

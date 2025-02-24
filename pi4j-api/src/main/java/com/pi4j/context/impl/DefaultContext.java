package com.pi4j.context.impl;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  DefaultContext.java
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

import com.pi4j.annotation.AnnotationEngine;
import com.pi4j.annotation.exception.AnnotationException;
import com.pi4j.annotation.impl.DefaultAnnotationEngine;
import com.pi4j.binding.Bindings;
import com.pi4j.binding.impl.DefaultBindings;
import com.pi4j.context.Context;
import com.pi4j.provider.Providers;
import com.pi4j.provider.impl.DefaultProviders;
import com.pi4j.registry.Registry;
import com.pi4j.registry.impl.DefaultRegistry;

public class DefaultContext implements Context {

    private Bindings bindings = DefaultBindings.singleton(this);
    private Providers providers = DefaultProviders.singleton(this);
    private Registry registry = DefaultRegistry.singleton(this);
    private AnnotationEngine annotationEngine = DefaultAnnotationEngine.singleton(this);

    private static Context singleton = null;
    public static Context singleton(){
        if(singleton == null){
            singleton = new DefaultContext();
        }
        return singleton;
    }

    // private constructor
    private DefaultContext() {
        // forbid object construction
    }

    @Override
    public Providers providers() {
        return providers;
    }

    @Override
    public Registry registry() { return this.registry; }

    @Override
    public Bindings bindings() {
        return bindings;
    }

    @Override
    public Context inject(Object... objects) throws AnnotationException {
        annotationEngine.inject(objects);
        return this;
    }
}

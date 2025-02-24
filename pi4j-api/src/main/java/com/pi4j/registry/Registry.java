package com.pi4j.registry;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  Registry.java
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

import com.pi4j.common.Describable;
import com.pi4j.common.Descriptor;
import com.pi4j.common.exception.LifecycleException;
import com.pi4j.config.Config;
import com.pi4j.context.Context;
import com.pi4j.exception.NotInitializedException;
import com.pi4j.io.IO;
import com.pi4j.provider.Provider;
import com.pi4j.provider.ProviderType;
import com.pi4j.provider.exception.ProviderException;
import com.pi4j.registry.exception.RegistryException;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public interface Registry extends Describable {

    <T extends IO> T create(String providerId, Config config, Class<T> type) throws RegistryException, ProviderException, NotInitializedException;
    <T extends IO> T create(Provider provider, Config config, Class<T> type) throws RegistryException, ProviderException;
    <T extends IO> T create(Config config, Class<T> type) throws RegistryException, ProviderException;

    boolean exists(String id, Class<? extends IO> type);
    boolean exists(String id);

    Map<String, ? extends IO> all() throws RegistryException;

    <T extends IO> T get(String id, Class<T> type) throws RegistryException;
    <T extends IO> T destroy(String id) throws RegistryException, LifecycleException;

    void terminate(Context context) throws ProviderException, RegistryException;

    default <T extends IO> Map<String, T> allByType(Class<T> ioClass) throws RegistryException{
        // create a map <io-id, io-instance> of I/O instances that extend of the given IO class
        var result = new ConcurrentHashMap<String, T>();
        this.all().values().stream().filter(ioClass::isInstance).forEach(p -> {
            result.put(p.id(), ioClass.cast(p));
        });
        return Collections.unmodifiableMap(result);
    }

    default <P extends Provider> Map<String, ? extends IO> allByProvider(ProviderType providerType) throws RegistryException{
        return allByType(providerType.getIOClass());
    }

    default <P extends Provider> Map<String, ? extends IO> allByProvider(Class<P> providerClass) throws RegistryException{
        return allByProvider(ProviderType.getProviderType(providerClass));
    }

    default <P extends Provider> Map<String, ? extends IO> allByProvider(String providerId) throws RegistryException{

        // create a map <io-id, io-instance> of providers that extend of the given io class
        var result = this.all().values().stream()
                .filter(instance -> providerId.equalsIgnoreCase(((IO) instance).provider().id()))
                .collect(Collectors.toMap(IO::id, c->c));

        return Collections.unmodifiableMap(result);
    }

    default <P extends Provider, T extends IO> Map<String, T> allByProvider(String providerId, Class<T> ioClass) throws RegistryException{
        // create a map <io-id, io-instance> of providers that extend of the given io class
        var result = new ConcurrentHashMap<String, T>();
        this.all().values().stream()
                .filter(instance -> providerId.equalsIgnoreCase(((IO) instance).provider().id()))
                .filter(ioClass::isInstance).forEach(p -> {
            result.put(p.id(), ioClass.cast(p));
        });
        return Collections.unmodifiableMap(result);
    }

    default Descriptor describe() {

        Map<String, ? extends IO> instances = new ConcurrentHashMap<>();

        try {
            instances = all();
        } catch (RegistryException e) {
            e.printStackTrace();
        }

        Descriptor descriptor = Descriptor.create()
                .category("REGISTRY")
                .name("I/O Registered Instances")
                .quantity((instances == null) ? 0 : instances.size())
                .type(this.getClass());

        if(instances != null && !instances.isEmpty()) {
            instances.forEach((id, instance) -> {
                descriptor.add(instance.describe());
            });
        }

        return descriptor;
    }
}

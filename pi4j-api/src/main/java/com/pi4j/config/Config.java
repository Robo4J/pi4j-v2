package com.pi4j.config;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  Config.java
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

public interface Config<CONFIG_TYPE> {
    String ID_KEY = "id";
    String NAME_KEY = "name";
    String DESCRIPTION_KEY = "description";

    String id();

    String name();
    CONFIG_TYPE name(String name);

    String description();
    CONFIG_TYPE description(String description);

    void validate();

    default String getId(){
        return this.id();
    }
    default String getName(){
        return this.name();
    }
    default String getDescription(){
        return this.description();
    }
    default void setName(String name){
        this.name(name);
    }
    default void setDescription(String description){
        this.description(description);
    }
}

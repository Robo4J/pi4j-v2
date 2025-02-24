package com.pi4j.config;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  ConfigBuilder.java
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map;
import java.util.Properties;

public interface ConfigBuilder<BUILDER_TYPE, CONFIG_TYPE> extends Builder<CONFIG_TYPE> {
    BUILDER_TYPE id(String id);
    BUILDER_TYPE name(String name);
    BUILDER_TYPE description(String description);

    BUILDER_TYPE load(Map<String, String> properties);
    BUILDER_TYPE load(Properties properties);
    BUILDER_TYPE load(Map<String, String> properties, String prefixFilter);
    BUILDER_TYPE load(Properties properties, String prefixFilter);
    BUILDER_TYPE load(InputStream stream) throws IOException;
    BUILDER_TYPE load(InputStream stream, String prefixFilter) throws IOException;
    BUILDER_TYPE load(Reader reader) throws IOException;
    BUILDER_TYPE load(Reader reader, String prefixFilter) throws IOException;
    BUILDER_TYPE load(File file) throws IOException;
    BUILDER_TYPE load(File file, String prefixFilter) throws IOException;
}

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: EXAMPLE :: Sample Code
 * FILENAME      :  module-info.java
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
module pi4j.example {

    // Pi4J API Module
    requires pi4j.api;
    uses com.pi4j.binding.Binding;
    uses com.pi4j.provider.Provider;

    // Pi4J Mock Module
    requires pi4j.provider.mock;
    uses com.pi4j.provider.mock.io.gpio.analog.MockAnalogInput;
    uses com.pi4j.provider.mock.io.gpio.analog.MockAnalogInputProvider;
    uses com.pi4j.provider.mock.io.gpio.analog.MockAnalogOutput;
    uses com.pi4j.provider.mock.io.gpio.analog.MockAnalogOutputProvider;
    uses com.pi4j.provider.mock.io.gpio.digital.MockDigitalInput;
    uses com.pi4j.provider.mock.io.gpio.digital.MockDigitalInputProvider;
    uses com.pi4j.provider.mock.io.gpio.digital.MockDigitalOutput;
    uses com.pi4j.provider.mock.io.gpio.digital.MockDigitalOutputProvider;

    // allow access to classes in the following namespaces for Pi4J annotation processing
    opens com.pi4j.example.gpio.analog;
    opens com.pi4j.example.gpio.digital;
}

package com.pi4j.provider.mock.io.serial;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: PROVIDER :: Mock Provider
 * FILENAME      :  MockSerialProvider.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2019 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialProvider;
import com.pi4j.io.serial.SerialProviderBase;
import com.pi4j.provider.mock.Mock;


public class MockSerialProvider extends SerialProviderBase implements SerialProvider {

    public static final String NAME = Mock.SERIAL_PROVIDER_NAME;
    public static final String ID = Mock.SERIAL_PROVIDER_ID;

    public MockSerialProvider(){
        this.id = ID;
        this.name = NAME;
    }

    @Override
    public Serial create(SerialConfig config) throws Exception {
        return new MockSerial(config);
    }
}

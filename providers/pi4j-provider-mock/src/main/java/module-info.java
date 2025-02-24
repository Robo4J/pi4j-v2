import com.pi4j.provider.mock.io.gpio.analog.MockAnalogInputProvider;
import com.pi4j.provider.mock.io.gpio.analog.MockAnalogOutputProvider;
import com.pi4j.provider.mock.io.gpio.digital.MockDigitalInputProvider;
import com.pi4j.provider.mock.io.gpio.digital.MockDigitalOutputProvider;
import com.pi4j.provider.mock.io.i2c.MockI2CProvider;
import com.pi4j.provider.mock.io.pwm.MockPwmProvider;
import com.pi4j.provider.mock.io.serial.MockSerialProvider;
import com.pi4j.provider.mock.io.spi.MockSpiProvider;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: PROVIDER :: Mock Provider
 * FILENAME      :  module-info.java
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
module pi4j.provider.mock {
    requires pi4j.api;

    exports com.pi4j.provider.mock.io.gpio.digital;
    exports com.pi4j.provider.mock.io.gpio.analog;
    exports com.pi4j.provider.mock.io.pwm;
    exports com.pi4j.provider.mock.io.serial;
    exports com.pi4j.provider.mock.io.spi;
    exports com.pi4j.provider.mock.io.i2c;

    provides com.pi4j.provider.Provider
            with MockAnalogInputProvider,
                 MockAnalogOutputProvider,
                 MockDigitalInputProvider,
                 MockDigitalOutputProvider,
                 MockPwmProvider,
                 MockSpiProvider,
                 MockI2CProvider,
                 MockSerialProvider;

}

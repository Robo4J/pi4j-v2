package com.pi4j.provider.mock;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: PROVIDER :: Mock Provider
 * FILENAME      :  Mock.java
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

public class Mock {
    public static final String NAME = "Mock";
    public static final String ID = "mock";

    // Platform name and unique ID
    public static final String PLATFORM_NAME = NAME + " Platform";
    public static final String PLATFORM_ID = ID;

    // Analog Input (GPIO) Provider name and unique ID
    public static final String ANALOG_INPUT_PROVIDER_NAME = NAME + " Analog Input (GPIO) Provider";
    public static final String ANALOG_INPUT_PROVIDER_ID = ID + "-analog-input";

    // Analog Output (GPIO) Provider name and unique ID
    public static final String ANALOG_OUTPUT_PROVIDER_NAME = NAME + " Analog Output (GPIO) Provider";
    public static final String ANALOG_OUTPUT_PROVIDER_ID = ID + "-analog-output";

    // Digital Input (GPIO) Provider name and unique ID
    public static final String DIGITAL_INPUT_PROVIDER_NAME = NAME +  " Digital Input (GPIO) Provider";
    public static final String DIGITAL_INPUT_PROVIDER_ID = ID + "-digital-input";

    // Digital Output (GPIO) Provider name and unique ID
    public static final String DIGITAL_OUTPUT_PROVIDER_NAME = NAME +  " Digital Output (GPIO) Provider";
    public static final String DIGITAL_OUTPUT_PROVIDER_ID = ID + "-digital-output";

    // PWM Provider name and unique ID
    public static final String PWM_PROVIDER_NAME = NAME + " PWM Provider";
    public static final String PWM_PROVIDER_ID = ID + "-pwm";

    // I2C Provider name and unique ID
    public static final String I2C_PROVIDER_NAME = NAME + " I2C Provider";
    public static final String I2C_PROVIDER_ID = ID + "-i2c";

    // SPI Provider name and unique ID
    public static final String SPI_PROVIDER_NAME = NAME + " SPI Provider";
    public static final String SPI_PROVIDER_ID = ID + "-spi";

    // Serial Provider name and unique ID
    public static final String SERIAL_PROVIDER_NAME = NAME + " Serial Provider";
    public static final String SERIAL_PROVIDER_ID = ID + "-serial";
}

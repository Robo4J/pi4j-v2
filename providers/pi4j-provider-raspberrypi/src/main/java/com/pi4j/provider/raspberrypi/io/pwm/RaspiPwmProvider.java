package com.pi4j.provider.raspberrypi.io.pwm;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: PROVIDER :: Raspberry Pi Provider
 * FILENAME      :  RaspiPwmProvider.java
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

import com.pi4j.io.pwm.Pwm;
import com.pi4j.io.pwm.PwmConfig;
import com.pi4j.io.pwm.PwmProvider;
import com.pi4j.io.pwm.PwmProviderBase;
import com.pi4j.provider.raspberrypi.RaspberryPi;

public class RaspiPwmProvider extends PwmProviderBase implements PwmProvider {

    public static final String NAME = RaspberryPi.PWM_PROVIDER_NAME;
    public static final String ID = RaspberryPi.PWM_PROVIDER_ID;

    public RaspiPwmProvider(){
        this.id = ID;
        this.name = NAME;
    }

    @Override
    public Pwm create(PwmConfig config) throws Exception {
        return null;
    }
}

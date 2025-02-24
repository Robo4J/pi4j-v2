package com.pi4j.test.provider;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: UNITTEST :: Unit/Integration Tests
 * FILENAME      :  TestDigitalInput.java
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

import com.pi4j.io.gpio.digital.*;

public class TestDigitalInput extends DigitalInputBase implements DigitalInput {

    private DigitalState state = DigitalState.UNKNOWN;

    @Override
    public DigitalState state() {
        return this.state;
    }

    public TestDigitalInput(DigitalInputConfig config){
        super(config);
    }

    public TestDigitalInput test(DigitalState state){

        // check to see of there is a state change; if there is then we need
        // to update the internal value variable and dispatch the change event
        if(this.state().equals(state)) {

            // update current/new value
            this.state = state;

            // dispatch value change event
            this.dispatch(new DigitalChangeEvent(this, this.state()));
        }
        return this;
    }
}

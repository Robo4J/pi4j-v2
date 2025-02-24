package com.pi4j.io.i2c;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  I2C.java
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

import com.pi4j.exception.NotInitializedException;
import com.pi4j.io.IO;
import com.pi4j.io.i2c.impl.I2CFactory;
import com.pi4j.provider.exception.ProviderException;

import java.io.IOException;


/**
 * This is abstraction of an i2c device. It allows data to be read or written to the device.
 *
 * @author Daniel Sendula, refactored by <a href="http://raspelikan.blogspot.co.at">RasPelikan</a>
 *
 */
public interface I2C extends IO<I2C, I2CConfig> {

    static final String ID = "I2C";

    static I2C instance(String device, int address) throws ProviderException, NotInitializedException {
        return I2CFactory.instance(device, address);
    }

    static I2C instance(I2CConfig config) throws ProviderException, NotInitializedException {
        return I2CFactory.instance(config);
    }

    static I2C instance(String providerId, String device, int address) throws ProviderException, NotInitializedException {
        return I2CFactory.instance(providerId, device, address);
    }

    static I2C instance(String providerId, I2CConfig config) throws ProviderException, NotInitializedException {
        return I2CFactory.instance(providerId, config);
    }

    static I2C instance(I2CProvider provider, String device, int address) throws ProviderException {
        return I2CFactory.instance(provider, device ,address);
    }

    static I2C instance(I2CProvider provider, I2CConfig config) throws ProviderException {
        return I2CFactory.instance(provider, config);
    }

    /**
     * @return The address for which this instance is constructed for.
     */
    int getAddress();

    /**
     * This method writes one byte directly to i2c device.
     *
     * @param b byte to be written
     *
     * @throws IOException thrown in case byte cannot be written to the i2c device or i2c bus
     */
    void write(byte b) throws IOException;

    /**
     * This method writes several bytes directly to the i2c device from given buffer at given offset.
     *
     * @param buffer buffer of data to be written to the i2c device in one go
     * @param offset offset in buffer
     * @param size number of bytes to be written
     *
     * @throws IOException thrown in case byte cannot be written to the i2c device or i2c bus
     */
    void write(byte[] buffer, int offset, int size) throws IOException;

    /**
     * This method writes all bytes included in the given buffer directly to the i2c device.
     *
     * @param buffer buffer of data to be written to the i2c device in one go
     *
     * @throws IOException thrown in case byte cannot be written to the i2c device or i2c bus
     */
    void write(byte[] buffer) throws IOException;

    /**
     * This method writes one byte to i2c device.
     *
     * @param address local address in the i2c device
     * @param b byte to be written
     *
     * @throws IOException thrown in case byte cannot be written to the i2c device or i2c bus
     */
    void write(int address, byte b) throws IOException;

    /**
     * This method writes several bytes to the i2c device from given buffer at given offset.
     *
     * @param address local address in the i2c device
     * @param buffer buffer of data to be written to the i2c device in one go
     * @param offset offset in buffer
     * @param size number of bytes to be written
     *
     * @throws IOException thrown in case byte cannot be written to the i2c device or i2c bus
     */
    void write(int address, byte[] buffer, int offset, int size) throws IOException;

    /**
     * This method writes all bytes included in the given buffer directoy to the register address on the i2c device
     *
     * @param address local address in the i2c device
     * @param buffer buffer of data to be written to the i2c device in one go
     *
     * @throws IOException thrown in case byte cannot be written to the i2c device or i2c bus
     */
    void write(int address, byte[] buffer) throws IOException;

    /**
     * This method reads one byte from the i2c device.
     * Result is between 0 and 255 if read operation was successful, else a negative number for an error.
     *
     * @return byte value read: positive number (or zero) to 255 if read was successful. Negative number if reading failed.
     *
     * @throws IOException thrown in case byte cannot be read from the i2c device or i2c bus
     */
    int read() throws IOException;

    /**
     * This method reads bytes directly from the i2c device to given buffer at asked offset.
     *
     * @param buffer buffer of data to be read from the i2c device in one go
     * @param offset offset in buffer
     * @param size number of bytes to be read
     *
     * @return number of bytes read
     *
     * @throws IOException thrown in case byte cannot be read from the i2c device or i2c bus
     */
    int read(byte[] buffer, int offset, int size) throws IOException;

    /**
     * This method reads one byte from the i2c device.
     * Result is between 0 and 255 if read operation was successful, else a negative number for an error.
     *
     * @param address local address in the i2c device
     * @return byte value read: positive number (or zero) to 255 if read was successful. Negative number if reading failed.
     *
     * @throws IOException thrown in case byte cannot be read from the i2c device or i2c bus
     */
    int read(int address) throws IOException;

    /**
     * This method reads bytes from the i2c device to given buffer at asked offset.
     *
     * @param address local address in the i2c device
     * @param buffer buffer of data to be read from the i2c device in one go
     * @param offset offset in buffer
     * @param size number of bytes to be read
     *
     * @return number of bytes read
     *
     * @throws IOException thrown in case byte cannot be read from the i2c device or i2c bus
     */
    int read(int address, byte[] buffer, int offset, int size) throws IOException;

    /**
     * This method writes and reads bytes to/from the i2c device in a single method call
     *
     * @param writeBuffer buffer of data to be written to the i2c device in one go
     * @param writeOffset offset in write buffer
     * @param writeSize number of bytes to be written from buffer
     * @param readBuffer buffer of data to be read from the i2c device in one go
     * @param readOffset offset in read buffer
     * @param readSize number of bytes to be read
     *
     * @return number of bytes read
     *
     * @throws IOException thrown in case byte cannot be read from the i2c device or i2c bus
     */
    int read(byte[] writeBuffer, int writeOffset, int writeSize, byte[] readBuffer, int readOffset, int readSize) throws IOException;

}

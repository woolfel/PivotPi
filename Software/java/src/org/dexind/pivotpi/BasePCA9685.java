package org.dexind.pivotpi;

import java.io.IOException;
import java.util.logging.Logger;

import com.pi4j.io.i2c.I2CDevice;

public abstract class BasePCA9685 implements PCA9685 {

	/**
	 * pi4j I2C device
	 */
	private I2CDevice i2cDevice;
	protected Logger log = null;
	
	public BasePCA9685(I2CDevice device) {
		this.i2cDevice = device;
	}
	
	public void writeRegister(int address, byte value) throws IOException {
        i2cDevice.write(address, value);
    }

    public void writeRegisters(int address, byte[] values) throws IOException {
        i2cDevice.write(address, values, 0, values.length);
    }

    public int readRegister(int address) throws IOException {
        int value = i2cDevice.read(address);
        return value;
    }

    public int readRegisters(int address, byte[] buffer, int offset, int size) throws IOException {
        return i2cDevice.read(address, buffer, 0, buffer.length);
    }
}

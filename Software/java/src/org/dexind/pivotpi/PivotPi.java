package org.dexind.pivotpi;

import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;

public class PivotPi extends BasePCA9685 implements ServoController {

	public final int addr_00 = 0x40;
	public final int addr_01 = 0x41;
	public final int addr_10 = 0x42;
	public final int addr_11 = 0x43;
	
    // Configure min and max servo pulse lengths
	public final int servo_min = 150;  // Min pulse length out of 4096
	public final int servo_max = 600;  // Max pulse length out of 4096
    private int frequency = 60;
    
    private I2CBus bus = null;
		
	public PivotPi() {
		super();
		try {
			this.bus = I2CFactory.getInstance(1);
			this.i2cDevice = this.bus.getDevice(PCA9685.PCA9685_ADDRESS);
		} catch (UnsupportedBusNumberException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void angle(int channel, int angle) {
	}

	@Override
	public void angleMicroseconds(int channel, int time) {
	}

	@Override
	public void led(int channel, double percent) {
	}

	@Override
	public int translate(int val, int leftMin, int leftMax, int rightMin, int rightMax) {
		// Figure out how 'wide' each range is
	    int leftSpan = leftMax - leftMin;
	    int rightSpan = rightMax - rightMin;

	    // Convert the left range into a 0-1 range (float)
	    float valueScaled = (float)(val - leftMin) / (float)(leftSpan);

	    // Convert the 0-1 range into a value in the right range.
	    return (int)(rightMin + (valueScaled * rightSpan));
	}

}

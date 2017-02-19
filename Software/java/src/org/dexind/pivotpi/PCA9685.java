package org.dexind.pivotpi;

public class PCA9685 {

	/**********************/
	/***    Registers   ***/
	/**********************/
	private int PCA9685_ADDRESS = 0x40;
	private int MODE1 = 0x00;
	private int MODE2 = 0x01;
	private int SUBADR1 = 0x02;
	private int SUBADR2 = 0x03;
	private int SUBADR3 = 0x04;
	private int PRESCALE = 0xFE;
	private int LED0_ON_L = 0x06;
	private int LED0_ON_H = 0x07;
	private int LED0_OFF_L = 0x08;
	private int LED0_OFF_H = 0x09;
	private int ALL_LED_ON_L = 0xFA;
	private int ALL_LED_ON_H = 0xFB;
	private int ALL_LED_OFF_L = 0xFC;
	private int ALL_LED_OFF_H = 0xFD;
	
	/**********************/
	/***      bits      ***/
	/**********************/
	private int RESTART = 0x80;
	private int SLEEP = 0x10;
	private int ALLCALL = 0x01;
	private int INVRT = 0x10;
	private int OUTDRV = 0x04;
	
	public PCA9685() {
		super();
	}
}

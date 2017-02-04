
package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.SPI;

/**
 * Representation of a LPD8806 based led strip.
 *
 * @author Gert Leenders
 */

// It is creating a class called "LedStrip"
public final class LedStrip {

	// This is saying that this will crate a new serial peripheral
	// interface(SPI), called "testSPI"; with a constuctor saying that the port
	// 'values' 0.
	private static final SPI testSPI = new SPI(SPI.Port.values()[0]);

	// Declaring an int called GAMMA_LENGTH which is equal to 256
	private static final int GAMMA_LENGTH = 256;

	// This is saying that it is defining a new byte:(8 bits), by and saying it
	// is the length of "GAMMA_LENGTH" ,that being the number 256.
	private static final byte[] GAMMA = new byte[GAMMA_LENGTH];

	// This is an int called numberOfLeds, since it is not defined, then it
	// automaticly starts at 0.
	private int numberOfLeds;

	// It is creating an empty array. Its called a,"zero length array".
	private RGBLed[] ledBuffer;

	// This is creating a float that starts at 0 called, "brightness".
	private float brightness;

	// This is a boolean called suspendUpdates, which is false.
	private boolean suspendUpdates = false;

	static {

		// This is that SPI from eariler that is being set to a colck rate of
		// 2000000 clock ticks per-second.
		testSPI.setClockRate(2000000);

		// The SPI from eariler saying that is saying something I dont know...
		testSPI.setMSBFirst();

		// A for loop that when "i" is less than 256, then it will do something
		// until it is greater than 256. Then it will add 1 to "i" and then loop
		// ("i" begins at zero).
		for (int i = 0; i < GAMMA_LENGTH; i++) {

			// An it,"j" is equal to math to the power of some float to "i"
			// divided by 255, 2.5. THen it will multiply that by 127 + 0.5.
			// The Gamma byte from eariler is equal to the byte of (0x80 | j)
			int j = (int) (Math.pow(((float) i) / 255.0, 2.5) * 127.0 + 0.5);
			GAMMA[i] = (byte) (0x80 | j);
		}

	}

	/**
	 * Initialize a led strip.
	 *
	 * @param numberOfLeds
	 *            the number of leds on the strip
	 * @param brightness
	 *            the overall brightness of the leds
	 * @throws IllegalArgumentException
	 */

	// This is a public statemnt continuing off of the the class
	// called,"LedStrip". It says that there is a perviously declared
	// int:(numberOfLeds) and float:(brightness). Then it throws an
	// IllegalArgumentException.
	public LedStrip(final int numberOfLeds, final float brightness) throws IllegalArgumentException {

		// If the brightness is less than 0 or brightness is greater than
		// 1 it will preform an action.
		if (brightness < 0 || brightness > 1.0) {

			// This is the action,(to through the newly defined
			// throw:(IllegalArgumentExecption). So the parameters of the
			// brightness must be between 0-1. Otherwise it will 'throw' an
			// error.
			throw new IllegalArgumentException("Brightness must be between 0.0 and 1.0");
		}

		// This specific class, makes the varible tittled, "numberOfLeds" equal
		// to then same variable, "numberOfLeds".
		this.numberOfLeds = numberOfLeds;
		// This specific class, makes the empty array tittled, "ledBuffer" equal
		// to
		this.ledBuffer = new RGBLed[numberOfLeds];
		for (int i = 0; i < numberOfLeds; i++) {
			ledBuffer[i] = new RGBLed();
		}

		this.brightness = brightness;
	}

	/**
	 * @param suspendUpdates
	 *            if true, the trip wil ignore updates
	 */
	public void setSuspendUpdates(boolean suspendUpdates) {
		this.suspendUpdates = suspendUpdates;
	}

	/**
	 * Set all leds off.
	 */
	public void allOff() {
		fill(0, 0, 0);
		update();
	}

	/**
	 * Fill all leds with a specified color.
	 *
	 * @param red
	 *            value between 0 and 255 for the red led
	 * @param green
	 *            value between 0 and 255 for the green led
	 * @param blue
	 *            value between 0 and 255 for the blue led
	 */
	public void fill(final int red, final int green, final int blue) {
		fill(red, green, blue, 1, numberOfLeds);
	}

	/**
	 * Fill all leds with a specified color and set the overall brightness.
	 *
	 * @param red
	 *            value between 0 and 255 for the red led
	 * @param green
	 *            value between 0 and 255 for the green led
	 * @param blue
	 *            value between 0 and 255 for the blue led
	 * @param brightness
	 *            value between 0 and 1 for the brightness
	 */
	public void fill(final int red, final int green, final int blue, final float brightness) {
		fill(red, green, blue, 1, numberOfLeds, brightness);
	}

	/**
	 * Fill a part of the led strip with a specified color.
	 *
	 * @param red
	 *            value between 0 and 255 for the red led
	 * @param green
	 *            value between 0 and 255 for the green led
	 * @param blue
	 *            value between 0 and 255 for the blue led
	 * @param start
	 *            the start led position in the led strip
	 * @param end
	 *            the end led position in the led strip
	 * @throws IllegalArgumentException
	 */
	public void fill(final int red, final int green, final int blue, final int start, final int end)
			throws IllegalArgumentException {
		fill(red, green, blue, start, end, brightness);
	}

	/**
	 * Fill a part of the led strip with a specified color and set the
	 * brightness.
	 *
	 * @param red
	 *            value between 0 and 255 for the red led
	 * @param green
	 *            value between 0 and 255 for the green led
	 * @param blue
	 *            value between 0 and 255 for the blue led
	 * @param start
	 *            the start led position in the led strip
	 * @param end
	 *            the end led position in the led strip
	 * @param brightness
	 *            value between 0 and 1 for the brightness
	 * @throws IllegalArgumentException
	 */
	public void fill(final int red, final int green, final int blue, final int start, final int end,
			final float brightness) throws IllegalArgumentException {

		if (red < 0 || green < 0 || blue < 0 || red > 255 || green > 255 || blue > 255) {
			throw new IllegalArgumentException("Red, green and blue values must be between 0 and 255.");
		}

		if (start < 1 || end > (numberOfLeds + 1)) {
			throw new IllegalArgumentException(
					"Led start must be greater then 0, end must be smaller then " + (numberOfLeds + 1) + ".");
		}

		if (end < start) {
			throw new IllegalArgumentException("End must be greater then or equal as start.");
		}

		for (int i = start; i <= end; i++) {
			setLed(i, red, green, blue, brightness);
		}
	}

	/**
	 * Set the color of an individual led.
	 *
	 * @param number
	 *            the number of the led in the led strip
	 * @param red
	 *            value between 0 and 255 for the red led
	 * @param green
	 *            value between 0 and 255 for the green led
	 * @param blue
	 *            value between 0 and 255 for the blue led
	 */
	public void setLed(final int number, final int red, final int green, final int blue) {
		setLed(number, red, green, blue, brightness);
	}

	/**
	 * Switch a led off.
	 *
	 * @param number
	 *            the number of the led in the led strip
	 */
	public void setLedOff(final int number) {
		setLed(number, 0, 0, 0, 0);
	}

	/**
	 * Set the color and brightness of an individual led.
	 *
	 * @param number
	 *            the number of the led in the led strip
	 * @param red
	 *            value between 0 and 255 for the red led
	 * @param green
	 *            value between 0 and 255 for the green led
	 * @param blue
	 *            value between 0 and 255 for the blue led
	 * @param brightness
	 *            value between 0 and 1 for the brightness
	 */
	public void setLed(final int number, final int red, final int green, final int blue, final float brightness) {
		if (number < 1 || number > numberOfLeds) {
			throw new IllegalArgumentException(
					"led number must be greater then 0 and smaller then " + (numberOfLeds + 1) + ".");
		}

		ledBuffer[number - 1].set(red, green, blue, brightness);
	}

	/**
	 * Update the strip in order to show its new settings.
	 */
	public void update() {
		if (suspendUpdates) {
			return;
		}

		final byte packet[] = new byte[(numberOfLeds * 3) + 6];

		packet[0] = (byte) 0x00;
		packet[1] = (byte) 0x00;
		packet[(numberOfLeds * 3 + 5)] = (byte) 0x00;
		for (int i = 0; i < numberOfLeds; i++) {
			packet[(i * 3) + 2] = ledBuffer[i].getGreen();
			packet[(i * 3) + 3] = ledBuffer[i].getRed();
			packet[(i * 3) + 4] = ledBuffer[i].getBlue();
		}
		// Update the strand
		testSPI.write(packet, ((this.numberOfLeds * 3) + 6));
	}

	/**
	 * Simple test function to test your led strip.
	 *
	 * @throws InterruptedException
	 */
	public void testStrip() throws InterruptedException {
		allOff();

		fill(0, 255, 0);
		update();

		Thread.sleep(2000);

		fill(0, 0, 255);
		update();

		Thread.sleep(2000);

		fill(255, 0, 0);
		update();

		Thread.sleep(2000);

		allOff();
	}

	/**
	 * RGBLed represents a 'single' led on a led strip. In reality these
	 * 'single' leds consist out of 3 leds, a red, a green and a blue one.
	 *
	 * @author Gert Leenders
	 */
	private class RGBLed {
		private byte red;
		private byte green;
		private byte blue;

		/**
		 * Initiate a single led in a led strip.
		 *
		 * @param red
		 *            value between 0 and 255 for the red led
		 * @param green
		 *            value between 0 and 255 for the green led
		 * @param blue
		 *            value between 0 and 255 for the blue led
		 * @param brightness
		 *            overall brightness for the led combination
		 */
		public void set(final int red, final int green, final int blue, final float brightness) {
			this.red = GAMMA[(int) (red * brightness)];
			this.green = GAMMA[(int) (green * brightness)];
			this.blue = GAMMA[(int) (blue * brightness)];
		}

		/**
		 * @return the value for the green led (between 0 and 255)
		 */
		public byte getGreen() {
			return green;
		}

		/**
		 * @return the value for the blue led (between 0 and 255)
		 */
		public byte getBlue() {
			return blue;
		}

		/**
		 * @return the value for the red led (between 0 and 255)
		 */
		public byte getRed() {
			return red;
		}
	}
}
package org.usfirst.frc.team2643.robot;

public class Dump extends Robot {
	public Dump() {

	}

	public void dump() {

		/*
		 * If the up dpad is pressed and the top limit switch is false, then the
		 * motor dump motor moves at a speed of 0.5 until the bottom limit
		 * switch is gotten.
		 */
		if (Robot.opStick.getPOV() == 0 && topLimitSwitch.get() == false) {
			Robot.dumpMotor.set(0.5);
		}
		/*
		 * Else, if the down dpad is pressed and the limit switch has not been
		 * pressed, then
		 */
		else if (Robot.opStick.getPOV() == 180 && bottomLimitSwitch.get() == false) {
			Robot.dumpMotor.set(-0.5);
		} else {
			Robot.dumpMotor.set(0);
		}
	}
}

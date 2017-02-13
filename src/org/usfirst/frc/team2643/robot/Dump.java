package org.usfirst.frc.team2643.robot;

public class Dump extends Robot {
	public Dump() {

	}
	
	/**
	 *{@code dump()}:
	 *
	 *		if the dPad is pressed up and the top limit switch is not pressed, 
	 *		then the dumpMotor will move forward, else if the dPad is pressed down
	 *		and the bottom limit switch is not pressed, then the dumpMotor will move backwards.
	 *		Otherwise it will just do nothing
	 *
	 *@speed
	 *		speed for full load - (0.5)
	 *		speed for about 10 balls - (0.3)
	 *
	 */
	public void static dump() {
		if (Robot.opStick.getPOV() == 0 && hallEffectTop.get() == false) 
		{
			Robot.dumpMotor.set(RobotMap.DUMP_UP_FULL_SPEED);
		}
		
		else if (Robot.opStick.getPOV() == 90 && hallEffectTop.get() == false)
		{
			Robot.dumpMotor.set(RobotMap.DUMP_UP_HALF_SPEED);
		} 
		
		else if(Robot.opStick.getPOV() == 180 && hallEffectBottom.get() == false)
		{
			Robot.dumpMotor.set(RobotMap.DUMP_DOWN_SPEED);
		}
		else 
		{
			Robot.dumpMotor.set(RobotMap.DUMP_NO_SPEED);
		}
	}
}

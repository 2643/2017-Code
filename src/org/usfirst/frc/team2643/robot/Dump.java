package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

public class Dump extends Robot {

	/**
	 *{@code dump()}: 
	 *
	 *		if the dPad is pressed up and the top limit switch is not pressed, 
	 *		then the dumpMotor will move forward, else if the dPad is pressed down
	 *		and the bottom limit switch is not pressed, then the dumpMotor will move backwards.
	 *		Otherwise it will just do nothing
	 * @return 
	 *
	 *@speed
	 *		speed for full load - (0.5)
	 *		speed for about 10 balls - (0.3)
	 *
	 */
	static Timer dumptimer = new Timer();
	public static void dump() {
		if(RobotMap.hallEffectTop.get() == true)
		{
			System.out.println("Hall Effect Hit");
			if(dumptimer.get() > 10)
			{
				if (RobotMap.driveStick.getPOV() == RobotMap.DUMP_FULL_UP_BUTTON) //if not hit
				{
					System.out.println("Hall Effect Hit at full speed");
					//RobotMap.dumpMotor.set(RobotMap.DUMP_UP_FULL_SPEED);
				}

				else if (RobotMap.driveStick.getPOV() == RobotMap.DUMP_HALF_UP_BUTTON) 
				{
					System.out.println("Hall Effect Hit at half speed");
					//RobotMap.dumpMotor.set(RobotMap.DUMP_UP_HALF_SPEED);
				} 
				else
				{
					RobotMap.dumpMotor.set(RobotMap.DUMP_NO_SPEED);
				}
				/*else if(RobotMap.driveStick.getPOV() == RobotMap.DUMP_DOWN_BUTTON)
				{
				RobotMap.dumpMotor.set(RobotMap.DUMP_DOWN_SPEED);
				}*/
			}
		}
		else
		{
			RobotMap.dumpMotor.set(RobotMap.DUMP_NO_SPEED);
			dumptimer.reset();
			dumptimer.start();
		}
	}
}


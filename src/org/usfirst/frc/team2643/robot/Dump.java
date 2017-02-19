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
	static int dumptimer = 100;//this timer is for pausing when the dump hits the hall effect
	public static void dump() 
	{
		if(RobotMap.hallEffectTop.get() == true)//if it is not hit
		{
			dumptimer +=1; //increase the timer//1 = 20ms
	//		System.out.println(dumptimer);//100 for dumptimer = 2000 ms = 2 seconds
			if(dumptimer > 100)//if the pause timer is not activated, then let controls work 
			{
				if (RobotMap.driveStick.getPOV() == RobotMap.DUMP_FULL_UP_BUTTON) 
				{
					RobotMap.dumpMotor.set(RobotMap.DUMP_UP_FULL_SPEED);
				}

				else if (RobotMap.driveStick.getPOV() == RobotMap.DUMP_HALF_UP_BUTTON) 
				{
					RobotMap.dumpMotor.set(RobotMap.DUMP_UP_HALF_SPEED);
				} 
				else
				{
					RobotMap.dumpMotor.set(RobotMap.DUMP_DOWN_SPEED);
				}
			}
			else
			{
				RobotMap.dumpMotor.set(RobotMap.DUMP_HOVER_SPEED);
			}
		}
		else if(RobotMap.hallEffectTop.get() == false)
		{
			//if the up button is still being held
			if(RobotMap.driveStick.getPOV() == RobotMap.DUMP_FULL_UP_BUTTON || RobotMap.driveStick.getPOV() == RobotMap.DUMP_HALF_UP_BUTTON)
			{
				RobotMap.dumpMotor.set(RobotMap.DUMP_HOVER_SPEED);
				dumptimer = 0;//set the timer to zero
			}
			else
			{
				RobotMap.dumpMotor.set(0);
			}
		}
	}
}


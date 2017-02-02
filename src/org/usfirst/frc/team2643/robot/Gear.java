 package org.usfirst.frc.team2643.robot;

public class Gear {
	public Gear(){
		 
	}
	public static void gear(){
	 
				//operator controlled
				//if the potentiometer is in the "in" position, 
				//then this will move it to the "middle" position
				if((Robot.opStick.getRawButton(robotMap.GEAR_MIDDLE_BUTTON) == true) && (Robot.pot.get() <= 30))//whoah, cheap!
				{
					Robot.gearMotor.set(0.25);
				}
				
				//if the potentiometer is in the "middle" position, 
				//then this will move it to the "out" position
				else if((Robot.opStick.getRawButton(robotMap.GEAR_OUT_BUTTON) == true) && ((Robot.pot.get() > 31) && 
						(Robot.pot.get() <= 70)))
				{
					Robot.gearMotor.set(0.25);
				}
				
				//if the potentiometer is in the "middle" or "out" position, 
				//then this will move it to the "in" position
				else if((Robot.opStick.getRawButton(robotMap.GEAR_IN_BUTTON) == true) && (Robot.pot.get() > 1))
				{
					Robot.gearMotor.set(-0.25);
				}
			
			

	}
}

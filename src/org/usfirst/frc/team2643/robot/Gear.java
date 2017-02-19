package org.usfirst.frc.team2643.robot;

public class Gear {
	public static void gear()
	{
		/*if(stick.getRawButton(1))
		{
			gearspeed = 0.2;
		}
		else if(stick.getRawButton(2))// alternate cde that always drives up 
		{
			gearspeed = 0;
		}
		else if(stick.getRawButton(3))
		{
			//gear.autoassist();
		}

		{
			gearMotor.set(gearspeed);//have yu nticed that the "o" key n the dell is really hard t press?
		}*/
		//		if(Robot.driveStick.getRawButton(9))
		//		{
		//			Robot.gear = 1;
		//		}
		//		if(Robot.driveStick.getRawButton(10))
		//		{
		//			Robot.gear = 2;
		//		}
		//		
		//		
		//		if(Robot.gear == 1)
		//		{
		//			Robot.gearMotor.set(0.2);
		//		}
		//		
		//		else if(Robot.gear == 2)
		//		{
		//			if(Robot.gearBottomLimit.get() == false)
		//			{
		//				Robot.gearMotor.set(0);
		//				
		//				System.out.println("bottom limit hit");
		//			}
		//			else if(Robot.gearBottomLimit.get() == true)
		//			{
		//				Robot.gearMotor.set(-0.5);
		//			}
		//			
		//		}
		//		if(Robot.gearTopLimit.get() == false){
		//			System.out.println("Top limit hit");	
		//		}
		if(RobotMap.driveStick.getRawButton(RobotMap.GEAR_MANUAL_RELEASE_BUTTON))
		{
			if(RobotMap.gearBottomLimit.get() == true)//if it is not hit
			{
				RobotMap.gearMotor.set(-0.4);
			}
			else
			{
				RobotMap.gearMotor.set(-0.4);
			}
		}
		else 
		{
			RobotMap.gearMotor.set(0);
		}
			
	}

}





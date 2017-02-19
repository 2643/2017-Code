package org.usfirst.frc.team2643.robot;



public class Toggle extends Robot {
	//Declare section
	static boolean speedToggle = false;
	static double yPosition = RobotMap.driveStick.getY();
	static double xPosition = RobotMap.driveStick.getX();
	static boolean isArcadeOn;
	/** 
	 * {@code testToggle()}:  
	 * 		If the toggleOn button is pressed, then the speed will be greatly reduced. 
	 * 		Else if the toggleOff button is pressed, then speed will be normal
	 * 		If the arcadeToggleOn button is pressed, then arcade mode will be on.
	 * 		Else if the arcadeToggleOff button is pressed, then tank mode will be on. 
	 */
	
	public static void toggle () {
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//If button 1 is pressed, then it will go to slow speed, else it if by default on normal speed//
		if (RobotMap.driveStick.getRawButton(RobotMap.toggleOn))  {
			speedToggle = true;
		}
		else if (RobotMap.driveStick.getRawButton(RobotMap.toggleOff)){
			speedToggle = false;
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// If the button is pressed the Arcade drive is toggled on otherwise it is by default on tank drive//
		if (RobotMap.driveStick.getRawButton(RobotMap.arcadeToggleOn)) {
			isArcadeOn = true;
		} else if (RobotMap.driveStick.getRawButton(RobotMap.arcadeToggleOff)) {
			isArcadeOn = false;
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//If the arcade is on, then the slow or normal speed will occur on arcade drive//
		if (isArcadeOn == true){
		
		    
			
			if (speedToggle == true){
				
				//slow arcade drive with gyro
			}
			
			else if(speedToggle == false){
				
				//aracade drive with gyro
				
			}		
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//If the arcade is off, then the slow or normal speed will occur on tank drive//
		else if (isArcadeOn == false){
			
			if(speedToggle == true){
				
				//System.out.println("TANK");
				RobotMap.rFrontMotor.set((RobotMap.driveStick.getRawAxis(5))*RobotMap.SLOW_MULTIPLIER);
				RobotMap.rBackMotor.set((RobotMap.driveStick.getRawAxis(5))*RobotMap.SLOW_MULTIPLIER);
				RobotMap.lFrontMotor.set((RobotMap.driveStick.getRawAxis(1))*-RobotMap.SLOW_MULTIPLIER);
				RobotMap.lBackMotor.set((RobotMap.driveStick.getRawAxis(1))*-RobotMap.SLOW_MULTIPLIER);
			}
			
			else if(speedToggle == false){
				
				//System.out.println("TANK");
				RobotMap.rFrontMotor.set(RobotMap.driveStick.getRawAxis(5));
				RobotMap.rBackMotor.set(RobotMap.driveStick.getRawAxis(5));
				RobotMap.lFrontMotor.set(-RobotMap.driveStick.getRawAxis(1));
				RobotMap.lBackMotor.set(-RobotMap.driveStick.getRawAxis(1));
			}
		}

	}
}

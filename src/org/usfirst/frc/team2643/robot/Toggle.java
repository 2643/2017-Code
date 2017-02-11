package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.RobotDrive;

public class Toggle extends Robot {
	//Declare section
	static boolean speedToggle = false;
	static double yPosition = driveStick.getY();
	static double xPosition = driveStick.getX();
	RobotDrive testdrive = new RobotDrive(lFrontMotor,rFrontMotor,lBackMotor,rBackMotor);


	public static void testToggle () {
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//If button 1 is pressed, then it will go to slow speed, else it if by default on normal speed//
		if (driveStick.getRawButton(1)) {
			speedToggle = true;
		}
		else if (driveStick.getRawButton(2)){
			speedToggle = false;
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// If the button is pressed the Arcade drive is toggled on otherwise it is by default on tank drive//
		if (driveStick.getRawButton(3)) {
			isArcadeOn = true;
		} else if (driveStick.getRawButton(4)) {
			isArcadeOn = false;
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//If the arcade is on, then the slow or normal speed will occur on arcade drive//
		if (isArcadeOn == true){
			if (speedToggle == true){
				rFrontMotor.set((yPosition + xPosition)*0.5);
				rBackMotor.set((yPosition + xPosition)*0.5);
				lFrontMotor.set((yPosition - xPosition)*-0.5);
				lBackMotor.set((yPosition - xPosition)*-0.5);
			}
			
			else if(speedToggle == false){
				rFrontMotor.set(yPosition + xPosition);
				rBackMotor.set(yPosition + xPosition);
				lFrontMotor.set(-(yPosition - xPosition));
				lBackMotor.set(-(yPosition - xPosition));

				
			}		
		}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//If the arcade is off, then the slow or normal speed will occur on tank drive//
		else if (isArcadeOn == false){
			if(speedToggle == true){
				rFrontMotor.set((driveStick.getRawAxis(1))*0.5);
				rBackMotor.set((driveStick.getRawAxis(1))*0.5);
				lFrontMotor.set((driveStick.getRawAxis(5))*-0.5);
				lBackMotor.set((driveStick.getRawAxis(5))*-0.5);
			}
			
			else if(speedToggle == false){
				rFrontMotor.set(driveStick.getRawAxis(1));
				rBackMotor.set(driveStick.getRawAxis(1));
				lFrontMotor.set(-driveStick.getRawAxis(5));
				lBackMotor.set(-driveStick.getRawAxis(5));
			}
		}

	}
}

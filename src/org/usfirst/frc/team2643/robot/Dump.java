package org.usfirst.frc.team2643.robot;

public class Dump {
	public Dump(){
		
	}
	public void dump(){
			//Some Encoder
			int SOMENUMBER = 0;
			
			/*If the up dpad is pressed and the "dumpEncoder" is less than just some number, 
			 * then the motor dump motor moves at a speed of 0.5 until the "dumpEncoder" is 
			 * bigger than some number.*/
			if(Robot.opStick.getPOV() == 0 && RobotMap.dumpEncoder.get() <= SOMENUMBER ){
				Robot.dumpMotor.set(0.5);
			}
			/*Else, if the down dpad is pressed and the limit switch has not been pressed,
			 * then*/
			else if(Robot.opStick.getPOV() == 180 && Robot.limitSwitch.get() == false){
				Robot.dumpMotor.set(-0.5);
				RobotMap.dumpEncoder.reset();
			}
			else{
				Robot.dumpMotor.set(0);
			}
		}
	}


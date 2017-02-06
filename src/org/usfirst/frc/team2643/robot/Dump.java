package org.usfirst.frc.team2643.robot;

public class Dump {
	public Dump(){
		
	}
	public void dump(){
			//Some Encoder
			int SOMENUMBER = 0;
			
			/*If the button is pressed and the "dumpEncoder" is less than just some number, 
			 * then the motor dump motor moves at a speed of 0.5 until the "dumpEncoder" is 
			 * bigger than some number.*/
			if(Robot.opStick.getRawButton(4)&& robotMap.dumpEncoder.get() <= SOMENUMBER ){
				Robot.dumpMotor.set(0.5);
			}
			/*Else, if the other button is pressed and the limit switch has not been pressed,
			 * then*/
			else if(Robot.opStick.getRawButton(3) && Robot.limitSwitch.get() == false){
				Robot.dumpMotor.set(-0.5);
				robotMap.dumpEncoder.reset();
			}
			else{
				Robot.dumpMotor.set(0);
			}
		}
	}
}

package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Spark;

public class Drive {
	/**
	 * @lFrontMotor
	 * 		left front wheel motor
	 */
	private Spark lFrontMotor;
	/**
	 * @lBackMotor
	 * 		left back motor
	 */
	private Spark lBackMotor;
	/**
	 * @rFrontMotor
	 * 		right front motor
	 */
	private Spark rFrontMotor;
	/**
	 * @rBackMotor
	 * 		right back motor
	 */
	private Spark rBackMotor = new Spark(RobotMap.RIGHT_BACK_SPARK_PWM_PORT);

	public Drive(){
		lFrontMotor = new Spark(RobotMap.LEFT_FRONT_SPARK_PWM_PORT);
		lBackMotor = new Spark(RobotMap.LEFT_BACK_SPARK_PWM_PORT);
		rFrontMotor = new Spark(RobotMap.RIGHT_FRONT_SPARK_PWM_PORT);
		rBackMotor = new Spark(RobotMap.RIGHT_BACK_SPARK_PWM_PORT);

	}
	/**
	 * {@code drive()}: 
	 * 		Sets the motors to the values of the y axis from both of the joysticks on the gamepad.
	 * 		Tank Drive.
	 */
	public void drive(){
		//The left front motor is set to the stick on the joystick, y axis (1).
			lFrontMotor.set(Robot.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS));
		//The left back motor is set to the stick on the joystick, y axis (1).
			lBackMotor.set(Robot.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS));
		//The right back motor is set to the stick on the joystick, y axis (5).
			rBackMotor.set(Robot.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS));
		//The right front motor is set to the stick on the joystick, y axis (5).
			rFrontMotor.set(Robot.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS));
			
		
	}
}


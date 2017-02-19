package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;


public class RobotMap {
	/**
	 * @WheelMotors
	 * 		These are the wheel motors
	 */
	public static Spark lFrontMotor = new Spark(1); //TODO The port
	public static Spark lBackMotor = new Spark(2);  //TODO The port
	public static Spark rFrontMotor = new Spark(5); //TODO The port
	public static Spark rBackMotor = new Spark(6);  //TODO The port

	/**
	 * @gearMotor
	 * 		motor for the gear
	 */
	public static Spark gearMotor = new Spark(8); //TODO Check the port
	/**
	 * @intakeMotor
	 * 		motor for the intake
	 */
	public static Spark intakeMotor = new Spark(9); //TODO check the port
//	/**
//	 * @CLIMBER_MOTOR_PORT
//	 * 		port for the climber motor
//	 * 		*currently does not exist on the robot
//	 */
//	public static Spark climberMotor = new Spark(666);	
	/**
	 * @dumpMotor
	 * 		the motor for the dump
	 */
	public static Spark dumpMotor = new Spark(3); 
	
	
	//Encoders
//	/**
//	 * @leftEncoder
//	 * 		the encoder for the left side wheels
//	 */
//	static Encoder leftEncoder = new Encoder(1, 2);
//	/**
//	 * @rightEncoder
//	 * 		the encoder for the right side wheels
//	 */
//	static Encoder rightEncoder = new Encoder(3, 4);
//	/**
//	 * @dumpEncoder
//	 * 		the encoder for the dump
//	 */
//	static Encoder dumpEncoder = new Encoder(5, 6);

	//Joysticks
	/**
	 * @driveStick
	 * 		driver joystick
	 */
	public static Joystick driveStick = new Joystick(0);
	/**
	 * @opStick
	 * 		operator joystick
	 */
	public static Joystick opStick = new Joystick(1);
			// right motor axis on joystick
	/**
	 		* @RIGHT_JOYSTICK_AXIS
	 * 			the axis used for the wheels on the right side
	 */
			static int RIGHT_JOYSTICK_AXIS = 5;

			// left motor axis on joystick
	/**
	 		* @LEFT_JOYSTICK_AXIS
	 * 		the y axis used for the wheels on the left side of the robot
	 */
			static int LEFT_JOYSTICK_AXIS = 1;

	// slow multiplier
	/**
	 * @SLOW_MULTLIPLIER
	 * 		this is the slow multiplier used in toggle drive
	 */
	static double SLOW_MULTIPLIER = 0.5;


	//limit switches
		///dump limit switches
		/** @hallEffectTop
		 * 		the top limit switch for the dump
		 */
		public static DigitalInput hallEffectTop = new DigitalInput(1);  //TODO The port is not right
	
		//gear limit switches
	/**
	 	* @gearTopLimit
	 * 		the top limit switch for the gear
	 */
		public static DigitalInput gearTopLimit = new DigitalInput(5);  //TODO Check the port
	/**
	 	* @gearBottomLimit
	 * 		the bottom limit switch for the gear
	 */
		public static DigitalInput gearBottomLimit = new DigitalInput(6);//TODO Check the port
	
	
	//constants in autonomous
	/**
	 * @AUTO_SPEED_ON
	 * 		the speed for autonomous
	 */
	static double AUTO_SPEED_ON = 0.5;
	/**
	 * @AUTO_SPEED_OFF
	 * 		another speed for autonomous
	 */
	static int AUTO_SPEED_OFF = 0;
	/**
	 * @BOILER_AUTO_DISTANCE
	 * 		distance to boiler
	 */
	static int BOILER_AUTO_DISTANCE = 500;
	/**
	 * @HOPPER_AUTO_DISTANCE
	 * 		distance to the hopper
	 */
	static int HOPPER_AUTO_DISTANCE = 50;
	/**
	 * @AIRSHIP_AUTO_DISTANCE
	 * 		distance to the airship
	 */
	static int AIRSHIP_AUTO_DISTANCE = 50;
	/**
	 * @AUTO_LINE_DISTANCE
	 * 		distance to the auto line
	 */
	static int AUTO_LINE_DISTANCE = 2200;


	//motor speeds
		//intake speeds
	/**
	 	* @INTAKE_IN_SPEED
	 * 		speed of the intake motor when taking in fuel
	 */
		static double INTAKE_IN_SPEED = 0.5;
		/**
		 * @INTAKE_OUT_SPEED
	 * 		intake speed when releasing fuel
	 */
		static double INTAKE_OUT_SPEED = -0.5;
	/**
	 	* @INTAKE_NO_SPEED
	 * 	 	intake speed when nothing is happening
	 */
		static int INTAKE_NO_SPEED = 0;


		//dump speeds
	/**
	 	* @DUMP_UP_FULL_SPEED
	 * 		speed of the motor when the dump is full
	 */
		static double DUMP_UP_FULL_SPEED = 0.25;
	/**
	 	* @DUMP_UP_HALF_SPEED
	 * 		speed of the motor, when the dump is holding only 10 balls
	 */
		static double DUMP_UP_HALF_SPEED = 0.3;
	/**
	 	* @DUMP_DOWN_SPEED
	 * 		dump motor speed when going down
	 */
		static double DUMP_DOWN_SPEED = 0.3;
	/**
	 	* @DUMP_NO_SPEED
	 * 		speed of the dump motor, when it is not running
	 */
		static int DUMP_NO_SPEED = 0;
	

	
/*
 * The Buttons
 */
	//toggle buttons
	/**
	 * @toggleOn
	 * 		button to turn the speed toggle on
	 *		used in Toggle.class
	 */
	public static int toggleOn = 1;
	/**
	 * @toggleOff
	 * 		button to turn speed toggle off
	 * 		used in Toggle.class
	 */
	public static int toggleOff = 2;
	//arcadeToggle
	/**
	 * @arcadeToggleOn
	 * 		button to turn on arcade mode
	 * 		used in Toggle.class
	 */
	public static int arcadeToggleOn = 5;
	/**
	 * @arcadeToggleOff
	 * 		button to turn arcade mode odd
	 * 		used in Toggle.class
	 */
	public static int arcadeToggleOff = 6; 
	
	//gear buttons
	/**
	 * @GEAR_MANUAL_RELEASE_BUTTON
	 * 	the button that releases the gear
	 */
	public static int GEAR_MANUAL_RELEASE_BUTTON = 4; //TODO get the right button
	
	// intake buttons
	/**
	 * @INTAKE_IN_BUTTON
	 * 		the button for intake in
	 */
	static int INTAKE_IN_BUTTON = 5;   //TODO get the right button
	/**
	 * @INTAKE_OUT_BUTTON
	 * 		the button for intake out
	 */
	static int INTAKE_OUT_BUTTON = 6;  //TODO get the right button
	/**
	 * @INTAKE_OUT_BUTTON
	 * 		the button for intake out
	 */
	static int INTAKE_NO_BUTTON = 666;//TODO get the right button
	 
	//dump buttons(on the dpad)
	public static int DUMP_FULL_UP_BUTTON = 0;
	public static int DUMP_HALF_UP_BUTTON = 90;
	public static int DUMP_DOWN_BUTTON = 180;

//Preset conditions for each function
	public static int intake = 3; //the intake does nothing
	public static int gear = 2; // the gear motor will do nothing
}
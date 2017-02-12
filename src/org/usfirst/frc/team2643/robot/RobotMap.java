package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;

public class RobotMap {

	//wheel motor ports
	/**
	 * @LEFT_FRONT_SPARK_PWN_PORT
  	 * 		left front wheel motor port
	 */
	static int LEFT_FRONT_SPARK_PWM_PORT = 7;
	/**
	 * @LEFT_BACK_SPARK_PWN_PORT
	 * 		left back wheel motor port
	 */
	static int LEFT_BACK_SPARK_PWM_PORT = 5;
	/**
	 * @RIGHT_FRONT_SPARK_PWN_PORT
	 * 		right front motor wheel port
	 */
	static int RIGHT_FRONT_SPARK_PWM_PORT = 6;
	/**
	 * @RIGHT_BACK_SPARK_PWN_PORT
	 * 		right back wheel motor port
	 */
	static int RIGHT_BACK_SPARK_PWM_PORT = 4;

	//potentiometer ports
	 /** 
	  * @ANALOG_INPUT_PORT 
	  * 		the analog port for the analog potentiometer
	  */
	static AnalogInput ANALOG_INPUT_PORT = new AnalogInput(0);
	/**
	 * @ANALOG_INPUT_PORT1
	 * 		the scale for the potentiometer
	 */
	static int ANALOG_INPUT_PORT1 = 360;
	/**
	 * @ANALOG_INPUT_PORT2
	 * 		the starting point for the potentiometer
	 */
	static int ANALOG_INPUT_PORT2 = 0;

	// encoder ports
	/**
	 * @leftEncoder
	 * 		the encoder for the left side wheels
	 */
	static Encoder leftEncoder = new Encoder(1, 2);
	/**
	 * @rightEncoder
	 * 		the encoder for the right side wheels
	 */
	static Encoder rightEncoder = new Encoder(3, 4);
	
	//dump encoder
	/**
	 * @dumpEncoder
	 * 		the encoder for the dump
	 */
	static Encoder dumpEncoder = new Encoder(5, 6);

	// joystick port
	/**
	 * @JOYSTICK_PORT
	 * 		driver joystick port
	 */
	static int JOYSTICK_PORT = 0;
	/**
	 * @JOYSTICK_PORT2
	 * 		operator stick port
	 */
	static int JOYSTICK_PORT2 = 1;

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
	static int LEFT_JOYSTICK_AXIS =1;

	// slow multiplier
	/**
	 * @SLOW_MULTLIPLIER
	 * 		this is the slow multiplier used in toggle drive
	 */
	static double SLOW_MULTIPLIER = 0.5;

	// gear motor port
	/**
	 * @GEAR_MOTOR_PORT
	 * 		port for the gear motor
	 */
	static int GEAR_MOTOR_PORT = 8;

	// intake motor port
	/**
	 * @INTAKE_MOTOR_PORT
	 * 		port for the intake motor
	 */
	static int INTAKE_MOTOR_PORT = 9;

	//climber motor port
	/**
	 * @CLIMBER_MOTOR_PORT
	 * 		port for the climber motor
	 * 		*currently does not exist on the robot
	 */
	static int CLIMBER_MOTOR_PORT = 666;   //need to change this later
	
	//dump motor port
	/**
	 * @DUMP_MOTOR_PORT
	 * 		port for the dump motor
	 */
	static int DUMP_MOTOR_PORT = 3;
	
	//dump limit switch
	/**
	 * @TOP_DUMP_LIMIT_SWITCH_PORT
	 * 		port for the HalEffect sensor
	 */
	static int TOP_DUMP_LIMIT_SWITCH_PORT = -666;   //need to change this later
	/**
	 * @BOTTOM_DUMP_LIMIT_SWITCH_PORT
	 * 		port for the HalEffect sensor
	 */
	static int BOTTOM_DUMP_LIMIT_SWITCH_PORT = -666;   //need to change this later
	
	// autonomous speed
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


	// intake motor speed
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

	// intake buttons
	/**
	 * @INTAKE_IN_BUTTON
	 * 		the button for intake in
	 */
	static int INTAKE_IN_BUTTON = 5;
	/**
	 * @INTAKE_OUT_BUTTON
	 * 		the button for intake out
	 */
	static int INTAKE_OUT_BUTTON = 6;

	/**
	 * @DUMP_UP_SPEED
	 * 		speed of the motor when going up
	 */
	static double DUMP_UP_SPEED = 0.25;
	
	/**
	 * @DUMP_DOWN_SPEED
	 * 		speed of the motor, when releasing the fuel
	 */
	static double DUMP_DOWN_SPEED = -0.25;
	
	/**
	 * @DUMP_NO_SPEED
	 * 		speed of the dump motor, when it is not running
	 */
	static int DUMP_NO_SPEED = 0;
	// toggle button
	/**
	 * @TOGGLE_ON_BUTTON
	 * 		speed toggle button on
	 */
	static int TOGGLE_ON_BUTTON = 1;
	/**
	 * @TOGGLE_OFF_BUTTON
	 * 		speed toggle off button
	 */
	static int TOGGLE_OFF_BUTTON = 2;
	/**
	 * @ARCADE_TOGGLE_ON_BUTTON
	 * 		the button to turn on arcade mode
	 */
	static int ARCADE_TOGGLE_ON_BUTTON = 5;
	/**
	 * @ARCADE_TOGGLE_OFF_BUTTON
	 * 		the button to turn arcade mode off
	 */
	static int ARCADE_TOGGLE_OFF_BUTTON = 6;


	// auto line distance
	/**
	 * @AUTO_LINE_DISTANCE
	 * 		distance to the auto line
	 */
	static int AUTO_LINE_DISTANCE = 2200;

}

package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;

public class robotMap {

	// wheel motor ports
	static int LEFT_FRONT_TALON_PWM_PORT = 7;
	static int LEFT_BACK_TALON_PWM_PORT = 5;
	static int RIGHT_FRONT_SPARK_PWM_PORT = 6;
	static int RIGHT_BACK_SPARK_PWM_PORT = 4;

	// potentiometer ports
	static AnalogInput ANALOG_INPUT_PORT = new AnalogInput(0);
	static int ANALOG_INPUT_PORT1 = 360;
	static int ANALOG_INPUT_PORT2 = 0;

	// encoder ports
	static Encoder leftEncoder = new Encoder(1, 2);
	static Encoder rightEncoder = new Encoder(3, 4);
	
	//dump encoder
	static Encoder dumpEncoder = new Encoder(5, 6);

	// joystick port
	static int JOYSTICK_PORT = 0;
	static int JOYSTICK_PORT2 = 1;

	// right motor axis on joystick
	static int RIGHT_JOYSTICK_AXIS = 5;

	// left motor axis on joystick
	static int LEFT_JOYSTICK_AXIS = 1;

	// slow multiplier
	static double SLOW_MULTIPLIER = 0.5;

	// gear motor port
	static int GEAR_MOTOR_PORT = 8;

	// potentiometer
	static int POTENTIOMETER_PORT = 0;

	// intake motor port
	static int INTAKE_MOTOR_PORT = 9;

	//climber motor port
	static int CLIMBER_MOTOR_PORT = 666;   //need to change this later
	
	//dump motor port
	static int DUMP_MOTOR_PORT = -666;     //need to change this later
	
	//dump limit switch
	static int DUMP_LIMIT_SWITCH_PORT = -666;   //need to change this later
	
	// autonomous speed
	static double AUTO_SPEED_ON = 0.5;
	static int AUTO_SPEED_OFF = 0;
	static int BOILER_AUTO_DISTANCE = 500;
	static int HOPPER_AUTO_DISTANCE = 50;
	static int AIRSHIP_AUTO_DISTANCE = 50;

	// gear motor speed
	static double GEAR_MOTOR_IN_SPEED = -0.25;
	static double GEAR_MOTOR_OUT_SPEED = 0.25;
	static int GEAR_MOTOR_NO_SPEED = 0;

	// intake motor speed
	static double INTAKE_IN_SPEED = 0.5;
	static double INTAKE_OUT_SPEED = -0.5;
	static int INTAKE_NO_SPEED = 0;

	// intake buttons
	static int INTAKE_IN_BUTTON = 5;
	static int INTAKE_OUT_BUTTON = 6;

	// toggle button
	static int TOGGLE_ON_BUTTON = 1;
	static int TOGGLE_OFF_BUTTON = 2;

	// gear button motors
	static int GEAR_IN_BUTTON = 3;
	static int GEAR_OUT_BUTTON = 2;
	static int GEAR_MIDDLE_BUTTON = 1;

	// auto line distance
	static int AUTO_LINE_DISTANCE = 2200;

}

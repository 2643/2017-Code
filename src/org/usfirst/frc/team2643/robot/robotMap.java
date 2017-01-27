package org.usfirst.frc.team2643.robot;

public  class robotMap {
	//wheel motor ports
	static int LEFT_FRONT_SPARK_PWM_PORT = 0;
	static int LEFT_BACK_SPARK_PWM_PORT = 1;
	static int RIGHT_FRONT_SPARK_PWM_PORT = 3;
	static int RIGHT_BACK_SPARK_PWM_PORT = 2;
	
	//joystick port
	static int JOYSTICK_PORT = 0;
	
	//right motor axis on joystick
	static int RIGHT_JOYSTICK_AXIS = 5;
	
	//left motor axis on joystick
	static int LEFT_JOYSTICK_AXIS = 1;
	
	
	//toggle button
	static int TOGGLE_ON_BUTTON = 2;
	static int TOGGLE_OFF_BUTTON = 3;
	
	//slow multiplier
	static double SLOW_MULTIPLIER = 0.5;
	
	//gear limit switch 
	static int GEAR_LIMIT_SWITCH_PORT = 2;
	
	//gear motor port
	static int GEAR_MOTOR_PORT = 8;
	
	//intake motor port
	static int INTAKE_MOTOR_PORT = 9;
	
	//time limit for autonomous 
	static int AUTO_TIME_LIMIT = 2;
	
	//gear lift buttons
	static int GEAR_LIFT_ON = 0;
	static int GEAR_LIFT_OFF = 1;
	
	//intake buttons
	static int INTAKE_IN = 2;
	static int INTAKE_OUT = 3;
	
	//autonomous speed 
	static double AUTO_SPEED_ON = 0.5;
	static int AUTO_SPEED_OFF = 0;
	
	//gear motor speed
	static double GEAR_MOTOR_IN_SPEED = 0.25;
	static double GEAR_MOTOR_OUT_SPEED = -0.25;
	static int GEAR_MOTOR_NO_SPEED = 0;
	
	
	//intake motor speed
	static double INTAKE_IN_SPEED = 0.5;
	static double INTAKE_OUT_SPEED = -0.5;
	static int INTAKE_NO_SPEED = 0;
}

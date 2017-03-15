package org.usfirst.frc.team2643.robot;

import java.text.NumberFormat;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

public class RobotMap
{
	// Drive Motors
	public static Spark lFrontMotor = new Spark(5);
	public static Spark lBackMotor = new Spark(2);
	public static Spark rFrontMotor = new Spark(6);
	public static Spark rBackMotor = new Spark(1);

	// More Motors
	public static Spark gearMotor = new Spark(7);
	public static Spark intakeMotor = new Spark(4);
	public static Spark dumpMotor = new Spark(3);
	public static Spark climbMotor = new Spark(0);
	
	// Encoders
	static Encoder leftEncoder = new Encoder(1, 2);
	static Encoder rightEncoder = new Encoder(3, 4);

	// Joysticks
	public static Joystick driveStick = new Joystick(0);
	public static Joystick opStick = new Joystick(1);

	// Joystick axis
	static int RIGHT_JOYSTICK_AXIS = 5;
	static int LEFT_JOYSTICK_AXIS = 1;

	// slow multiplier
	static double SLOW_MULTIPLIER = 0.65;

	/* limit switches */
	// dump limit switches
	public static DigitalInput hallEffectTop = new DigitalInput(8);

	// gear limit switches
	public static DigitalInput gearTopLimit = new DigitalInput(5);
	public static DigitalInput gearBottomLimit = new DigitalInput(6);

	// constants in autonomous
	/**
	 * @AUTO_SPEED_ON the speed for autonomous
	 */
	static double AUTO_SPEED_ON = 0.5;
	/**
	 * @AUTO_SPEED_OFF another speed for autonomous
	 */
	static int AUTO_SPEED_OFF = 0;
	/**
	 * @BOILER_AUTO_DISTANCE distance to boiler
	 */
	static int BOILER_AUTO_DISTANCE = 500;
	/**
	 * @HOPPER_AUTO_DISTANCE distance to the hopper
	 */
	static int HOPPER_AUTO_DISTANCE = 50;
	/**
	 * @AIRSHIP_AUTO_DISTANCE distance to the airship
	 */
	static int AIRSHIP_AUTO_DISTANCE = 50;
	/**
	 * @AUTO_LINE_DISTANCE distance to the auto line
	 */
	static int AUTO_LINE_DISTANCE = 2200;

	// motor speeds
	// intake speeds
	static double INTAKE_IN_SPEED = -0.6;// increased from 0.6, where it did not
											// always intake, although it did
											// some times.
	static double INTAKE_OUT_SPEED = 0.75;
	static int INTAKE_NO_SPEED = 0;
	static double INTAKE_IN_FASTER = -0.8;

	// dump speeds
	static double DUMP_UP_FULL_SPEED = 0.45;
	static double DUMP_UP_HALF_SPEED = 0.3;
	static int DUMP_NO_SPEED = 0;
	static double DUMP_HOVER_SPEED = 0.2;

	/*
	 * The Buttons
	 */
	// toggle buttons
	public static int toggleOn = 2;
	public static int toggleOff = 1;

	// arcadeToggle
	public static int arcadeToggleOn = 3;
	public static int arcadeToggleOff = 4;

	// gear buttons
	public static int GEAR_MANUAL_RELEASE_BUTTON = 6;

	// intake buttons
	static int INTAKE_IN_BUTTON = 2;
	static int INTAKE_OUT_BUTTON = 4;
	static int INTAKE_IN_FAST_BUTTON = 3;
	static int INTAKE_NO_BUTTON = 1;
	
	// vision buttons
	static int VISION_STREAMER = 7;
	static int VISION_AUTO_ASSIST = 8;
	
	// dump buttons(on the dpad)
	public static int DUMP_FULL_UP_BUTTON = 0;
	public static int DUMP_HALF_UP_BUTTON = 90;
	public static int DUMP_DOWN_BUTTON = 180;

	// Preset conditions for each function
	public static int intake = 3; // the intake does nothing
	public static int gear = 2; // the gear motor will do nothing

	// Advanced Auto
	static int state;
	static boolean toggle = true;
	static String autoMode = "c";

	// Arduino
	//final static int baut = 230400;
	//static SerialPort arduino = new SerialPort(baut, SerialPort.Port.kUSB1);
	
	//gyro
	static double tmp;
	static int x;
	static NumberFormat f = NumberFormat.getInstance();
	static double myNumber = 0;
	static boolean gyroToggle = true;
}
package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class Declaration extends IterativeRobot {

	/**
	 * @pot
	 * 		not used anymore; only used in testPeriodic
	 */
	static Potentiometer pot = new AnalogPotentiometer(RobotMap.ANALOG_INPUT_PORT, RobotMap.ANALOG_INPUT_PORT1,
			RobotMap.ANALOG_INPUT_PORT2);
	
	// Setting the motors to their ports
	/**
	 * @lFrontMotor
	 * 		left front wheel motor
	 */
	static Spark lFrontMotor = new Spark(RobotMap.LEFT_FRONT_SPARK_PWM_PORT);
	/**
	 * @lBackMotor
	 * 		left back motor
	 */
	static Spark lBackMotor = new Spark(RobotMap.LEFT_BACK_SPARK_PWM_PORT);
	/**
	 * @rFrontMotor
	 * 		right front motor
	 */
	static Spark rFrontMotor = new Spark(RobotMap.RIGHT_FRONT_SPARK_PWM_PORT);
	/**
	 * @rBackMotor
	 * 		right back motor
	 */
	static Spark rBackMotor = new Spark(RobotMap.RIGHT_BACK_SPARK_PWM_PORT);
	
	//declaring a new joystick called stick, and another called opStick
	/**
	 * @driveStick
	 * 		driver joystick
	 */
	static Joystick driveStick = new Joystick(RobotMap.JOYSTICK_PORT);
	/**
	 * @opStick
	 * 		operator joystick
	 */
	static Joystick opStick = new Joystick(RobotMap.JOYSTICK_PORT2);
	

	//toggleOn & toggleOff buttons
	/**
	 * @toggleOn
	 * 		button to turn the speed toggle on
	 *		used in Toggle.class
	 */
	static int toggleOn = RobotMap.TOGGLE_ON_BUTTON;
	/**
	 * @toggleOff
	 * 		button to turn speed toggle off
	 * 		used in Toggle.class
	 */
	static int toggleOff = RobotMap.TOGGLE_OFF_BUTTON;

	//arcadeToggle
	/**
	 * @arcadeToggleOn
	 * 		button to turn on arcade mode
	 * 		used in Toggle.class
	 */
	static int arcadeToggleOn = RobotMap.ARCADE_TOGGLE_ON_BUTTON;
	/**
	 * @arcadeToggleOff
	 * 		button to turn arcade mode odd
	 * 		used in Toggle.class
	 */
	static int arcadeToggleOff = RobotMap.ARCADE_TOGGLE_OFF_BUTTON;
	
	// the number to make the speed of the robot slower
	/**
	 * @slowMult
	 * 		used in Toggle.class
	 */
	static double slowMult = RobotMap.SLOW_MULTIPLIER;

	// boolean to see if arcade is toggled on or off/true or false
	/**
	 * @isArcadeOn
	 * 		used in Toggle.class
	 */
	static boolean isArcadeOn = false;
	
	//declaring the gear motor
	/**
	 * @gearMotor
	 * 		motor for the gear
	 */
	static Spark gearMotor = new Spark(RobotMap.GEAR_MOTOR_PORT);
	
	//declaring the intake motor
	/**
	 * @intakeMotor
	 * 		motor for the intake
	 */
	static Spark intakeMotor = new Spark(RobotMap.INTAKE_MOTOR_PORT);
	
	//declaring the climber motor
	/**
	 * This is the motor for the climber.
	 * It currently is not on the robot. Only exists in testPeriodic.
	 */
	static Spark climberMotor = new Spark(RobotMap.CLIMBER_MOTOR_PORT);
	
	//declaring the dump motor
	/**
	 * @dumpMotor
	 * 		the motor for the dump
	 */
	static Spark dumpMotor = new Spark(RobotMap.DUMP_MOTOR_PORT);
	
	//dump limit switch
	/**
	 * @hallEffectTop
	 * 		the top limit switch for the dump
	 */
	static DigitalInput hallEffectTop = new DigitalInput(RobotMap.TOP_DUMP_LIMIT_SWITCH_PORT);
	/**
	 * @hallEffectBottom
	 * 		the bottom limit switch for the dump
	 */
	static DigitalInput hallEffectBottom = new DigitalInput(RobotMap.BOTTOM_DUMP_LIMIT_SWITCH_PORT);
	
	//Imported from robotMap.java for speeds and distances
	/**
	 * @AUTO_SPEED_ON
	 * @AUTO_SPEED_OFF
	 * @BOILER_AUTO_DISTANCE
	 * @HOPPER_AUTO_DISTANCE
	 * @AIRSHIP_AUTO_DISTANCE
	 * 		Already is defined in RobotMap
	 */
	static double AUTO_SPEED_ON = RobotMap.AUTO_SPEED_ON;
	static int AUTO_SPEED_OFF = RobotMap.AUTO_SPEED_OFF;
	static int BOILER_AUTO_DISTANCE = RobotMap.BOILER_AUTO_DISTANCE;
	static int HOPPER_AUTO_DISTANCE = RobotMap.HOPPER_AUTO_DISTANCE;
	static int AIRSHIP_AUTO_DISTANCE = RobotMap.AIRSHIP_AUTO_DISTANCE;

	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	// leds
	public static final int LEDNUMBER = 48;
	LEDController led = new LEDController(LEDNUMBER);

}

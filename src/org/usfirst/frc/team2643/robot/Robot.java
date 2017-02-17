package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	// Setting the motors to their ports
	
	//declaring a new joystick called stick, and another called opStick
	/**
	 * @driveStick
	 * 		driver joystick
	 */
	public static Joystick driveStick = new Joystick(RobotMap.JOYSTICK_PORT);
	/**
	 * @opStick
	 * 		operator joystick
	 */
	public static Joystick opStick = new Joystick(RobotMap.JOYSTICK_PORT2);
	

	//toggleOn & toggleOff buttons
	/**
	 * @toggleOn
	 * 		button to turn the speed toggle on
	 *		used in Toggle.class
	 */
	public static int toggleOn = RobotMap.TOGGLE_ON_BUTTON;
	/**
	 * @toggleOff
	 * 		button to turn speed toggle off
	 * 		used in Toggle.class
	 */
	public static int toggleOff = RobotMap.TOGGLE_OFF_BUTTON;

	//arcadeToggle
	/**
	 * @arcadeToggleOn
	 * 		button to turn on arcade mode
	 * 		used in Toggle.class
	 */
	public static int arcadeToggleOn = RobotMap.ARCADE_TOGGLE_ON_BUTTON;
	/**
	 * @arcadeToggleOff
	 * 		button to turn arcade mode odd
	 * 		used in Toggle.class
	 */
	public static int arcadeToggleOff = RobotMap.ARCADE_TOGGLE_OFF_BUTTON;
	
	// the number to make the speed of the robot slower
	/**
	 * @slowMult
	 * 		used in Toggle.class
	 */
	public static double slowMult = RobotMap.SLOW_MULTIPLIER;

	// boolean to see if arcade is toggled on or off/true or false
	/**
	 * @isArcadeOn
	 * 		used in Toggle.class
	 */
	public static boolean isArcadeOn = false;
	
	//declaring the gear motor
	/**
	 * @gearMotor
	 * 		motor for the gear
	 */
	public static Spark gearMotor = new Spark(RobotMap.GEAR_MOTOR_PORT);
	
	//declaring the intake motor
	/**
	 * @intakeMotor
	 * 		motor for the intake
	 */
	public static Spark intakeMotor = new Spark(RobotMap.INTAKE_MOTOR_PORT);
	
	//declaring the climber motor
	/**
	 * This is the motor for the climber.
	 * It currently is not on the robot. Only exists in testPeriodic.
	 */
	public static Spark climberMotor = new Spark(RobotMap.CLIMBER_MOTOR_PORT);
	
	//declaring the dump motor
	/**
	 * @dumpMotor
	 * 		the motor for the dump
	 */
	public static Spark dumpMotor = new Spark(RobotMap.DUMP_MOTOR_PORT);
	
	public static Spark lFrontMotor = new Spark(RobotMap.LEFT_FRONT_SPARK_PWM_PORT);
	public static Spark lBackMotor = new Spark(RobotMap.LEFT_BACK_SPARK_PWM_PORT);
	
	public static Spark rFrontMotor = new Spark(RobotMap.RIGHT_FRONT_SPARK_PWM_PORT);
	public static Spark rBackMotor = new Spark(RobotMap.RIGHT_BACK_SPARK_PWM_PORT);
	
	
	//dump limit switch
	/**
	 * @hallEffectTop
	 * 		the top limit switch for the dump
	 */
	public static DigitalInput hallEffectTop = new DigitalInput(RobotMap.TOP_DUMP_LIMIT_SWITCH_PORT);
	/**
	 * @hallEffectBottom
	 * 		the bottom limit switch for the dump
	 */
	public static DigitalInput hallEffectBottom = new DigitalInput(RobotMap.BOTTOM_DUMP_LIMIT_SWITCH_PORT);
	
	//Imported from robotMap.java for speeds and distances
	/**
	 * @AUTO_SPEED_ON
	 * @AUTO_SPEED_OFF
	 * @BOILER_AUTO_DISTANCE
	 * @HOPPER_AUTO_DISTANCE
	 * @AIRSHIP_AUTO_DISTANCE
	 * 		Already is defined in RobotMap
	 */
	public static double AUTO_SPEED_ON = RobotMap.AUTO_SPEED_ON;
	public static int AUTO_SPEED_OFF = RobotMap.AUTO_SPEED_OFF;
	public static int BOILER_AUTO_DISTANCE = RobotMap.BOILER_AUTO_DISTANCE;
	public static int HOPPER_AUTO_DISTANCE = RobotMap.HOPPER_AUTO_DISTANCE;
	public static int AIRSHIP_AUTO_DISTANCE = RobotMap.AIRSHIP_AUTO_DISTANCE;

	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	// leds
	public static final int LEDNUMBER = 48;
	LEDController led = new LEDController(LEDNUMBER);
	
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		SmartDashboard.putData("Auto choices", chooser);
		// reseting the encoders
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();

		LedStrip allLEDs = new LedStrip(LEDNUMBER, 1.0f);
		allLEDs.allOff();
		allLEDs.update();
		led.initialize();
		led.reset();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		// if the leftencoder and the rightencoder, divided by two is less than
		// 2200, then it will make the robot
		// all 4 motors move at half speed.
		if ((Math.abs(RobotMap.leftEncoder.get()) + Math.abs(RobotMap.rightEncoder.get())) / 2 < 2200) {
			// a method defined up above to make all four motors move at half
			// speed.
			setAll(0.5);
		} else {
			// Setting all 4 motors to zero.
			setAll(0);
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// prints out the left encoder and the right encoder divided by 2
		System.out.println((Math.abs(RobotMap.leftEncoder.get()) + Math.abs(RobotMap.rightEncoder.get())) / 2);
		Intake.intake();
		Gear.gear(); 
		Drive.drive();
		colors();
		Dump.dump();
	}

	/**
	 * This function is called periodically during test mode
	 * 
	 * @button1: A button
	 * 		lFrontMotor is set to the left y axis, otherwise it is set to 0
	 * @button2: B button
	 * 		lBackMotor is set to the left y axis, otherwise it is set to 0
	 * @button3: X button
	 * 		rFrontMotor is set to the left y axis, otherwise it is set to 0
	 * @button4: Y button
	 * 		rBackMotor is set to the left y axis, otherwise it is set to 0
	 * @button5: back left button
	 * 		gearMotor is set to the left y axis, otherwise it is set to 0
	 * @button6: back right button
	 * 		dumpMotor is set to the left y axis, otherwise it is set to 0
	 * @button7: back button
	 * 		intakeMotor is set to the left y axis, otherwise it is set to 0
	 * @button8: start button
	 * 		climberMotor is set to the left y axis. otherwise it is set to 0
	 * @leftJoystickUp:
	 * 		prints the average of the encoders
	 * @leftJoystickDown: 
	 * 		prints the potentiometer value
	 */ 
	@Override
	public void testPeriodic() { 
		MotorTest.testMotor();
		MotorTest.teststuff();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Sets all motors to parameter speed
	 * 
	 * @param speed
	 * 		speed of the robot
	 */
	public static void setAll(double speed) {
		// making all the motors go to a set speed which will be told later.
		lFrontMotor.set(-speed);
		lBackMotor.set(-speed);
		rFrontMotor.set(speed);
		rBackMotor.set(speed);
	}
	
	/**
	 *  Starts and updates the led bars
	 */
	public void colors() {
		led.bars();
	}
	

}

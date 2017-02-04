package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
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
	 
	
	static Potentiometer pot = new AnalogPotentiometer(robotMap.ANALOG_INPUT_PORT,
			robotMap.ANALOG_INPUT_PORT1, robotMap.ANALOG_INPUT_PORT2);
	//Setting the motors to their ports
	static Spark lFrontMotor = new Spark(robotMap.LEFT_FRONT_SPARK_PWM_PORT);
	static Spark lBackMotor = new Spark(robotMap.LEFT_BACK_SPARK_PWM_PORT);
	static Spark rFrontMotor = new Spark(robotMap.RIGHT_FRONT_SPARK_PWM_PORT);
	static Spark rBackMotor = new Spark(robotMap.RIGHT_BACK_SPARK_PWM_PORT);
	
	//declaring a new robot drive
	RobotDrive drive = new RobotDrive(lFrontMotor, rFrontMotor, lBackMotor, rBackMotor);
	
	//declaring a new joystick called stick, and another called opStick
	static Joystick driveStick = new Joystick(robotMap.JOYSTICK_PORT);
	static Joystick opStick = new Joystick(robotMap.JOYSTICK_PORT2);
	
	//boolean for drive toggle
	static boolean driveToggle = false;
	
	//booleana for toggleOn & toggleOff
	static int toggleOn = robotMap.TOGGLE_ON_BUTTON;
	static int toggleOff = robotMap.TOGGLE_OFF_BUTTON;
	
	//the number to make the speed of the robot slower
	static double slowMult = robotMap.SLOW_MULTIPLIER;
	
	//boolean to see if arcade is toggled on or off/true or false
	boolean isArcadeOn = false;
	
	//declaring the gear motor
	static Spark gearMotor = new Spark(robotMap.GEAR_MOTOR_PORT);
	
	//declaring the intake motor
	static Spark intakeMotor = new Spark(robotMap.INTAKE_MOTOR_PORT);
	
	//Imported from robotMap.java for speeds and distances
	static double AUTO_SPEED_ON = 0.5;
	static int AUTO_SPEED_OFF = 0;
	static int BOILER_AUTO_DISTANCE = 500;
	static int HOPPER_AUTO_DISTANCE = 50;
	static int AIRSHIP_AUTO_DISTANCE = 50;
	
	
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
	
		SmartDashboard.putData("Auto choices", chooser);
		//reseting the encoders
		robotMap.leftEncoder.reset();
		robotMap.rightEncoder.reset();
		
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
		//if the leftencoder and the rightencoder, divided by two is less than 2200, then it will make the robot
		//all 4 motors move at half speed.
		if((Math.abs(robotMap.leftEncoder.get()) + Math.abs(robotMap.rightEncoder.get()))/2 < 2200)
		{
			//a method defined up above to make all four motors move at half speed.
			setAll(0.5);
		}
		else
		{
			//seting all 4 motors to zero.
			setAll(0);
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		//prints out the leftencoder and the right encoder divided by 2
		System.out.println((Math.abs(robotMap.leftEncoder.get()) + Math.abs(robotMap.rightEncoder.get()))/2);
		//Intake.intake();
		//Gear.gear();
		Drive.drive();
		ToggleDrive.toggledrive();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
	


 	public void setAll(double speed)
 	{
 		//making all the motors go to a set speed which will be told later.
 		speed = -speed;
 		lFrontMotor.set(speed);
 		lBackMotor.set(speed);
 		rFrontMotor.set(speed);
 		rBackMotor.set(speed);
 	}
}



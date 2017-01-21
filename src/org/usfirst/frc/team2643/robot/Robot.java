package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robotMap;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//wheel motors
	Spark lFrontMotor = new Spark(robotMap.LEFT_FRONT_SPARK_PWM_PORT);
	Spark lBackMotor = new Spark(robotMap.LEFT_BACK_SPARK_PWN_PORT);
	Spark rFrontMotor = new Spark(robotMap.RIGHT_FRONT_SPARK_PWN_PORT);
	Spark rBackMotor = new Spark(robotMap.RIGHT_FRONT_SPARK_PWN_PORT);
	
	//joystick 
	Joystick stick = new Joystick(robotMap.JOYSTICK_PORT);
	
	//driveToggle
	boolean driveToggle = false;
	
	//toggle buttons
	int toggleOn = robotMap.TOGGLE_ON_BUTTON;
	int toggleOff = robotMap.TOGGLE_OFF_BUTTON;
	double slowMult = robotMap.SLOW_MULTIPLIER;
	
	//arcade boolean
	boolean isArcadeOn = false;
	
	//gear motor and limit switch
	DigitalInput limitSwitch = new DigitalInput(robotMap.GEAR_LIMIT_SWITCH_PORT);
	Spark gearMotor = new Spark(robotMap.GEAR_MOTOR_PORT);
	
	//intake motor 
	Spark intakeMotor = new Spark(robotMap.INTAKE_MOTOR_PORT);
	
	//time limit for autonomous
	int time = robotMap.AUTO_TIME_LIMIT;
	
	//timer
	Timer AutoTimer = new Timer();
	
	//gear lift buttons
	int button = robotMap.GEAR_LIFT_ON;
	int button2 = robotMap.GEAR_LIFT_OFF;
	
	//intake buttons
	int button3 = robotMap.INTAKE_IN;
	int button4 = robotMap.INTAKE_IN;
	
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
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
		
		//start the timer
		AutoTimer.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() { 
		//while the timer is less than 10 seconds, then move forward
		if(AutoTimer.get() < time)
		{
			System.out.println(AutoTimer.get());
			lFrontMotor.set(robotMap.AUTO_SPEED_ON);
			lBackMotor.set(robotMap.AUTO_SPEED_ON);
			rFrontMotor.set(-robotMap.AUTO_SPEED_ON);
			rBackMotor.set(-robotMap.AUTO_SPEED_ON);
		}
		//else, stop
		else
		{
			AutoTimer.stop();
			lFrontMotor.set(robotMap.AUTO_SPEED_OFF);
			lBackMotor.set(robotMap.AUTO_SPEED_OFF);
			rFrontMotor.set(-robotMap.AUTO_SPEED_OFF);
			rBackMotor.set(-robotMap.AUTO_SPEED_OFF);
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		drive();
		toggleDrive();
		intake();
		gear();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
	
	public void toggleDrive() {
		// if you press the button, then driveToggle will be true
		if (stick.getRawButton(toggleOn)) {
			driveToggle = true;
		}
		// if you press the button for toggleOff, then driveToggle will be false
		else if (stick.getRawButton(toggleOff)) {
			driveToggle = false;
		}

		// if driveToggle is not on, then motors will be at the full speed
		// of the joystick
		if (!driveToggle) {
			lFrontMotor.set(stick.getRawAxis(robotMap.LEFT_WHEEL_AXIS));
			lBackMotor.set(stick.getRawAxis(robotMap.LEFT_WHEEL_AXIS));
			rFrontMotor.set(stick.getRawAxis(robotMap.RIGHT_WHEEL_AXIS)*-1);
			rBackMotor.set(stick.getRawAxis(robotMap.RIGHT_WHEEL_AXIS)*-1);
		}
		// otherwise if driveToggle is true, then the motors will be at the half
		// speed
		// of the joystick
		else {
			lFrontMotor.set((stick.getRawAxis(robotMap.LEFT_WHEEL_AXIS)) * slowMult);
			lBackMotor.set((stick.getRawAxis(robotMap.LEFT_WHEEL_AXIS)) * slowMult);
			rFrontMotor.set((stick.getRawAxis(robotMap.RIGHT_WHEEL_AXIS)) * -slowMult);
			rBackMotor.set((stick.getRawAxis(robotMap.RIGHT_WHEEL_AXIS)) * -slowMult);
		}

	}
	
public void drive(){
		//the motors are set the values of the joystick in tank drive
		lFrontMotor.set(stick.getRawAxis(robotMap.LEFT_WHEEL_AXIS));
		lBackMotor.set(stick.getRawAxis(robotMap.LEFT_WHEEL_AXIS));
		rBackMotor.set(stick.getRawAxis(robotMap.RIGHT_WHEEL_AXIS)*-1);
		rFrontMotor.set(stick.getRawAxis(robotMap.RIGHT_WHEEL_AXIS)*-1);
	}
	
 public void gear() {
	 //if the 0 button is pressed then, the robot will hold onto the gear
		if (stick.getRawButton(button)) {
			gearMotor.set(robotMap.GEAR_MOTOR_IN_SPEED);

		} 
		//if the 1 button is pressed, then the robot will release the gear
		else if(stick.getRawButton(button2)) {
			gearMotor.set(robotMap.GEAR_MOTOR_OUT_SPEED);
		}
		//otherwise, the gear mechanism will not move
		else{
			gearMotor.set(robotMap.GEAR_MOTOR_NO_SPEED);
		}
	}
	
 public void intake() {
	 	//if the 2 button is pressed , then the intake motor will take in the balls
		if (stick.getRawButton(button3) == true)
		{
			intakeMotor.set(robotMap.INTAKE_IN_SPEED);
		}
		//if the 3 button is pressed, then the intake motor will release the balls
		else if (stick.getRawButton(button4)) 
		{
			intakeMotor.set(robotMap.INTAKE_OUT_SPEED);
		} 
		//else, nothing will happen
		else {
			intakeMotor.set(robotMap.INTAKE_NO_SPEED);
		}
	}
 
}


package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2643.robot.robotMap;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//potentiometer
	Potentiometer pot = new AnalogPotentiometer(robotMap.POTENTIOMETER_PORT, 360,0);
	
	
	
	
	//wheel motors
	Spark lFrontMotor = new Spark(robotMap.LEFT_FRONT_SPARK_PWM_PORT);
	Spark lBackMotor = new Spark(robotMap.LEFT_BACK_SPARK_PWM_PORT);
	Spark rFrontMotor = new Spark(robotMap.RIGHT_FRONT_SPARK_PWM_PORT);
	Spark rBackMotor = new Spark(robotMap.RIGHT_FRONT_SPARK_PWM_PORT);
	
	Encoder lFrontMotorEncoder = new Encoder(robotMap.LEFT_FRONT_MOTOR_ENCODER_PORT_1, robotMap.LEFT_FRONT_MOTOR_ENCODER_PORT_2);
	Encoder lBackMotorEncoder = new Encoder(robotMap.LEFT_BACK_MOTOR_ENCODER_PORT_1, robotMap.LEFT_BACK_MOTOR_ENCODER_PORT_2);
	Encoder rFrontMotorEncoder = new Encoder(robotMap.RIGHT_FRONT_MOTOR_ENCODER_PORT_1, robotMap.RIGHT_FRONT_MOTOR_ENCODER_PORT_2,true);
	Encoder rBackMotorEncoder = new Encoder(robotMap.RIGHT_BACK_MOTOR_ENCODER_PORT_1, robotMap.RIGHT_BACK_MOTOR_ENCODER_PORT_2,true);
	
	//joystick 
	Joystick StickofdeOperator = new Joystick(robotMap.JOYSTICK_PORT);
	Joystick deDriverStick = new Joystick(robotMap.JOYSTICK_PORT2);

	//driveToggle
	boolean driveToggle = false;

	//toggle buttons
	int toggleOn = robotMap.TOGGLE_ON_BUTTON;
	int toggleOff = robotMap.TOGGLE_OFF_BUTTON;
	double slowMult = robotMap.SLOW_MULTIPLIER;

	//arcade boolean
	boolean isArcadeOn = false;

	//Encoders for Gears
	Encoder gearEncoder = new Encoder(robotMap.GEAR_MOTOR_ENCODER_PORT_1, robotMap.GEAR_MOTOR_ENCODER_PORT_2);

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
	int Gearbuttonpresetmiddle = robotMap.GEAR_LIFT_1;
	int Gearbuttonpresetout = robotMap.GEAR_LIFT_2;
	int Gearbuttonpresetin = robotMap.GEAR_LIFT_3;

	//intake buttons
	int button3 = robotMap.INTAKE_IN;
	int button4 = robotMap.INTAKE_IN;
	
	
	final String DoNothingAuto = "DoNothingAuto";
	final String BoilerAuto = "BoilerAuto";
	final String HopperAuto = "HopperAuto";
	final String AirshipAuto = "AirshipAuto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	
	Timer timer = new Timer();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.addDefault("Do Nothing", DoNothingAuto);
		chooser.addObject("Boiler", BoilerAuto);
		chooser.addObject("Hopper", HopperAuto);
		chooser.addObject("Airship", AirshipAuto);
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
		lFrontMotorEncoder.reset();
		lBackMotorEncoder.reset();
		rFrontMotorEncoder.reset();
		rBackMotorEncoder.reset();
		
	}
	
	void SetAll(double speed)
	{
		lFrontMotor.set(speed);
		lBackMotor.set(speed);
		rFrontMotor.set(-speed);
		rBackMotor.set(-speed);
	}
	
	
	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() { 
		Scheduler.getInstance().run();
		double encoderaverage = (lFrontMotorEncoder.get()+lBackMotorEncoder.get()+rFrontMotorEncoder.get()+rBackMotorEncoder.get())/4;
		double speed = 1;
		switch (autoSelected) {
		case DoNothingAuto:
			//We do nothing 
			break;
		case BoilerAuto: 

			if(encoderaverage<500)//go a certain amount of space
			{
				SetAll(speed);//set all motors to FULL SPEED AHEAD
			}
			else
			{
				SetAll(0);//stop
			}
			break;
		case HopperAuto:
			if(encoderaverage<50)//if it is less than a certain amount
			{
				SetAll(speed);//move forward
			}
			else
			{
				SetAll(0);//stop
			}
			break;
		case AirshipAuto:
			if(encoderaverage<50)
			{
				SetAll(speed);
			}
			else
			{
				SetAll(0);
			}
			break;
			
		default:
			// do nothing
			break;
		}
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic()
	{
	}
		
		
		
		
		
		
		
		
		

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}

	public void toggleDrive() {
		// if you press the button, then driveToggle will be true
		if (deDriverStick.getRawButton(toggleOn)) {
			driveToggle = true;
		}
		// if you press the button for toggleOff, then driveToggle will be false
		else if (deDriverStick.getRawButton(toggleOff)) {
			driveToggle = false;
		}

		// if driveToggle is not on, then motors will be at the full speed
		// of the joystick
		if (!driveToggle) {
			lFrontMotor.set(deDriverStick.getRawAxis(robotMap.LEFT_JOYSTICK_AXIS));
			lBackMotor.set(deDriverStick.getRawAxis(robotMap.LEFT_JOYSTICK_AXIS));
			rFrontMotor.set(deDriverStick.getRawAxis(robotMap.RIGHT_JOYSTICK_AXIS)*-1);
			rBackMotor.set(deDriverStick.getRawAxis(robotMap.RIGHT_JOYSTICK_AXIS)*-1);
		}
		// otherwise if driveToggle is true, then the motors will be at the half
		// speed
		// of the joystick
		else {
			lFrontMotor.set((deDriverStick.getRawAxis(robotMap.LEFT_JOYSTICK_AXIS)) * slowMult);
			lBackMotor.set((deDriverStick.getRawAxis(robotMap.LEFT_JOYSTICK_AXIS)) * slowMult);
			rFrontMotor.set((deDriverStick.getRawAxis(robotMap.RIGHT_JOYSTICK_AXIS)) * -slowMult);
			rBackMotor.set((deDriverStick.getRawAxis(robotMap.RIGHT_JOYSTICK_AXIS)) * -slowMult);
		}

	}
	
	
	public void gear(){
		//Prints of the value of the pot	
		System.out.print(pot.get());
			//if button 1 is pressed and pot angle is less than 30, set motor to 0.25
			if(StickofdeOperator.getRawButton(Gearbuttonpresetmiddle)== true && pot.get() < 30)//whoah, cheap!
			{
				gearMotor.set(robotMap.GEAR_MOTOR_OUT_SPEED);
			}
			//if button 2 is pressed and pot angle is between 30 and 70, set motor to 0.25
			else if(StickofdeOperator.getRawButton(Gearbuttonpresetout) == true && pot.get() > 30 && pot.get() < 70)
			{
				gearMotor.set(robotMap.GEAR_MOTOR_OUT_SPEED);
			}
			//if button 2half is pressed and pot angle is greater than 0, set motor to -0.25
			else if(StickofdeOperator.getRawButton(Gearbuttonpresetin) == true && pot.get() > 0)
			{
				gearMotor.set(robotMap.GEAR_MOTOR_IN_SPEED);
			}
	}	
	
	
	
	
	public void drive(){
		//the motors are set the values of the joystick in tank drive
		lFrontMotor.set(deDriverStick.getRawAxis(robotMap.LEFT_JOYSTICK_AXIS));
		lBackMotor.set(deDriverStick.getRawAxis(robotMap.LEFT_JOYSTICK_AXIS));
		rBackMotor.set(deDriverStick.getRawAxis(robotMap.RIGHT_JOYSTICK_AXIS)*-1);
		rFrontMotor.set(deDriverStick.getRawAxis(robotMap.RIGHT_JOYSTICK_AXIS)*-1);
	}
	public void intake() {
		//if the 2 button is pressed , then the intake motor will take in the balls
		if (StickofdeOperator.getRawButton(button3) == true)
		{
			intakeMotor.set(robotMap.INTAKE_IN_SPEED);
		}
		//if the 3 button is pressed, then the intake motor will release the balls
		else if (StickofdeOperator.getRawButton(button4)) 
		{
			intakeMotor.set(robotMap.INTAKE_OUT_SPEED);
		} 
		//else, nothing will happen
		else {
			intakeMotor.set(robotMap.INTAKE_NO_SPEED);
		}
	}

}


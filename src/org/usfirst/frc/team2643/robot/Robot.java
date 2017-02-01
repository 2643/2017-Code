package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
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
	
	DigitalInput Switch1 = new DigitalInput(1);//HopperAuto
	DigitalInput Switch2 = new DigitalInput(2);//AirshipAuto
	DigitalInput Switch3 = new DigitalInput(3);//BoilerAuto
	
	
	Potentiometer pot = new AnalogPotentiometer(0, 360, 0);
	
	//Declaring for Motors
	Spark lFrontMotor = new Spark(5);
	Spark lBackMotor = new Spark(7);
	Spark rFrontMotor = new Spark(6);
	Spark rBackMotor = new Spark(4);
	Spark dumpMotor = new Spark(8);
	Spark gearMotor = new Spark(8);
	Spark intakeMotor = new Spark(9);

	
	//Declaring for Encoders
	Encoder dumpEncoder = new Encoder(0,0);
	
	//Declaring for Joystick
	Joystick stick = new Joystick(0);
	
	//Drive toggle boolean
	boolean driveToggle = false;
	
	//Toggles for on & off
	int toggleOn = 2;
	int toggleOff = 3;
	
	//Slow
	double slowMult = .5;
	
	boolean isArcadeOn = false;
	
	//Declaration for Limit Switches
	DigitalInput limitSwitch = new DigitalInput(2);
		
	//Encoder leftEncoder = new Encoder(2,4);
	//Encoder rightEncoder = new Encoder(5,6);
	
	static double AUTO_SPEED_ON = 0.5;
	static int AUTO_SPEED_OFF = 0;
	static int BOILER_AUTO_DISTANCE = 500;
	static int HOPPER_AUTO_DISTANCE = 50;
	static int AIRSHIP_AUTO_DISTANCE = 50;
	
	String autoSelected = "DoNothingAuto";
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
	
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
		if(Switch1.get())//HopperAuto
		{
			autoSelected = "HopperAuto";
		}
		else if(Switch2.get())//AirshipAuto
		{
			autoSelected = "AirshipAuto";
		}
		else if(Switch3.get())//BoilerAuto
		{
			autoSelected = "BoilerAuto";
		}
	}

	public void Sleep(int miliseconds)
	{
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		//Scheduler.getInstance().run();
		double encoderaverage = 0;//(lFrontMotorEncoder.get()+lBackMotorEncoder.get()+rFrontMotorEncoder.get()+rBackMotorEncoder.get())/4;
	
		switch (autoSelected) {
		case "DoNothingAuto":
			//SetAll(0); 
			break;
		case "HopperAuto": 

			if(encoderaverage < HOPPER_AUTO_DISTANCE)//go a certain amount of space
			{
				//SetAll(AUTO_SPEED_ON);//set all motors to FULL SPEED AHEAD
			}
			else
			{
				//SetAll(0);//stop
			}
			break;
		case "AirshipAuto":
			if(encoderaverage < AIRSHIP_AUTO_DISTANCE)//if it is less than a certain amount
			{
				//SetAll(AUTO_SPEED_ON);//move forward
			}
			else
			{
				//SetAll(0);//stop
			}
			break;
		case "BoilerAuto":
			if(encoderaverage < BOILER_AUTO_DISTANCE)
			{
				//SetAll(AUTO_SPEED_ON);
			}
			else
			{
				//SetAll(0);
			}
			break;
			
		default:
			//do nothing 
			break;
		}
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		
		
		toggleDrive();
		
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
			lFrontMotor.set(stick.getRawAxis(1)*-1);
			lBackMotor.set(stick.getRawAxis(1)*-1);
			rFrontMotor.set(stick.getRawAxis(5));
			rBackMotor.set(stick.getRawAxis(5));
		}
		// otherwise if driveToggle is true, then the motors will be at the half
		// speed
		// of the joystick
		else {
			lFrontMotor.set((stick.getRawAxis(1)) * -slowMult);
			lBackMotor.set((stick.getRawAxis(1)) * -slowMult);
			rFrontMotor.set((stick.getRawAxis(5)) * slowMult);
			rBackMotor.set((stick.getRawAxis(5)) * slowMult);
		}

	}
	
public void drive(){
		
		lFrontMotor.set(stick.getRawAxis(1)*-1);
		lBackMotor.set(stick.getRawAxis(1)*-1);
		rBackMotor.set(stick.getRawAxis(5));
		rFrontMotor.set(stick.getRawAxis(5));
	}

 public void gear() {
		
		//operator controlled
		//if the potentiometer is in the "in" position, 
		//then this will move it to the "middle" position
		if((stick.getRawButton(6) == true) && (pot.get() <= 30))//whoah, cheap!
		{
			gearMotor.set(0.25);
		}
		
		//if the potentiometer is in the "middle" position, 
		//then this will move it to the "out" position
		else if((stick.getRawButton(5) == true) && ((pot.get() > 31) && (pot.get() <= 70)))
		{
			gearMotor.set(0.25);
		}
		
		//if the potentiometer is in the "middle" or "out" position, 
		//then this will move it to the "in" position
		else if((stick.getRawButton(4) == true) && (pot.get() > 1))
		{
			gearMotor.set(-0.25);
		}
	}
	
 public void intake() {
	 //If the button is pressed, then the intake motor is turned on.
		if (stick.getRawButton(1) == true) {
			intakeMotor.set(0.5);
	 //If the other button is pressed, then the motor will be turned on back ways.
		} else if (stick.getRawButton(2)) {
			intakeMotor.set(-0.5);
	//otherwise it won't move at all.
		} else {
			intakeMotor.set(0);
		}
	}
 public void dump(){
		//Some Encoder number,(temporary)
		int SOMENUMBER = 0;
		
		/*If the button is pressed and the "dumpEncoder" is less than just some number, 
		 * then the motor dump motor moves at a speed of 0.5 until the "dumpEncoder" is 
		 * bigger than some number.*/
		if(stick.getRawButton(4)&& dumpEncoder.get()<=SOMENUMBER ){
			dumpMotor.set(0.5);
		}
		/*Else, if the other button is pressed and the limit switch has not been pressed,
		 * then the motor will move back and then reset the encoder. That is until the 
		 * limit switch is switched on making it true*/
		else if(stick.getRawButton(3)&& limitSwitch.get()==false){
			dumpMotor.set(-0.5);
			dumpEncoder.reset();
		}
		//Else the motor will not move.
		else{
			dumpMotor.set(0);
		}
	}
}



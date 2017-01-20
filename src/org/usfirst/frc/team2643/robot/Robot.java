
package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
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
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	//these are the motors and the ports are not accurate
	int RandomPort = 2;
	//A placeholder port until we find the real one
	Talon lFrontMotor = new Talon(1);
	Talon lBackMotor = new Talon(4);
	Talon rFrontMotor = new Talon(3);
	Talon rBackMotor = new Talon(2);

	//joystick
	Joystick stick = new Joystick(0);

	//this is for the slow toggle button in drive
	boolean driveToggle = false;
	//these are the buttons for toggleOn and toggleOff, these are not decided yet
	int toggleOn = 2;
	int toggleOff = 3;

	//The multiplier for motor speed that determines how much slower the
	//motors should turn in slow-button mode
	//For example, a value of .5 would result in half speed.
	final double slowMult = .5;

	//arcade drive variable
	boolean isArcadeOn = false;
	//these are the buttons to turn on arcade drive


	RobotDrive myDrive = new RobotDrive(lFrontMotor, rFrontMotor, lBackMotor, rBackMotor);
	public void robotInit() {
		chooser = new SendableChooser();
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);


	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomousInit() {
		autoSelected = (String) chooser.getSelected();
		//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		switch(autoSelected) {
		case customAuto:
			//Put custom auto code here   
			break;
		case defaultAuto:
		default:
			//Put default auto code here
			break;
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		drive();
		toggleDrive();
		System.out.println((lFrontMotor.get() + lBackMotor.get() +
				rFrontMotor.get() + rBackMotor.get())/4);
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

	public void drive(){
		//set the motors to the values of the axes on the joystick

		lFrontMotor.set(stick.getRawAxis(1));
		lBackMotor.set(stick.getRawAxis(1));
		rBackMotor.set(stick.getRawAxis(5));
		rFrontMotor.set(stick.getRawAxis(5));
	}

	public void toggleDrive() {
		//if you press the button, then driveToggle will be true
		if (stick.getRawButton(toggleOn)) 
		{
			driveToggle = true;
		} 
		//if you press the button for toggleOff, then driveToggle will be false
		else if (stick.getRawButton(toggleOff)) 
		{
			driveToggle = false;
		}


		//if driveToggle is not on, then motors will be at the full speed 
		//of the joystick
		if (!driveToggle) 
		{
			lFrontMotor.set(stick.getRawAxis(1));
			lBackMotor.set(stick.getRawAxis(1));
			rFrontMotor.set(stick.getRawAxis(5));
			rBackMotor.set(stick.getRawAxis(5));
		} 
		//otherwise if driveToggle is true, then the motors will be at the half speed
		//of the joystick
		else 
		{
			lFrontMotor.set((stick.getRawAxis(1))* slowMult);
			lBackMotor.set((stick.getRawAxis(1))* slowMult);
			rFrontMotor.set((stick.getRawAxis(5))* slowMult);
			rBackMotor.set((stick.getRawAxis(5))* slowMult);
		}
	}
	
	Talon IntakeMotor = new Talon(1);
	void Intake()
	{
		if(stick.getRawButton(1) == true)
		{
			IntakeMotor.set(0.5);
		}
		else if(stick.getRawButton(2))
		{
			IntakeMotor.set(-0.5);
		}
		else
		{
			IntakeMotor.set(0);
		}
	}
}







package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
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
	



	// leds
	public static final int LEDNUMBER = 48;
	LEDController led = new LEDController(LEDNUMBER);
	
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	@Override
	public void robotInit() {
	
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
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		// if the leftencoder and the rightencoder, divided by two is less than
		// 2200, then it will make the robot
		// all 4 motors move at half speed.
//		if ((Math.abs(RobotMap.leftEncoder.get()) + Math.abs(RobotMap.rightEncoder.get())) / 2 < 2200) {
//			// a method defined up above to make all four motors move at half
//			// speed.
//			setAll(0.5);
//		} else {
//			// Setting all 4 motors to zero.
//			setAll(0);
//		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// prints out the left encoder and the right encoder divided by 2
		//System.out.println((Math.abs(RobotMap.leftEncoder.get()) + Math.abs(RobotMap.rightEncoder.get())) / 2);
		Intake.intake();
		Gear.gear(); 
		Toggle.toggle();
		//colors();
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
		//MotorTest.testMotor();
		
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
		RobotMap.lFrontMotor.set(-speed);
		RobotMap.lBackMotor.set(-speed);
		RobotMap.rFrontMotor.set(speed);
		RobotMap.rBackMotor.set(speed);
	}
	
	/**
	 *  Starts and updates the led bars
	 */
	public void colors() {
		led.bars();
	}
	

}

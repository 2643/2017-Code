package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  // Drive Motors
  Spark l1 = new Spark(5);
  Spark l2 = new Spark(2);
  Spark r1 = new Spark(6);
  Spark r2 = new Spark(1);

  int state = 0;

  Joystick j1 = new Joystick(0);


  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  public void setDrive(double l, double r) {
    l1.set(l);
    l2.set(l);
    r1.set(-r);
    r2.set(-r);
  }

  @Override
  public void teleopPeriodic() {
    setDrive(-0.5*j1.getRawAxis(1), -0.5*j1.getRawAxis(5));
  }

  @Override
  public void testPeriodic() {
  }
}

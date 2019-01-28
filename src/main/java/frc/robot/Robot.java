package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

// Drive Motors
Spark l1 = new Spark(5);
Spark l2 = new Spark(2);
Spark r1 = new Spark(6);
Spark r2 = new Spark(1);

Joystick jyst = new Joystick(0);

  @Override
  public void robotInit() {
    new Thread(() -> {
			CameraServer.getInstance().startAutomaticCapture();
    }).start();
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

  @Override
  public void teleopPeriodic() {
    l1.set(jyst.getRawAxis(1));
    l2.set(jyst.getRawAxis(1));
    r1.set(jyst.getRawAxis(5));
    r2.set(jyst.getRawAxis(5));
  }

  @Override
  public void testPeriodic() {
  }
}

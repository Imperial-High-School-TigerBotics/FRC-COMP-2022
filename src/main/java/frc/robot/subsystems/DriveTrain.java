// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private Spark rightFront;
  private Spark leftFront;
  private Spark rightBack;
  private Spark leftBack;
  private MotorControllerGroup rightMotors;
  private MotorControllerGroup leftMotors;

  public DriveTrain() {
    rightFront = new Spark(Constants.RIGHT_FRONT);
    leftFront = new Spark(Constants.LEFT_FRONT);
    rightBack = new Spark(Constants.RIGHT_BACK);
    leftBack = new Spark(Constants.LEFT_BACK);

    rightMotors = new MotorControllerGroup(rightFront, rightBack);
    rightMotors.setInverted(false);
    leftMotors = new MotorControllerGroup(leftFront, leftBack);
    leftMotors.setInverted(true);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoySticks(XboxController controller, double speed)
  {
    double left = controller.getRawAxis(Constants.LEFT_Y_AXIS);
    double right = controller.getRawAxis(Constants.RIGHT_Y_AXIS);

    rightMotors.set(right*speed);
    leftMotors.set(left*speed);
  }

  public void driveBackwardsStart() {
    rightMotors.set(-.2);
    leftMotors.set(-.2);
  }

  public void driveStop() {
    rightMotors.set(0);
    leftMotors.set(0);
  }


public static void set(double d, double e) {
}
}

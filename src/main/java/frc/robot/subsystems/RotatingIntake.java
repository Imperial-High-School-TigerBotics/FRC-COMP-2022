// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RotatingIntake extends SubsystemBase {
  /** Creates a new RotatingIntake. */
  private Spark rotatingIntake;

  public RotatingIntake() {
    rotatingIntake = new Spark(Constants.ROTATING_INTAKE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void rotateIntake( XboxController controller, double speed )
  {
    double rotate = controller.getRawAxis(Constants.RIGHT_TRIGGER);
    rotatingIntake.set (rotate*speed);
    
  }

  public void reverseIntake( XboxController controller, double speed)
  {
    if (controller.getRightBumper())
    {
      rotatingIntake.set (-speed);
    }else {
      rotatingIntake.set(0);
    }
  }

  public void stop() {
    rotatingIntake.set(0);
  }
}

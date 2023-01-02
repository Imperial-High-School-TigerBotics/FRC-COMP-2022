// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BottomLift extends SubsystemBase {
  /** Creates a new BottomLift. */
  private Spark bottomLift;

  public BottomLift() {
    bottomLift = new Spark(Constants.BOTTOM_LIFT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void bottomLift( XboxController controller, double speed )
  {
    double rotate = controller.getRawAxis(Constants.LEFT_TRIGGER);
    bottomLift.set (rotate*speed);
    
  }

  public void reverseBlift( XboxController controller, double speed)
  {
    if (controller.getLeftBumper())
    {
      bottomLift.set (-speed);
    }else {
      bottomLift.set(0);
    }
  }

  public void stop() {
    bottomLift.set(0);
  }

}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MiddleLift extends SubsystemBase {
  /** Creates a new MiddleLift. */
  private Spark middleLift;
  
  public MiddleLift() {
    middleLift = new Spark(Constants.MIDDLE_LIFT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void liftMiddle( XboxController controller, double speed )
  {
    if( controller.getXButton() ) //up
      middleLift.set(-speed);
    if( controller.getBButton() ) //down
      middleLift.set(speed);
    
  }

  public void stop()
  {
    middleLift.set(0);
  }

}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LiftIntake extends SubsystemBase {
  /** Creates a new LiftIntake. */
  private Spark liftIntake;

  public LiftIntake() {
    liftIntake = new Spark(Constants.LIFT_INTAKE);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void liftIntake( XboxController controller, double speed )
  {
    if( controller.getYButton() ) //up
      liftIntake.set(-speed);
    if( controller.getAButton() ) //down
      liftIntake.set(speed);
    
  }

  public void stop()
  {
    liftIntake.set(0);
  }

}

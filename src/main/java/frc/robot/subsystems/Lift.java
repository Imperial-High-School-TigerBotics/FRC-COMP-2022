// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lift extends SubsystemBase {
  /** Creates a new Lift. */
  private Spark lift;

  public Lift() {
    lift = new Spark(Constants.LIFT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void lift( XboxController controller, double speed )
  {
    int angle = controller.getPOV();
    if( angle <= (Constants.UP_DPAD + Constants.DELTA_ANGLE) && angle >= (Constants.UP_DPAD - Constants.DELTA_ANGLE))
      lift.set(-speed);
    else if( angle <= (Constants.DOWN_DPAD + Constants.DELTA_ANGLE) && angle >= (Constants.DOWN_DPAD - Constants.DELTA_ANGLE))
      lift.set(speed);
    else if( angle <= 9 && angle >= -11)
      lift.set(0);
  }



}

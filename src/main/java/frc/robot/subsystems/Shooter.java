// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  private Spark shooter;

  public Shooter() {
    shooter = new Spark(Constants.SHOOTER);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shootBall( XboxController controller, double speed )
  {
    int angle = controller.getPOV();
    if( angle <= (Constants.RIGHT_DPAD + Constants.DELTA_ANGLE) && angle >= (Constants.RIGHT_DPAD - Constants.DELTA_ANGLE))
      shooter.set(-speed);
    else if( angle <= (Constants.LEFT_DPAD + Constants.DELTA_ANGLE) && angle >= (Constants.LEFT_DPAD - Constants.DELTA_ANGLE))
      shooter.set(speed);
    else if( angle <= 9 && angle >= -11)
      shooter.set(0);
  }

  public void stop()
  {
    shooter.set(0);
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.MiddleLift;

public class LiftMiddleCmd extends CommandBase {
  /** Creates a new LiftMiddle. */
  MiddleLift middleLift;

  public LiftMiddleCmd( MiddleLift m ) {
    // Use addRequirements() here to declare subsystem dependencies.
    middleLift = m;
    addRequirements(middleLift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    middleLift.liftMiddle(RobotContainer.controller, Constants.MIDDLE_LIFT_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    middleLift.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

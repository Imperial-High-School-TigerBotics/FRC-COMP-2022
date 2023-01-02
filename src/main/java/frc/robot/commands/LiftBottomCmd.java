// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BottomLift;

public class LiftBottomCmd extends CommandBase {
  /** Creates a new LiftMiddle. */
  BottomLift bottomLift;

  public LiftBottomCmd( BottomLift b ) {
    // Use addRequirements() here to declare subsystem dependencies.
    bottomLift = b;
    addRequirements(bottomLift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    bottomLift.bottomLift(RobotContainer.controller, Constants.BOTTOM_LIFT_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    bottomLift.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

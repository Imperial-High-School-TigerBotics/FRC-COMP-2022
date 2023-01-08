// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveWithJoySticksCmd;
import frc.robot.commands.LiftBottomCmd;
import frc.robot.commands.LiftCmd;
import frc.robot.commands.LiftIntakeCmd;
import frc.robot.commands.LiftMiddleCmd;
import frc.robot.commands.ReverseIntakeCmd;
import frc.robot.commands.RotateIntakeCmd;
import frc.robot.commands.ShootBallCmd;
import frc.robot.commands.reverseBlift;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.LiftIntake;
import frc.robot.subsystems.BottomLift;
import frc.robot.subsystems.MiddleLift;
import frc.robot.subsystems.RotatingIntake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static XboxController controller;

  private final DriveTrain driveTrain;
  private final DriveWithJoySticksCmd driveWithJoySticksCmd;
  
  private final Shooter shooter;
  private final ShootBallCmd shootBallCmd;

  private final MiddleLift middleLift;
  private final LiftMiddleCmd liftMiddleCmd;

  private final BottomLift bottomLift;
  private final LiftBottomCmd liftBottomCmd;
  private final reverseBlift reverseBlift;

  private final Lift lift;
  private final LiftCmd liftCmd;

  private final RotatingIntake rotatingIntake;
  private final RotateIntakeCmd rotatingIntakeCmd;
  private final ReverseIntakeCmd reverseIntakeCmd;

  private final LiftIntake liftIntake;
  private final LiftIntakeCmd liftIntakeCmd;
  
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    controller = new XboxController(Constants.JOYSTICK_NUMBER);
 
    driveTrain = new DriveTrain();
    driveWithJoySticksCmd = new DriveWithJoySticksCmd(driveTrain);
    //driveWithJoySticks.addRequirements( driveTrain );
    driveTrain.setDefaultCommand(driveWithJoySticksCmd);

    shooter = new Shooter();
    shootBallCmd = new ShootBallCmd(shooter);
    //shootBall.addRequirements(shooter);
    shooter.setDefaultCommand(shootBallCmd);

    middleLift = new MiddleLift();
    liftMiddleCmd = new LiftMiddleCmd(middleLift);

    lift = new Lift();
    liftCmd = new LiftCmd(lift);
    lift.setDefaultCommand(liftCmd);

    rotatingIntake = new RotatingIntake();
    rotatingIntakeCmd = new RotateIntakeCmd(rotatingIntake);
    reverseIntakeCmd = new ReverseIntakeCmd(rotatingIntake);
    rotatingIntake.setDefaultCommand(rotatingIntakeCmd);

    liftIntake = new LiftIntake();
    liftIntakeCmd = new LiftIntakeCmd(liftIntake);


    bottomLift = new BottomLift();
    liftBottomCmd = new LiftBottomCmd(bottomLift);
    bottomLift.setDefaultCommand(liftBottomCmd);
    reverseBlift = new reverseBlift(bottomLift);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton middleLiftX = new JoystickButton(controller, XboxController.Button.kX.value);  //DOWN
    middleLiftX.onTrue(liftMiddleCmd);   

    JoystickButton middleLiftB = new JoystickButton(controller, XboxController.Button.kB.value);  //UP
    middleLiftB.onTrue(liftMiddleCmd);

    JoystickButton liftIntakeY = new JoystickButton(controller, XboxController.Button.kY.value);
    liftIntakeY.onTrue(liftIntakeCmd);

    JoystickButton LiftIntakeA = new JoystickButton(controller, XboxController.Button.kA.value);
    LiftIntakeA.onTrue(liftIntakeCmd);

    JoystickButton rightBumperRB = new JoystickButton(controller, XboxController.Button.kRightBumper.value);
    rightBumperRB.onTrue(reverseIntakeCmd);

    JoystickButton leftBumperLB = new JoystickButton(controller, XboxController.Button.kLeftBumper.value);
    leftBumperLB.onTrue(reverseBlift);

    
  }  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new InstantCommand(driveTrain::driveBackwardsStart).andThen(new WaitCommand(2).andThen(driveTrain::driveStop));
  }
}

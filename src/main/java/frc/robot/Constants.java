// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //PWM's for wiring
    public static final int LEFT_FRONT = 2;         //verify PWM spark number for drivetrain left_front motor
    public static final int LEFT_BACK = 3;          //verify PWM spark number for drivetrain left_back motor
    public static final int RIGHT_FRONT = 0;        //verify PWM spark number for drivetrain right_front motor
    public static final int RIGHT_BACK = 1;         //verify PWM spark number for drivetrain right_back motor
    public static final int BOTTOM_LIFT = 9;        //verify PWM spark number for bottom_lift motor
    public static final int LIFT = 4;               //verify PWM spark number for lift motor
    public static final int LIFT_INTAKE = 6;        //verify PWM spark number for lift_intake motor
    public static final int MIDDLE_LIFT = 8;        //verify PWM spark number for middle_lift motor
    public static final int ROTATING_INTAKE = 5;    //verify PWM spark number for rotating_intake motor
    public static final int SHOOTER = 7;            //verify PWM spark number for shooter motor

    //Xbox Controller Number/Raw Axis and Buttons
    public static final int JOYSTICK_NUMBER = 0;
    public static final int LEFT_Y_AXIS = 1;        //verify axis for left wheels forward/backward
    public static final int RIGHT_Y_AXIS = 5;       //verify axis for right wheels forward/backward  

    //Subsystems speed scale factor
    public static final double DRIVETRAINSPEED = 0.7;   //increase scale factor for faster drivetrain speed
    public static final double SHOOTERSPEED = 0.7;     //increase scale factor for faster shooter speed    
    public static final double MIDDLE_LIFT_SPEED = 0.5; //increase scale factor for faster middleLift speed
    public static final double BOTTOM_LIFT_SPEED = 0.6;
    public static final int RIGHT_DPAD = 90;
    public static final int DELTA_ANGLE = 10;
    public static final int LEFT_DPAD = 270;
    public static final int UP_DPAD = 360;
    public static final int DOWN_DPAD = 180;
    public static final int RIGHT_TRIGGER = 3;
    public static final int LEFT_TRIGGER = 2;
    public static final double ROTATING_INTAKE_SPEED = 0.6;
    public static final double LIFT_INTAKE_SPEED = 0.4;
}

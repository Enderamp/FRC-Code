/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7715.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// PWM Ports
	public static int rightDrive = 0;
	public static int leftDrive = 1;
	public static int squeezeMotor = 3;
	public static int armMotor = 2;
	public static int intakeMotor = 4;

	//DIO Ports
	public static int rightEncoderChannelA = 0;
	public static int rightEncoderChannelB = 1;
	public static int leftEncoderChannelA = 2;
	public static int leftEncoderChannelB = 3;

	//Controller Ports
	public static int xboxController = 0;
	public static int autoDialPort = 4;
	
	//Analog Pprts
	public static int armPotPort = 0;
	
	//pulses per inch constant (encoder)
	public static final int PULSES_PER_INCH = 0;
	
	//Cameras
	public static int cameraDrive = 0;
	
	
}


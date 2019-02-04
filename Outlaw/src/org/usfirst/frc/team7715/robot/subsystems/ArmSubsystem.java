package org.usfirst.frc.team7715.robot.subsystems;

import org.usfirst.frc.team7715.robot.RobotMap;
import org.usfirst.frc.team7715.robot.commands.MoveArmCommand;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
//import frc.robot.subsystems.Spark;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
	
	public Spark armMotor = new Spark(RobotMap.armMotor);
	
	public AnalogPotentiometer armPot = new AnalogPotentiometer(RobotMap.armPotPort);
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public ArmSubsystem(){
		armMotor.setInverted(true);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new MoveArmCommand());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void moveArm(double speed){
		armMotor.set(speed);
	}

	public void stopArm(){
		armMotor.set(0.0);
	}
}

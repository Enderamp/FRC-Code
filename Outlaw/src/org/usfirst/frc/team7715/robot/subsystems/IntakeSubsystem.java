package org.usfirst.frc.team7715.robot.subsystems;

import org.usfirst.frc.team7715.robot.RobotMap;
import org.usfirst.frc.team7715.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public Spark squeezeMotor = new Spark(RobotMap.squeezeMotor);
	public Spark intakeMotor = new Spark(RobotMap.intakeMotor);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeCommand());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void squeeze() {
    	squeezeMotor.set(-1.0);
    }
    public void releaseSqueeze() {
    	squeezeMotor.set(1.0);
    }
    public void intakeIn() {
    	intakeMotor.set(-.6);
    }
    public void intakeOut() {
    	intakeMotor.set(1.0);
    }
    public void stopSqueeze() {
    	squeezeMotor.set(0);
    }
    public void stopIntake() {
    	intakeMotor.set(0);
    }
    
}


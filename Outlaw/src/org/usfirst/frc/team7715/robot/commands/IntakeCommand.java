package org.usfirst.frc.team7715.robot.commands;

import org.usfirst.frc.team7715.robot.OI;
import org.usfirst.frc.team7715.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {
		
	
    public IntakeCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intake);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(OI.xbox.getBumper(Hand.kLeft)) {
    		Robot.intake.intakeIn();
    	} else if(OI.xbox.getBumper(Hand.kRight)) {
    		Robot.intake.intakeOut();
    	} else {
    		Robot.intake.stopIntake();
    	}
    	
    	if(OI.xbox.getAButton()) {
    		Robot.intake.squeeze();
    	} else if(OI.xbox.getBButton()) {
    		Robot.intake.releaseSqueeze();
    	} else {
    		Robot.intake.stopSqueeze();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

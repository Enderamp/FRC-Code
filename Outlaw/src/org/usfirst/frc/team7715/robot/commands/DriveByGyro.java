package org.usfirst.frc.team7715.robot.commands;

import org.usfirst.frc.team7715.robot.Robot;
import org.usfirst.frc.team7715.robot.utilities.PIDStuff;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByGyro extends Command {
	
	PIDStuff pidStuff = new PIDStuff(.008);	
	double targetHeading;
	double basePower;
	double targetDistance;

    public DriveByGyro(double targetHeading, double basePower, double targetDistance) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        this.targetHeading = targetHeading;
        this.basePower = basePower;
        this.targetDistance = targetDistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		double currentHeading = Robot.drive.getCurrentHeading();
    		double correction = pidStuff.calculateCorrection(targetHeading, currentHeading);
    		double leftPower = basePower;
    		double rightPower = basePower;
    			if (targetHeading < currentHeading) {
    				leftPower -= correction;
    				rightPower += correction;
    			} else {
    				leftPower += correction;
    				rightPower -= correction;
    				}
    		Robot.drive.tankDrive(leftPower, rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.drive.getAverageDistance() >= targetDistance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.stop(); 
    }
}

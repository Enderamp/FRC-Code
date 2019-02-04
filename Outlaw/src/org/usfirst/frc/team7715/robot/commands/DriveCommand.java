package org.usfirst.frc.team7715.robot.commands;

import org.usfirst.frc.team7715.robot.OI;
import org.usfirst.frc.team7715.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
//import frc.robot.Robot;

/**
 *
 */
public class DriveCommand extends Command {
	public DriveCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

		if(isRightTriggerPulled()){
			Robot.drive.drive(OI.xbox.getRawAxis(1), -OI.xbox.getRawAxis(0));
		} else if(isLeftTriggerPulled()){
			Robot.drive.drive(OI.xbox.getRawAxis(1), -OI.xbox.getRawAxis(0) * .6);
		} else{
			Robot.drive.drive(OI.xbox.getRawAxis(1) * .6, -OI.xbox.getRawAxis(0) * .6);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.drive.stop();
	}

	public boolean isRightTriggerPulled(){
		if(OI.xbox.getRawAxis(3) >.5){
			return true;
		} else {
			return false;
		}
	}

	public boolean isLeftTriggerPulled() {
		if(OI.xbox.getRawAxis(2) > .5){
			return true;
		} else {
			return false;
		}
	}
}
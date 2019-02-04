package org.usfirst.frc.team7715.robot.utilities;

import org.usfirst.frc.team7715.robot.OI;
import org.usfirst.frc.team7715.robot.commands.AutoDoNothing;
import org.usfirst.frc.team7715.robot.commands.AutoDriveForward;

import edu.wpi.first.wpilibj.command.Command;

public class AutoSelector {

	public Command autoCommand;
	
	public void selectAuto() {
		if(isDoNothing()) {
			autoCommand = new AutoDoNothing();
		} 
		if(isDriveForward()) {
			autoCommand = new AutoDriveForward();
		}
	}
	
	public boolean isDoNothing() {
		if(OI.dial1.get()) {
			return true;
		} else {
			return false;
		}
			
	}
	
	public boolean isDriveForward() {
		if(OI.dial2.get()) {
			return true;
		} else {
			return false;
		}
			
	}
}

package org.usfirst.frc.team7715.robot.subsystems;

import org.usfirst.frc.team7715.robot.RobotMap;
import org.usfirst.frc.team7715.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
/*import frc.robot.subsystems.DifferentialDrive;
import frc.robot.subsystems.Encoder;
import frc.robot.subsystems.TalonSR;
*/
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {

	public Talon leftDrive = new Talon(RobotMap.leftDrive);
	public Talon rightDrive = new Talon(RobotMap.rightDrive);
	
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public Encoder leftEncoder = new Encoder(RobotMap.leftEncoderChannelA, RobotMap.leftEncoderChannelB, false, EncodingType.k4X);
	public Encoder rightEncoder = new Encoder(RobotMap.rightEncoderChannelA, RobotMap.rightEncoderChannelB, false, EncodingType.k4X);
	
	DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);

	public DriveTrainSubsystem() {
		leftDrive.setInverted(true);
		rightDrive.setInverted(true);
	}
	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void drive(double moveValue, double rotateValue) {
		drive.arcadeDrive(moveValue, rotateValue);
	}
	
	public void tankDrive(double leftMoveValue, double rightMoveValue) {
		drive.tankDrive(leftMoveValue, rightMoveValue);
	}

	public void stop() {
		drive.arcadeDrive(0.0, 0.0);
	}
	
    public void resetEncoder() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public int getPulsesLeft() {
    	return Math.abs(leftEncoder.get());
    }

    public int getPulsesRight() {
    	return Math.abs(rightEncoder.get());
    }
    
    public double getDistanceLeft() {
    	return (getPulsesLeft() / RobotMap.PULSES_PER_INCH);
    }
    
    public double getDistanceRight() {
    	return (getPulsesRight() / RobotMap.PULSES_PER_INCH);
    }
    
    public double getAverageDistance() {
    	return (((getPulsesLeft() + getPulsesRight()) / 2) / RobotMap.PULSES_PER_INCH);
    }
    
    public double getCurrentHeading() {
    	return gyro.getAngle();
    }
}

package org.usfirst.frc.team7715.robot.utilities;

public class PIDStuff {

	double pValue;
	public double error;
	
	public PIDStuff(double pValue) {
		this.pValue = pValue;
	}

	public double getpValue() {
		return pValue;
	}

	public void setpValue(double pValue) {
		this.pValue = pValue;
	}
	
	public double calculateCorrection(double targetDirection, double currentDirection) {
		error = targetDirection - currentDirection;
		return (Math.abs(error) * pValue);
	}
}

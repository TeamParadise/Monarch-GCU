package org.usfirst.frc.team1165.robot.pidcontrollers;

import org.usfirst.frc.team1165.util.NavX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotateToHeadingPID
{
	private PIDController mRotateCtrl;

	public RotateToHeadingPID()
	{
		mRotateCtrl = new PIDController(0.2, 0, 0.2, 0, NavX.getInstance(), (output) -> {});
		mRotateCtrl.setInputRange(0, 360);
		mRotateCtrl.setOutputRange(-0.5, 0.5);
		mRotateCtrl.setAbsoluteTolerance(1);
		mRotateCtrl.setContinuous();
	}
	
	public void setSetpoint(double setpoint) {
		mRotateCtrl.setSetpoint(setpoint);
	}

	public void setSetpointRelative(double deltaSetpoint) {
		mRotateCtrl.setSetpoint(mRotateCtrl.getSetpoint() + deltaSetpoint);
	}
	
	public void enable() {
		mRotateCtrl.enable();
	}
	
	public void disable() {
		mRotateCtrl.disable();
	}
	
	public boolean onTarget() {
		return mRotateCtrl.onTarget();
	}
	
	public double getOutput() {
		return mRotateCtrl.get();
	}

	public void report() {
    	SmartDashboard.putNumber("Rotate Heading PID Power", getOutput());
    	SmartDashboard.putBoolean("Rotate Heading PID On Target", onTarget());
    	SmartDashboard.putNumber("Rotate Heading PID Error", mRotateCtrl.getError());
    }

}


package org.usfirst.frc.team1165.robot.pidcontrollers;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightPID
{

	private static PIDSource mSource = new PIDSource() {
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return Robot.mDriveTrain.getLeftDist();
		}
		
	};
	
	private PIDController mDriveCtrl;

	public DriveStraightPID()
	{
		mDriveCtrl = new PIDController(0.1, 0, 0, 0, mSource, (output) -> {});
		mDriveCtrl.setOutputRange(-0.75, 0.75);
		mDriveCtrl.setAbsoluteTolerance(3);
		mDriveCtrl.setContinuous(false);
	}
	
	public void resetInputRange(double overUnder) {
		mDriveCtrl.setInputRange(Robot.mDriveTrain.getLeftDist() - overUnder, Robot.mDriveTrain.getLeftDist() + overUnder);
	}

	public void setSetpoint(double setpoint) {
		mDriveCtrl.setSetpoint(setpoint);
	}

	public void setSetpointRelative(double deltaSetpoint) {
		mDriveCtrl.setSetpoint(mDriveCtrl.getSetpoint() + deltaSetpoint);
	}
	
	public void enable() {
		mDriveCtrl.enable();
	}
	
	public void disable() {
		mDriveCtrl.disable();
	}
	
	public boolean onTarget() {
		return mDriveCtrl.onTarget();
	}
	
	public double getOutput() {
		return mDriveCtrl.get();
	}
	
    public void report() {
    	SmartDashboard.putNumber("Drive Straight PID Power", getOutput());
    	SmartDashboard.putBoolean("Drive Straight PID On Target", onTarget());
    	SmartDashboard.putNumber("Drive Straight PID Error", mDriveCtrl.getError());
    }
}


package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotaryLiftPosition extends Command
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
			return Robot.mRotaryLift.getAngle();
		}
		
	};
	
	private PIDController mRotateCtrl = new PIDController(0.05, 0.0, 0.0, 0.0, mSource, (output) -> {});
	
	private double mTarget, mFinalPower, mMaxOutput;

	public RotaryLiftPosition(double target, double finalPower, double maxOutput)
	{
		mFinalPower = finalPower;
		mTarget = target;
		mMaxOutput = maxOutput;
		
		requires(Robot.mRotaryLift);

		mRotateCtrl.setInputRange(-787, -335);
		mRotateCtrl.setOutputRange(-0.2, mMaxOutput);
		mRotateCtrl.setAbsoluteTolerance(5);
		mRotateCtrl.setContinuous(false);
	}

	@Override
	protected void initialize() {
		System.out.println("Command Started: " + getName());
		mRotateCtrl.setSetpoint(mTarget);
		mRotateCtrl.enable();
	}

	@Override
	protected void execute()
	{
		SmartDashboard.putNumber("Rotate Ctrl", mRotateCtrl.get());
		SmartDashboard.putNumber("Rotate Ctrl Error", mRotateCtrl.getError());
		
		if(mRotateCtrl.onTarget())
			Robot.mRotaryLift.setSpeed(mFinalPower);
		else
			Robot.mRotaryLift.setSpeed(mRotateCtrl.get());
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}
	
	@Override
	protected void end() {
		Robot.mRotaryLift.setSpeed(0);
	}

}

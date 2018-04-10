package org.usfirst.frc.team1165.robot.commands.auto;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightSpeed extends Command
{
	private static PIDController mRotateCtrl = new PIDController(0.2, 0, 0.2, 0, Robot.mNavX, (output) -> {});

	static {
		mRotateCtrl.setInputRange(0, 360);
		mRotateCtrl.setOutputRange(-0.5, 0.5);
		mRotateCtrl.setAbsoluteTolerance(1);
		mRotateCtrl.setContinuous();
	}
	
	private double mTarget;

	public DriveStraightSpeed(double target)
	{
		mTarget = target;
		
		requires(Robot.mDriveTrain);
	}

	@Override
	protected void initialize()
	{
		mRotateCtrl.setSetpoint(Robot.mNavX.getHeading());
		mRotateCtrl.enable();
	}

	@Override
	protected void execute()
	{
		Robot.mDriveTrain.arcadeDrive(mTarget, mRotateCtrl.get());
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}

	@Override
	protected void end()
	{
		Robot.mDriveTrain.arcadeDrive(0, 0);
		
		mRotateCtrl.disable();
	}
}
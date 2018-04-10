package org.usfirst.frc.team1165.robot.commands.auto;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.pidcontrollers.DriveStraightPID;
import org.usfirst.frc.team1165.robot.pidcontrollers.RotateToHeadingPID;
import org.usfirst.frc.team1165.util.NavX;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightDistance extends Command
{
	private static DriveStraightPID mDriveStraightPID = new DriveStraightPID();
	private static RotateToHeadingPID mRotatePID = new RotateToHeadingPID();

	private double mTarget;

	public DriveStraightDistance(double target)
	{
		mTarget = target;
		
		requires(Robot.mDriveTrain);
	}

	@Override
	protected void initialize()
	{
		mDriveStraightPID.resetInputRange(mTarget * 1.125);
		mDriveStraightPID.setSetpointRelative(mTarget);
		mDriveStraightPID.enable();
		
		mRotatePID.setSetpoint(NavX.getInstance().getHeading());
		mRotatePID.enable();
	}

	@Override
	protected void execute()
	{
		Robot.mDriveTrain.arcadeDrive(mDriveStraightPID.getOutput(), mRotatePID.getOutput());
	}
	
	@Override
	protected boolean isFinished()
	{
		return mDriveStraightPID.onTarget();
	}

	@Override
	protected void end()
	{
		Robot.mDriveTrain.arcadeDrive(0, 0);
		
		mDriveStraightPID.disable();
		mRotatePID.disable();
	}
}
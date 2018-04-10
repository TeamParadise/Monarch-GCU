package org.usfirst.frc.team1165.robot.commands.auto;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForwardSpeed extends Command
{
	private double mDistance;

	public DriveForwardSpeed(double distance)
	{
		mDistance = distance;

		requires(Robot.mDriveTrain);
	}

	@Override
	protected void execute() {
		Robot.mDriveTrain.arcadeDrive(mDistance, 0);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.mDriveTrain.stop();
	}

}

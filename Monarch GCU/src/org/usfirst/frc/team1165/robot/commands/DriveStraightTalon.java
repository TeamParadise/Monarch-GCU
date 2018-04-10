package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightTalon extends Command
{
	private double mTarget;
	
	public DriveStraightTalon(double target)
	{
		mTarget = target;
		requires(Robot.mDriveTrain);
	}

	@Override
	protected void initialize() {
		System.out.println("Command Started: " + getName());
	}
	
	@Override
	protected void execute() {
		Robot.mDriveTrain.setPosition(mTarget);
	}

	@Override
	protected boolean isFinished() {
		return Robot.mDriveTrain.onTarget(mTarget);
	}

	@Override
	protected void end() {
		Robot.mDriveTrain.stop();
	}
}

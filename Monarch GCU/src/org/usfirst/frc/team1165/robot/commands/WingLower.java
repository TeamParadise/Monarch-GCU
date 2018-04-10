package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WingLower extends Command
{
	public WingLower() {
		requires(Robot.mWing);
	}

	@Override
	protected void initialize()
	{
		System.out.println("Command Started: " + getName());
		Robot.mWing.lower();
	}

	@Override
	protected boolean isFinished() {
		return !Robot.mOI.getLowerWing();
	}
}

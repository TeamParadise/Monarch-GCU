package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClawToggle extends InstantCommand
{
	public ClawToggle() {
		requires(Robot.mClaw);
	}

	@Override
	protected void initialize()
	{
		System.out.println("Command Started: " + getName());
		Robot.mClaw.toggle();
	}
}

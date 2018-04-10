package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClimberDown extends InstantCommand
{
	public ClimberDown()
	{
		requires(Robot.mClimber);
	}

	@Override
	protected void initialize()
	{
		System.out.println("Command Started: " + getName());
		Robot.mClimber.down();
	}
}

package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ClimberUp extends InstantCommand
{

	public ClimberUp()
	{
		requires(Robot.mClimber);
	}

	@Override
	protected void initialize()
	{
		System.out.println("Command Started: " + getName());
		Robot.mClimber.up();
	}
}

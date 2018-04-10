package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotaryLiftStop extends Command
{
	public RotaryLiftStop()
	{
		requires(Robot.mRotaryLift);
	}

//	@Override
//	protected void initialize() {
//		System.out.println("Command Started: " + getName());
//	}

	@Override
	protected void execute() {
		Robot.mRotaryLift.setSpeed(0);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}

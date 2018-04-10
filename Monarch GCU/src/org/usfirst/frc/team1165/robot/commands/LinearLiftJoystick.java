package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LinearLiftJoystick extends Command
{
	public LinearLiftJoystick()
	{
		requires(Robot.mLinearLift);
	}

//	@Override
//	protected void initialize() {
//		System.out.println("Command Started: " + getName());
//	}

	@Override
	protected void execute()
	{
		Robot.mLinearLift.setSpeed(Robot.mOI.getRightY());
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}

}
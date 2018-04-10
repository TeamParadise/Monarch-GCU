package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotaryLiftUp extends Command
{
	public RotaryLiftUp()
	{
		requires(Robot.mRotaryLift);
	}

	@Override
	protected void initialize() {
		System.out.println("Command Started: " + getName());
	}

	@Override
	protected void execute()
	{
		Robot.mRotaryLift.setSpeed(RotaryLift.ROTARY_LIFT_FWD_SPEED);
	}

	@Override
	protected boolean isFinished()
	{
		return !Robot.mOI.getRotaryLiftUp();
	}
	
	@Override
	protected void end() {
		Robot.mRotaryLift.setSpeed(0);
	}

}

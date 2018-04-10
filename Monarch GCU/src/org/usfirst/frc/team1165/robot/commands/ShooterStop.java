package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterStop extends Command
{
	public ShooterStop() {
		requires(Robot.mShooter);
	}

//	@Override
//	protected void initialize() {
//		System.out.println("Command Started: " + getName());
//	}

	@Override
	protected void execute() {
		Robot.mShooter.set(0);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}

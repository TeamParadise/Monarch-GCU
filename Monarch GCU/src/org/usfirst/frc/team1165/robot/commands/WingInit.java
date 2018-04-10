package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WingInit extends Command
{
	public WingInit() {
		requires(Robot.mWing);
	}

	@Override
	protected void initialize() {
//		System.out.println("Command Started: " + getName());
		Robot.mWing.init();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}

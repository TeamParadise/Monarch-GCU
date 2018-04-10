package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveResetEncoders extends Command
{
	public DriveResetEncoders() {
		requires(Robot.mDriveTrain);
	}

	@Override
	protected void initialize() {
		System.out.println("Command Started: " + getName());
	}
	
	@Override
	protected void execute() {
		Robot.mDriveTrain.resetEncoders();
	}

	@Override
	protected boolean isFinished() {
		return Robot.mDriveTrain.isZeroed();
	}

}

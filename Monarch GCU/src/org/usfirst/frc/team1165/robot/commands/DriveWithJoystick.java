package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoystick extends Command
{
	public DriveWithJoystick()
	{
		requires(Robot.mDriveTrain);
	}

//	@Override
//	protected void initialize() {
//		System.out.println("Command Started: " + getName());
//	}
	
	@Override
	protected void execute() {
		Robot.mDriveTrain.arcadeDrive(Robot.mOI.getY(), Robot.mOI.getTwist());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.mDriveTrain.stop();
	}

}

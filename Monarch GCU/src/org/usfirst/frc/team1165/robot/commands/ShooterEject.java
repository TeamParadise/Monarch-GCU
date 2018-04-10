package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterEject extends Command
{
	public ShooterEject() {
		requires(Robot.mShooter);
	}

	@Override
	protected void initialize() {
		System.out.println("Command Started: " + getName());
	}

	@Override
	protected void execute() {
		Robot.mShooter.set(Shooter.SHOOTER_EJECT_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return !Robot.mOI.getEject();
	}

	@Override
	protected void end() {
		Robot.mShooter.set(0);
	}
}

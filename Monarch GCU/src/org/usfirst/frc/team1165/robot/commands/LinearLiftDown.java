package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.Robot;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LinearLiftDown extends Command
{
	public LinearLiftDown() {
		requires(Robot.mLinearLift);
	}

	@Override
	protected void initialize() {
		System.out.println("Command Started: " + getName());
	}

	@Override
	protected void execute() {
		Robot.mLinearLift.setSpeed(LinearLift.LINEAR_LIFT_REV_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return Robot.mLinearLift.isDown();
	}
	
	@Override
	protected void end() {
		Robot.mLinearLift.stop();
	}

}

package org.usfirst.frc.team1165.robot.commands.auto;

import org.usfirst.frc.team1165.robot.commands.ClawOpen;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSwitch extends CommandGroup
{
	public AutoSwitch()
	{
		addSequential(new DriveStraightDistance(11 * 12));
		addSequential(new AutoRotaryLiftPosition(RotaryLift.ROTARY_LIFT_SWITCH, 0.35));
		addSequential(new ClawOpen());
	}
}

package org.usfirst.frc.team1165.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveStraight extends CommandGroup
{
	public AutoDriveStraight()
	{
		addSequential(new DriveStraightDistance(11 * 12));
	}
}

package org.usfirst.frc.team1165.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossLineSide extends CommandGroup
{
	public AutoCrossLineSide()
	{
		addSequential(new DriveStraightSpeed(0.75), 2);
	}
}

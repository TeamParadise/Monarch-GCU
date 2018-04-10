package org.usfirst.frc.team1165.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossLineCenter extends CommandGroup
{
	public AutoCrossLineCenter()
	{
		addSequential(new DriveStraightSpeed(0.75), 1.3);
	}
}

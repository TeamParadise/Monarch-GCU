package org.usfirst.frc.team1165.robot.commands;

import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class HassettFunction extends CommandGroup {
    public HassettFunction() {
    	addSequential(new ClawOpen());
    	addParallel(new LinearLiftDown());
    	addSequential(new RotaryLiftPosition(RotaryLift.ROTARY_LIFT_SWITCH, 0, 0.375), 4);
    }
}

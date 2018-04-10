package org.usfirst.frc.team1165.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{

	// MOTOR CONTROLLERS

	public static final int RIGHT_MASTER_DRIVE_TALON = 11;
	public static final int RIGHT_SLAVE_DRIVE_TALON = 10;
	public static final int LEFT_MASTER_DRIVE_TALON = 13;
	public static final int LEFT_SLAVE_DRIVE_TALON = 12;
	
	public static final int RIGHT_SHOOTER_TALON = 16;
	public static final int LEFT_SHOOTER_TALON = 17;

	public static final int LINEAR_LIFT_MASTER_TALON = 14;
	public static final int LINEAR_LIFT_SLAVE_TALON = 15;

	public static final int ROTARY_LIFT_TALON = 18;

	// SENSORS

	public static final int LINEAR_LIFT_LIMIT_SWITCH = 0; // placeholder value
	public static final int ROTARY_LIFT_POT = 0; // placeholder value

	public static final int PRESSURE_SENSOR_PORT = 1;
	
	// PNEUMATICS

	public static final int PCM = 1;

	public static final int WING_SOLENOID = 5;

	public static final int CLAW_EXTEND_SOLENOID = 0;
	public static final int CLAW_RETRACT_SOLENOID = 1;

	public static final int CLIMBER_EXTEND_SOLENOID = 2;
	public static final int CLIMBER_RETRACT_SOLENOID = 3;
	
	// BUTTONS
	
	// BUTTONS FOR DRIVER

	public static final int CLAW_TOGGLE_BUTTON = 1;
	public static final int SHOOTER_INTAKE_BUTTON = 2;
	public static final int SHOOTER_EJECT_BUTTON = 3;
	
	public static final int ROTARY_LIFT_UP_BUTTON = 12;
	public static final int ROTARY_LIFT_DOWN_BUTTON = 11;
	
	public static final int ROTARY_LIFT_SWITCH_BUTTON = 5;
	public static final int ROTARY_LIFT_SCALE_BUTTON = 6;
	
	public static final int SLOW_TURN_BUTTON = 4;

	// BUTTONS FOR CO-DRIVER

	// linear lift is right stick on controller

	public static final int LOWER_WING_BUTTON = 5;

	public static final int CLIMBER_UP_BUTTON = 1;
	public static final int CLIMBER_DOWN_BUTTON = 4;
	
	public static final int HASSETT_FUNCTION = 2;
	
	
	public static final double DRIVE_IN_TO_TICKS = Math.PI * 5 / 80;
	public static final double DRIVE_TICKS_TO_IN = 80 / (Math.PI * 5);
}

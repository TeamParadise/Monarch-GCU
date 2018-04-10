package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.ShooterStop;
import org.usfirst.frc.team1165.util.drivers.BasicTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class Shooter extends Subsystem
{
	private BasicTalon mRightMotor = new BasicTalon(RobotMap.RIGHT_SHOOTER_TALON, false);
	private BasicTalon mLeftMotor = new BasicTalon(RobotMap.LEFT_SHOOTER_TALON, false);

	public static final double SHOOTER_INTAKE_SPEED = 0.6;
	public static final double SHOOTER_EJECT_SPEED = -0.6;
	
	public void set(double speed)
	{
		mRightMotor.set(speed);
		mLeftMotor.set(speed);
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new ShooterStop());
	}

	public void report()
	{
		SmartDashboard.putNumber(getName() + " Right", mRightMotor.get());
		SmartDashboard.putNumber(getName() + " Left", mLeftMotor.get());
	}

}
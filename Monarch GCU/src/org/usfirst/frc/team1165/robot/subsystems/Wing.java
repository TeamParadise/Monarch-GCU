package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;
import org.usfirst.frc.team1165.robot.commands.WingInit;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Wing extends Subsystem
{
	private Solenoid mWing = new Solenoid(RobotMap.PCM, RobotMap.WING_SOLENOID);

	public void lower()
	{
		mWing.set(true);
	}

	public void init()
	{
		mWing.set(false);
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new WingInit());
	}

	public void report()
	{
		SmartDashboard.putBoolean(getName() + " State", mWing.get());
	}
}
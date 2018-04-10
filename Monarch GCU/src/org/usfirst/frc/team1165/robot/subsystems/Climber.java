package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem
{
	private DoubleSolenoid mClimber = new DoubleSolenoid(RobotMap.PCM, RobotMap.CLIMBER_EXTEND_SOLENOID,
			RobotMap.CLIMBER_RETRACT_SOLENOID);

	public void up()
	{
		mClimber.set(Value.kReverse);
	}

	public void down()
	{
		mClimber.set(Value.kForward);
	}

	public void off()
	{
		mClimber.set(Value.kOff);
	}

	@Override
	protected void initDefaultCommand()
	{
	}

	public void report()
	{
		SmartDashboard.putString(getName() + " Solenoid", mClimber.get().toString());
	}
}
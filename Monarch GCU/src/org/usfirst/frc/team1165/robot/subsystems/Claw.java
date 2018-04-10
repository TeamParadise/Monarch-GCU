package org.usfirst.frc.team1165.robot.subsystems;

import org.usfirst.frc.team1165.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw extends Subsystem
{
	private DoubleSolenoid mClawSolenoid = new DoubleSolenoid(RobotMap.PCM, RobotMap.CLAW_EXTEND_SOLENOID,
			RobotMap.CLAW_RETRACT_SOLENOID);

	public void toggle()
	{
		if (get() == Value.kForward)
			mClawSolenoid.set(Value.kReverse);
		else
			mClawSolenoid.set(Value.kForward);
	}
	
	public void open() {
		mClawSolenoid.set(Value.kForward);
	}
	
	public void close() {
		mClawSolenoid.set(Value.kReverse);
	}

	public void off() {
		mClawSolenoid.set(Value.kOff);
	}

	public Value get() {
		return mClawSolenoid.get();
	}

	@Override
	protected void initDefaultCommand()
	{
	}

	public void report()
	{
		SmartDashboard.putString(getName(), mClawSolenoid.get().toString());
	}

}
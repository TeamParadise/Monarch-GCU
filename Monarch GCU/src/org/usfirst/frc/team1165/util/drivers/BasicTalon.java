package org.usfirst.frc.team1165.util.drivers;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BasicTalon extends WPI_TalonSRX
{
	public BasicTalon(int id, boolean isInverted)
	{
		super(id);
		
		setInverted(isInverted);

		configNeutralDeadband(0.009, 0);
		
		configOpenloopRamp(0.1, 0);

		configVoltageCompSaturation(13, 0);
		enableVoltageCompensation(true);
		
//		configNominalOutputForward(0, 0);
//		configNominalOutputReverse(0, 0);
//		configPeakOutputForward(1, 0);
//		configPeakOutputReverse(-1, 0);
	}
	
	public void report(String name)
	{
		SmartDashboard.putNumber(name + " Speed", getMotorOutputPercent());
		SmartDashboard.putNumber(name + " Voltage", getMotorOutputVoltage());
		SmartDashboard.putNumber(name + " Current", getOutputCurrent());
		
	}
}
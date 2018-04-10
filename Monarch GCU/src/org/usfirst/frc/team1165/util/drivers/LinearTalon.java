package org.usfirst.frc.team1165.util.drivers;

import static com.ctre.phoenix.motorcontrol.LimitSwitchNormal.NormallyOpen;
import static com.ctre.phoenix.motorcontrol.LimitSwitchSource.FeedbackConnector;
import static edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.putBoolean;
import static edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.putNumber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class LinearTalon extends WPI_TalonSRX
{
	public LinearTalon(int id, boolean isInverted)
	{
		super(id);
		
		setInverted(isInverted);

		configNeutralDeadband(0.05, 0);
		
		configOpenloopRamp(0.1, 0);
		
		configVoltageCompSaturation(13, 0);
		enableVoltageCompensation(true);
		
		configNominalOutputForward(0, 0);
		configNominalOutputReverse(0, 0);
		configPeakOutputForward(0.75, 0);
		configPeakOutputReverse(-0.75, 0);

		configForwardLimitSwitchSource(FeedbackConnector, NormallyOpen, 0);
		configReverseLimitSwitchSource(FeedbackConnector, NormallyOpen, 0);
	}
	
	public boolean getFwdLimit() {
		return getSensorCollection().isFwdLimitSwitchClosed();
	}
	
	public boolean getRevLimit() {
		return getSensorCollection().isRevLimitSwitchClosed();
	}
	
	public void report(String name)
	{
		putNumber(name + " Speed", getMotorOutputPercent());
		putBoolean(name + " Fwd Limit", getFwdLimit());
		putBoolean(name + " Rev Limit", getRevLimit());
	}
}
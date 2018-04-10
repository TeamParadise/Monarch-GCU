package org.usfirst.frc.team1165.util.drivers;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotaryTalon extends WPI_TalonSRX
{
	public RotaryTalon(int id, boolean phase, boolean isInverted)
//	public RotaryTalon(int id, boolean phase, boolean isInverted, double[] pid)
	{
		super(id);
		
		setInverted(isInverted);

		configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
		configSetParameter(ParamEnum.eFeedbackNotContinuous, 1, 0x00, 0x00, 0x00);
		setSensorPhase(phase);
		
		configNeutralDeadband(0.05, 0);
		
		configOpenloopRamp(0.1, 0);

		configVoltageCompSaturation(13, 0);
		enableVoltageCompensation(true);
		
//		configNominalOutputForward(0, 0);
//		configNominalOutputReverse(0, 0);
//		configPeakOutputForward(0.5, 0);
//		configPeakOutputReverse(-0.5, 0);
		
		configForwardSoftLimitThreshold(-335, 0);
		configReverseSoftLimitThreshold(-787, 0);
		
		configForwardSoftLimitEnable(true, 0);
		configReverseSoftLimitEnable(true, 0);
		
//		configAllowableClosedloopError(0, (int) ROTARY_LIFT_TICKS_TO_DEG, 0);
		
//		selectProfileSlot(0, 0);
//		config_kP(0, pid[0], 0);
//		config_kI(0, pid[1], 0);
//		config_kD(0, pid[2], 0);
//		config_kF(0, pid[3], 0);
	}
	
	public double getAngle() {
		return getSelectedSensorPosition(0);
	}
	
	public double getError() {
		return getClosedLoopError(0);
	}
	
	public boolean onTarget(double target) {
		return fuzzyEquals(getAngle(), target, 1);
	}
	
	public void reset() {
		setSelectedSensorPosition(0, 0, 0);
	}
	
	public boolean isReset() {
		return fuzzyEquals(getAngle(), 0, 0.01);
	}
	
	private static boolean fuzzyEquals(double a, double b, double tolerance) {
		return Math.abs(Math.abs(a) - Math.abs(b)) < tolerance;		
	}
	
	public void report(String name)
	{
		SmartDashboard.putNumber(name + " Speed", getMotorOutputPercent());
		SmartDashboard.putNumber(name + " Position", getAngle());
		SmartDashboard.putNumber(name + " Error", getError());
	}
}
package org.usfirst.frc.team1165.util.drivers;

import org.usfirst.frc.team1165.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTalon extends WPI_TalonSRX
{
	public DriveTalon(int id, boolean phase, boolean isInverted, double[] pid)
	{
		super(id);
		
		setInverted(isInverted);

		configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		setSensorPhase(phase);
		
		configNeutralDeadband(0.009, 0);
		
		configOpenloopRamp(0.1, 0);

		configVoltageCompSaturation(13, 0);
		enableVoltageCompensation(true);
		
//		configNominalOutputForward(0, 0); // 0.1
//		configNominalOutputReverse(0, 0);
//		configPeakOutputForward(1, 0); // 0.6, 1
//		configPeakOutputReverse(-1, 0);
		
		configAllowableClosedloopError(0, (int) DriveTrain.IN_TO_TICKS, 0);
		
		selectProfileSlot(0, 0);
		config_kP(0, pid[0], 0);
		config_kI(0, pid[1], 0);
		config_kD(0, pid[2], 0);
		config_kF(0, pid[3], 0);
	}
	
	public double getDist() {
//		return getSelectedSensorPosition(0);
		return getSelectedSensorPosition(0) / DriveTrain.IN_TO_TICKS;
	}
	
	public double getVel() {
		return getSelectedSensorVelocity(0) * 10 / DriveTrain.IN_TO_TICKS;
	}
	
	public double getError() {
		return getClosedLoopError(0) / DriveTrain.IN_TO_TICKS;
	}
	
	public boolean onTarget(double target) {
		return fuzzyEquals(getDist(), target, 1);
	}
	
	public void reset() {
		setSelectedSensorPosition(0, 0, 0);
	}
	
	public boolean isReset() {
		return fuzzyEquals(getDist(), 0, 0.01);
	}
	
	private static boolean fuzzyEquals(double a, double b, double tolerance) {
		return Math.abs(Math.abs(a) - Math.abs(b)) < tolerance;		
	}
	
	public void report(String name)
	{
		SmartDashboard.putNumber(name + " Speed", getMotorOutputPercent());
		SmartDashboard.putNumber(name + " Position", getDist());
		SmartDashboard.putNumber(name + " Vel", getVel());
		SmartDashboard.putNumber(name + " Error", getError());
	}
}
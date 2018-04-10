package org.usfirst.frc.team1165.util;

import static org.usfirst.frc.team1165.robot.RobotMap.PRESSURE_SENSOR_PORT;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Wraps an analog input for a Rev Robotics Analog Pressure sensor.
 *
 * http://www.revrobotics.com/wp-content/uploads/2015/11/REV-11-1107-DS-00.pdf
 */
public class PressureSensor
{
	private static final PressureSensor mInstance = new PressureSensor();
	
	public static PressureSensor getInstance() {
		return mInstance;
	}
	
	private AnalogInput mPressureSensor = new AnalogInput(PRESSURE_SENSOR_PORT);

	protected PressureSensor() {
	}
	
	/*
	 * Equation:
	 * 
	 * v_out = mAnalogInput.getVoltage()
	 * v0 = voltage at 60 psi
	 * 
	 * p = 85(v_out/v0) - 25
	 * 
	 * 0.587158143 -> 60
	 * 0.717773364 -> 85
	 * 
	 * (85 - 60) / (0.717773364 - 0.587158143)
	 * 25/ .13061522
	 * 
	 * 191.4 * (v - 0.717773364) + 85
	 */
	public double getPressure()
	{
		return 191.4 * (mPressureSensor.getVoltage() - 0.717773364) + 85;
//		return 50 * mPressureSensor.getVoltage() - 25;
	}

	public void report()
	{
		SmartDashboard.putNumber("Pressure Sensor Value", getPressure());
	}

}

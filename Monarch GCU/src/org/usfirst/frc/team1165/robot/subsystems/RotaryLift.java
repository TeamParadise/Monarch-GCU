package org.usfirst.frc.team1165.robot.subsystems;

import static org.usfirst.frc.team1165.robot.RobotMap.ROTARY_LIFT_TALON;

import org.usfirst.frc.team1165.robot.commands.RotaryLiftStop;
import org.usfirst.frc.team1165.util.drivers.RotaryTalon;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class RotaryLift extends Subsystem implements PIDSource, PIDOutput
{
	public static final double[] ROTARY_PID = { 0.1, 0, 0, 0 };
	
	private RotaryTalon mRotaryLift = new RotaryTalon(ROTARY_LIFT_TALON, true, false);

	public static final double ROTARY_LIFT_FWD_SPEED = 0.75;
	public static final double ROTARY_LIFT_REV_SPEED = -0.2;
	
	public static final double ROTARY_LIFT_SWITCH = -450;
	public static final double ROTARY_LIFT_SCALE = -385;
	
	public void setSpeed(double speed) {
		mRotaryLift.set(speed);
	}
	
	public void setAngle(double angle) {
		mRotaryLift.set(ControlMode.Position, angle);
	}

	public double getAngle() {
		return mRotaryLift.getSelectedSensorPosition(0);
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new RotaryLiftStop());
	}

	public void report()
	{
		SmartDashboard.putNumber(getName() + " Motor", mRotaryLift.get());
		SmartDashboard.putNumber(getName() + " Angle", getAngle());
		mRotaryLift.report("Rotary Lift ");
	}
	
	// ----- PIDSource ----- //
	
	@Override
	public void setPIDSourceType(PIDSourceType type)
	{
	}

	@Override
	public PIDSourceType getPIDSourceType()
	{
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet()
	{
		return getAngle();
	}

	// ----- PIDOutput ----- //
	
	@Override
	public void pidWrite(double output)
	{
		setSpeed(output);
	}

}
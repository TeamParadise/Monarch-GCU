package org.usfirst.frc.team1165.robot.subsystems;

import static org.usfirst.frc.team1165.robot.RobotMap.LINEAR_LIFT_MASTER_TALON;
import static org.usfirst.frc.team1165.robot.RobotMap.LINEAR_LIFT_SLAVE_TALON;

import org.usfirst.frc.team1165.robot.commands.LinearLiftJoystick;
import org.usfirst.frc.team1165.util.drivers.BasicTalon;
import org.usfirst.frc.team1165.util.drivers.LinearTalon;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Kesav Kadalazhi
 *
 */
public class LinearLift extends Subsystem
{
	private LinearTalon mMaster = new LinearTalon(LINEAR_LIFT_MASTER_TALON, false);
	private BasicTalon mFollower = new BasicTalon(LINEAR_LIFT_SLAVE_TALON, false);

	private SpeedControllerGroup mLift = new SpeedControllerGroup(mMaster, mFollower);

//	private DigitalInput mLimit = new DigitalInput(RobotMap.LINEAR_LIFT_LIMIT_SWITCH);
	
	public static final double LINEAR_LIFT_FWD_SPEED = 0.6;
	public static final double LINEAR_LIFT_REV_SPEED = -0.6;
	
	public void setSpeed(double speed) {
		mLift.set(speed);
	}
	
	public void up() {
		setSpeed(LINEAR_LIFT_FWD_SPEED);
	}

	public void down() {
		setSpeed(LINEAR_LIFT_REV_SPEED);
	}

	public boolean isUp() {
		return mMaster.getFwdLimit();
	}
	
	public boolean isAtSwitch() {
		return false;
//		return mLimit.get();
	}
	
	public boolean isDown() {
		return mMaster.getRevLimit();
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LinearLiftJoystick());
	}

	public void report()
	{
		SmartDashboard.putNumber(getName() + " Speed", mLift.get());
		SmartDashboard.putBoolean(getName() + " Down", isDown());
		SmartDashboard.putBoolean(getName() + " At Switch", isAtSwitch());
		SmartDashboard.putBoolean(getName() + " Up", isUp());
	}

}
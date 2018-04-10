package org.usfirst.frc.team1165.robot.subsystems;

import static org.usfirst.frc.team1165.robot.RobotMap.LEFT_MASTER_DRIVE_TALON;
import static org.usfirst.frc.team1165.robot.RobotMap.LEFT_SLAVE_DRIVE_TALON;
import static org.usfirst.frc.team1165.robot.RobotMap.RIGHT_MASTER_DRIVE_TALON;
import static org.usfirst.frc.team1165.robot.RobotMap.RIGHT_SLAVE_DRIVE_TALON;

import org.usfirst.frc.team1165.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team1165.util.drivers.BasicTalon;
import org.usfirst.frc.team1165.util.drivers.DriveTalon;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem
{
	public static final double[] DRIVE_STRAIGHT_LEFT_PID = { 0.32, 0, 0, 0 };
	public static final double[] DRIVE_STRAIGHT_RIGHT_PID = { 0.25, 0, 0, 0 };
	
	private DriveTalon mLeftMaster = new DriveTalon(LEFT_MASTER_DRIVE_TALON, true, false, DRIVE_STRAIGHT_LEFT_PID);	
	private DriveTalon mRightMaster = new DriveTalon(RIGHT_MASTER_DRIVE_TALON, true, false, DRIVE_STRAIGHT_RIGHT_PID);

	private BasicTalon mLeftSlave = new BasicTalon(LEFT_SLAVE_DRIVE_TALON, false);
	private BasicTalon mRightSlave = new BasicTalon(RIGHT_SLAVE_DRIVE_TALON, false);

	private SpeedControllerGroup mLeftDrive = new SpeedControllerGroup(mLeftMaster, mLeftSlave);
	private SpeedControllerGroup mRightDrive = new SpeedControllerGroup(mRightMaster, mRightSlave);

	private DifferentialDrive mDrive = new DifferentialDrive(mLeftDrive, mRightDrive);

	
	// 4777 / 24 = 199
	// 600 ticks / (5pi in) = 38.2
	// 80 ticks /rev * 1 rev/5pi
	
	public static final double IN_TO_TICKS = 199;
	
	public DriveTrain()
	{
		mDrive.setDeadband(0.009);
	}
	
	public void arcadeDrive(double speed, double twist)
	{
		mDrive.arcadeDrive(speed, twist);
	}

	public void tankDrive(double leftSpeed, double rightSpeed)
	{
		mDrive.tankDrive(leftSpeed, rightSpeed);
	}
	
	public void setPosition(double setpoint)
	{
		double target = setpoint * IN_TO_TICKS;
	
		mLeftMaster.set(ControlMode.Position, target);
		mRightMaster.set(ControlMode.Position, -target);
	}
	
	public void stop()
	{
		mLeftMaster.set(ControlMode.PercentOutput, 0);
		mRightMaster.set(ControlMode.PercentOutput, 0);

		mLeftSlave.set(ControlMode.PercentOutput, 0);
		mRightSlave.set(ControlMode.PercentOutput, 0);
	}
	
	public double getLeftDist() {
		return mLeftMaster.getDist();
	}
	
	public double getRightDist() {
		return mRightMaster.getDist();
	}
	
	public void resetEncoders()
	{
		mLeftMaster.reset();
		mRightMaster.reset();
	}
	
	public boolean isZeroed() {
		return mLeftMaster.isReset() && mRightMaster.isReset();
	}
	
	public boolean onTarget(double target) {
		return mLeftMaster.onTarget(target) && mRightMaster.onTarget(target);
	}

	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new DriveWithJoystick());
	}

	public void report()
	{
		mLeftMaster.report("Left");
		mRightMaster.report("Right");
	}
}
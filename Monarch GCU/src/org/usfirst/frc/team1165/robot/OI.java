package org.usfirst.frc.team1165.robot;

import org.usfirst.frc.team1165.robot.commands.ClawOpen;
import org.usfirst.frc.team1165.robot.commands.ClawToggle;
import org.usfirst.frc.team1165.robot.commands.ClimberDown;
import org.usfirst.frc.team1165.robot.commands.ClimberUp;
import org.usfirst.frc.team1165.robot.commands.DriveResetEncoders;
import org.usfirst.frc.team1165.robot.commands.DriveStraightTalon;
import org.usfirst.frc.team1165.robot.commands.HassettFunction;
import org.usfirst.frc.team1165.robot.commands.RotaryLiftDown;
import org.usfirst.frc.team1165.robot.commands.RotaryLiftPosition;
import org.usfirst.frc.team1165.robot.commands.RotaryLiftUp;
import org.usfirst.frc.team1165.robot.commands.ShooterEject;
import org.usfirst.frc.team1165.robot.commands.ShooterIntake;
import org.usfirst.frc.team1165.robot.commands.WingLower;
import org.usfirst.frc.team1165.robot.commands.auto.DriveStraightDistance;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	// DRIVER FUNCTIONALITY

	private Joystick mJoy = new Joystick(0);

	private JoystickButton mClawToggle = new JoystickButton(mJoy, RobotMap.CLAW_TOGGLE_BUTTON);

	private JoystickButton mShooterIntake = new JoystickButton(mJoy, RobotMap.SHOOTER_INTAKE_BUTTON);
	private JoystickButton mShooterEject = new JoystickButton(mJoy, RobotMap.SHOOTER_EJECT_BUTTON);

	private JoystickButton mRotaryLiftUp = new JoystickButton(mJoy, RobotMap.ROTARY_LIFT_UP_BUTTON);
	private JoystickButton mRotaryLiftDown = new JoystickButton(mJoy, RobotMap.ROTARY_LIFT_DOWN_BUTTON);

	private JoystickButton mRotaryLiftSwitch = new JoystickButton(mJoy, RobotMap.ROTARY_LIFT_SWITCH_BUTTON);
	private JoystickButton mRotaryLiftScale = new JoystickButton(mJoy, RobotMap.ROTARY_LIFT_SCALE_BUTTON);

	// CO-DRIVER FUNCTIONALITY

	private XboxController mCtrl = new XboxController(1);

	private JoystickButton mLowerWing = new JoystickButton(mCtrl, RobotMap.LOWER_WING_BUTTON);

	private JoystickButton mClimberUp = new JoystickButton(mCtrl, RobotMap.CLIMBER_UP_BUTTON);
	private JoystickButton mClimberDown = new JoystickButton(mCtrl, RobotMap.CLIMBER_DOWN_BUTTON);
	
	private JoystickButton mHassettFunction = new JoystickButton(mCtrl, RobotMap.HASSETT_FUNCTION);

	public OI()
	{
		SmartDashboard.putData(new DriveStraightTalon(10));
		SmartDashboard.putData(new DriveResetEncoders());
//		SmartDashboard.putData(new RotaryLiftPosition(RotaryLift.ROTARY_LIFT_SWITCH));
		SmartDashboard.putData(new HassettFunction());
		SmartDashboard.putData(new ClawOpen());

		SmartDashboard.putData(new DriveStraightDistance(11 * 12));

//		SmartDashboard.putData(new RotaryLiftPosition(RotaryLift.ROTARY_LIFT_SWITCH, 0.15, 0.36));
//		SmartDashboard.putData(new RotaryLiftPosition(RotaryLift.ROTARY_LIFT_SCALE, 0.2, 0.425));
		
		// Driver Functionality

		mClawToggle.whenPressed(new ClawToggle());

		mShooterIntake.whenPressed(new ShooterIntake());
		mShooterEject.whenPressed(new ShooterEject());

		mRotaryLiftUp.whenPressed(new RotaryLiftUp());
		mRotaryLiftDown.whenPressed(new RotaryLiftDown());
		
		mRotaryLiftSwitch.whenPressed(new RotaryLiftPosition(RotaryLift.ROTARY_LIFT_SWITCH, 0.3, 0.4));
		mRotaryLiftScale.whenPressed(new RotaryLiftPosition(RotaryLift.ROTARY_LIFT_SCALE, 0.3, 0.44));

		// Co Driver Functionality

		mLowerWing.whenPressed(new WingLower());

		mHassettFunction.whenPressed(new HassettFunction());

		mClimberUp.whenPressed(new ClimberUp());
		mClimberDown.whenPressed(new ClimberDown());
	}
	
	public double getX()
	{
		return dampen(mJoy.getX(), 3);
	}

	public double getY()
	{
		return dampen(-mJoy.getY(), 3);
	}

	public double getTwist()
	{
		if(mJoy.getRawButton(RobotMap.SLOW_TURN_BUTTON))
			return constrain(mJoy.getTwist(), -0.5, 0.5);
		else
			return dampen(mJoy.getTwist(), 3);
	}

	public boolean getIntake()
	{
		return mShooterIntake.get();
	}

	public boolean getEject()
	{
		return mShooterEject.get();
	}

	// linear lift
	public double getRightY() {
		return mCtrl.getY(Hand.kRight);
//		return constrain(mCtrl.getY(Hand.kRight), -0.3, 0.75);
	}

	public boolean getRotaryLiftUp()
	{
		return mRotaryLiftUp.get();
	}

	public boolean getRotaryLiftDown()
	{
		return mRotaryLiftDown.get();
	}
	
	public boolean getLowerWing()
	{
		return mLowerWing.get();
	}

	// INPUT TRANSFORM

	public static double dampen(double value, double dampener)
	{
		return Math.abs(value) < 0.05? 0: Math.copySign(Math.pow(value, dampener), value);
	}

	public static double constrain(double input, double low, double high)
	{
		return Math.max(low, Math.min(input, high));
	}
	
	public void report()
	{
		SmartDashboard.putNumber("Right Y", getRightY());
	}

}
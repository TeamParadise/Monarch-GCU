package org.usfirst.frc.team1165.robot;

import org.usfirst.frc.team1165.robot.commands.auto.AutoCrossLineCenter;
import org.usfirst.frc.team1165.robot.commands.auto.AutoCrossLineSide;
import org.usfirst.frc.team1165.robot.commands.auto.AutoDriveStraight;
import org.usfirst.frc.team1165.robot.commands.auto.AutoSwitch;
import org.usfirst.frc.team1165.robot.subsystems.Claw;
import org.usfirst.frc.team1165.robot.subsystems.Climber;
import org.usfirst.frc.team1165.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1165.robot.subsystems.LinearLift;
import org.usfirst.frc.team1165.robot.subsystems.RotaryLift;
import org.usfirst.frc.team1165.robot.subsystems.Shooter;
import org.usfirst.frc.team1165.robot.subsystems.Wing;
import org.usfirst.frc.team1165.util.GameData;
import org.usfirst.frc.team1165.util.NavX;
import org.usfirst.frc.team1165.util.Position;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot
{
	public static DriveTrain mDriveTrain = new DriveTrain();
	public static Shooter mShooter = new Shooter();
	public static LinearLift mLinearLift = new LinearLift();
	public static RotaryLift mRotaryLift = new RotaryLift();
	public static Claw mClaw = new Claw();
	public static Climber mClimber = new Climber();
	public static Wing mWing = new Wing();
	
	public static OI mOI = new OI();
	
	public static NavX mNavX = NavX.getInstance();

	public static GameData mGameData = GameData.getInstance();
	
	private Command mAuto;
//	private SendableChooser<Command> mAutoChooser = new SendableChooser<>();

	private SendableChooser<Position> mPositionChooser = new SendableChooser<>();

	@Override
	public void robotInit()
	{
//		mAutoChooser.addDefault("Center Auto", new AutoCrossLineCenter());
//		mAutoChooser.addObject("Side Auto", new AutoCrossLineSide());
//
//		mAutoChooser.addObject("Switch Auto Left", new AutoSwitch(Position.kLeft));
//		mAutoChooser.addObject("Switch Auto Right", new AutoSwitch(Position.kRight));

//		mAutoChooser.addObject("DriveStraightDistance Auto", new DriveStraightDistance(10));

//		SmartDashboard.putData("Auto mode", mAutoChooser);
		
		mPositionChooser.setName("Robot Position");
		mPositionChooser.addObject("Center", Position.kCenter);
		mPositionChooser.addObject("Left", Position.kLeft);
		mPositionChooser.addDefault("Right", Position.kRight);
		
		SmartDashboard.putData(mPositionChooser);
	}
	
	@Override
	public void robotPeriodic()
	{
		mDriveTrain.report();
		mShooter.report();
		mLinearLift.report();
		mRotaryLift.report();
		mClaw.report();
		mClimber.report();
		mWing.report();
		
		mOI.report();
		
		mNavX.report();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit()
	{
//		mAuto = mAutoChooser.getSelected();

		try {
			if(mPositionChooser.getSelected() == mGameData.getFrontSwitch()) {
				mAuto = new AutoSwitch();
				System.out.println("Auto Switch selected");
			} else {
				mAuto = new AutoDriveStraight();
				System.out.println("Auto Drive Straight selected");
			}
		} catch(Exception ex) { 
			System.out.println("Can't get DS message");
			mAuto = new AutoDriveStraight();
			System.out.println("Auto Drive Straight selected");
		}
		
		if (mAuto != null) mAuto.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (mAuto != null) mAuto.cancel();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}

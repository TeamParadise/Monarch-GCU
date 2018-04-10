package org.usfirst.frc.team1165.robot.commands.auto;

import org.usfirst.frc.team1165.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoRotaryLiftPosition extends Command
{
	private static PIDSource mSource = new PIDSource() {
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return Robot.mRotaryLift.getAngle();
		}
		
	};
	
	private PIDController mRotateCtrl = new PIDController(0.05, 0.0, 0.0, 0.0, mSource, (output) -> {});
	
	private double mTarget, mMaxOutput;

	public AutoRotaryLiftPosition(double target, double maxOutput)
	{
		mTarget = target;
		mMaxOutput = maxOutput;
		
		requires(Robot.mRotaryLift);

		mRotateCtrl.setInputRange(-787, -335);
		mRotateCtrl.setOutputRange(-0.2, mMaxOutput);
		mRotateCtrl.setAbsoluteTolerance(5);
		mRotateCtrl.setContinuous(false);
	}

	@Override
	protected void initialize()
	{
		System.out.println("Command Started: " + getName());
		mRotateCtrl.setSetpoint(mTarget);
		mRotateCtrl.enable();
	}

	@Override
	protected void execute() {
		Robot.mRotaryLift.setSpeed(mRotateCtrl.get());
	}

	@Override
	protected boolean isFinished()
	{
		return mRotateCtrl.onTarget();
	}
	
	@Override
	protected void end() {
		Robot.mRotaryLift.setSpeed(0);
	}

}

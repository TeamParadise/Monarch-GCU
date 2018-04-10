/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1165.util;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class NavX implements PIDSource
{
	private static final NavX mInstance = new NavX();
	
	public static NavX getInstance() {
		return mInstance;
	}
	
	private AHRS mAHRS;

	protected NavX() {
		mAHRS = new AHRS(SPI.Port.kMXP);
	}
	
	public double getHeading()
	{
		return mAHRS.getFusedHeading();
	}

	public void report()
	{
		SmartDashboard.putNumber("NavX Heading", getHeading());
	}

	// ----- PIDSource ----- //
	
	@Override
	public void setPIDSourceType(PIDSourceType type)
	{
//		mAHRS.setPIDSourceType(type);
	}

	@Override
	public PIDSourceType getPIDSourceType()
	{
		return PIDSourceType.kDisplacement;
//		return mAHRS.getPIDSourceType();
	}

	@Override
	public double pidGet()
	{
		return getHeading();
	}
}

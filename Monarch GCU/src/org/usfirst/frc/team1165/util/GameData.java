package org.usfirst.frc.team1165.util;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GameData {
	
	private static final GameData mInstance = new GameData();
	
	public static GameData getInstance() {
		return mInstance;
	}
	
	protected GameData() {
	}
	
	public Position getFrontSwitch() {
		return getData(0);
	}
	
	public Position getScale() {
		return getData(1);
	}
	
	public Position getBackSwitch() {
		return getData(2);
	}
	
	private static Position getData(int index) {
		switch(DriverStation.getInstance().getGameSpecificMessage().charAt(index)) {
			case 'L': return Position.kLeft;
			case 'R': return Position.kRight;
			default: return null;
		}
	}
	
	public void report() {
		SmartDashboard.putString("Front Switch", getFrontSwitch().toString());
		SmartDashboard.putString("Scale", getScale().toString());
		SmartDashboard.putString("Back Switch", getBackSwitch().toString());
		
//		System.out.println("Front Switch: " + getFrontSwitch().toString());
//		System.out.println("Scale: " + getScale().toString());
//		System.out.println("Back Switch: " + getBackSwitch().toString());
	}
}

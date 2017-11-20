package org.usfirst.frc.team263.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 * Holds static methods for traversing pre-recorded obstacles
 * @author Dan Waxman
 * @since 2016-02-16
 * @version 1.0
 */
public class Presets {
	private static final double RECORD_LENGTH = 0.1;
	private static final int INTERRUPT_BUTTON = 8;
	
	private static double[] portcullisLF = {};
	private static double[] portcullisLB = {};
	private static double[] portcullisRF = {};
	private static double[] portcullisRB = {};
	private static double[] portcullisM = {};
	private static double[] lowBarLF = {0,0,0,0,0,0,0,0,0,0,0,0,0,.3,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,-.25,-.25,0,0,0,0,0};
	private static double[] lowBarLB = {0,0,0,0,0,0,0,0,0,0,0,0,0,-.3,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,.25,.25,0,0,0,0,0};
	private static double[] lowBarRF = {0,0,0,0,0,0,0,0,0,0,0,0,0,.3,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,.6,-.25,-.25,0,0,0,0,0};
	private static double[] lowBarRB = {0,0,0,0,0,0,0,0,0,0,0,0,0,-.3,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,-.6,.25,.25,0,0,0,0,0};
	private static double[] lowBarM = {-.7,-.7,-.5-.2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private static double[] moatLF = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-.25,-.25,-.25};
	private static double[] moatLB = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,.25,.25,.25};
	private static double[] moatRF = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-.25,-.25,-.25};
	private static double[] moatRB = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,.25,.25,.25};
	private static double[] rockWallLF = {};
	private static double[] rockWallLB = {};
	private static double[] rockWallRF = {};
	private static double[] rockWallRB = {};
	private static double[] roughTerrainLF = {};
	private static double[] roughTerrainLB = {};
	private static double[] roughTerrainRF = {};
	private static double[] roughTerrainRB = {};
	private static double[] rampartsLF = {};
	private static double[] rampartsLB = {};
	private static double[] rampartsRF = {};
	private static double[] rampartsRB = {};
	private static double[] sallyPortLF = {};
	private static double[] sallyPortLB = {};
	private static double[] sallyPortRF = {};
	private static double[] sallyPortRB = {};
	private static double[] sallyPortM = {};
	private static double[] chevalLF = {};
	private static double[] chevalLB = {};
	private static double[] chevalRF = {};
	private static double[] chevalRB = {};
	private static double[] chevalM = {};
	private static double[] drawBridgeLF = {};
	private static double[] drawBridgeLB = {};
	private static double[] drawBridgeRF = {};
	private static double[] drawBridgeRB = {};
	private static double[] drawBridgeM = {};
	
	private static final Joystick interruptJS = new Joystick(0);
	
	/**
	 * Traverses portcullis based on pre-defined path
	 * @param leftFront Front left drivebase motor
	 * @param leftBack Back left drivebase motor
	 * @param rightFront Front right drivebase motor
	 * @param rightBack Back right drivebase motor
	 * @param arm Arm pivot
	 */
	public static void portcullis(Talon leftFront, Talon leftBack, Talon rightFront, CANTalon rightBack, CANTalon arm) {
		for (int i = 0; i < Math.min(Math.min(portcullisLF.length, portcullisRF.length), portcullisM.length); i++) {
			if (interruptJS.getRawButton(INTERRUPT_BUTTON)) break;
			leftFront.set(portcullisLF[i]);
			leftBack.set(portcullisLB[i]);
			rightFront.set(portcullisRF[i]);
			rightBack.set(portcullisRB[i]);
			arm.set(portcullisM[i]);
			Timer.delay(RECORD_LENGTH);
		}
		leftFront.set(0);
		leftBack.set(0);
		rightFront.set(0);
		rightBack.set(0);
		arm.set(0);
	}
	
	/**
	 * Traverses Cheval de Frise based on pre-defined path
	 * @param leftFront Front left drivebase motor
	 * @param leftBack Back left drivebase motor
	 * @param rightFront Front right drivebase motor
	 * @param rightBack Back right drivebase motor
	 * @param arm Arm pivot
	 */
	public static void cheval(Talon leftFront, Talon leftBack, Talon rightFront, CANTalon rightBack, CANTalon arm) {
		for (int i = 0; i < Math.min(Math.min(chevalLF.length, chevalRF.length), chevalM.length); i++) {
			if (interruptJS.getRawButton(INTERRUPT_BUTTON)) break;
			leftFront.set(chevalLF[i]);
			leftBack.set(chevalLB[i]);
			rightFront.set(chevalRF[i]);
			rightBack.set(chevalRB[i]);
			arm.set(chevalM[i]);
			Timer.delay(RECORD_LENGTH);
		}
		leftFront.set(0);
		leftBack.set(0);
		rightFront.set(0);
		rightBack.set(0);
		arm.set(0);
	}
	
	/**
	 * Traverses moat based on pre-defined path
	 * @param leftFront Front left drivebase motor
	 * @param rightBack Back right drivebase motor
	 * @param rightFront Front right drivebase motor
	 * @param leftBack Back left drivebase motor
	 */
	public static void moat(Talon leftFront, Talon leftBack, Talon rightFront, CANTalon rightBack) {
		for (int i = 0; i < Math.min(moatLF.length, moatRF.length); i++) {
			if (interruptJS.getRawButton(INTERRUPT_BUTTON)) break;
			leftFront.set(moatLF[i]);
			leftBack.set(moatLB[i]);
			rightFront.set(moatRF[i]);
			rightBack.set(moatRB[i]);
			Timer.delay(RECORD_LENGTH);
		}
		leftFront.set(0);
		leftBack.set(0);
		rightFront.set(0);
		rightBack.set(0);
	}
	
	/**
	 * Traverses ramparts based on pre-defined path
	 * @param leftFront Front left drivebase motor
	 * @param leftBack Back left drivebase motor
	 * @param rightFront Front right drivebase motor
	 * @param rightBack Back right drivebase motor
	 */
	public static void ramparts(Talon leftFront, Talon leftBack, Talon rightFront, CANTalon rightBack) {
		for (int i = 0; i < Math.min(rampartsLF.length, rampartsRF.length); i++) {
			if (interruptJS.getRawButton(INTERRUPT_BUTTON)) break;
			leftFront.set(rampartsLF[i]);
			leftBack.set(rampartsLB[i]);
			rightFront.set(rampartsRF[i]);
			rightBack.set(rampartsRB[i]);
			Timer.delay(RECORD_LENGTH);
		}
		leftFront.set(0);
		leftBack.set(0);
		rightFront.set(0);
		rightBack.set(0);
	}
	
	/**
	 * Traverses drawbridge based on pre-defined path
	 * @param leftFront Front left drivebase motor
	 * @param leftBack Back left drivebase motor
	 * @param rightFront Front right drivebase motor
	 * @param rightBack Back right drivebase motor
	 * @param arm Arm pivot
	 */
	public static void drawBridge(Talon leftFront, Talon leftBack, Talon rightFront, CANTalon rightBack, CANTalon arm) {
		for (int i = 0; i < Math.min(Math.min(drawBridgeLF.length, drawBridgeRF.length), drawBridgeM.length); i++) {
			if (interruptJS.getRawButton(INTERRUPT_BUTTON)) break;
			leftFront.set(drawBridgeLF[i]);
			leftBack.set(drawBridgeLB[i]);
			rightFront.set(drawBridgeRF[i]);
			rightBack.set(drawBridgeRB[i]);
			arm.set(drawBridgeM[i]);
			Timer.delay(RECORD_LENGTH);
		}
		leftFront.set(0);
		leftBack.set(0);
		rightFront.set(0);
		rightBack.set(0);
		arm.set(0);
	}
	
	/**
	 * Traverses sally port based on pre-defined path
	 * @param leftFront Front left drivebase motor
	 * @param leftBack Back left drivebase motor
	 * @param rightFront Front right drivebase motor
	 * @param rightBack Back right drivebase motor
	 * @param arm Arm pivot
	 */
	public static void sallyPort(Talon leftFront, Talon leftBack, Talon rightFront, CANTalon rightBack, CANTalon arm) {
		for (int i = 0; i < Math.min(Math.min(sallyPortLF.length, sallyPortRF.length), sallyPortM.length); i++) {
			if (interruptJS.getRawButton(INTERRUPT_BUTTON)) break;
			leftFront.set(sallyPortLF[i]);
			leftBack.set(sallyPortLB[i]);
			rightFront.set(sallyPortRF[i]);
			rightBack.set(sallyPortRB[i]);
			arm.set(sallyPortM[i]);
			Timer.delay(RECORD_LENGTH);
		}
		leftFront.set(0);
		leftBack.set(0);
		rightFront.set(0);
		rightBack.set(0);
		arm.set(0);
	}
	
	/**
	 * Traverses rock wall based on pre-defined path
	 * @param leftFront Front left drivebase motor
	 * @param leftBack Back left drivebase motor
	 * @param rightFront Front right drivebase motor
	 * @param rightBack Back right drivebase motor
	 */
	public static void rockWall(Talon leftFront, Talon leftBack, Talon rightFront, CANTalon rightBack) {
		for (int i = 0; i < Math.min(rockWallLF.length, rockWallRF.length); i++) {
			if (interruptJS.getRawButton(INTERRUPT_BUTTON)) break;
			leftFront.set(rockWallLF[i]);
			leftBack.set(rockWallLB[i]);
			rightFront.set(rockWallRF[i]);
			rightBack.set(rockWallRB[i]);
			Timer.delay(RECORD_LENGTH);
		}
		leftFront.set(0);
		leftBack.set(0);
		rightFront.set(0);
		rightBack.set(0);
	}
	
	/**
	 * Traverses rough terrain based on pre-defined path
	 * @param leftFront Front left drivebase motor
	 * @param leftBack Back left drivebase motor
	 * @param rightFront Front right drivebase motor
	 * @param rightBack Back right drivebase motor
	 */
	public static void roughTerrain(Talon leftFront, Talon leftBack, Talon rightFront, CANTalon rightBack) {
		for (int i = 0; i < Math.min(roughTerrainLF.length, roughTerrainRF.length); i++) {
			if (interruptJS.getRawButton(INTERRUPT_BUTTON)) break;
			leftFront.set(roughTerrainLF[i]);
			leftBack.set(roughTerrainLB[i]);
			rightFront.set(roughTerrainRF[i]);
			rightBack.set(roughTerrainRB[i]);
			Timer.delay(RECORD_LENGTH);
		}
		leftFront.set(0);
		leftBack.set(0);
		rightFront.set(0);
		rightBack.set(0);
	}
	
	/**
	 * Traverses low bar based on pre-defined path
	 * @param leftFront Front left drivebase motor
	 * @param leftBack Back left drivebase motor
	 * @param rightFront Front right drivebase motor
	 * @param rightBack Back right drivebase motor
	 */
	public static void lowBar(Talon leftFront, Talon leftBack, Talon rightFront, CANTalon rightBack, CANTalon arm) {
		for (int i = 0; i < Math.min(lowBarLF.length, lowBarRF.length); i++) {
			if (interruptJS.getRawButton(INTERRUPT_BUTTON)) break;
			leftFront.set(lowBarLF[i]);
			leftBack.set(lowBarLB[i]);
			rightFront.set(lowBarRF[i]);
			rightBack.set(lowBarRB[i]);
			arm.set(lowBarM[i]);
			Timer.delay(RECORD_LENGTH);
		}
		leftFront.set(0);
		leftBack.set(0);
		rightFront.set(0);
		rightBack.set(0);
	}
}

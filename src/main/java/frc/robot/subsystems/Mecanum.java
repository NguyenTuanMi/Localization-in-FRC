// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Mecanum extends SubsystemBase {
  private WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.ROBOT_ID.LF_ID);
  private WPI_TalonSRX leftBack = new WPI_TalonSRX(Constants.ROBOT_ID.LB_ID);
  private WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.ROBOT_ID.RF_ID);
  private WPI_TalonSRX rightBack = new WPI_TalonSRX(Constants.ROBOT_ID.RB_ID);
  
  private MecanumDrive mecanumDrive = new MecanumDrive(leftFront, leftBack, rightFront, rightBack);
  /** Creates a new MecanumDrive. */
  public Mecanum() {
  }

  public void init() {
    leftFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    leftBack.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    rightFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    rightBack.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    leftFront.setNeutralMode(NeutralMode.Brake);
    leftBack.setNeutralMode(NeutralMode.Brake);
    rightFront.setNeutralMode(NeutralMode.Brake);
    rightBack.setNeutralMode(NeutralMode.Brake);

    leftFront.setInverted(true);
    leftBack.setInverted(true);
  }

  public void drive(double x, double y, double rotation) {
    mecanumDrive.driveCartesian(y, x, rotation);
  }

  public double getLeftFrontVelocity() {
    return leftFront.getSelectedSensorVelocity()/1024*10*60*2*Math.PI*60;
  }

  public double getRightFrontVelocity() {
    return rightFront.getSelectedSensorVelocity()/1024*10*60*2*Math.PI*60;
  }

  public double getRightBackVelocity() {
    return rightBack.getSelectedSensorVelocity()/1024*10*60*2*Math.PI*60;
  }

  public double getLeftBackVelocity() {
    return leftBack.getSelectedSensorVelocity()/1024*10*60*2*Math.PI*60;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

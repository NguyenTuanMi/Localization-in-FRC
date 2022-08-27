// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.ROBOT_ID.*;

public class Intake extends SubsystemBase {
  private WPI_TalonSRX intake = new WPI_TalonSRX(INTAKE_ID);
  public Intake() {
  }

  public void init() {
    intake.setNeutralMode(NeutralMode.Brake);
    intake.setInverted(true);
  }

  public void suck(double suck) {
    intake.set(suck);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

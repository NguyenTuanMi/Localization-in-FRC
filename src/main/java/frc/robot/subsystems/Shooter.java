// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.ROBOT_ID.*;

public class Shooter extends SubsystemBase {
  private WPI_TalonSRX shooter = new WPI_TalonSRX(SHOOTER_ID);

  public Shooter() {
  }

  public void init() {
    shooter.setNeutralMode(NeutralMode.Brake);
    shooter.setInverted(true);
  }

  public void shoot(double speed) {
    shooter.set(speed);
  }

  @Override
  public void periodic() {
    
  }
}

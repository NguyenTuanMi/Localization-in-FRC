// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import static frc.robot.Constants.ROBOT_ID.*;

public class Loader extends SubsystemBase {
  /** Creates a new Loader. */
  //private WPI_TalonSRX loader;
  private VictorSPX loader;
  public Loader() {
    //loader = new WPI_TalonSRX(LOADER_ID);
    loader = new VictorSPX(LOADER_ID);
  }

  public void init() {
    // loader.setNeutralMode(NeutralMode.Brake);
    // loader.setInverted(false);
    loader.setNeutralMode(NeutralMode.Brake);
    loader.setInverted(false);
  }

  public void load(double speed) {
    loader.set(VictorSPXControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

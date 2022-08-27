// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Gyro extends SubsystemBase {
  private AHRS ahrs = new AHRS();
  /** Creates a new ExampleSubsystem. */
  public Gyro() {
  }

  public void init() {
    ahrs.zeroYaw();
  }

  public float getYaw() {
    return ahrs.getYaw();
  }

  public float getAccelX() {
    return ahrs.getWorldLinearAccelX();
  }

  public float getAccelY() {
    return ahrs.getWorldLinearAccelY();
  }

  public Rotation2d getRotationYaw() {
    return new Rotation2d(getYaw());
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Yaw value", getYaw());
    SmartDashboard.putNumber("Accel X", getAccelX());
    SmartDashboard.putNumber("Accel y", getAccelY());
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

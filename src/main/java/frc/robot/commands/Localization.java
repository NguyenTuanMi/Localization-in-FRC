// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gyro;
import frc.robot.subsystems.Mecanum;
import frc.robot.subsystems.Odometry;

public class Localization extends CommandBase {
  private Mecanum mecanum;
  private Gyro gyro;
  private Odometry odometry = new Odometry();
  private Pose2d position = new Pose2d();
  /** Creates a new Localization. */
  public Localization(Mecanum meca, Gyro imu) {
    mecanum = meca;
    gyro = imu;
    addRequirements(meca);
    addRequirements(imu);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mecanum.init();
    gyro.init();
    while(gyro.isCalibrating()) {
      SmartDashboard.putBoolean("Calibration", true);
    }
    odometry.init(gyro.getRotationYaw());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    odometry.update(mecanum.getLeftFrontVelocity(), mecanum.getRightFrontVelocity(), mecanum.getLeftBackVelocity(), mecanum.getRightBackVelocity(), gyro.getRotationYaw());
    position = odometry.getPosition();
    SmartDashboard.putNumber("X value", position.getX());
    SmartDashboard.putNumber("Y value", position.getY());
    SmartDashboard.putNumber("Heading value", position.getRotation().getRadians());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

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
import edu.wpi.first.wpilibj.Joystick;
public class Localization extends CommandBase {
  private Mecanum mecanum;
  private Gyro gyro;
  private Odometry odometry = new Odometry();
  private Pose2d position = new Pose2d();
  private Joystick joystick;
  
  public Localization(Mecanum meca, Gyro imu, Joystick stick) {
    mecanum = meca;
    gyro = imu;
    joystick = stick;
    addRequirements(meca);
    addRequirements(imu);
  }

  @Override
  public void initialize() {
    mecanum.init();
    gyro.init();
    while(gyro.isCalibrating()) {
      SmartDashboard.putBoolean("Calibration", true);
    }
    odometry.init(gyro.getRotationYaw());
  }

  @Override
  public void execute() {
    double x = joystick.getRawAxis(4);
    double y = joystick.getRawAxis(5);
    double rotation = joystick.getRawAxis(0);
    
    mecanum.drive(x, y, rotation);

    odometry.update(mecanum.getLeftFrontVelocity(), 
                    mecanum.getRightFrontVelocity(), 
                    mecanum.getLeftBackVelocity(), 
                    mecanum.getRightBackVelocity(), 
                    gyro.getRotationYaw());
    position = odometry.getPosition();
    SmartDashboard.putNumber("X value", position.getX());
    SmartDashboard.putNumber("Y value", position.getY());
    SmartDashboard.putNumber("Heading value", position.getRotation().getRadians());

    SmartDashboard.putNumber("Joystick x value", x);
    SmartDashboard.putNumber("Joystick y value", y);
  }

  @Override
  public void end(boolean interrupted) {
    mecanum.drive(0, 0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.VISION.*;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight extends SubsystemBase {
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry area = table.getEntry("ta");
  private NetworkTableEntry driverMode = table.getEntry("camMode");

  /** Creates a new Limelight. */
  public Limelight() {
  }

  public double getX() {
    return tx.getDouble(0);
  }

  public double getY() {
    return ty.getDouble(0);
  }

  public double getArea() {
    return area.getDouble(0);
  }

  public double getEstimateDistance() {
    double angle = getY() + MOUNTING_ANGLE; // Calculate angle
    angle = angle*Math.PI/180; // Convert degrees to radians 
    double dH = HOOD_HEIGHT - LIMELIGHT_HEIGHT;
    return dH/Math.atan(angle);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("LimelighX", getX());
    SmartDashboard.putNumber("LimelightY", getY());
    SmartDashboard.putNumber("Limelight Area", getArea());
    SmartDashboard.putNumber("Limelight distance", getEstimateDistance());
    driverMode.setDouble(1);
    // This method will be called once per scheduler run
  }
}

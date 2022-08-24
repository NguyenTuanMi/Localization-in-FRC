// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Mecanum;

import static frc.robot.Constants.VISION.*;

public class RotateToAngle extends CommandBase {
  private Mecanum mecanum;
  private Limelight limelight;
  private PIDController controller;
  private PIDController dController;

  public RotateToAngle(Mecanum meca, Limelight cam) {
    mecanum = meca;
    limelight = cam;
    controller = new PIDController(KP, KI, KD);
    dController = new PIDController(D_KP, D_KI, D_KD);

    controller.setIntegratorRange(-27/360, 27/360);
    controller.setTolerance(0.02);

    dController.setIntegratorRange(0, 1);
    dController.setTolerance(0.08);
    
    addRequirements(meca);
    addRequirements(cam);
  }

  private boolean atSetpoint() {
    return dController.atSetpoint() && controller.atSetpoint();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double yOutput = 0;
    yOutput = dController.calculate(limelight.getEstimateDistance(), AIMING_DISTANCE);
    double output = controller.calculate(limelight.getX(), 0);
    mecanum.drive(0, yOutput, output);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mecanum.drive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return atSetpoint();
  }
}

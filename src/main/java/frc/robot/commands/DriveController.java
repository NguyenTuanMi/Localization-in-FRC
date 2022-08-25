// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mecanum;

public class DriveController extends CommandBase {
  private XboxController controller;
  private Mecanum mecanum;
  
  public DriveController(Mecanum meca, XboxController xbox) {
    meca.init();
    controller = xbox;
    mecanum = meca;
    addRequirements(meca);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double x = controller.getLeftX()*0.6;
    double y = controller.getLeftY()*0.6;
    double rotation = -controller.getRightX()*0.6;

    mecanum.drive(x, y, rotation);
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

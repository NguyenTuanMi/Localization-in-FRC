// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Mecanum;

public class DriveController extends CommandBase {
  private Joystick joystick;
  private Mecanum mecanum;
  /** Creates a new DriveController. */
  public DriveController(Mecanum meca, Joystick stick) {
    joystick = stick;
    mecanum = meca;
    addRequirements(meca);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double x = joystick.getRawAxis(Constants.CONTROLLER.LEFT_X_AXIS);
    double y = joystick.getRawAxis(Constants.CONTROLLER.LEFT_Y_AXIS);
    double rotation = joystick.getRawAxis(Constants.CONTROLLER.RIGHT_X_AXIS);

    mecanum.drive(x, y, rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mecanum.drive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

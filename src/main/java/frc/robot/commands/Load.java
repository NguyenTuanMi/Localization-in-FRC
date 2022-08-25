// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Loader;

public class Load extends CommandBase {
  private Loader loader;
  private XboxController xboxController;
  
  public Load(Loader load, XboxController xbox) {
    load.init();
    xboxController = xbox;
    loader = load;
    addRequirements(load);
  }

  @Override
  public void initialize() {
    // if (xboxController.getLeftTriggerAxis() != 0) {
    //   loader.load(-Constants.SPEED.LOADER_SPEED);
    // }
  }

  @Override
  public void execute() {
    if (xboxController.getLeftTriggerAxis() != 0) {
      loader.load(Constants.SPEED.LOADER_SPEED);
    }
  }

  @Override
  public void end(boolean interrupted) {
    loader.load(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

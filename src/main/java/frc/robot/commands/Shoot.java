// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {
  private Shooter shoot;
  
  public Shoot(Shooter shooter) {
    shooter.init();
    shoot = shooter;
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
    shoot.shoot(Constants.SPEED.SHOOTER_SPEED);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    shoot.shoot(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

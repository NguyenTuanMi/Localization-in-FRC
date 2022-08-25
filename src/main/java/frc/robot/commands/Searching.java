
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mecanum;

public class Searching extends CommandBase {
  private Mecanum mecanum;
  public Searching(Mecanum meca) {
    mecanum = meca;
    meca.init();
    addRequirements(meca);
  }

  @Override
  public void initialize() {
    mecanum.drive(0, 0, 0.3);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    mecanum.drive(0, 0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

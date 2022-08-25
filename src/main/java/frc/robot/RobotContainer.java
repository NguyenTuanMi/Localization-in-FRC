// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Load;
import frc.robot.commands.AutoAiming;
import frc.robot.commands.Searching;
// import frc.robot.commands.Shoot;
// import frc.robot.commands.Sucker;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Loader;
import frc.robot.subsystems.Mecanum;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveController;
import static frc.robot.Constants.CONTROLLER.*;
/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private Mecanum mecanum = new Mecanum();
  private Shooter shooter = new Shooter();
  private Loader loader = new Loader();
  private Intake intake = new Intake();
  private Limelight limelight = new Limelight();

  private XboxController controller = new XboxController(0);
  // private Command shoot = new Shoot(shooter);
  private Command load = new Load(loader, controller);
  // private Command suck = new Sucker(intake);
  private Command driveController = new DriveController(mecanum, controller);
  private Command rotateToAngle = new AutoAiming(mecanum, limelight);
  private Command seeking = new Searching(mecanum);
  
  public RobotContainer() {
    // mecanum.init();
    intake.init();
    shooter.init();
    // loader.init();

    configureButtonBindings();
    mecanum.setDefaultCommand(driveController);
    loader.setDefaultCommand(load);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // new JoystickButton(controller, Constants.CONTROLLER.RIGHT_BUMPER).whileActiveOnce(shoot);
    // new JoystickButton(controller, Constants.CONTROLLER.B_BUTTON).whileActiveOnce(load);
    // new JoystickButton(controller, Constants.CONTROLLER.LEFT_BUMPER).whileActiveOnce(suck);
    // new JoystickButton(controller, Constants.CONTROLLER.A_BUTTON).whileActiveOnce(rotateToAngle);
    
    new JoystickButton(controller, A_BUTTON).whileActiveOnce(new ConditionalCommand(rotateToAngle, seeking, limelight::seeTarget));
    new JoystickButton(controller, RIGHT_BUMPER).whileActiveOnce(new StartEndCommand(
    () -> shooter.shoot(1),
    () -> shooter.shoot(0),
    shooter)
    );
    new JoystickButton(controller, LEFT_BUMPER).whileActiveOnce(new StartEndCommand(
    () -> intake.suck(0.4),
    () -> intake.suck(0),
    intake)
    );
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}

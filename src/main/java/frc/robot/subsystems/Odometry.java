package frc.robot.subsystems;

import edu.wpi.first.math.kinematics.MecanumDriveOdometry;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Pose2d;
import static frc.robot.Constants.ROBOT_MAPPING.*;

public class Odometry {
    private Pose2d position = new Pose2d();
    private Rotation2d gyroAngle;
    private MecanumDriveKinematics kinematics = new MecanumDriveKinematics(FRONTLEFT, FRONTRIGHT, BACKLEFT, BACKRIGHT);
    private MecanumDriveOdometry odometry;
    
    public Odometry() {
    }

    public void init(Rotation2d yaw) {
        gyroAngle = yaw;
        odometry = new MecanumDriveOdometry(
            kinematics, 
            gyroAngle, 
            new Pose2d(INIT_X, INIT_Y, new Rotation2d(INIT_THETA))
            );
    }

    public void update(double frontLeft, double frontRight, double backLeft, double backRight, Rotation2d yaw) {
        gyroAngle = yaw;
        position = odometry.update(
            gyroAngle, 
            new MecanumDriveWheelSpeeds(frontLeft, frontRight, backLeft, backRight)
            );
    }

    public Pose2d getPosition() {
        return position;
    }
}

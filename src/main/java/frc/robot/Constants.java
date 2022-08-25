// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class ROBOT_MAPPING {
        public static final double INIT_X = 0;
        public static final double INIT_Y = 0;
        public static final double INIT_THETA = Math.PI/2;
        
        public static final double LBCENTER = 120;
        public static final double RBCENTER = 120;
        public static final double LFCENTER = 120;
        public static final double RFCENTER = 120;
        
        public static final double LBORIENT = 100;
        public static final double RBORIENT = 100;
        public static final double LFORIENT = 100;
        public static final double RFORIENT = 100;
        
        public static final Translation2d FRONTLEFT = new Translation2d(LFCENTER, new Rotation2d(LFORIENT));
        public static final Translation2d BACKLEFT = new Translation2d(LBCENTER, new Rotation2d(LBORIENT));
        public static final Translation2d FRONTRIGHT = new Translation2d(RFCENTER, new Rotation2d(RFORIENT));
        public static final Translation2d BACKRIGHT = new Translation2d(RBCENTER, new Rotation2d(RBORIENT));
    }

    public static final class ROBOT_ID {
        public static final int LF_ID = 3;
        public static final int LB_ID = 4;
        public static final int RF_ID = 1;
        public static final int RB_ID = 7;

        public static final int SHOOTER_ID = 6;
        public static final int LOADER_ID = 9;
        public static final int INTAKE_ID = 11;
    }

    public static final class CONTROLLER {
        public static final int A_BUTTON = 1;
        public static final int B_BUTTON = 2;
        public static final int X_BUTTON = 3;
        public static final int Y_BUTTON = 4;
        public static final int LEFT_BUMPER = 5;
        public static final int RIGHT_BUMPER = 6;
        public static final int BACK_BUTTON = 7;
        public static final int START_BUTTON = 8;

    }

    public static final class SPEED {
        public static final double LOADER_SPEED = 0.6;
        public static final double INTAKE_SPEED = 0.4;
        public static final double SHOOTER_SPEED = 1;
    }

    public static final class VISION {
        public static final double MOUNTING_ANGLE = 30;
        public static final double LIMELIGHT_HEIGHT = 2;
        public static final double HOOD_HEIGHT = 2.64;

        public static final double KP = 0.8;
        public static final double KI = 0;
        public static final double KD = 0;

        public static final double D_KP = 0.8;
        public static final double D_KI = 0;
        public static final double D_KD = 0;

        public static final double AIMING_DISTANCE = 2.5;
    }
}

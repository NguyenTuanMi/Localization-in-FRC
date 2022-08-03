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
}

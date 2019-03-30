/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
    //drivebase
    public static final double WHEEL_DIAMETER = 6;//inches
    public static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER*Math.PI;
    public static final double INCHES_PER_COUNT = WHEEL_CIRCUMFERENCE / MConstants.kRotCounts;
    public static final double COUNTS_PER_100MS_TO_INCHES_PER_SEC = INCHES_PER_COUNT * 10;//100ms is 1/10th of 1 second
    //
    public static double frontLimeHeight=38.5;//all inches
    public static double backLimeHeight=0;
    public static double frontLimeAngle=5;
    public static double backLimeAngle=0;
    public static double tapeHeight=28.5;
    public static double tapeDistanceFlat=0;
}

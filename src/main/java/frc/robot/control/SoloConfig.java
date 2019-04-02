package frc.robot.control;

import frc.robot.control.controlCommands.*;

public class SoloConfig extends ControllerConfig{
    
    public void assign(XboxJoystick controller){
        conditions = new XboxButton[]{controller.leftBumper};//control lift when pressing these
        controller.rightBumper.whenActive(new RumbleEvent(controller, 1), conditions, false);
    }
}
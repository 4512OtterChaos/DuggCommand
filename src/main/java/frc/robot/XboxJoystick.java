package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboxJoystick extends Joystick {

    //XboxController does not have command functionality, so we imitate it as a Joystick.
    public XboxJoystick(final int port){
        super(port);
    }

    //we want these objects because they have a lot of handles for command based things!
    public JoystickButton xButton = new JoystickButton(this, 3);
	public JoystickButton yButton = new JoystickButton(this, 4);
	public JoystickButton aButton = new JoystickButton(this, 1);
	public JoystickButton bButton = new JoystickButton(this, 2);
	public JoystickButton rightBumper = new JoystickButton(this, 6);
	public JoystickButton leftBumper = new JoystickButton(this, 5);
	public JoystickButton startButton = new JoystickButton(this, 8);
	public JoystickButton selectButton = new JoystickButton(this, 7);
	public JoystickButton leftStickButton = new JoystickButton(this, 9);
    public JoystickButton rightStickButton = new JoystickButton(this, 10);
    
    public double getLeftX(){
		return this.getRawAxis(0);
	}
	public double getLeftY(){
		return -this.getRawAxis(1);
	}
	public double getRightX(){
		return this.getRawAxis(4);
	}
	public double getRightY(){
		return -this.getRawAxis(5);
    }
    public double getLeftTrigger(){
        return this.getRawAxis(3);
    }
    public double getRightTrigger(){
        return this.getRawAxis(2);
    }
}
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

public class XboxButton extends Button {
    private final GenericHID m_joystick;
    private final int m_buttonNum;
  
    /**
     * Create a joystick button for triggering commands.
     *
     * @param joystick     The GenericHID object that has the button (e.g. Joystick, KinectStick,
     *                     etc)
     * @param buttonNumber The button number (see {@link GenericHID#getRawButton(int) }
     */
    public XboxButton(GenericHID joystick, int buttonNum) {
        m_joystick = joystick;
        m_buttonNum = buttonNum;
    }
  
    /**
     * Gets the value of the joystick button(s).
     *
     * @return The value of the joystick button(s)
     */
    @Override
    public boolean get() {
        return m_joystick.getRawButton(m_buttonNum);
    }

    public int getNum(){
        return m_buttonNum;
    }

    public void whenActive(final Command command, final XboxButton other, final boolean blocks){
        new ButtonScheduler() {
            private boolean m_pressedLast = get() && (other.get()==!blocks);
      
            @Override
            public void execute() {
              boolean pressed = get() && (other.get()==!blocks);
      
              if (!m_pressedLast && pressed) {
                command.start();
              }
      
              m_pressedLast = pressed;
            }
          }.start();
    }
    public void whileActive(final Command command, final XboxButton other, final boolean blocks) {
        new ButtonScheduler() {
          private boolean m_pressedLast = get() && (other.get()==!blocks);
    
          @Override
          public void execute() {
            boolean pressed = get() && (other.get()==!blocks);
    
            if (pressed) {
              command.start();
            } else if (m_pressedLast && !pressed) {
              command.cancel();
            }
    
            m_pressedLast = pressed;
          }
        }.start();
    }
    public void whenInactive(final Command command, final XboxButton other, final boolean blocks) {
        new ButtonScheduler() {
          private boolean m_pressedLast = get() && (other.get()==!blocks);
    
          @Override
          public void execute() {
            boolean pressed = get() && (other.get()==!blocks);
    
            if (m_pressedLast && !pressed) {
              command.start();
            }
    
            m_pressedLast = pressed;
          }
        }.start();
    }
    public void toggleWhenActive(final Command command, final XboxButton other, final boolean blocks) {
        new ButtonScheduler() {
          private boolean m_pressedLast = get() && (other.get()==!blocks);
    
          @Override
          public void execute() {
            boolean pressed = get() && (other.get()==!blocks);
    
            if (!m_pressedLast && pressed) {
              if (command.isRunning()) {
                command.cancel();
              } else {
                command.start();
              }
            }
    
            m_pressedLast = pressed;
          }
        }.start();
    }
    public void cancelWhenActive(final Command command, final XboxButton other, final boolean blocks) {
        new ButtonScheduler() {
          private boolean m_pressedLast = get() && (other.get()==!blocks);
    
          @Override
          public void execute() {
            boolean pressed = get() && (other.get()==!blocks);
    
            if (!m_pressedLast && pressed) {
              command.cancel();
            }
    
            m_pressedLast = pressed;
          }
        }.start();
      }
}
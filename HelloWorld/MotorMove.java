import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.LCD;

public class MotorMove
{
    public static void main(String[] args)
    {
        LCD.drawString("Program 1", 0,0);
        Button.waitForAnyPress();
        Motor.B.setSpeed(720);
        Motor.B.forward();
        Button.waitForAnyPress();
        LCD.drawString("Forward",0,0);
        Button.waitForAnyPress();
        Motor.B.backward();
        LCD.drawString("BACKWARD",0,0);
        Button.waitForAnyPress();
        Motor.B.stop();
    }
}
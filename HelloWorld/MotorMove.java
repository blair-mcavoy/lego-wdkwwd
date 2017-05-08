import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.LCD;

public class MotorMove
{
    public static void main(String[] args)
    {
        LCD.drawString("Program 1", 0,0);
        Button.waitForAnyPress();
        Motor.A.forward();
    }
}
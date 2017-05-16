import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.Motor;
import lejos.nxt.Button;

public class TouchTest {
  public static void main(String[] args) throws Exception {
    TouchSensor touch = new TouchSensor(SensorPort.S4);
    while (!touch.isPressed()) {
    	Motor.B.backward();
    	Motor.C.backward();
    }
    Motor.B.stop();
    Motor.C.stop();
    LCD.drawString("Finished", 3, 4);
    Button.waitForAnyPress();
  }
}
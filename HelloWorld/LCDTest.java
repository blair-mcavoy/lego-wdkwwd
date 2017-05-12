

import lejos.nxt.LCD;

public class LCDTest {
  public static void main(String[] args) throws Exception {
    LCD.drawString("Free RAM:", 0, 0);
    LCD.drawInt((int) System.getRuntime().freeMemory(), 6, 9, 0);
    Thread.sleep(2000);
  }
}
import lejos.nxt.*;

/**
 * Write a description of            class LightSensor here.
 * 
 * @author (your name) 
 * @vers            ion (a version number or a date)
 */
public class LSensor implements SensorPortListener
{
    public static void main(String[] args) throws Exception {
        LightSensor light = new LightSensor(SensorPort.S2);
        SensorPort.S2.addListerner(
        while (true) {
            LCD.drawInt(light.getLightValue(), 4, 0, 0);
            LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
            LCD.drawInt(SensorPort.S2.readRawValue(), 4, 0, 2);
            LCD.drawInt(SensorPort.S2.readValue(), 4, 0, 3);
        }
        Button.waitForAnyPress();
    }

    public void stateChanged(SensorPort aSource,int aOldValue,int aNewValue)  
    {
       
            
    }
}


import lejos.nxt.*;

/**
 * Write a description of            class LightSensor here.
 * 
 * @author (your name) 
 * @vers            ion (a version number or a date)
 */
public class LSensor implements SensorPortListener
{
    public static void main(String[] args) throws Exception 
    {
        Motor.B.forward();
        Motor.C.forward();
        LSensor ls = new LSensor();
        SensorPort.S2.addSensorPortListener(ls);
        Button.waitForAnyPress();
    }

    public void stateChanged(SensorPort aSource,int aOldValue,int aNewValue)  
    {
        LightSensor light = new LightSensor(SensorPort.S2);
        LCD.drawInt(light.getLightValue(), 4, 0, 0);
        LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
        LCD.drawInt(SensorPort.S2.readValue(), 4, 0, 3);
      
        if( light.getLightValue() < 35)
        {
            Motor.B.stop();
            Motor.C.stop();

        }
    }
}


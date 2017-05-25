import lejos.nxt.*;
import lejos.robotics.objectdetection.*;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Write a description of class ObstacleCourse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleCourse implements SensorPortListener, FeatureListener
{
    DifferentialPilot pilot ;
    private boolean isPressed;
    private int count;
    private int angle;
    public ObstacleCourse ()
    {
        angle = 45;
        count = 1;
        isPressed = false;
        pilot = new DifferentialPilot(2.25f, 5.5f, Motor.B, Motor.C);
        pilot.forward();
    }

    public static void main(String[] args)
    {

        ObstacleCourse c = new ObstacleCourse();

        SensorPort.S2.addSensorPortListener(c);
        SensorPort.S3.addSensorPortListener(c);

        UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
        RangeFeatureDetector fd = new RangeFeatureDetector(us, 80, 500);

        fd.addListener(c);

        Button.waitForAnyPress();

    }

    public void stateChanged(SensorPort aSource,int aOldValue,int aNewValue)  
    {
        if (aSource == SensorPort.S2)
        {
            LightSensor light = new LightSensor(SensorPort.S2);
            LCD.drawInt(light.getLightValue(), 4, 0, 0);
            LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
            LCD.drawInt(SensorPort.S2.readValue(), 4, 0, 3);

            if( light.getLightValue() < 35)
            {
                pilot.travel(-10);
                pilot.rotate(angle);
              
                pilot.forward();
              
                if(angle<315)
                {
                    angle += 45;
                }
                else
                {
                    angle = 45;
                }
            
            }
        }
        else if (aSource == SensorPort.S3)
        {   TouchSensor touch = new TouchSensor(SensorPort.S3);
            if (touch.isPressed())
            {
                isPressed = true;
                pilot.travel(-5);
                pilot.rotate(90);
                pilot.forward(); 
                
            } 
                isPressed = false;
        }
    }

    public void featureDetected(Feature feature, FeatureDetector detector) {
        if (isPressed == false)
        {
            pilot.stop();
           
            int range = (int)feature.getRangeReading().getRange();
            int angle = (int)feature.getRangeReading().getAngle();
             LCD.drawInt(range,0,5);
            pilot.rotate(angle);
            pilot.travel(range);
        }
    }
}

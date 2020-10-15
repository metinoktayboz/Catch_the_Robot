package pi;
/* Code by Adem, Metin */
 
import lejos.hardware.motor.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;
import lejos.hardware.Button;

public class pi {
	public static void main(String[] args) {
		//System.out.println("Catch The Robot Thesis");
		System.out.println("Represented By");
		System.out.println("Adem Savas");
		System.out.println("Metin Oktay Boz");
		System.out.println("Emirhan Erturan");
		System.out.println("Hilal Demir");
		System.out.println("Press Any Buttom to Continue...");
		 PIController pi = new PIController() ;
		int i=0;
		
		Button.waitForAnyPress();
		while (i<2000) {
			if (Button.ESCAPE.isDown())
				break;
			
			 pi.run();
			i++;
		}
		
	}
}

class PIController {
	final float TARGET = Robot.COLOUR_VALUES[2];
	final float P_CONTROL = 970;
	final float I_CONTROL = 30;
	final float BASE_SPEED = 200; 
	float leftSpeed, rightSpeed; 
	float sensorData;
	float integral = 0; 
	
	int counter = 0; 
	
	public void run() {
		
		sensorData = Robot.pollSensor(true);
		float a;
		/*if(sensorData>=0.54f&&sensorData<=0.58f) {
			a=0.55f;
		}
		else {
			a=sensorData;
		}*/
		float err = TARGET - sensorData;
		 
		//integral *= 0.90;  
		integral += err; 
		if(integral >3) {
			integral = 0;
		}
		 //System.out.print(P_CONTROL * err + I_CONTROL * integral + " ");
		 rightSpeed = BASE_SPEED + P_CONTROL * err + I_CONTROL * integral;
		 leftSpeed = BASE_SPEED - (P_CONTROL * err + I_CONTROL * integral);
		//System.out.println(integral);
		 System.out.print(sensorData + " ");
		Robot.drive(leftSpeed, rightSpeed);
	}
}

class Robot {
	public static EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S2);
	public static float[] COLOUR_VALUES = { 0.102f, 0.160f, 0.55f, 0.507f, 0.582f }; 
	// most black to most white 
								
	public static void drive(float l, float r) {
		// B-> to left C-> to right

		Motor.B.setSpeed(Math.abs(l));
		Motor.C.setSpeed(Math.abs(r));
		if (l > 0) {
			Motor.B.forward();
		} else if (l < 0) {
			Motor.B.backward();
		} else {
			Motor.B.stop(true);
		}

		if (r > 0) {
			Motor.C.forward();
		} else if (r < 0) {
			Motor.C.backward();
		} else {
			Motor.C.stop(true);
		}
	}

	public static float pollSensor(boolean log) {
		int sampleSize = sensor.sampleSize();
		float[] redsample = new float[sampleSize];
		sensor.getRedMode().fetchSample(redsample, 0);
		if (log) {
			//System.out.print("sensor: ");
			//System.out.print(redsample[0]+" ");
		}
		return redsample[0];
	}
}
package distance;

import lejos.hardware.Brick;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;
import lejos.hardware.Brick;
public class wall {
	DifferentialPilot pilot;
	ultrasonic ultrasonic;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new wall();
	}
	public wall() {
		pilot=new DifferentialPilot(1.5f,6,Motor.B,Motor.C);
		Brick b = BrickFinder.getDefault();
		Port s3=b.getPort("S3");
		EV3UltrasonicSensor us=new EV3UltrasonicSensor(s3);
		ultrasonic=new ultrasonic(us.getMode("Distance"));
		float pi;
        float integral=0f; 
    while(true) {
	    float err=ultrasonic.distance()-0.15f;
	    integral+=err;
	    pi=err*6900f+integral*0.279f;
		if(err>0) {
			Motor.B.setSpeed(pi);
			Motor.C.setSpeed(pi);
			Motor.B.forward();
			Motor.C.forward();
		}
		else if(err<0) {
			Motor.B.setSpeed(pi);
			Motor.C.setSpeed(pi);
			Motor.B.backward();
			Motor.C.backward();
		}
	System.out.println(err);
    }
    } 
}

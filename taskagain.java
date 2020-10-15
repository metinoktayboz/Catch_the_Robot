package adem;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;
public class taskagain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		int ii;
		float kp=0.069f;							//Kp VALUE THAT FIND IN PI TUNER TOOLS
		float ki=0.279f;							//Ki VALUE THAT FIND IN PI TUNER TOOLS
		int integral=0;
	    float pi=0;
		int error=0;
		int a=0;
		for(ii=0;ii<2;ii++) {
			for(i=0;i<150;i++) {
				error=600-Motor.B.getRotationSpeed();//ERROR=INPUT-OUTPUT
		    	integral+=error;					 //INTEGRATOR
		    	pi=kp*error+ki*integral;			 //PI CONTROLLER
		    	Motor.B.setSpeed(pi);				 //SET SPPED AS PI KONTROLLER
				if(pi>0)							 //IF PI POSITIVE MOTOR GO FORWARD
					Motor.B.forward();				 
				else if(pi==0)						 //IF PI EQUALS ZERO MOTOR STOP
					Motor.B.stop();
				else
					Motor.B.backward();				 //IF PI NEGATÝVE MOTOR GO BACKWARD
		System.out.println(Motor.B.getRotationSpeed());
			}
			for(i=0;i<150;i++) {
				error=0-Motor.B.getRotationSpeed();
		    	integral+=error;
		    	pi=kp*error+ki*integral;
				Motor.B.setSpeed(pi);
				if(pi>0)
					Motor.B.forward();
				else if(pi==0)
					Motor.B.stop();
				else
					Motor.B.backward();
		System.out.println(Motor.B.getRotationSpeed());
			}
			for(i=0;i<150;i++) {
				error=-600-Motor.B.getRotationSpeed();
		    	integral+=error;
		    	pi=kp*error+ki*integral;
				Motor.B.setSpeed(pi);
				if(pi>0)
					Motor.B.forward();
				else if(pi==0)
					Motor.B.stop();
				else
					Motor.B.backward();
			System.out.println(Motor.B.getRotationSpeed());
			}
			for(i=0;i<150;i++) {
				error=0-Motor.B.getRotationSpeed();
		    	integral+=error;
		    	pi=kp*error+ki*integral;
				Motor.B.setSpeed(pi);
				if(pi>0)
					Motor.B.forward();
				else if(pi==0)
					Motor.B.stop();
				else
					Motor.B.backward();
			System.out.println(Motor.B.getRotationSpeed());
			}
		}
	}
				
				
				
	
				/*else if(i<400) {
					mob.stop();
					
					
					
					i++;
				}
				else if(i<600) {
					mob.driveback();
				
					i++;
				}
				else if(i<800) {
					mob.stop();
					
					i++;
				}
				else if(i<1000) {
					mob.drive();
			
					i++;
						}
						else if(i<1200) {
							mob.stop();
							
							i++;
						}
						else if(i<1400) {
							mob.driveback();
							
							i++;
						}
						else if(i<1600) {
							mob.stop();
						
							i++;
						}
						else if(i<1800) {
							mob.drive();
							
							i++;
						}
						else if(i<2000) {
							mob.stop();
							
							i++;
						}*/
			}
			
			
	


class Robot {
	//public static EV3ColorSensor sensor = new EV3ColorSensor(SensorPort.S2);
	//public static float[] COLOUR_VALUES = { 0.102f, 0.160f, 0.55f, 0.507f, 0.582f }; 
	// most black to most white 
		
	//float kp=0.1832f;
	//float ki=0.2744f;
	//int integral=0;
	//float c=2800f;
	float i=0;
	//float pi=0;
	//int error=0;
	public void drive() {
		
		
        int target=600;
        long time=0; 
        long start=System.currentTimeMillis();
        long end=0;
       while(end-start<=10) {
        
    	    //error=target-Motor.B.getRotationSpeed();
    	    //integral+=error;
    	    //if(integral<-c||integral>c)
    	    //	integral=0;
    	  // pi=kp*error+ki*integral;
    	   
		Motor.B.setSpeed(target);
		Motor.C.setSpeed(target);
		/*if(pi>=0) {
			Motor.B.forward();
			Motor.C.forward();
		}
		
		else {
		Motor.B.backward();
		Motor.C.backward();
		}*/
		
		
		end=System.currentTimeMillis();
		time=end-start;
		
		
       }
       
       
     
        
      
      //i++;
       System.out.println(Motor.B.getRotationSpeed());
		
		
		
		
		
		
		
	}
	/*public void driveback() {
		
	
        int target=-600;
       
        
        long time=0; 
        long start=System.currentTimeMillis();
        long end=0;
          while(time<=10) {
            error=target-Motor.B.getRotationSpeed();
           
           integral+=error;
           if(integral<-c||integral>c)
   	    	integral=0;
            pi=kp*error+ki*integral;


   		Motor.B.setSpeed(pi);
   		Motor.C.setSpeed(pi);
   		if(pi>=0) {
   			Motor.B.forward();
   			Motor.C.forward();
   		}
   		
   		
   		else {
   		Motor.B.backward();
   		Motor.C.backward();
   		}
   		end=System.currentTimeMillis();
   		time=end-start;
   		
   	
          }
        
         i++;
         System.out.print(Motor.B.getRotationSpeed() + " ");
		
		
		
		
		
		
	}
	public void stop() {
		
		
        int target=0;
        
        
        long time=0; 
        long start=System.currentTimeMillis();
        long end=0;
          while(time<=10) {
            error=target-Motor.B.getRotationSpeed();
           
           integral+=error;
           if(integral<-c||integral>c)
   	    	integral=0;
            pi=kp*error+ki*integral;
           
   		Motor.B.setSpeed(pi);
   		Motor.C.setSpeed(pi);
   		if(pi>=0) {
   			Motor.B.forward();
   			Motor.C.forward();
   		}
   		
   		else {
   		Motor.B.backward();
   		Motor.C.backward();
   		}
   		end=System.currentTimeMillis();
   		time=end-start;
   		
   		
          }
        
         i++;
         System.out.print(Motor.B.getRotationSpeed() + " ");
		
		
		
		
		
		
	}
    public static void measure() {
    	System.out.println(Motor.A.getSpeed() + ", "  + Motor.B.getSpeed());
    	Delay.msDelay(100);
    }*/
}



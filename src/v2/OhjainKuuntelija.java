package v2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import ch.aplu.xboxcontroller.XboxControllerAdapter;


public class OhjainKuuntelija extends XboxControllerAdapter{

	RegulatedMotor ma;
	RegulatedMotor mb;
	
	public OhjainKuuntelija(){
		RegulatedMotor ma = new EV3LargeRegulatedMotor(MotorPort.A);
		RegulatedMotor mb = new EV3LargeRegulatedMotor(MotorPort.B);
	}
	
	public void leftShoulder(boolean tosi){
		
			ma.forward();
			mb.backward();
		
		
	}
	
	public void rightShoulder(boolean tosi){
		
		mb.forward();
		ma.backward();
		
		
	}
	
	
	
}

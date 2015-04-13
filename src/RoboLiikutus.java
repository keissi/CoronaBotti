import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;


public class RoboLiikutus {

	
	public static void main(String[] args) throws IOException{
	
			//Moottorit
			RegulatedMotor ma = new EV3LargeRegulatedMotor(MotorPort.A);
			RegulatedMotor mb = new EV3LargeRegulatedMotor(MotorPort.B);
		
		
			//Yhteyden muodostus
			ServerSocket serv = new ServerSocket(1111);
			Socket s = null;
			s = serv.accept();
			DataInputStream in = new DataInputStream(s.getInputStream());	
			boolean käynnissä = true;
			int i;
			while(käynnissä){
				i = in.readInt();
				if(i == 1){
					ma.forward();
					mb.backward();
					
				}
				if(i == 2){
					ma.backward();
					mb.backward();
				}
				
			}
			
	}
			
			
}

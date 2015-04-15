import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;


public class RoboLiikutus {

	
	public static void main(String[] args) throws IOException{
			int speed = 100;
			//Moottorit
			EV3LargeRegulatedMotor ma = new EV3LargeRegulatedMotor(MotorPort.A);
			EV3LargeRegulatedMotor mb = new EV3LargeRegulatedMotor(MotorPort.B);
			EV3LargeRegulatedMotor mc = new EV3LargeRegulatedMotor(MotorPort.C);
			EV3LargeRegulatedMotor md = new EV3LargeRegulatedMotor(MotorPort.D);
			//mb.setSpeed(speed);
			//ma.setSpeed(speed);
			mc.setSpeed(25);
			//Yhteyden muodostus
			ServerSocket serv = new ServerSocket(1111);
			Socket s = null;
			s = serv.accept();
			DataInputStream in = new DataInputStream(s.getInputStream());	
			boolean käynnissä = true;
			int i = 0;
			while(käynnissä){
				i = in.readInt();
				if(i == 1){
					ma.forward();
					mb.backward();
					//Delay.msDelay(500);
					
					
				}
				if(i == 0){
					ma.backward();
					mb.forward();
					//Delay.msDelay(500);
					
				}
				
				if(i == 2){
					mc.forward();
				}
				if(i == 3){
					mc.backward();
				}
				if(i == -1){
				
				ma.stop();
				mb.stop();
				mc.stop();
				md.stop();
				}
				}
			
			}
			
	}
			
			


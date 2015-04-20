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
			boolean k�ynniss� = true;
			int i = 0;
			Renkaat renkaat = new Renkaat(ma, mb);
			Kurki kurki = new Kurki(mc);
			Ly�ntik�si k�si = new Ly�ntik�si(md);
			renkaat.setNopeus(100);
			
			while(k�ynniss�){
				i = in.readInt();
				if(i == 0){
					renkaat.liikuVasemmalle();
					//Delay.msDelay(500);
					
				}
				if(i == 1){
					renkaat.liikuOikealle();
					//Delay.msDelay(500);	
				}
				if(i == 2){
					kurki.k��nn�Oikealle();
				}
				if(i == 3){
					kurki.k��nn�Vasemmalle();
				}
				if(i == 4){					
					k�si.ly�();
					
				}
				if(i == 5){
					k�si.vaihdaNopeus();
				}
				if(i == -1){
				
				renkaat.seis();
				kurki.seis();
//				md.stop();
				}
				}
			
			}
			
	}
			
			


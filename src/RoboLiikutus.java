import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;


public class RoboLiikutus {

	
	public static void main(String[] args) throws IOException{
			//Moottorit
			EV3LargeRegulatedMotor ma = new EV3LargeRegulatedMotor(MotorPort.A);
			EV3LargeRegulatedMotor mb = new EV3LargeRegulatedMotor(MotorPort.B);
			EV3MediumRegulatedMotor mc = new EV3MediumRegulatedMotor(MotorPort.C);
			EV3LargeRegulatedMotor md = new EV3LargeRegulatedMotor(MotorPort.D);
			//mb.setSpeed(speed);
			//ma.setSpeed(speed);
			mc.setSpeed(25);
			//Yhteyden muodostus
			ServerSocket serv = new ServerSocket(1111);
			Socket s = null;
			s = serv.accept();
			System.out.println("Yhteys muodostettu");
			Delay.msDelay(2000);
			DataInputStream in = new DataInputStream(s.getInputStream());	
			boolean käynnissä = true;
			int i = 0;
			Renkaat renkaat = new Renkaat(ma, mb);
			Kurki kurki = new Kurki(mc);
			Lyöntikäsi käsi = new Lyöntikäsi(mc);
			renkaat.setNopeus(100);
			
			while(käynnissä){
				i = in.readInt();
				if(i == 3){
					renkaat.liikuVasemmalle();
					//Delay.msDelay(500);
					
				}
				if(i == 2){
					renkaat.liikuOikealle();
					//Delay.msDelay(500);	
				}
				if(i == 0){
					kurki.käännäOikealle();
				}
				if(i == 1){
					kurki.käännäVasemmalle();
				}
				if(i == 4){					
					käsi.lyö();
					
				}
				if(i == 5){
					käsi.vaihdaNopeus();
				}
				if(i == -1){
				
				renkaat.seis();
				kurki.seis();
//				md.stop();
				}
				if(i == 100){
					käynnissä = false;
				}
				}
			
			}
			
	}
			
			


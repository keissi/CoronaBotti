import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class RoboLiikutus {

	
	
	public static void main(String[] args) throws IOException{
			//Moottorit
			EV3LargeRegulatedMotor ma = new EV3LargeRegulatedMotor(MotorPort.A);
			EV3LargeRegulatedMotor mb = new EV3LargeRegulatedMotor(MotorPort.B);
			EV3LargeRegulatedMotor mc = new EV3LargeRegulatedMotor(MotorPort.C);
			//EV3MediumRegulatedMotor mc = new EV3MediumRegulatedMotor(MotorPort.C);
			EV3LargeRegulatedMotor md = new EV3LargeRegulatedMotor(MotorPort.D);
			//mb.setSpeed(speed);
			//ma.setSpeed(speed);
			Port colorPort = LocalEV3.get().getPort("S1");
			@SuppressWarnings("resource")
			SampleProvider colorProvider = ((EV3ColorSensor)new EV3ColorSensor(colorPort)).getRGBMode();
			Väritunnistus väri = new Väritunnistus(colorProvider);
			mc.setSpeed(25);
			//Yhteyden muodostus
			ServerSocket serv = new ServerSocket(1111);
			Socket s = null;
			s = serv.accept();
			System.out.println("Yhteys muodostettu");
			Delay.msDelay(2000);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			boolean käynnissä = true;
			int i = 0;
			Renkaat renkaat = new Renkaat(ma, mb);
			Kurki kurki = new Kurki(mc);
			Lyöntikäsi käsi = new Lyöntikäsi(md);
			Demo demo = new Demo(väri, käsi, renkaat, in);
			renkaat.setNopeus(100);
			kurki.setNopeus(20);
			while(käynnissä){
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
					kurki.käännäOikealle();
				}
				if(i == 3){
					kurki.käännäVasemmalle();
				}
				if(i == 4){					
					käsi.lyö();
					
				}
				if(i == 5){
					käsi.vaihdaNopeus();
					out.writeInt(käsi.palautaNopeus());
				}
				if(i == 6){
					demo.ajaDemoa();
				}

				
				if(i == -1){
				System.out.println(renkaat.tachoLaskuri());
				renkaat.seis();
				kurki.seis();
				käsi.seis();
				}
				if(i == 100){
					käynnissä = false;
				}
				i=-2;
				}
	}
}
			
			
			
	
			
			




import java.awt.Toolkit;

import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Lyöntikäsi {
	RegulatedMotor käsi;
	int nopeus[] = new int[2];
	int valinta = 0;
	Toolkit toolkit;
	boolean lyön = false;
	
	
	public Lyöntikäsi(RegulatedMotor käsi) {
		this.käsi = käsi;
		int x=300;
		for (int i = 0; i < nopeus.length ; i++){
			nopeus[i] = x;
			x+=600;
		}
		
	}

	

	public void vaihdaNopeus() {
		if(valinta < (nopeus.length-1)){
			valinta++;
		}
		else valinta=0;
		System.out.println("Speed: " + nopeus[valinta]);
	}

	public void oletusasentoon() {
		Delay.msDelay(1000);
		käsi.setSpeed(100);
		käsi.rotateTo(0);
		käsi.setSpeed(palautaNopeus());
	}

	public void lyö() {
		lyön = true;
		käsi.setSpeed(palautaNopeus());
		käsi.rotate(120);
		 oletusasentoon();
		 lyön = false;
		
	}
	
	public int palautaNopeus(){
		return nopeus[valinta];
	}

	public void seis(){
		while(lyön){
			
		}
		käsi.stop();
	}
}

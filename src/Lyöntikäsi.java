

import java.awt.Toolkit;

import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Ly�ntik�si {
	RegulatedMotor k�si;
	int nopeus[] = new int[2];
	int valinta = 0;
	Toolkit toolkit;
	boolean ly�n = false;
	
	
	public Ly�ntik�si(RegulatedMotor k�si) {
		this.k�si = k�si;
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
		k�si.setSpeed(100);
		k�si.rotateTo(0);
		k�si.setSpeed(palautaNopeus());
	}

	public void ly�() {
		ly�n = true;
		k�si.setSpeed(palautaNopeus());
		k�si.rotate(120);
		 oletusasentoon();
		 ly�n = false;
		
	}
	
	public int palautaNopeus(){
		return nopeus[valinta];
	}

	public void seis(){
		while(ly�n){
			
		}
		k�si.stop();
	}
}

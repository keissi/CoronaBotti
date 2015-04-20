

import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Ly�ntik�si {
	RegulatedMotor k�si;
	int nopeus[] = new int[2];
	int valinta = 0;

	public Ly�ntik�si(RegulatedMotor k�si) {
		this.k�si = k�si;
		int x=200;
		for (int i = 0; i < nopeus.length ; i++){
			nopeus[i] = x;
			x+=700;
		}
		
	}

	

	public void vaihdaNopeus() {
		if(valinta < nopeus.length){
			valinta++;
		}
		else valinta=0;
	}

	public void oletusasentoon() {
		Delay.msDelay(1000);
		k�si.setSpeed(100);
		k�si.rotateTo(0);
		k�si.setSpeed(palautaNopeus());
	}

	public void ly�() {
		k�si.setSpeed(palautaNopeus());
		k�si.rotate(120);
		 oletusasentoon();
		
	}
	
	public int palautaNopeus(){
		return nopeus[valinta];
	}

}

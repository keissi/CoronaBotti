

import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Ly�ntik�si {
	RegulatedMotor k�si;
	int nopeus;

	public Ly�ntik�si(RegulatedMotor k�si) {
		this.k�si = k�si;
		nopeus = 900;
		k�si.setSpeed(nopeus);
	}

	public void setNopeus(int nopeusvalinta) {
		k�si.setSpeed(nopeusvalinta);

	}

	public void vaihdaNopeus() {
		if (nopeus == 900) {
			nopeus = 500;
			k�si.setSpeed(nopeus);
		}
		if (nopeus == 500){
			nopeus = 900;
			k�si.setSpeed(nopeus);
		}
	}

	public void oletusasentoon() {
		Delay.msDelay(1000);
		k�si.setSpeed(100);
		k�si.rotateTo(0);
		k�si.setSpeed(nopeus);
	}

	public void ly�() {
		k�si.rotate(120);
		 oletusasentoon();
		
		
		
	}

}

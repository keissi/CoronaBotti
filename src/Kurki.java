

import lejos.hardware.motor.*;
import lejos.robotics.RegulatedMotor;

public class Kurki {
	BaseRegulatedMotor kurki;
	


	public Kurki(BaseRegulatedMotor kurki) {
		this.kurki = kurki;
		
		
	
	}

	public void setNopeus(int nopeus) {
		kurki.setSpeed(nopeus);
	}

	public void k‰‰nn‰Vasemmalle() {
		kurki.backward();
		//kurki.rotate(360);
	}

	public void k‰‰nn‰Oikealle() {
		kurki.forward();
//		kurki.rotate(3);
	}

	public void seis() {
		kurki.stop();
		kurki.resetTachoCount();
	}

	public void oletusasentoon() {
		kurki.rotateTo(0);
	}
	public void kurkiAsento(){
		System.out.println(kurki.getTachoCount());
	}
}

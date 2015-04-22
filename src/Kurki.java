

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

	public void käännäVasemmalle() {
		kurki.backward();
		//kurki.rotate(360);
	}

	public void käännäOikealle() {
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

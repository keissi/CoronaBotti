

import lejos.robotics.RegulatedMotor;

public class Kurki {
	RegulatedMotor kurki;

	public Kurki(RegulatedMotor kurki) {
		this.kurki = kurki;
	}

	public void setNopeus(int nopeus) {
		kurki.setSpeed(nopeus);
	}

	public void käännäVasemmalle() {
		kurki.backward();
//		kurki.rotate(-3);
	}

	public void käännäOikealle() {
		kurki.forward();
//		kurki.rotate(3);
	}

	public void seis() {
		kurki.stop();
	}

	public void oletusasentoon() {
		kurki.rotateTo(0);
	}
}

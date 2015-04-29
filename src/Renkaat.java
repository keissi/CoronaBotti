

import lejos.robotics.RegulatedMotor;

public class Renkaat {
	RegulatedMotor vasen;
	RegulatedMotor oikea;

	public Renkaat(RegulatedMotor vasen, RegulatedMotor oikea) {
		this.vasen = vasen;
		this.oikea = oikea;
		vasen.setAcceleration(1000);
		oikea.setAcceleration(1000);
		vasen.synchronizeWith(new RegulatedMotor[] {oikea});
	}

	public void setNopeus(int nopeus) {
		vasen.setSpeed(nopeus);
		oikea.setSpeed(nopeus);
	}

	public void liikuVasemmalle() {
		vasen.backward();
		oikea.forward();
		
	}

	public void liikuOikealle() {
		vasen.forward();
		oikea.backward();
	}

	public void seis() {
		vasen.startSynchronization();
		vasen.stop();
		oikea.stop();
		vasen.endSynchronization();
	}
	
	public int oikeaTachoCount(){
		return oikea.getTachoCount();
	}
	
	public String tachoLaskuri(){
		String tacho;
		tacho = "Vasen: " + vasen.getTachoCount()
				+ "\n" + "Oikea:" + oikea.getTachoCount();
		return tacho;
		
	}

}

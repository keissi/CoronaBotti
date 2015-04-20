

import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Lyöntikäsi {
	RegulatedMotor käsi;
	int nopeus[] = new int[2];
	int valinta = 0;

	public Lyöntikäsi(RegulatedMotor käsi) {
		this.käsi = käsi;
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
		käsi.setSpeed(100);
		käsi.rotateTo(0);
		käsi.setSpeed(palautaNopeus());
	}

	public void lyö() {
		käsi.setSpeed(palautaNopeus());
		käsi.rotate(120);
		 oletusasentoon();
		
	}
	
	public int palautaNopeus(){
		return nopeus[valinta];
	}

}

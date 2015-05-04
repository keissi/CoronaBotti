import ch.aplu.xboxcontroller.XboxController;

public class Kontrolleri {

	LiikutusTesti liikutus;
	CoronaUI ui;
	XboxController xc;
	boolean ohjainKäytössä = false;

	public Kontrolleri() {
		this.liikutus = new LiikutusTesti();
		this.ui = new CoronaUI();

		ui.asetaKontrolleri(this);
	}

	public void vaihdaNopeus(int x) {

		String nopeus = "" + x;
		ui.päivitäNopeus(nopeus);
	}

	public void käytäOhjainta() {
		if (!ohjainKäytössä) {
			xc = liikutus.alustaOhjain();
			ohjainKäytössä = true;
		}
	}

	public void lopeta() {

		liikutus.lopeta();
	}

}

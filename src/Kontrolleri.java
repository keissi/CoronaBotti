import ch.aplu.xboxcontroller.XboxController;

public class Kontrolleri {

	LiikutusTesti liikutus;
	CoronaUI ui;
	XboxController xc;
	boolean ohjainK�yt�ss� = false;

	public Kontrolleri() {
		this.liikutus = new LiikutusTesti();
		this.ui = new CoronaUI();

		ui.asetaKontrolleri(this);
	}

	public void vaihdaNopeus(int x) {

		String nopeus = "" + x;
		ui.p�ivit�Nopeus(nopeus);
	}

	public void k�yt�Ohjainta() {
		if (!ohjainK�yt�ss�) {
			xc = liikutus.alustaOhjain();
			ohjainK�yt�ss� = true;
		}
	}

	public void lopeta() {

		liikutus.lopeta();
	}

}

import ch.aplu.xboxcontroller.XboxController;


public class Kontrolleri {

	LiikutusTesti liikutus;
	CoronaUI ui; 
	XboxController xc;
	
	public Kontrolleri(){
		this.liikutus = new LiikutusTesti();
		this.ui = new CoronaUI();
		
		ui.asetaKontrolleri(this);
	}
	
	

	public void k‰yt‰Ohjainta() {
		xc = liikutus.alustaOhjain();
		
	}

	public void lopeta() {
		
		liikutus.lopeta();
	}
	
	
}

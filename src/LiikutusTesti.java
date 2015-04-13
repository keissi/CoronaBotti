import ch.aplu.xboxcontroller.XboxController;


public class LiikutusTesti {

	
	
	public static void main(String[] args){
		
	alustus alustaohjain = new alustus();
	XboxController xc = alustaohjain.getOhjain();
	Tiedonsiirto siirto = new Tiedonsiirto();
	OhjainKuuntelija kuuntelija = new OhjainKuuntelija(siirto.palautaYhteys());
	xc.addXboxControllerListener(kuuntelija);
	boolean käynnissä = true;
	while(käynnissä){
		
		
	}
		
	}
	
}

import javax.swing.JOptionPane;

import ch.aplu.xboxcontroller.XboxController;


public class LiikutusTesti {
	
	private alustus alustus;
	private XboxController xc;
	private Tiedonsiirto siirto;
	OhjainKuuntelija kuuntelija;
	
	public LiikutusTesti(){
	}
	public XboxController alustaOhjain(){
	alustus = new alustus();
	xc = alustus.getOhjain();
	siirto = new Tiedonsiirto();
	kuuntelija = new OhjainKuuntelija(siirto);
	xc.addXboxControllerListener(kuuntelija);
	boolean k�ynniss� = true;
	return xc;
	
	}
		  
	public void lopeta(){
		xc.release();
		siirto.lopetaOhjelma();
		System.exit(0);
	}
	
}

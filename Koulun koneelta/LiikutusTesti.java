import javax.swing.JOptionPane;

import ch.aplu.xboxcontroller.XboxController;


public class LiikutusTesti {

	
	
	public static void main(String[] args){
		
	alustus alustaohjain = new alustus();
	XboxController xc = alustaohjain.getOhjain();
	Tiedonsiirto siirto = new Tiedonsiirto();
	OhjainKuuntelija kuuntelija = new OhjainKuuntelija(siirto.palautaYhteys());
	xc.addXboxControllerListener(kuuntelija);
	boolean käynnissä = true;
	JOptionPane.showMessageDialog(null, 
		      "Xbox controller connected.\n" + 
		      "Press left or right trigger, Ok to quit.",
		        "RumbleDemo V1.0 (www.aplu.ch)", 
		        JOptionPane.PLAIN_MESSAGE);
		    
		    xc.release();
		    System.exit(0);
		  
		
	}
	
}

package v2;
import javax.swing.JOptionPane;

import ch.aplu.xboxcontroller.XboxController;


public class LiikutusTesti {

	
	
	public static void main(String[] args){
		
	alustus alustaohjain = new alustus();
	XboxController xc = alustaohjain.getOhjain();
	OhjainKuuntelija kuuntelija = new OhjainKuuntelija();
	xc.addXboxControllerListener(kuuntelija);
	boolean käynnissä = true;
	JOptionPane.showMessageDialog(null, "Xbox controller connected.\n" + 
		      "Liiku.",
		        "RumbleDemo V1.0 (www.aplu.ch)", 
		        JOptionPane.PLAIN_MESSAGE);
	
	xc.release();
	System.exit(0);
}
}

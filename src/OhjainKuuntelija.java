import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import ch.aplu.xboxcontroller.XboxControllerAdapter;


public class OhjainKuuntelija extends XboxControllerAdapter{
	
	boolean taulukko[] = new boolean[6];
	
	boolean streamKäytössä = false;
	boolean tikkuKäytössä = false;
	Tiedonsiirto tiedonsiirto;
	
	
	
	public OhjainKuuntelija(Tiedonsiirto tiedonsiirto){
		this.tiedonsiirto = tiedonsiirto;
		for(int i = 0; i < taulukko.length ; i++){
			taulukko[i] = false;
		}
	}
	
	public void leftShoulder(boolean tosi){
			if(!streamKäytössä){
				streamKäytössä = true;
				taulukko[0] = true;
			if(tosi){
				tiedonsiirto.lähetäTietoa(0);
				

			}
			}
			
			if(!tosi && taulukko[0]) {
				streamKäytössä = tiedonsiirto.lähetäTietoa(-1);
				taulukko[0] = false;
			}
			
	
	}
	
	public void rightShoulder(boolean tosi){
		if(!streamKäytössä){
			streamKäytössä = true;
			taulukko[1] = true;
		if(tosi){
			tiedonsiirto.lähetäTietoa(1);
		}
		}
		
		if(!tosi && taulukko[1]) {
			streamKäytössä = tiedonsiirto.lähetäTietoa(-1);
			taulukko[1] = false;
		}
		
	}
	
	
	
		
		public void dpad(int arvo, boolean painettu){
			if(!streamKäytössä){
				streamKäytössä = true;
				taulukko[2] = true;
				taulukko[3] = true;
			if(painettu && arvo == 2){
				tiedonsiirto.lähetäTietoa(2);
			}
			if(painettu && arvo == 6){
				tiedonsiirto.lähetäTietoa(3);
			}
			}
			
			if(!painettu && taulukko[2] && taulukko[3]) {
				streamKäytössä = tiedonsiirto.lähetäTietoa(-1);
				taulukko[2] = false;
				taulukko[3] = false;
			}
			
		}
		
		public void buttonA(boolean painettu){
			if(!streamKäytössä){
				streamKäytössä = true;
				taulukko[4] = true;
			if(painettu){
				tiedonsiirto.lähetäTietoa(4);
			}
			}
			
			if(!painettu && taulukko[4]) {
				streamKäytössä = tiedonsiirto.lähetäTietoa(-1);
				taulukko[4] = false;
			}
		}
		
		
		public void buttonY(boolean painettu){
			if(!streamKäytössä){
				streamKäytössä = true;
				taulukko[5] = true;
			if(painettu){
				tiedonsiirto.lähetäTietoa(5);
			}
			}
			
			if(!painettu && taulukko[5]) {
				streamKäytössä = tiedonsiirto.lähetäTietoa(-1);
				taulukko[5] = false;
			}
			
		
		}
}
//	public void leftThumbDirection(double arg0) {
//		if (arg0 > 240 && arg0 < 280 && tikkuKäytössä){
//			try {
//				out.writeInt(3);
//				out.flush();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		if (arg0 > 70 && arg0 < 110 && tikkuKäytössä){
//			try {
//				out.writeInt(2);
//				out.flush();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	
//	}
//	
//	public void leftThumbMagnitude(double arg0) {
//		tikkuKäytössä = false;	
//		if (arg0 > 0.7){
//			tikkuKäytössä = true;
//		}
//		else{
//			tikkuKäytössä = false;
//			try {
//				out.writeInt(-1);
//				out.flush();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
	
	
		



			
		
		
	

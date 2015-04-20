import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import ch.aplu.xboxcontroller.XboxControllerAdapter;


public class OhjainKuuntelija extends XboxControllerAdapter{
	
	boolean tikkuKäytössä = false;
	DataOutputStream out;
	
	public OhjainKuuntelija(DataOutputStream out){
		this.out = out;
	}
	
	public void leftShoulder(boolean tosi){
			if(tosi){
			try {
				out.writeInt(0);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(!tosi) {
				try {
					out.writeInt(-1);
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
	}
	
	public void rightShoulder(boolean tosi){
			if(tosi){
			try {
				out.writeInt(1);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if (!tosi){
				try {
					out.writeInt(-1);
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
	}
	
		
		public void dpad(int arvo, boolean painettu){
			if(arvo == 6 && painettu){
//				jos painetaan oikealle
				try{
					out.writeInt(3);
					out.flush();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(arvo == 2 && painettu){
//				jos painetaan vasemmalle
				try {
					out.writeInt(2);
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!painettu) {
				try {
					out.writeInt(-1);
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public void buttonA(boolean painettu){
			if(painettu){
			try {
				out.writeInt(4);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else {
				try {
					out.writeInt(-1);
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		public void buttonY(boolean painettu){
			if(painettu){
			try {
				out.writeInt(5);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else {
				try {
					out.writeInt(-1);
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	
	
		

	
}
			
		
		
	

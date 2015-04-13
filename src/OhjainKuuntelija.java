import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import ch.aplu.xboxcontroller.XboxControllerAdapter;


public class OhjainKuuntelija extends XboxControllerAdapter{

	DataOutputStream out;
	
	public OhjainKuuntelija(DataOutputStream out){
		this.out = out;
	}
	
	public void leftShoulder(boolean tosi){
		
			try {
				out.writeInt(0);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	
	public void rightShoulder(boolean tosi){
		
			try {
				out.writeInt(1);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	
	
	
}


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Tiedonsiirto {

	DataInputStream in;
	DataOutputStream out;
	Socket s;
	
	public Tiedonsiirto(){
		Socket s = null;
		try {
			s = new Socket("10.0.1.1", 1111);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.in = null;
		try {
			out = new DataOutputStream(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	public DataOutputStream palautaYhteys(){
		
		return out;
	}
	
}

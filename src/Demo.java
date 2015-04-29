import java.io.DataInputStream;
import java.io.IOException;

import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;


public class Demo {

	boolean käynnissä = false;
	Väritunnistus tunnistus;
	Renkaat renkaat;
	Lyöntikäsi käsi;
	DataInputStream in;
	
	
	
	public Demo(Väritunnistus tunnistus, Lyöntikäsi käsi, Renkaat renkaat, DataInputStream in){
		this.tunnistus = tunnistus;
		this.käsi = käsi;
		this.renkaat = renkaat;
		this.in = in;
	
	}
	
	public void ajaDemoa() throws IOException {
		int i = 0;
		int aika = 0;
		käynnissä = true;
		for(int k = 0; k < 5; k++){
			System.out.println("Skannaan väriä");
			tunnistus.setVäri();
			Delay.msDelay(1000);
		}
		renkaat.liikuOikealle();
		Delay.msDelay(1000);
		while(käynnissä){
			lopetaDemo();
		
			
			System.out.println("olen käynnissä");
			if(i == 0){
			renkaat.liikuOikealle();
			}
			else{
				renkaat.liikuVasemmalle();
			}
			if(tunnistus.väriTunnistus()){
				System.out.println("Lyön");
				renkaat.liikuOikealle();
				if(i == 0){
					aika = 1000;
					}
				else aika = 750;
				Delay.msDelay(aika);
				renkaat.seis();
				käsi.lyö();
				if (i == 0){
					i = 1;
				}
				else if( i == 1 ) {
					i = 0;
				}
			}
			if (renkaat.oikeaTachoCount() <-500 ){
				i = 1;
			}
			else if(renkaat.oikeaTachoCount() > 500) {
				i = 0;
			}
		}
	}
	
	public void lopetaDemo(){
		int h= 0;
		try {
			if(in.available()== 4){
				h = in.readInt();
			}		
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(h == 7){
		käynnissä = false;
		}
	}
	
}

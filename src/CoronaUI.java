import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class CoronaUI extends JFrame implements ActionListener{
	
	private JPanel paneeli;
	private JButton k‰yt‰Ohjainta;
	private JLabel otsikko;
	private JButton lopeta;
	private Kontrolleri kontrolleri;
	boolean ohjainLuotu = false;
	
	public CoronaUI(){
		
		k‰yt‰Ohjainta = new JButton("Ohjainmode");
		k‰yt‰Ohjainta.addActionListener(this);
		otsikko = new JLabel("CoronaBotti 1.0");
		lopeta = new JButton("Lopeta pelaaminen");
		lopeta.addActionListener(this);
		paneeli = new JPanel(new BorderLayout());
		paneeli.add(otsikko, BorderLayout.NORTH);
		paneeli.add(k‰yt‰Ohjainta, BorderLayout.CENTER);
		paneeli.add(lopeta, BorderLayout.SOUTH);
		add(paneeli);
		setVisible(true);
		setPreferredSize(new Dimension(400, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void asetaKontrolleri(Kontrolleri kontrolleri){
		this.kontrolleri = kontrolleri;
	}

	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==k‰yt‰Ohjainta){
			if(!ohjainLuotu){
			kontrolleri.k‰yt‰Ohjainta();
			ohjainLuotu = true;
			}
			}
		
		if(e.getSource() == lopeta){
			kontrolleri.lopeta();
			
		}
	}
}

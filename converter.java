import java.awt.GridLayout;
import javax.swing.*;




	
public class converter extends JFrame{ 
	
	
	JLabel labelC,labelF;
	JButton button;
	JTextField txf;
	
	public converter () {
		
		super("converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	GridLayout grid = new GridLayout ( 2,2);
	
	this.setLayout(grid);
	txf= new JTextField(10);
	labelC= new JLabel("celsius");
	button = new JButton ("convert");
	labelF= new JLabel ( "fahrenheit");
	 
	
	add(txf);
	add(labelC);
	add(button);
	add(labelF);
	}
	
	public static void  main (String[])
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





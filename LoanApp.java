import javax.swing.*;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.text.NumberFormatter;

public class LoanApp extends JFrame {
JLabel amountLabel,aprLabel,yearLabel,monthlypaymentLabel;
JFormattedTextField amounttf;


	// constructor
	public LoanApp() {
		
	super("converter");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	GridLayout grid = new GridLayout ( 0,1);
	
amounttf= new JFormattedTextField ( new DecimalFormat ("### ,###.###"));
	 add (amountLabel);
	 add(amounttf);

setVisible (true);

}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoanApp win = new LoanApp();
		win.pack();
		
		
		
		
	}

}

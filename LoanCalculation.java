import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;

public class LoanCalculation extends JFrame {

JFormattedTextField txtamount;
JFormattedTextField txtRate;
JFormattedTextField txtyear;
JFormattedTextField txtmonthpayment;
JTextField txtResult;

	
	public LoanCalculation() {
	
	super ("LoanCalculater");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	GridLayout grid = new GridLayout ( 8,11);
	
JLabel amountLabel =new JLabel ("Loan Amount:");
JLabel rateLabel = new JLabel ("APR  (%)");
JLabel yearLabel = new JLabel ("Years:");
JLabel monthpayment = new JLabel ( " monthly payment:");
// JLabel Result = new JLabel ("0.0");
	
	txtamount= new JFormattedTextField ( new DecimalFormat ("###,### .## "));
	txtRate= new JFormattedTextField ( new DecimalFormat ("##.#"));
	txtyear= new JFormattedTextField ( new DecimalFormat ("##"));
	txtResult = new JTextField ("0.0");
	txtResult .setForeground(Color.RED);
	
	txtResult.setEditable(false);
	add(amountLabel);
	add(txtamount);
	add(rateLabel);
	add(txtRate);
	add(yearLabel);
	add(txtyear);
	add(monthpaymentLabel);
	add(txtResult);
	
	
	
	
	
	
	
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

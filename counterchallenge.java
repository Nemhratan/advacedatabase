import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class counterchallenge extends JFrame implements ActionListener {

	JPanel p1, p2;
	JLabel label;
	JButton button;
	JTextField txf;
	int counter = 0;

	public counterchallenge() {
		super("counter challenge");
		setSize(300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		p1 = new JPanel();
		p2 = new JPanel();
		JLabel label = new JLabel(" counter");
		JLabel label2 = new JLabel("counter");
		button = new JButton("count");
		txf = new JTextField("value is" + String.valueOf(counter));
		txf.setEditable(false);

		button.addActionListener(this);// register the listenerto the button
		p1.add(label);
		p1.add(button);

		this.add(p1, BorderLayout.NORTH); // Layout of frame is Border Layout
		this.add(p2, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		counterchallenge win = new counterchallenge();
		win.setVisible(true);
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		counter = counter + 1;
    txf.setText("value is" + String.valueOf(counter));
    		

	}

}

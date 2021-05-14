package View.Popup;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Creators extends JFrame implements ActionListener{
	private JPanel contentPane;
	public Creators(){
		setTitle("Creators");
		setBounds(100, 100, 230, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JTextArea Info = new JTextArea();
		Info.setEditable(false);
		Info.setBackground(Color.LIGHT_GRAY);
		Info.setText("  Team ParkFam\r\n20142359 \uBC15\uC9C4\uAE30 \r\n20142348 \uBC15\uB300\uACBD\r\n20132349 \uBC15\uC0C1\uC900\r\n2017-06-11  ver Final");
		Info.setBounds(0, 0, 230, 269);
		contentPane.add(Info);
		
		JButton Button = new JButton("\uD655\uC778");
		Button.setBounds(0, 267, 230, 33);
		contentPane.add(Button);
		
		Button.addActionListener(this);	
	}
	 public void actionPerformed(ActionEvent e) {
	        JButton button = (JButton) e.getSource();
	        if(button.getText().equals("»Æ¿Œ"))
	        	this.setVisible(false);
	 }
}


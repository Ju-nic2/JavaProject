package View.Popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class HelpContents extends JFrame implements ActionListener{
	private JPanel contentPane;
	public HelpContents(){
		setTitle("HelpContents");
		setBounds(100, 100, 320, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JTextArea Info = new JTextArea();
		Info.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
		Info.setEditable(false);
		Info.setLineWrap(true);
		Info.setBackground(Color.LIGHT_GRAY);
		Info.setText("\n                                         \uC0AC\uC6A9\uC124\uBA85\uC11C\r\n\n 1.\uC0AC\uAC01\uD615 \uC0DD\uC131 : \uBA54\uB274 \uD639\uC740 \uD234\uBC14\uC5D0 \"Draw Rectangle\"\uC744\r\n\uD074\uB9AD \uD55C \uD6C4 EditorPane\uC5D0 \uB4DC\uB798\uADF8\uB97C \uD55C\uB2E4.\r\n\r\n\n 2.\uC0AC\uAC01\uD615 \uC120\uD0DD : \uC0AC\uAC01\uD615\uC744 \uB9C8\uC6B0\uC2A4\uB85C \uD074\uB9AD, \uC0AC\uC774\uC988 \uBCC0\uACBD,\r\n\uC774\uB3D9, \uC0DD\uC131\uD560 \uB54C \uC790\uB3D9\uC73C\uB85C \uC120\uD0DD\uC774 \uB41C\uB2E4.\r\n\r\n\n 3.\uC0AC\uAC01\uD615 \uC0AC\uC774\uC988 \uBCC0\uACBD : \uC6B0\uCE21 \uD558\uB2E8\uC5D0 \uC788\uB294 \uBE68\uAC04\uC0C9 \uC791\uC740\r\n\uC0AC\uAC01\uD615\uC744 \uD074\uB9AD\uD55C \uCC44\uB85C \uB4DC\uB798\uADF8 \uD558\uC5EC \uC0AC\uACA9\uD615\uC758 \uC0AC\uC774\uC988\uB97C\r\n\uBCC0\uACBD\uD55C\uB2E4.\r\n\r\n\n 4.\uC0AC\uAC01\uD615 \uC0AD\uC81C : \uC0AD\uC81C\uD558\uACE0 \uC2F6\uC740 \uC0AC\uAC01\uD615\uC744 \uC120\uD0DD\uD55C \uD6C4 \r\n\uBA54\uB274 \uD639\uC740 \uD234\uBC14\uC5D0 \"Remove Rectangle\"\uC744 \uD074\uB9AD\uD55C\uB2E4.");
		Info.setBounds(0, 0, 320, 286);
		
		contentPane.add(Info);
		
		JButton Button = new JButton("\uD655\uC778");
		Button.setBounds(0, 286, 320, 43);
		contentPane.add(Button);
		Button.addActionListener(this);	
	}
	 public void actionPerformed(ActionEvent e) {
	        JButton button = (JButton) e.getSource();
	        if(button.getText().equals("È®ÀÎ"))
	        	this.setVisible(false);
	 }
}
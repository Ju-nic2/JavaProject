package Control.Listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class AttributeListener  implements KeyListener {

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e) {
		JTextField temp = (JTextField) e.getSource();
		char onlyInt = e.getKeyChar();
		if (!Character.isDigit(onlyInt) || temp.getText().length()>=3){
			e.consume();
			return;
		}
	}
		
}

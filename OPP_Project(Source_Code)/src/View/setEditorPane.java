package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class setEditorPane {
	private JPanel EditorPane;

	public setEditorPane(JPanel EditorPane, JPanel contentPane) {
		this.EditorPane = EditorPane;
		EditorPane.setBorder(new LineBorder(Color.GRAY, 4));
		EditorPane.setBackground(Color.WHITE);
		EditorPane.setLayout(null);
		EditorPane.setBounds(238, 89, 610, 550);
		
		JTextPane EditorPane_title = new JTextPane();
		EditorPane_title.setEditable(false);
		EditorPane_title.setBounds(227, 25, 631, 48);
		EditorPane_title.setForeground(Color.GRAY);
		EditorPane_title.setText("                       Editor Pane");
		EditorPane_title.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(EditorPane_title);
	}
	
	public JPanel getEditorPane(){
		return EditorPane;
	}
	
}

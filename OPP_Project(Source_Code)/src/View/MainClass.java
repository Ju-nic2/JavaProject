package View;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import Control.methods;
import Control.Listeners.IntKeyListener;

class MainClass {
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("Project_ParkFam");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 860, 700);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);
		
		JPanel EditorPane = new JPanel();
		setEditorPane EditorPanel = new setEditorPane(EditorPane,contentPane);
		contentPane.add(EditorPanel.getEditorPane());
		
		JPanel AttributePane = new JPanel();
		setAttributePane AttibutePanel = new setAttributePane(AttributePane,contentPane,new IntKeyListener());
		contentPane.add(AttributePane);
		
		methods Control = new methods(EditorPane,AttibutePanel);
		
		JMenuBar menuBar = new JMenuBar();
		Menu Menu = new Menu(menuBar,Control);
		Menu.setMenu();
		frame.setJMenuBar(menuBar);
		
		
		JToolBar toolBar = new JToolBar();
		ToolBar Tool = new ToolBar(toolBar,Control);
		Tool.setTool();
		contentPane.add(toolBar);
		
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		View.Popup.HelpContents ViewHelp = new View.Popup.HelpContents();
		ViewHelp.setResizable(false);
		ViewHelp.setLocationRelativeTo(null);
		ViewHelp.setVisible(true);
	}
}

package View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import Control.MakeAttribute;
import Control.MakeMindMap;
import Model.ManageLabel;


public class Main
{
	public static void main(String[] args) {
		
		ManageLabel[] LABEL = new ManageLabel[100];
		
		JFrame frame = new JFrame();
		frame.setTitle("Simple MindMap");
		frame.setBounds(10,10,1100,600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창닫으면 상태창도닫
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.setLayout(null);//null로하면 좌표로 지정할 수 있다.
		frame.setContentPane(contentPane);
		
		JSplitPane SPLITPANE_Right = new JSplitPane();
		SPLITPANE_Right.setBounds(0,37,1100,700);
		SPLITPANE_Right.setDividerLocation(850);
		SPLITPANE_Right.setEnabled(false);
		contentPane.add(SPLITPANE_Right);
		
		JSplitPane SPLITPANE_Left = new JSplitPane();
		SPLITPANE_Left.setDividerLocation(250);
		SPLITPANE_Left.setEnabled(false);
		SPLITPANE_Right.setLeftComponent(SPLITPANE_Left);
	
		JPanel TextEditorPanePanel= new JPanel(); // actionlistener에서 접근하기위
		TextEditorPane TEXTEDITORPANE = new TextEditorPane(TextEditorPanePanel);		
		TEXTEDITORPANE.setTextEditorPane(SPLITPANE_Left);//Panel 위에 올
		
		AttributePane ATTRIBUTEPANE = new AttributePane();
		ATTRIBUTEPANE.setAttributePane(SPLITPANE_Right);
		
		MindMapPane MINDMAPPANE = new MindMapPane(SPLITPANE_Left);
		//MINDMAPPANE.setMindMapPane(SPLITPANE_Left);
		
		MakeMindMap Action= new MakeMindMap(TEXTEDITORPANE,MINDMAPPANE,LABEL);
		TEXTEDITORPANE.get_Action(Action);
		TEXTEDITORPANE.add_Action();
		
		MakeAttribute Action2 = new MakeAttribute(MINDMAPPANE,ATTRIBUTEPANE,LABEL);
		ATTRIBUTEPANE.get_Action2(Action2);
		ATTRIBUTEPANE.add_Action2();
		
		MINDMAPPANE.get_Action2(Action2,LABEL);
		MINDMAPPANE.add_Action2();
		
		
		Menu menu = new Menu(Action);
		menu.setMenu(frame);
	
		ToolBar toolbar = new ToolBar(Action);
		toolbar.setToolBar(contentPane);
		
	
		
		frame.setVisible(true);//code의 맨밑에 넣어
	
		
		
		
	}

}
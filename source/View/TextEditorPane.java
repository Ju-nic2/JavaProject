package View;


import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Control.MakeMindMap;
import Model.ManageLabel;

public class TextEditorPane {
	
	private JTextField TextEditorPaneText;
	private JTextArea TextEditorPaneTextArea;
	private JScrollPane TextEditorPaneScroll;
	private JButton TextEditorPaneButton;
	private JPanel TextEditorPanePanel;
	private MakeMindMap Action;
	
	
	public TextEditorPane(JPanel TextEditorPanePanel)
	{
		this.TextEditorPanePanel=TextEditorPanePanel;
	}
	
	
	void setTextEditorPane(JSplitPane SplitPaneLeft)
	{
		Border line =BorderFactory.createLineBorder(Color.black);
		TextEditorPaneTextArea = new JTextArea();
		TextEditorPaneTextArea.setBackground(Color.ORANGE);
		TextEditorPaneTextArea.setBorder(line);
		TextEditorPaneTextArea.setTabSize(2);//탭사이즈를 지정해준다 
	
		
		 TextEditorPaneText = new JTextField("TextEdit Pane");
		 TextEditorPaneText.setBackground(Color.decode("0xCCCC66"));
		 TextEditorPaneText.setBorder(line);
		 TextEditorPaneText.setOpaque(true);
		 TextEditorPaneText.setHorizontalAlignment(0);
		 TextEditorPaneText.setBounds(0, 0,248, 30);
		 
	     TextEditorPaneText.setEditable(false);
		 
		TextEditorPaneButton = new JButton();
		TextEditorPaneButton.setBackground(Color.decode("0xCCCC66"));
		TextEditorPaneButton.setOpaque(true);
		TextEditorPaneButton.setText("적용");
		TextEditorPaneButton.setBorder(line);
		TextEditorPaneButton.setBounds(20,469,210, 40);
		
		TextEditorPanePanel = new JPanel();
		TextEditorPanePanel.setLayout(null);
		TextEditorPanePanel.setBounds(0, 0, 250, 510);
		TextEditorPanePanel.add(TextEditorPaneButton);
		TextEditorPanePanel.setBackground(Color.ORANGE);
		TextEditorPanePanel.add(TextEditorPaneText);
	
		TextEditorPaneScroll = new JScrollPane(TextEditorPaneTextArea);
		TextEditorPaneScroll.setBounds(0, 30, 250, 440);
		TextEditorPaneScroll.setBackground(Color.ORANGE);
		TextEditorPanePanel.add(TextEditorPaneScroll);
		
		SplitPaneLeft.setBackground(Color.ORANGE);
		SplitPaneLeft.setLeftComponent(TextEditorPanePanel);
 	}
	public void copyTextEditorPane(ManageLabel[] storage)
	{
		TextEditorPaneTextArea.setText(null);
		int i =0;
		while(storage[i]!=null)
		{
			System.out.println("text추가할때 node Level: "+storage[i].getNodeLevel());
			if(storage[i].getNodeLevel() !=0)
			{
				TextEditorPaneTextArea.append("\n");
				for(int j=0;j<storage[i].getNodeLevel();j++)
				{
					TextEditorPaneTextArea.append("\t");
				}
			}
			
			TextEditorPaneTextArea.append(storage[i].getLabels().getText());
			i++;
			if(i>storage[0].getLabelCount())break;
		}
		TextEditorPaneTextArea.append("\n");
		
	}
	
	

	private void whlie(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void reset_Text() {TextEditorPaneTextArea.setText(null);}
	public void get_Action(MakeMindMap Action)
	{
        this.Action = Action;
        
	}
	public void add_Action()
	{
		TextEditorPaneButton.addActionListener(Action);
		
	}
	public String ReadText()
	{
		String TextRead=TextEditorPaneTextArea.getText();
		return TextRead;
	}
	public int WordCount()
	{
		String Text=TextEditorPaneTextArea.getText();
		int cols=0;
		for(int i=0;i<Text.length();i++)
		{
			if(Text.charAt(i)=='\n')
			{
				cols++;
			}
		}
		
		return cols;
	}
	public int Col()
	{
		return TextEditorPaneTextArea.getColumns();
	}
	
	}
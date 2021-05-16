package View;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;

import Control.MakeMindMap;

public class ToolBar 
{
	
	private JToolBar toolbar;
	private JButton newFile;
	private JButton open;
	private JButton save;
	private JButton saveAs;
	private JButton close;
	
	private MakeMindMap Action;
	
	public ToolBar(MakeMindMap Action)
	{
		this.Action = Action;
	}
	public void setToolBar(JPanel contentPane)
	{
		Border line =BorderFactory.createLineBorder(Color.black);
		toolbar = new JToolBar();
		toolbar.setBackground(Color.ORANGE);
		toolbar.setLayout(null);
		toolbar.setBounds(0,0,1100,30);
		toolbar.setFloatable(false);
		
		
		newFile= new JButton("New File");
		newFile.setBounds(0, 0, 80, 30);
		newFile.setBackground(Color.decode("0xCCCC66"));
		newFile.setBorder(line);
		newFile.setOpaque(true);
		newFile.addActionListener(Action);
		
		open= new JButton("Open");
		open.setBounds(80, 0, 80, 30);
		open.setBackground(Color.decode("0xCCCC66"));
		open.setBorder(line);
	//	open.setBorderPainted(false);
		open.setOpaque(true);
		open.addActionListener(Action);
		
		save= new JButton("Save");
		save.setBackground(Color.decode("0xCCCC66"));
		save.setBorder(line);
		save.setOpaque(true);
		save.setBounds(160,0, 80, 30);
		//save.setBorderPainted(true);
		save.addActionListener(Action);
		
		saveAs= new JButton("Save as..");
		saveAs.setBackground(Color.decode("0xCCCC66"));
		saveAs.setBorder(line);
		//saveAs.setBorderPainted(false);
		saveAs.setOpaque(true);
		saveAs.setBounds(240,0, 80, 30);
		saveAs.addActionListener(Action);
		
		close = new JButton("Close");
		close.setBackground(Color.decode("0xCCCC66"));
		close.setBorder(line);
		//close.setBorderPainted(false);
		close.setOpaque(true);
		close.setBounds(320,0, 80, 30);
		close.addActionListener(Action);
		
		
		toolbar.add(newFile);
		toolbar.add(open);
		toolbar.add(save);
		toolbar.add(saveAs);
		toolbar.add(close);
		contentPane.setBackground(Color.ORANGE);
		contentPane.add(toolbar);
		
	}

}
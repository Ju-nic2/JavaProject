package View;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;

import Control.MakeMindMap;


class Menu {
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem newFile;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem saveAs;
	private JMenuItem close;
	private MakeMindMap Action;

	public Menu(MakeMindMap Action)
	{
		this.Action = Action;
	}
	public void setMenu(JFrame frame)
	{
		Border line =BorderFactory.createLineBorder(Color.black);
		menu = new JMenu("MenuBar");
		
		menu.setBackground(Color.ORANGE);
		menu.setOpaque(true);
		
		menubar= new JMenuBar();
		menubar.setBorder(line);
		menubar.setBackground(Color.ORANGE);
		menubar.setBounds(0,0,frame.getWidth(),30);
		
		newFile = new JMenuItem("New File");
		newFile.addActionListener(Action);
		newFile.setBackground(Color.decode("0xCCCC66"));
		newFile.setOpaque(true);
		
		open = new JMenuItem("Open");
		open.addActionListener(Action);
		open.setBackground(Color.decode("0xCCCC66"));
		open.setOpaque(true);
		
		save= new JMenuItem("Save");
		save.addActionListener(Action);
		save.setBackground(Color.decode("0xCCCC66"));
		save.setOpaque(true);
		
		saveAs = new JMenuItem("Save as..");
		saveAs.addActionListener(Action);
		saveAs.setBackground(Color.decode("0xCCCC66"));
		saveAs.setOpaque(true);
		
		close = new JMenuItem("Close");
		close.setBackground(Color.decode("0xCCCC66"));
		close.setOpaque(true);
		close.addActionListener(Action);
		
		menu.add(newFile);
		menu.add(open);
		menu.add(save);
		menu.add(saveAs);
		menu.add(close);
		
		menubar.add(menu);
		frame.setJMenuBar(menubar);
		
	}

}
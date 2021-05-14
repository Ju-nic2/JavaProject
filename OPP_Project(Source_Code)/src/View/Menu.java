package View;

import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import Control.methods;

class Menu {
	private JMenuBar menu;
	private methods BTListener;
	
	Menu(JMenuBar menubar,methods control){
		menu = menubar;
		this.BTListener = control;
	}
	void setMenu(){
		JMenu File = new JMenu("File(ALT+F)");
		File.setMnemonic(KeyEvent.VK_F);
		File.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		
		JMenuItem menu_File_New = new JMenuItem("New");
		menu_File_New.addActionListener(BTListener);
		File.add(menu_File_New);
		
		JMenuItem menu_File_Open = new JMenuItem("Open");
		menu_File_Open.addActionListener(BTListener);
		File.add(menu_File_Open);
		
		JSeparator separator = new JSeparator();
		File.add(separator);
		
		JMenuItem menu_File_Save = new JMenuItem("Save");
		menu_File_Save.addActionListener(BTListener);
		File.add(menu_File_Save);
		
		JMenuItem menu_File_SaveAs = new JMenuItem("Save As...");
		menu_File_SaveAs.addActionListener(BTListener);
		File.add(menu_File_SaveAs);
		
		JMenuItem menu_File_ExtractJava = new JMenuItem("Make *.java");
		menu_File_ExtractJava.addActionListener(BTListener);
		File.add(menu_File_ExtractJava);
		
		JSeparator separator_1 = new JSeparator();
		File.add(separator_1);
		
		JMenuItem menu_File_Exit = new JMenuItem("Exit");
		menu_File_Exit.addActionListener(BTListener);
		File.add(menu_File_Exit);

		JMenu Edit = new JMenu("Edit(ALT+E)");
		Edit.setMnemonic(KeyEvent.VK_E);
		
		JMenuItem menu_Edit_RemoveRect = new JMenuItem("Remove Rectangle");
		menu_Edit_RemoveRect.addActionListener(BTListener);
		Edit.add(menu_Edit_RemoveRect);
		
		JMenuItem Add = new JMenu("Add(ALT+A)");
		Add.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem menu_Add_DrawRect = new JMenuItem("Draw Rectangle");
		menu_Add_DrawRect.addActionListener(BTListener);
		Add.add(menu_Add_DrawRect);
		
		JMenuItem Help = new JMenu("Help(ALT+H)");
		Help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem menu_Help_Helpcontents = new JMenuItem("Help Contents");
		menu_Help_Helpcontents.addActionListener(BTListener);
		Help.add(menu_Help_Helpcontents);
		
		JMenuItem menu_Help_Creators = new JMenuItem("Creators");
		menu_Help_Creators.addActionListener(BTListener);
		Help.add(menu_Help_Creators);
		
		menu.add(File);
		menu.add(Edit);
		menu.add(Add);
		menu.add(Help);
	}
}

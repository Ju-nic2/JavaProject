package View;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import Control.methods;

class ToolBar {
	private JToolBar toolBar;
	private methods BTListener;
	private JLabel sep[] = new JLabel[2];
	
	ToolBar(JToolBar ToolBar,methods control){
		this.toolBar = ToolBar;
		this.BTListener = control;
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 858, 26);
		sep[0] = new JLabel("              ");
		sep[0].setBackground(Color.GRAY);
		sep[1] = new JLabel("              ");
		sep[1].setBackground(Color.GRAY);
	}
	void setTool(){
		JButton tool_File_New = new JButton(new ImageIcon("ICON/New.png"));
		tool_File_New.setToolTipText("New : Reset All of Rectangles");
		tool_File_New.setName("New");
		tool_File_New.addMouseListener(BTListener);
		toolBar.add(tool_File_New);
		
		JButton tool_File_Open = new JButton(new ImageIcon("ICON/Open.png"));
		tool_File_Open.setName("Open");
		tool_File_Open.setToolTipText("Open : Open new Json File");
		tool_File_Open.addMouseListener(BTListener);
		toolBar.add(tool_File_Open);
		
		JButton tool_File_Save = new JButton(new ImageIcon("ICON/Save.png"));
		tool_File_Save.setToolTipText("Save : Save file into json format");
		tool_File_Save.setName("Save");
		tool_File_Save.addMouseListener(BTListener);
		toolBar.add(tool_File_Save);
		
		JButton tool_File_SaveAs = new JButton(new ImageIcon("ICON/SaveAs.png"));
		tool_File_SaveAs.setToolTipText("Save As... : Save Json file in another name");
		tool_File_SaveAs.setName("SaveAs");
		tool_File_SaveAs.addMouseListener(BTListener);
		toolBar.add(tool_File_SaveAs);
		
		JButton tool_File_MakeJavaFile = new JButton(new ImageIcon("ICON/MakeJavaFile.png"));
		tool_File_MakeJavaFile.setToolTipText("Make JavaFile : Save Java file");
		tool_File_MakeJavaFile.setName("MakeJavaFile");
		tool_File_MakeJavaFile.addMouseListener(BTListener);
		toolBar.add(tool_File_MakeJavaFile);
		
		
		JButton tool_File_Exit = new JButton(new ImageIcon("ICON/Exit.png"));
		tool_File_Exit.setToolTipText("Exit : Exit Program");
		tool_File_Exit.setName("Exit");
		tool_File_Exit.addMouseListener(BTListener);
		toolBar.add(tool_File_Exit);
		
		toolBar.add(sep[0]);
		
		JButton tool_Add_DrawRect = new JButton(new ImageIcon("ICON/Draw.png"));
		tool_Add_DrawRect.setToolTipText("Draw : Draw Rectangle");
		tool_Add_DrawRect.setName("Draw Rectangle");
		tool_Add_DrawRect.addMouseListener(BTListener);
		toolBar.add(tool_Add_DrawRect);
		
		JButton tool_Edit_RemoveRect = new JButton(new ImageIcon("ICON/Remove.png"));
		tool_Edit_RemoveRect.setToolTipText("Remove : Remove Rectangle");
		tool_Edit_RemoveRect.setName("Remove Rectangle");
		tool_Edit_RemoveRect.addMouseListener(BTListener);
		toolBar.add(tool_Edit_RemoveRect);
		
		toolBar.add(sep[1]);
		
		JButton tool_Help_Creators = new JButton(new ImageIcon("ICON/Creators.png"));
		tool_Help_Creators.setToolTipText("Creators : Show Creators");
		tool_Help_Creators.setName("Creators");
		tool_Help_Creators.addMouseListener(BTListener);
		toolBar.add(tool_Help_Creators);
		
		JButton tool_Help_Helpcontents = new JButton(new ImageIcon("ICON/Help.png"));
		tool_Help_Helpcontents.setToolTipText("Help : Show help contents");
		tool_Help_Helpcontents.setName("Help Contents");
		tool_Help_Helpcontents.addMouseListener(BTListener);
		toolBar.add(tool_Help_Helpcontents);
	}
}

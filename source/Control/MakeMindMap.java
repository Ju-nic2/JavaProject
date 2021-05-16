package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import Control.Save;
//import javax.swing.JOptionPane;
import Model.ManageLabel;
import Model.Tree;
import View.MindMapPane;
import View.TextEditorPane;

public class MakeMindMap implements ActionListener
{
	private TextEditorPane TEXTEDITORPANE;
	private MindMapPane MINDMAPPANE;
//	private JTextArea TextEditorPaneTextArea;
	private ManageLabel []LABEL;
	private Tree empty;
	private MindMapPane toOpen;
	private int yncopt;
	
	    
	public MakeMindMap(TextEditorPane TEXTEDITORPANE,MindMapPane MINDMAPPANE,ManageLabel []LABEL)
	{
		this.LABEL = LABEL;
		this.TEXTEDITORPANE=TEXTEDITORPANE;
		this.MINDMAPPANE=MINDMAPPANE;
	}
	
	protected void event_Exit()
	{
			System.exit(0);
	}
	protected void event_NewFile() 
	{

		if (Save.rout != null)
		{

			yncopt = JOptionPane.showConfirmDialog(null, "새로운 작업으로 시작하시겠습니까?", "저장 완료",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (yncopt == JOptionPane.YES_OPTION) 
			{
				yncopt = 1;
				LABEL=MINDMAPPANE.getManageLabel();
				new Save(LABEL);
				MINDMAPPANE.resetPanel();  
				MINDMAPPANE.getPanel().setDraw(false);  
				TEXTEDITORPANE.reset_Text();
			}
		}
		else {
			if(ManageLabel.LabelCount!=0) 
			{
				yncopt = JOptionPane.showConfirmDialog(null, "변경된 내용을 저장 하시겠습니까?", "저장 완료",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (yncopt == JOptionPane.YES_OPTION)
				{
					if(ManageLabel.LabelCount!=0) 
					{
						LABEL=MINDMAPPANE.getManageLabel();
						new Save(LABEL);
						MINDMAPPANE.resetPanel();  
						MINDMAPPANE.getPanel().setDraw(false);  
						TEXTEDITORPANE.reset_Text();
					}
				}
				else if (yncopt == JOptionPane.NO_OPTION)
				{
					MINDMAPPANE.resetPanel();  
					MINDMAPPANE.getPanel().setDraw(false);  
					TEXTEDITORPANE.reset_Text();
				}
			}else {
				yncopt = JOptionPane.showConfirmDialog(null, "새로운 작업으로 시작하시겠습니까?", "저장 완료",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (yncopt == JOptionPane.YES_OPTION) 
				{
					MINDMAPPANE.resetPanel();  
					MINDMAPPANE.getPanel().setDraw(false);  
					TEXTEDITORPANE.reset_Text();
				}
			}
				
		}
		Save.rout=null;
		}
	  protected void event_Save() throws IOException
      {
		 
	     
	    		MINDMAPPANE.getBackColor();
	    		LABEL=MINDMAPPANE.getManageLabel();
	         new Save(LABEL);
	      
      }
	  protected void event_SaveAs() {
		  new SaveAs(LABEL);
	  }
	  protected void event_Open()
      {
		 
         if (Save.rout != null)
         {

            yncopt = JOptionPane.showConfirmDialog(null, "저장 하시겠습니까?", "저장 완료",
                  JOptionPane.YES_NO_CANCEL_OPTION);
            if (yncopt == JOptionPane.NO_OPTION) {
            	  empty = new Tree();
                  toOpen=MINDMAPPANE;
            	new Open(empty,toOpen,LABEL,TEXTEDITORPANE);
            }
            else {
            	yncopt = 1;
            	new Save(LABEL);
            	MINDMAPPANE.removeAll();
            	MINDMAPPANE.repaint();
               empty = new Tree();  
               toOpen=MINDMAPPANE;
               new Open(empty,toOpen,LABEL,TEXTEDITORPANE);
            }
         }
         else
         {
        	if(ManageLabel.LabelCount!=0) {
	        	new Save(LABEL);
	         	MINDMAPPANE.removeAll();
	         	MINDMAPPANE.repaint();
	            empty = new Tree();
	            toOpen=MINDMAPPANE;
	            new Open(empty,toOpen,LABEL,TEXTEDITORPANE);
        	 }
        	 else {
        		  empty = new Tree();
        		toOpen=MINDMAPPANE;
        		 new Open(empty,toOpen,LABEL,TEXTEDITORPANE);
        	 }
         }
         
      }

	
	
      public void actionPerformed(ActionEvent e) {
          
          String ButtonPressed = e.getActionCommand();
          if (ButtonPressed.equals("Close"))
             event_Exit();
          else if(ButtonPressed.equals("적용"))
          {
             LABEL= new ManageLabel[100];
             String TextEditorPaneText;
             int TextEditorPaneWordCount;
             TextEditorPaneText=TEXTEDITORPANE.ReadText();
             TextEditorPaneWordCount= TEXTEDITORPANE.WordCount();
             MINDMAPPANE.AddLabel(TextEditorPaneText,TextEditorPaneWordCount,LABEL); 
             if(TextEditorPaneWordCount>=1) {MINDMAPPANE.AddLabel(TextEditorPaneText,TextEditorPaneWordCount,LABEL);}
             else {MINDMAPPANE.resetPanel(); MINDMAPPANE.getPanel().setDraw(false);}
          }
          else if(ButtonPressed.equals("Save"))
          {
            try {
             event_Save();
          } catch (IOException e1) {
             // TODO Auto-generated catch block
             e1.printStackTrace();
          }
          }
          else if(ButtonPressed.equals("Open"))
          {

             event_Open();
          }
          else if(ButtonPressed.equals("Save as..")) {
        	  event_SaveAs();
          }
          else if(ButtonPressed.equals("New File")) {
        	  event_NewFile();
          }
          
       }

    }
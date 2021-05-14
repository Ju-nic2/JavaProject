package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Control.Function.ExtractJava;
import Control.Function.Open;
import Control.Function.Save;
import Control.Function.SaveAs;
import Control.Listeners.DrawRectListener;
import Control.Listeners.Size_MoveListener;
import Model.Model;
import View.setAttributePane;

public class methods implements MouseListener, ActionListener
{
	Model Storage = new Model();
	public static boolean isdrawed = false;
	private JPanel EditorPane;
	private setAttributePane AttributePane;
	private DrawRectListener DrawRectListener;
	private Size_MoveListener[] Size_MoveListener = new Size_MoveListener[100];
	private int yncopt;

	public methods(JPanel editorPane, setAttributePane AttibutePanel)
	{
		EditorPane = editorPane;
		AttributePane = AttibutePanel;
	}

	protected void event_Save()
	{
		new Save(Storage);
	}

	protected void event_New()
	{
		if (Save.rout != null)
		{

			yncopt = JOptionPane.showConfirmDialog(null, "새로운 작업으로 시작하시겠습니까?", "저장 완료",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (yncopt == JOptionPane.YES_OPTION) {
				yncopt = 1;
				new Save(Storage);
				EditorPane.removeAll();
				EditorPane.repaint();
				Storage = new Model();
				Storage.Rectcnt = 0;
			}

		}
		else
		{
			if (Storage.Rectcnt != 0)
			{
				yncopt = JOptionPane.showConfirmDialog(null, "변경된 내용을 저장 하시겠습니까?", "저장 완료",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (yncopt == JOptionPane.YES_OPTION)
				{
					if (Storage.Rectcnt != 0)
					{
						new Save(Storage);
						EditorPane.removeAll();
						EditorPane.repaint();
						Storage = new Model();
						Storage.Rectcnt = 0;
					}
				}
				else if (yncopt == JOptionPane.NO_OPTION)
				{
					EditorPane.removeAll();
					EditorPane.repaint();
					Storage = new Model();
					Storage.Rectcnt = 0;
				}
			}

		}

		Save.rout = null;

	}

	protected void event_Open()
	{
		if (Save.rout != null)
		{
			yncopt = JOptionPane.showConfirmDialog(null, "저장 하시겠습니까?", "저장 완료", JOptionPane.YES_NO_OPTION);

			if (yncopt == JOptionPane.NO_OPTION)
				new Open(EditorPane, AttributePane, Storage, Size_MoveListener);

			else
			{
				yncopt = 1;

				new Save(Storage);
				EditorPane.removeAll();
				EditorPane.repaint();
				Storage = new Model();
				Storage.Rectcnt = 0;
				new Open(EditorPane, AttributePane, Storage, Size_MoveListener);
			}
		}

		else
		{
			if (Storage.Rectcnt != 0)
			{
				new Save(Storage);
				EditorPane.removeAll();
				EditorPane.repaint();
				Storage = new Model();
				Storage.Rectcnt = 0;
				new Open(EditorPane, AttributePane, Storage, Size_MoveListener);
			}
			else
				new Open(EditorPane, AttributePane, Storage, Size_MoveListener);
		}
	}

	protected void event_SaveAs()
	{
		new SaveAs(Storage);
	}

	protected void event_Exit()
	{
		if (Storage.Rectcnt == 0)
			System.exit(0);
		else
		{
			new Save(Storage);
			System.exit(0);
		}
	}
	
	protected void event_ExtractJava()
	{
		new ExtractJava(Storage);
	}

	protected void event_DrawRect()
	{
		if(!isdrawed){
			isdrawed = true;
			for (int i = 0; i < Storage.Rectcnt; i++) {
				Storage.getRectBag()[i].getRect().removeMouseListener(Size_MoveListener[i]);
				Storage.getRectBag()[i].getRect().removeMouseMotionListener(Size_MoveListener[i]);
			}
			DrawRectListener = new DrawRectListener(EditorPane, AttributePane, Storage, Size_MoveListener);
			EditorPane.addMouseListener(DrawRectListener);
			EditorPane.addMouseMotionListener(DrawRectListener);
		}
	}

	protected void event_RemoveRect()
	{
		doSelect.removeRect(Storage, EditorPane, AttributePane,Size_MoveListener);
	
	}

	protected void event_Creators()
	{
		View.Popup.Creators frame = new View.Popup.Creators();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	protected void event_Helpcontents()
	{
		View.Popup.HelpContents frame = new View.Popup.HelpContents();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void mousePressed(MouseEvent e)
	{
		JButton button = (JButton) e.getSource();

		if (button.getName().equals("Exit"))
			event_Exit();
		else if (button.getName().equals("Creators"))
			event_Creators();
		else if (button.getName().equals("Open"))
			event_Open();
		else if (button.getName().equals("Draw Rectangle"))
			event_DrawRect();
		else if (button.getName().equals("New"))
			event_New();
		else if (button.getName().equals("Remove Rectangle"))
			event_RemoveRect();
		else if (button.getName().equals("Help Contents"))
			event_Helpcontents();
		else if (button.getName().equals("Save"))
			event_Save();
		else if (button.getName().equals("SaveAs"))
			event_SaveAs();
		else if (button.getName().equals("MakeJavaFile"))
			event_ExtractJava();

	}

	public void actionPerformed(ActionEvent e)
	{
		String itemPressed = e.getActionCommand();

		if (itemPressed.equals("Exit"))
			event_Exit();
		else if (itemPressed.equals("Creators"))
			event_Creators();
		else if (itemPressed.equals("Open"))
			event_Open();
		else if (itemPressed.equals("Draw Rectangle"))
			event_DrawRect();
		else if (itemPressed.equals("Remove Rectangle"))
			event_RemoveRect();
		else if (itemPressed.equals("New"))
			event_New();
		else if (itemPressed.equals("Help Contents"))
			event_Helpcontents();
		else if (itemPressed.equals("Save"))
			event_Save();
		else if (itemPressed.equals("SaveAs"))
			event_SaveAs();
		else if (itemPressed.equals("Make *.java"))
			event_ExtractJava();
	}

	public void mouseClicked(MouseEvent e)
	{
	}

	public void mouseEntered(MouseEvent e)
	{
	}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e)
	{
	}

}

package Control;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Control.Listeners.Size_MoveListener;
import Model.Model;
import Model.Rectangles;
import View.setAttributePane;

public class doSelect {
	private static JLabel tempRect;
	
	public doSelect(Rectangles Rect,setAttributePane AttibutePane){
		if(Rect != null)
			Rect.getRect().removeAll();
		JLabel SizeControl = new JLabel();
		SizeControl.setBounds(Rect.getRect().getWidth() - 5, Rect.getRect().getHeight() - 5, 5, 5);
		SizeControl.setBorder(new LineBorder(Color.RED, 2));
		Rect.getRect().add(SizeControl);
		
		if (tempRect != null && !Rect.getRect().equals(tempRect)) {
			tempRect.setBackground(Color.white);
			tempRect.removeAll();
			tempRect = Rect.getRect();
			Rect.getRect().setBackground(Color.LIGHT_GRAY);
			
			AttibutePane.showInfo(Rect);
			
		} 
		else {
			Rect.getRect().setBackground(Color.LIGHT_GRAY);
			
			tempRect = Rect.getRect();
			AttibutePane.showInfo(Rect);
		}
	}
	
	public static void removeRect(Model Storage,JPanel EditorPane,setAttributePane AttributePane, Size_MoveListener[] size_MoveListener){
		Rectangles[] Rectangles = Storage.getRectBag();
		for(int i=0;i<Storage.Rectcnt;i++){
			if(Rectangles[i].getRect().equals(tempRect)){
				if(i != Storage.Rectcnt-1){
					EditorPane.remove(Rectangles[i].getRect());
					Rectangles[i].setRect(Rectangles[Storage.Rectcnt-1].getRect());
					Rectangles[i].setType(Rectangles[Storage.Rectcnt-1].getType());
					Rectangles[i].getRect().setName(Rectangles[Storage.Rectcnt-1].getRect().getName());
					Rectangles[Storage.Rectcnt-1].getRect().removeMouseMotionListener(size_MoveListener[Storage.Rectcnt-1]);
					Rectangles[Storage.Rectcnt-1].getRect().removeMouseListener(size_MoveListener[Storage.Rectcnt-1]);
					size_MoveListener[i] = new Size_MoveListener(EditorPane,AttributePane,Rectangles[i]);
					Rectangles[i].getRect().addMouseListener(size_MoveListener[i]);
					Rectangles[i].getRect().addMouseMotionListener(size_MoveListener[i]);
					Storage.Rectcnt--;
					EditorPane.repaint();
					AttributePane.showInfo(null);
				}
				else{
					EditorPane.remove(Rectangles[--Storage.Rectcnt].getRect());
					EditorPane.repaint();
					AttributePane.showInfo(null);
				}	
			}
		}
	}

}

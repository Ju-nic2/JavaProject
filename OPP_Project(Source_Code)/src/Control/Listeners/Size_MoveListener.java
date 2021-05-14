package Control.Listeners;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.doSelect;
import Model.Rectangles;
import View.setAttributePane;

public class Size_MoveListener implements MouseMotionListener,MouseListener{
	private setAttributePane AttributePane;
	private Rectangles rectInfo;
	private int width,height,firstX,firstY,x,y,firstgetX,firstgetY;
	private JPanel EditorPane;
	private JLabel Rect;
	private boolean Move_or_Size;
	public Size_MoveListener(JPanel editorPane, setAttributePane attributePane, Rectangles rectInfo) {
		this.EditorPane = editorPane;
		this.Rect = rectInfo.getRect();
		this.AttributePane = attributePane;
		this.rectInfo = rectInfo;
	}

	public void mousePressed(MouseEvent e) {
		firstX = Rect.getX();
		firstY =Rect.getY();
		width = Rect.getWidth();
		height = Rect.getHeight();
		firstgetX = e.getX();
		firstgetY = e.getY();
		if(firstgetX>width-10 && firstgetY>height-10){
			Move_or_Size = false;
			EditorPane.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		}
		else
			Move_or_Size = true;
	}
	
	public void mouseDragged(MouseEvent e) {
		if(Move_or_Size){
			EditorPane.setCursor(new Cursor(Cursor.MOVE_CURSOR));	
			this.x = Rect.getX()+e.getX()-firstgetX;
			this.y =  Rect.getY()+ e.getY()-firstgetY;
			if(this.x < 5)
				this.x = 5;
			else if(this.x+width+5 > EditorPane.getWidth())
				this.x = EditorPane.getWidth() - width-5;
			if(this.y < 5)
				this.y = 5;
			else if(this.y+height+5 > EditorPane.getHeight())
				this.y = EditorPane.getHeight() - height-5;
			Rect.setLocation(this.x,this.y);
			EditorPane.repaint();
			new doSelect(rectInfo,AttributePane);
			AttributePane.showInfo(rectInfo);
		}
		else{
			if(e.getY() < 0 && e.getX() > 0)
				Rect.setSize(e.getX(),10);
			else if(e.getX() < 0 && e.getY() > 0)
				Rect.setSize(10,e.getY());
			else if(e.getY() < 0 && e.getX() < 0 )
				Rect.setSize(10,10);
			else if(e.getX() > EditorPane.getWidth()-firstX-5 && e.getY() > EditorPane.getHeight()-firstY-5)
				Rect.setSize(EditorPane.getWidth()-firstX-5,EditorPane.getHeight()-firstY-5);
			else if(e.getX() > EditorPane.getWidth()-firstX-5 && e.getY() < EditorPane.getHeight()-firstY-5)
				Rect.setSize(EditorPane.getWidth()-firstX-5,e.getY());
			else if(e.getX() < EditorPane.getWidth()-firstX-5 && e.getY() > EditorPane.getHeight()-firstY-5)
				Rect.setSize(e.getX(),EditorPane.getHeight()-firstY-5);			
			else 
				Rect.setSize(e.getX(),e.getY());
			Rect.removeAll();
			EditorPane.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
			new doSelect(rectInfo,AttributePane);
			EditorPane.repaint();
			AttributePane.showInfo(rectInfo);
		}
	}	

	public void mouseReleased(MouseEvent e) {
		if(Move_or_Size){
			this.x = Rect.getX()+e.getX()-firstgetX;
			this.y =  Rect.getY()+ e.getY()-firstgetY;
			if(this.x < 5)
				this.x = 5;
			else if(this.x+width+5 > EditorPane.getWidth())
				this.x = EditorPane.getWidth() - width-5;
			if(this.y < 5)
				this.y = 5;
			else if(this.y+height+5 > EditorPane.getHeight())
				this.y = EditorPane.getHeight() - height-5;
			Rect.setLocation(this.x,this.y);
			new doSelect(rectInfo,AttributePane);
			EditorPane.repaint();
			AttributePane.showInfo(rectInfo);
		}
		else{
			if(e.getY() < 0 && e.getX() > 0)
				Rect.setSize(e.getX(),10);
			else if(e.getX() < 0 && e.getY() > 0)
				Rect.setSize(10,e.getY());
			else if(e.getY() < 0 && e.getX() < 0 )
				Rect.setSize(10,10);
			else if(e.getX() > EditorPane.getWidth()-firstX-5 && e.getY() > EditorPane.getHeight()-firstY-5)
				Rect.setSize(EditorPane.getWidth()-firstX-5,EditorPane.getHeight()-firstY-5);
			else if(e.getX() > EditorPane.getWidth()-firstX-5 && e.getY() < EditorPane.getHeight()-firstY-5)
				Rect.setSize(EditorPane.getWidth()-firstX-5,e.getY());
			else if(e.getX() < EditorPane.getWidth()-firstX-5 && e.getY() > EditorPane.getHeight()-firstY-5)
				Rect.setSize(e.getX(),EditorPane.getHeight()-firstY-5);				
			else
				Rect.setSize(e.getX(),e.getY());
			new doSelect(rectInfo,AttributePane);
			EditorPane.repaint();
			EditorPane.setCursor(null);
			AttributePane.showInfo(rectInfo);
		}
	
	}
	
	public void mouseEntered(MouseEvent e) {
		EditorPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void mouseExited(MouseEvent e) {
		EditorPane.setCursor(null);
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
}

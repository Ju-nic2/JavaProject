package Control.Listeners;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Control.doSelect;
import Control.methods;
import Model.Model;
import Model.Rectangles;
import View.setAttributePane;

public class DrawRectListener implements MouseMotionListener,MouseListener{
	private static int x,y,width,height,tempX,tempY;
	protected static JLabel Rect;
	private JPanel EditorPane;
	protected JLabel cursorinfo;
	
	protected Rectangles[] RectInfo;
	protected Size_MoveListener[] size_MoveListener;
	protected Model storage;
	protected setAttributePane AttributePane;
	public DrawRectListener(JPanel EditorPane,setAttributePane attributePane,Model storage, Size_MoveListener[] size_MoveListener){
		this.EditorPane = EditorPane;
		this.storage = storage;
		this.RectInfo = storage.getRectBag();
		this.AttributePane = attributePane;
		this.size_MoveListener = size_MoveListener;
		Rect = RectInfo[storage.Rectcnt].getRect();
		
	}
	
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		tempX = x;
		tempY = y;
		Rect.setText("Edit Text here !");
		Rect.setName("Rect_"+storage.Rectcnt);
		cursorinfo = new JLabel();
		cursorinfo.setBounds(x, y,55,30);
		EditorPane.add(cursorinfo);
	}
	
	
	public void mouseDragged(MouseEvent e) {
		if(e.getX() > tempX && e.getY() > tempY){
			if(e.getX() < EditorPane.getWidth()-5 && e.getY() < EditorPane.getHeight()-5){
				width = e.getX() - x;
				height = e.getY() - y;
			}
			else if(e.getX() > EditorPane.getWidth()-5 && e.getY() < EditorPane.getHeight()-5){
				width = EditorPane.getWidth()-5 - x;
				height = e.getY() - y;
			}
			else if(e.getX() < EditorPane.getWidth()-5 && e.getY() > EditorPane.getHeight()-5){
				width = e.getX() - x;
				height =  EditorPane.getHeight()-5 - y;
			}
			else if(e.getX() > EditorPane.getWidth()-5 && e.getY() > EditorPane.getHeight()-5){
				width = EditorPane.getWidth()-5 - x;
				height =  EditorPane.getHeight()-5 - y;
			}
			cursorinfo.setLocation(e.getX(),e.getY()+3);
			cursorinfo.setText("("+width+","+height+")");
		}
		else if(e.getX() > tempX && e.getY() < tempY){
			if(e.getX() < EditorPane.getWidth()-5 && e.getY() > 5){
				width = e.getX() - x;
				height = tempY - e.getY();
				y = e.getY();
			}
			else if(e.getX() > EditorPane.getWidth()-5 && e.getY() > 5){
				width = EditorPane.getWidth() - x - 5;
				height = tempY - e.getY();
				y = e.getY();
			}
			else if(e.getX() < EditorPane.getWidth()-5 && e.getY() < 5){
				width = e.getX() - x;
				height = tempY-5;
				y = 5;
			}
			else if(e.getX() > EditorPane.getWidth()-5 && e.getY() < 5){
				width = EditorPane.getWidth() - x - 5;
				height = tempY-5;
				y = 5;
			}
			cursorinfo.setLocation(e.getX(),e.getY()-33);
			cursorinfo.setText("("+width+","+height+")");
		}
		else if(e.getX() < tempX && e.getY() > tempY){
			if(e.getX() > 5 && e.getY() < EditorPane.getHeight()-5){
				width = tempX - e.getX();
				height = e.getY() - y; 
				x = e.getX();
			}
			else if(e.getX() > 5 && e.getY() > EditorPane.getHeight()-5){
				width = tempX - e.getX();
				height =  EditorPane.getHeight()-5 - y; 
				x = e.getX();
			}
			else if(e.getX() < 5 && e.getY() < EditorPane.getHeight()-5){
				width = tempX - 5;
				height =  e.getY() - y; 
				x = 5;
			}
			else if(e.getX() < 5 && e.getY() > EditorPane.getHeight()-5){
				width = tempX - 5;
				height =  EditorPane.getHeight()-5 - y; 
				x = 5;
			}
			cursorinfo.setLocation(e.getX()-40,e.getY()+3);
			cursorinfo.setText("("+width+","+height+")");
		}
		else if(e.getX() < tempX && e.getY() < tempY){
			if(e.getX() > 5 && e.getY() > 5){
				width = tempX - e.getX();
				height = tempY - e.getY(); 
				x = e.getX();
				y = e.getY();
			}
			else if(e.getX() > 5 && e.getY() < 5){
				width = tempX - e.getX();
				height = tempY - 5;
				x = e.getX();
				y = 5;
			}
			else if(e.getX() < 5 && e.getY() > 5){
				width = tempX - 5;
				height = tempY - e.getY(); 
				x = 5;
				y = e.getY();
			}
			else if(e.getX() < 5 && e.getY() < 5){
				width = tempX - 5;
				height = tempY - 5; 
				x = 5;
				y = 5;
			}
			cursorinfo.setLocation(e.getX()-40,e.getY()-33);
			cursorinfo.setText("("+width+","+height+")");
		}
		Rect.setBounds(x, y, width, height);
		Rect.setBorder(new LineBorder(Color.black,2));
		EditorPane.add(Rect);
		AttributePane.showInfo(RectInfo[storage.Rectcnt]);
		EditorPane.repaint();
	}
	
	public void mouseReleased(MouseEvent e) {
		if(e.getX() > x && e.getY() > y){
			if(e.getX() < EditorPane.getWidth()-5 && e.getY() < EditorPane.getHeight()-5){
				width = e.getX() - x;
				height = e.getY() - y;
			}
			else if(e.getX() > EditorPane.getWidth()-5 && e.getY() < EditorPane.getHeight()-5){
				width = EditorPane.getWidth()-5 - x;
				height = e.getY() - y;
			}
			else if(e.getX() < EditorPane.getWidth()-5 && e.getY() > EditorPane.getHeight()-5){
				width = e.getX() - x;
				height =  EditorPane.getHeight()-5 - y;
			}
			else if(e.getX() > EditorPane.getWidth()-5 && e.getY() > EditorPane.getHeight()-5){
				width = EditorPane.getWidth()-5 - x;
				height =  EditorPane.getHeight()-5 - y;
			}
		}
		else if(e.getX() > x && e.getY() < y){
			if(e.getX() < EditorPane.getWidth()-5 && e.getY() > 5){
				width = e.getX() - x;
				height = tempY - e.getY();
				y = e.getY();
			}
			else if(e.getX() > EditorPane.getWidth()-5 && e.getY() > 5){
				width = EditorPane.getWidth() - x - 5;
				height = tempY - e.getY();
				y = e.getY();
			}
			else if(e.getX() < EditorPane.getWidth()-5 && e.getY() < 5){
				width = e.getX() - x;
				height = tempY-5;
				y = 5;
			}
			else if(e.getX() > EditorPane.getWidth()-5 && e.getY() < 5){
				width = EditorPane.getWidth() - x - 5;
				height = tempY-5;
				y = 5;
			}
		}
		else if(e.getX() < x && e.getY() > y){
			if(e.getX() > 5 && e.getY() < EditorPane.getHeight()-5){
				width = tempX - e.getX();
				height = e.getY() - y; 
				x = e.getX();
			}
			else if(e.getX() > 5 && e.getY() > EditorPane.getHeight()-5){
				width = tempX - e.getX();
				height =  EditorPane.getHeight()-5 - y; 
				x = e.getX();
			}
			else if(e.getX() < 5 && e.getY() < EditorPane.getHeight()-5){
				width = tempX - 5;
				height =  e.getY() - y; 
				x = 5;
			}
			else if(e.getX() < 5 && e.getY() > EditorPane.getHeight()-5){
				width = tempX - 5;
				height =  EditorPane.getHeight()-5 - y; 
				x = 5;
			}
		}
		else if(e.getX() < x && e.getY() < y){
			if(e.getX() > 5 && e.getY() > 5){
				width = tempX - e.getX();
				height = tempY - e.getY(); 
				x = e.getX();
				y = e.getY();
			}
			else if(e.getX() > 5 && e.getY() < 5){
				width = tempX - e.getX();
				height = tempY - 5;
				x = e.getX();
				y = 5;
			}
			else if(e.getX() < 5 && e.getY() > 5){
				width = tempX - 5;
				height = tempY - e.getY(); 
				x = 5;
				y = e.getY();
			}
			else if(e.getX() < 5 && e.getY() < 5){
				width = tempX - 5;
				height = tempY - 5; 
				x = 5;
				y = 5;
			}
		}

		Rect.setBounds(x, y, width, height);
		Rect.setBorder(new LineBorder(Color.black,2));
		Rect.setOpaque(true);
		RectInfo[storage.Rectcnt].setType("JLabel");
		EditorPane.add(Rect);
		EditorPane.remove(cursorinfo);
		if(RectInfo[storage.Rectcnt] != null)
			storage.Rectcnt++;
		for(int i = 0 ; i < storage.Rectcnt ; i++){
			size_MoveListener[i] = new Size_MoveListener(EditorPane,AttributePane,RectInfo[i]);
			RectInfo[i].getRect().addMouseListener(size_MoveListener[i]);
			RectInfo[i].getRect().addMouseMotionListener(size_MoveListener[i]);	
		}
		EditorPane.repaint();
		EditorPane.setCursor(null);
		width = 0;
		height = 0;
		EditorPane.removeMouseListener(this);
		EditorPane.removeMouseMotionListener(this);
		methods.isdrawed = false;
		AttributePane.showInfo(RectInfo[storage.Rectcnt-1]);
		new doSelect(RectInfo[storage.Rectcnt-1],AttributePane);
	}
	
	
	public void mouseEntered(MouseEvent e) {
		EditorPane.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	}
	public void mouseMoved(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
}

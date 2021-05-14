package Model;

import javax.swing.JLabel;

public class Rectangles{
	private String type,Color = "Default";
	private JLabel Rect;

	Rectangles(){
		Rect = new JLabel();
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	public JLabel getRect(){
		return Rect;
	}
	public void setColor(String Color){
		this.Color = Color;
	}
	public String getColor(){
		return Color;
	}
	public void setRect(JLabel Rect){
		this.Rect = Rect;
	}
}

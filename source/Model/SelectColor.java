package Model;

import java.awt.Color;
public class SelectColor 
{
	private Color[] ColorInfo = new Color[8];
	public void setColors()
	{
		
		ColorInfo[0]=(Color.GREEN);
		ColorInfo[1]=(Color.PINK);
		ColorInfo[2]=(Color.RED);
		ColorInfo[3]=(Color.orange);
		ColorInfo[4]=(Color.YELLOW);
		ColorInfo[5]=(Color.BLUE);
		ColorInfo[6]=(Color.CYAN);
		ColorInfo[7]=(Color.DARK_GRAY);
		
		
	}
	public Color useColor(int Index_number)
	{
		return ColorInfo[Index_number];
	}
	
}
package Model;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ManageLabel 
{
	//private ManageLabel[] ManageLB =new ManageLabel[100];
	public static int LabelCount=0;
	private static int Index_number;
	private JLabel EditLabel;
	private LocationInfo []LocInfo;
	private boolean Connected[]= new boolean[4];
	private ManageLabel Parent;
	private int nodeLevel;
	private int preLevel;
	
	public void setParent(ManageLabel parent) {this.Parent=parent;}
	public ManageLabel getParent() { return Parent;}
	public JLabel getLabels() {return EditLabel;}
	
	public JLabel setLabel(String word)
	{
		EditLabel = new JLabel();
		EditLabel.setText(word);
		EditLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		LocInfo = new LocationInfo[4];
		
		return EditLabel;
		
	}
	public static void resetCount(int num) {LabelCount=num;	}
	public void setLabelCount(int Index_number)
	{
		ManageLabel.Index_number=Index_number;
		if(Index_number>=LabelCount)
		LabelCount=Index_number;
	}
	
	public void setPreLevel(int preLevel)
	{
		this.preLevel=preLevel;
	}
	
	public void setNodeLevel(int nodeLevel)
	{
		System.out.print("µé¾î°¨");

		this.nodeLevel = nodeLevel;
	}
	
	public int getPreLevel()
	{
		return preLevel;
	}
	
	public int getNodeLevel()
	{
		return nodeLevel;
	}
	
	
	public int getLabelCount() 
	{
		return LabelCount;
	}
	
	public int getIndexNumber()
	{
		return Index_number;
	}
	
	public void setLocInfo(JLabel Info)
	{	
		for(int i=0;i<4;i++)	
		{
			LocInfo[i]=new LocationInfo();
			Connected[i] = false;
		}
		
		LocInfo[0].setLocInfo(Info);
	}
	public LocationInfo[] getInfo()	{return LocInfo;	}
	
	public int getVal(int i,int j)
	{
		return LocInfo[i].Pos[j];
	}
	public void setConnected(int index_number,boolean set){ Connected[index_number] = set;}
	public boolean getConnected(int index_number){return Connected[index_number];}
	public void ResetConnected() {for(int i=0;i<4;i++)Connected[i]=false;}
	class LocationInfo
	{
		
		int []Loc1 = new int[2];	//(X+width)/2 , Y
		int []Loc2 = new int[2];	//(X+width)   , (Y-height)/2
		int []Loc3 = new int[2];	//(X+width)/2 , Y-heigth
		int []Loc4_= new int[2];	//X			  ,	(Y-height)/2
		int []Pos= new int[2];
		
		
		
		public void setLocInfo(JLabel Info)
		{
			//LocInfo[][] = new LocationInfo[4][2];
			
			LocInfo[0].Pos[0] = Info.getX()+Info.getWidth()/2;
			LocInfo[0].Pos[1] = Info.getY();
			
			LocInfo[1].Pos[0] = Info.getX()+Info.getWidth();
			LocInfo[1].Pos[1] = Info.getY()+Info.getHeight()/2;
			
			LocInfo[2].Pos[0]= Info.getX() + Info.getWidth() /2;
			LocInfo[2].Pos[1]= Info.getY() + Info.getHeight() ;
			
			LocInfo[3].Pos[0] = Info.getX();
			LocInfo[3].Pos[1] = Info.getY() + Info.getHeight() /2;
		}
		
	}

}
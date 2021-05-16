package View;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Control.MakeAttribute;
import Model.ManageLabel;
import Model.SelectColor;
import Model.Tree;

public class MindMapPane extends JFrame
{
  private static final int CENTER = 0;
// private JPanel MindMapPanePanel;
   private JTextField MindMapPaneText_Title;
   private JScrollPane MindMapPaneScrollPane;
   private MakeAttribute Action2;
   private ManageLabel []Label;
   private SelectColor COLOR = new SelectColor();
   private MyPanel myPanel = new MyPanel();
 
   private Color tempColor;
   
   public class MyPanel extends JPanel
	{
	   private ManageLabel Arry[];
	   private ManageLabel start,end;
		
	   
	   int start_x,start_y;
	   int mid_x,mid_y;
	   int end_x,end_y;		
	   int index_i,index_j;
	   int []poly_x = new int[3];
	   int []poly_y = new int[3];
		
	   boolean drawStart= false;
		
		public void setPoint(ManageLabel arry[])
		{
			Arry=arry;
			drawStart= true;
		}
		public void setDraw(boolean start) { drawStart=start;}
		public void paintComponent(Graphics g)
		{
		
			Graphics2D g2 = (Graphics2D) g;
			super.paintComponent(g2);
			
			if(drawStart)		
			{	
				for(int i=1;i<=ManageLabel.LabelCount;i++)			
				{			
				//	System.out.println("DrawText["+i+"]: "+Arry[i].getLabels().getText());
					start=Arry[i];
					end=Arry[i].getParent();
					calcDist();
					calPoly();
					calMidPoint();
					//System.out.println("start_x: "+start.getLabels().getX()+"start_y"+start.getLabels().getY());
					//System.out.println("end_x: "+end.getLabels().getX()+"end_y"+end.getLabels().getY());
					
					
					QuadCurve2D.Double curve1 =new QuadCurve2D.Double(start_x,start_y,mid_x,mid_y,end_x,end_y);
					 
					Line2D drawline = new Line2D.Double(start_x,start_y,end_x,end_y);
					 Shape arrowHead = createArrowHead(drawline, 5, 14);
				
					g2.draw(curve1);
			
					g2.fill(arrowHead);
				}
				for(int i=0;i<=Label[0].getLabelCount();i++) {Label[i].ResetConnected();}
			}
			
			
		}
		private Shape createArrowHead(Line2D line, double length, double width)
	    {
	        Point2D p0 = line.getP1();
	        Point2D p1 = line.getP2();
	        double x0 = p0.getX();
	        double y0 = p0.getY();
	        double x1 = p1.getX();
	        double y1 = p1.getY();
	        double dx = x1 - x0;
	        double dy = y1 - y0;
	        double invLength = 1.0 / Math.sqrt(dx*dx+dy*dy);
	        double dirX = dx * invLength;
	        double dirY = dy * invLength;
	        double ax = x1 - length * dirX;
	        double ay = y1 - length * dirY;
	        double offsetX = width * -dirY * 0.5;
	        double offsetY = width * dirX * 0.5;
	        double c0x = ax + offsetX;
	        double c0y = ay + offsetY;
	        double c1x = ax - offsetX;
	        double c1y = ay - offsetY;
	        Path2D arrowHead = new Path2D.Double();
	        arrowHead.moveTo(x1, y1);
	        arrowHead.lineTo(c0x, c0y);
	        arrowHead.lineTo(c1x, c1y);
	        arrowHead.closePath();
	        return arrowHead;
	    }
		public void calMidPoint()
		{
			if(end_x>=start_x)
			{
				mid_x=start_x+Math.abs(end_x-start_x)/5*1;
				if(end_y>=start_y)
				{
					mid_y=start_y+Math.abs(start_y-end_y)/10*9;
				}
				else
				{
					mid_y=start_y-Math.abs(start_y-end_y)/10*9;
				}
			}
			else
			{
				mid_x=start_x-Math.abs(end_x-start_x)/5*1;
				if(end_y>=start_y)
				{
					mid_y=start_y+Math.abs(start_y-end_y)/10*9;
				}
				else
				{
					mid_y=start_y-Math.abs(start_y-end_y)/10*9;
				}
			}
			
			System.out.println("mid_x: "+mid_x+" mid_y: "+mid_y);
		}
		public void calcDist()
		{
			long min=10000000,result=0;
			drawStart=true;
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<4;j++)
				{
				//	System.out.println("x1 : "+start.getVal(i, 0)+" y1: "+end.getVal(j, 0)+ " x2: "+ end.getVal(i, 1) +" y2: "+end.getVal(j, 1));
					result=(long) Math.sqrt( Math.pow(start.getVal(i, 0)-end.getVal(j, 0),2) + Math.pow(start.getVal(i, 1) -end.getVal(j, 1),2));
					//System.out.println(result);
					//result=(long) Math.sqrt(start.getVal(i, 0)-end.getVal(j, 0) + start.getVal(i, 1) -end.getVal(j, 1));
					if(result<min && start.getConnected(i)==false &&end.getConnected(j)==false )
					{
						min=result;
						start_x=start.getVal(i, 0);
						start_y=start.getVal(i, 1);
						end_x=end.getVal(j, 0);
						end_y=end.getVal(j, 1);
						index_i=i;index_j=j;
					}
				}
			}
			
			
			start.setConnected(index_i, true);
			end.setConnected(index_j, true);
		}
		public void calPoly()
		{
			
			poly_x[0]=end_x-5; poly_x[1]=end_x; poly_x[2]=poly_x[0]+2;
			poly_y[0]=end_y-end.getLabels().getHeight()/2; poly_y[1]=end_y; poly_y[2]= poly_y[0]-end.getLabels().getHeight()/4;
			
		}
	}
   
   public MindMapPane(JSplitPane SplitPaneMiddle)
   {
	   
	   Border line =BorderFactory.createLineBorder(Color.black);
	  myPanel.setLayout(null);
	  myPanel.setPreferredSize(new Dimension(1000,1000));
      
      MindMapPaneText_Title = new JTextField("Mind Map Pane");
      MindMapPaneText_Title.setHorizontalAlignment(CENTER);
      MindMapPaneText_Title.setBorder(line);
      MindMapPaneText_Title.setBackground(Color.decode("0xCCCC66"));
      
      
      MindMapPaneText_Title.setEditable(false);
      MindMapPaneText_Title.setBounds(180, 0,250, 30);
      myPanel.add(MindMapPaneText_Title);
      
      MindMapPaneScrollPane = new JScrollPane(myPanel);
      MindMapPaneScrollPane.setSize(1000,1000);
     
      
      SplitPaneMiddle.setRightComponent(MindMapPaneScrollPane);
      COLOR.setColors();
      
   }
   public ManageLabel[] getManageLabel() {return Label;}
   public MyPanel getPanel()	{ return myPanel;}
   public void resetPanel()
	{
		myPanel.removeAll();
		myPanel.add(MindMapPaneText_Title);
		myPanel.repaint();
	}
  
	public void get_Action2(MakeAttribute Action2,ManageLabel []Label)
	{
		this.Label =Label;
		this.Action2 = Action2;
	}
	public void add_Action2()
	{
		//myPanel.addMouseListener(Action2);
	}

	public void AddLabel(String TextRead,int TextWordCount,ManageLabel []Label)	
	{
	      Tree TextTree = new Tree();
	      String AddTextRead= TextRead;
	      int j=0;
	      int tabsize=0;
	      int pretabsize = 0;
	      this.Label=Label;
	      
	      myPanel.removeAll();
	      
	      for(int i=0;i<AddTextRead.length();i++)
	      {   
	         
	         if(AddTextRead.charAt(i)=='\t')
	            ++tabsize;
	         if(AddTextRead.charAt(i)=='\n')
	         {
	            if(tabsize>TextTree.getTreeLevel())
	               TextTree.setTreeLevel(tabsize);
	            System.out.println("word: "+AddTextRead.substring(j,i));
	            System.out.println("tabsize: "+tabsize);
	            if(tabsize==0) 
	            {
	               TextTree=TextTree.InsertNode(AddTextRead.substring(j+tabsize,i), tabsize,0);
	               pretabsize = tabsize;
	            }
	            else 
	            {
	               TextTree=TextTree.InsertNode(AddTextRead.substring(j+tabsize,i), tabsize,pretabsize);
	               pretabsize = tabsize;
	            }
	            tabsize=0;
	            j=i+1;
	         }
	         
	      }
	     // System.out.println("samemaxlevel: "+TextTree.SameMaxLevel);
	      AddLabel2Map(TextTree,myPanel,Action2);
	  
	}
	public MakeAttribute getAction()
	{
		return Action2;
	}
	
	public void Open_AddLabel2Map(ManageLabel[] Label)
	{
		Border blackline  = BorderFactory.createLineBorder(Color.black);
		this.Label=Label;
		myPanel.removeAll();
		myPanel.revalidate();
		
		for(int i=0;i<=Label[0].getLabelCount();i++)
		{
			Label[i].getLabels().setOpaque(true);
	         Label[i].getLabels().addMouseListener(Action2);
	         Label[i].getLabels().addMouseMotionListener(Action2);
			Label[i].getLabels().setBorder(blackline);
	//		 System.out.println("W: "+Label[i].getLabels().getWidth()+"H: "+Label[i].getLabels().getHeight());
			 myPanel.add(Label[i].getLabels());
	//		 System.out.println("W: "+Label[i].getLabels().getWidth()+"H: "+Label[i].getLabels().getHeight());
		}
		myPanel.setPoint(Label);
		for(int i=0;i<=Label[0].getLabelCount();i++) {Label[i].ResetConnected();}
		myPanel.add(MindMapPaneText_Title);
		myPanel.repaint();
	}
	public void AddLabel2Map(Tree TextTree,MyPanel myPanel,MakeAttribute Action2)
	{
		
		
		Label[0]= new ManageLabel();
		ManageLabel.resetCount(0);
		int Index_number=0;
		int level=0;
		boolean drawLine= false,sameLine=false;
		System.out.println("TreeLevel: "+ TextTree.getTreeLevel());
		TextTree.PrintNode2Map(Label,Action2,0,TextTree.getRoot(),null,COLOR,level,myPanel,drawLine,sameLine);
		System.out.println("index_nuber: "+Index_number);
		
		
		System.out.println("lableC"+Label[0].getLabelCount());
		for(int i=0;i<=Label[0].getLabelCount();i++)
		{
		
			System.out.println(Label[i].getLabels().getText());
			myPanel.add(Label[i].getLabels());
			
				
		}
		myPanel.setPoint(Label);
		for(int i=0;i<=Label[0].getLabelCount();i++) {Label[i].ResetConnected();}
		
		MindMapPaneScrollPane.repaint();	
		myPanel.add(MindMapPaneText_Title);
		
		
		
	}
	
	public void SetLabel(JLabel label,Color tempColor)
	{
		this.tempColor=tempColor;
		for(int i=0;i<=ManageLabel.LabelCount;i++) {Label[i].ResetConnected();  Label[i].setLocInfo(Label[i].getLabels());}
		myPanel.add(label);
		myPanel.setPoint(Label);
		myPanel.repaint();
		myPanel.add(MindMapPaneText_Title);
		
		System.out.println("setlabel");
		for(int i=0;i<=Label[0].getLabelCount();i++)
		{
		//	System.out.println("변경된 라벨값: " +Label[i].getLabels().getX()+"  "+Label[i].getLabels().getY()+"  "+Label[i].getLabels().getWidth()+"  "+Label[i].getLabels().getHeight());
			
		}
		
	}
	public void getBackColor() { Action2.getBackColor();}
		

	
}
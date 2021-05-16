package DrawLine;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.ManageLabel;
import View.MindMapPane;



public class DrawLine extends JPanel
	{
		private ManageLabel start,end;
		int start_x,start_y;
		int end_x,end_y;
		
		public void setPoint(ManageLabel start,ManageLabel end)
		{
			this.start=start;
			this.end =end;
		}
		@Override
		public void paintComponent(Graphics g)
		{
			calcDist();
			//System.out.println("그려주라2222");
			//TODO Auto-generated method stub
			super.paintComponent(g);
		//	g.drawLine(0,0,20,20);
			System.out.println(start_x+"   "+start_y+"    "+end_x+"    "+end_y);
			System.out.println("start 라벨 : "+start.getLabels().getText());
			System.out.println("end 라벨 : "+end.getLabels().getText());
			//g.drawLine(start.getLabels().getX(),start.getLabels().getY(),end.getLabels().getX(),end.getLabels().getY());
			g.drawLine(start_x,start_y,end_x,end_y);
			g.setColor(Color.BLUE);
			//System.out.println("그려주라2222");
		}
		public void calcDist()
		{
			long min=10000000,result=0;
	
			for(int i=0;i<4;i++)
			{
				for(int j=i+1;j<4;j++)
				{
					System.out.println("x1 : "+start.getVal(i, 0)+"y1: "+end.getVal(j, 0)+ "x2: "+ start.getVal(i, 1) +"y2: "+end.getVal(j, 1));
					result=(long) Math.sqrt( Math.pow(start.getVal(i, 0)-end.getVal(j, 0),2) + Math.pow(start.getVal(i, 1) -end.getVal(j, 1),2));
					System.out.println(result);
					//result=(long) Math.sqrt(start.getVal(i, 0)-end.getVal(j, 0) + start.getVal(i, 1) -end.getVal(j, 1));
					if(result<min)
					{
						System.out.println("어디4");
						min=result;
						start_x=start.getVal(i, 0);
						start_y=start.getVal(i, 1);
						end_x=end.getVal(j, 0);
						end_y=end.getVal(j, 1);
					}
				}
			}
		}
	
	}
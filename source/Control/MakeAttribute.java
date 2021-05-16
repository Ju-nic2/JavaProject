package Control;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import Model.ManageLabel;
import View.AttributePane;
import View.MindMapPane;

public class MakeAttribute implements ActionListener, MouseListener,MouseMotionListener
{

	private MindMapPane MINDMAPPANE;
	private AttributePane ATTRIBUTEPANE;
	private int X,Y,W,H;
	private int first_X,first_Y;
	private boolean NodeSizeChange=false;
	private JLabel ReadLabel;
	private JLabel prevReadLabel;
	private JLabel vertex_Left,vertex_Right,vertex_BottomLeft, vertex_BottomRight;
	private int vertex_number=0;//1.좌상 2.우상 3.우하 4.좌
	private Color prevColor=null;
	private ManageLabel[] manageLabel;
	public MakeAttribute(MindMapPane MINDMAPPANE,AttributePane ATTRIBUTEPANE,ManageLabel []LABEL)
	{
		this.MINDMAPPANE = MINDMAPPANE;
		this.ATTRIBUTEPANE=ATTRIBUTEPANE;
	}
	protected void event_Exit()
	{
			System.exit(0);
	}
	protected void add_Vertex_Label()
	{
		System.out.println("addvertexLabel: "+Integer.toHexString(ReadLabel.getBackground().getRGB()) );
		if(prevColor !=null)
		{
			prevReadLabel.setBackground(prevColor);
			prevReadLabel.removeAll();	
		}
		prevColor=ReadLabel.getBackground();
		ReadLabel.setBackground(Color.GRAY);
		Border redline=BorderFactory.createLineBorder(Color.YELLOW);
		
		if( ReadLabel != null)
		{ 
			
			JLabel vertex_Left = new JLabel();
			JLabel vertex_Right = new JLabel();
			JLabel vertex_BottomLeft = new JLabel();
			JLabel vertex_BottomRight = new JLabel();
			
			
			
			vertex_Left.setBorder(redline);
			vertex_Left.setBounds(0, 0, 7, 7);
			vertex_Left.setBackground(Color.YELLOW);
			vertex_Left.setOpaque(true);
			ReadLabel.add(vertex_Left);
			
			vertex_Right.setBorder(redline);
			vertex_Right.setBounds(ReadLabel.getWidth()-7, 0, 7, 7);
			vertex_Right.setBackground(Color.YELLOW);
			vertex_Right.setOpaque(true);
			ReadLabel.add(vertex_Right);
			
			vertex_BottomLeft.setBorder(redline);
			vertex_BottomLeft.setBounds(ReadLabel.getWidth()-7, ReadLabel.getHeight()-7, 7, 7);
			vertex_BottomLeft.setBackground(Color.YELLOW);
			vertex_BottomLeft.setOpaque(true);
			ReadLabel.add(vertex_BottomLeft);

			vertex_BottomRight.setBorder(redline);
			vertex_BottomRight.setBounds(0, ReadLabel.getHeight()-7, 7, 7);
			vertex_BottomRight.setBackground(Color.YELLOW);
			vertex_BottomRight.setOpaque(true);
			ReadLabel.add(vertex_BottomRight);
			
			
			prevReadLabel=ReadLabel;
	
			this.vertex_Left = vertex_Left;
			this.vertex_Right = vertex_Right;
			this.vertex_BottomLeft = vertex_BottomLeft;
			this.vertex_BottomRight = vertex_BottomRight;
		// TODO Auto-genera ted method stub
		}
	}
	
	void setLabelBounds()
	{
		System.out.println("vertex_number:"+vertex_number);
		if(vertex_number==1)
		{
			if(X>=ReadLabel.getWidth())//x가 기존값 보다 마이너스가될때 
			{
					ReadLabel.setLocation(ReadLabel.getX(), ReadLabel.getY()+Y);
					ReadLabel.setSize(X,ReadLabel.getHeight()-Y);
			}
			else if(X<ReadLabel.getWidth())//x평
			{
				
				
				if(Y>=ReadLabel.getHeight())
				{
					ReadLabel.setBounds(ReadLabel.getX()+X, ReadLabel.getY(),ReadLabel.getWidth()-X,Y);
				}
				else
				{
					ReadLabel.setLocation(ReadLabel.getX()+X, ReadLabel.getY()+Y);			
					ReadLabel.setSize( ReadLabel.getWidth()-X, ReadLabel.getHeight()-Y);
				}
			}
		}
		else if(vertex_number==2)
		{
			if(X>0)
			{
			
				ReadLabel.setLocation(ReadLabel.getX(), ReadLabel.getY()+Y);			
				ReadLabel.setSize(X,ReadLabel.getHeight()-Y);
			}
			else
			{
				vertex_number=1;
			}
		}
		else if(vertex_number==3)
		{
			ReadLabel.setBounds(ReadLabel.getX(), ReadLabel.getY(),X,Y);
		}
		else if(vertex_number==4)
		{
			ReadLabel.setBounds(ReadLabel.getX()+X, ReadLabel.getY(),ReadLabel.getWidth()-X,Y);
		}
		
	}
	public void getBackColor() { if(prevColor!=null) {ReadLabel.setBackground(prevColor); ReadLabel.removeAll();}}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String ButtonPressed = e.getActionCommand();
		
		if(ButtonPressed.equals("변경"))
		{
			
			ATTRIBUTEPANE.SetInfo(ReadLabel);//정보를 읽고
			prevColor=ReadLabel.getBackground();
			add_Vertex_Label();
			System.out.println("변경 color:"+ReadLabel.getBackground());
			MINDMAPPANE.SetLabel(ReadLabel,prevColor);
		}
		
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) //클릭시 라벨의 정보를 읽
	{		System.out.println("어디냐4");
		// TODO Auto-genera ted method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		
		ReadLabel=(JLabel) e.getSource();
		add_Vertex_Label();
		
		
		first_X=e.getX(); first_Y=e.getY();
		
		X=ReadLabel.getX(); Y=ReadLabel.getY(); W=ReadLabel.getWidth(); H=ReadLabel.getHeight();
		System.out.println(first_X+" "+first_Y+"  "+W+"  "+H);
		System.out.println("클릭했을떄 좌표값:" +X+"  "+Y);
		
		
		if(first_X<=vertex_Left.getWidth() && first_Y<=vertex_Left.getHeight())
		{
			NodeSizeChange=true;
			System.out.println("true");					
			vertex_number=1;
		}
		else if( (first_X<= ReadLabel.getWidth() && (first_X >=ReadLabel.getWidth()-vertex_Right.getWidth()) )&& (first_Y<=vertex_Right.getHeight() ))
		{
			NodeSizeChange=true;
			vertex_number=2;
		}
		else if((first_X<= ReadLabel.getWidth() && (first_X >=ReadLabel.getWidth()-vertex_BottomRight.getWidth()) ) && ( (first_Y<=ReadLabel.getHeight() && first_Y>=ReadLabel.getHeight() -vertex_BottomRight.getHeight())  ))
		{
			NodeSizeChange=true;		
			vertex_number=3;
		}
		else if( (first_X<=vertex_BottomLeft.getWidth()) && ((first_Y<=ReadLabel.getHeight() && first_Y>=ReadLabel.getHeight() -vertex_BottomLeft.getHeight())) )
		{
			NodeSizeChange=true;
			vertex_number=4;
		}
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
			
		if(X!=0 &&Y!=0 && NodeSizeChange ==false)
		{
			System.out.println("MouseReleased");
			System.out.println("x,y값 확인"+ReadLabel.getX() +ReadLabel.getY());
			ATTRIBUTEPANE.ReadInfo(ReadLabel.getText(),ReadLabel.getX(),ReadLabel.getY(),ReadLabel.getWidth(),ReadLabel.getHeight(),prevColor);
			MINDMAPPANE.SetLabel(ReadLabel,prevColor);
			
			this.X=0;
			this.Y=0;
			vertex_number=0;
		}
		else if(NodeSizeChange)
		{
			System.out.println("ChangeSize");
			ATTRIBUTEPANE.ReadInfo(ReadLabel.getText(),ReadLabel.getX(),ReadLabel.getY(),ReadLabel.getWidth(),ReadLabel.getHeight(),prevColor);	
			MINDMAPPANE.SetLabel(ReadLabel,prevColor);
			//ReadLabel.setBackground(prevColor);//색원상복구
			this.X=0;
			this.Y=0;
			NodeSizeChange=false;
			
		}
		
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		MINDMAPPANE.getPanel().setCursor(new Cursor(Cursor.MOVE_CURSOR));
		if(NodeSizeChange)
		{
			this.X=e.getX();		
			this.Y=e.getY();		
			System.out.println("X: "+X+"Y:"+Y);
			ReadLabel=(JLabel) e.getSource();
			setLabelBounds();
			add_Vertex_Label();
			
			System.out.println("LOCATION: "+ReadLabel.getLocation());
			ReadLabel.setBackground(Color.GRAY);
			MINDMAPPANE.SetLabel(ReadLabel,prevColor);
			ATTRIBUTEPANE.ReadInfo(ReadLabel.getText(),ReadLabel.getX(),ReadLabel.getY(),ReadLabel.getWidth(),ReadLabel.getHeight(),prevColor);
		
		}
		else
		{
			this.X=e.getX();		
			this.Y=e.getY();	
			System.out.println("X: "+X+"Y:"+Y);
			ReadLabel=(JLabel) e.getSource();
			ReadLabel.setLocation(ReadLabel.getX()+X-first_X, ReadLabel.getY()+Y-first_Y);
			ReadLabel.setSize(ReadLabel.getWidth(), ReadLabel.getHeight());
			ReadLabel.setBackground(Color.GRAY);
			MINDMAPPANE.SetLabel(ReadLabel,prevColor);	
			ATTRIBUTEPANE.ReadInfo(ReadLabel.getText(),ReadLabel.getX(),ReadLabel.getY(),ReadLabel.getWidth(),ReadLabel.getHeight(),prevColor);
			
		}
	
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	

}
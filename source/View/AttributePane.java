package View;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Control.MakeAttribute;

public class AttributePane {

	private static final int CENTER = 0;
	private JPanel AttributePanePanel;
	private JPanel AttributePanePanel_Base;
	private JScrollPane AttributPaneScrollPane;
	private JTextField AttributePaneText_Title;
	private JTextField AttributePaneText_Text;
	private JTextField AttributePaneText_X;
	private JTextField AttributePaneText_Y;
	private JTextField AttributePaneText_W;
	private JTextField AttributePaneText_H;
	private JTextField AttributePaneText_color;
	
	private JLabel AttributeLabel_Text;
	private JLabel AttributeLabel_X;
	private JLabel AttributeLabel_Y;
	private JLabel AttributeLabel_W;
	private JLabel AttributeLabel_H;
	private JLabel AttributeLabel_color;
	
	private JButton AttributeLabelButton;
	
	private MakeAttribute Action2;
	
	//private ManageLabel EditLabel;
	
	public void setAttributePane(JSplitPane SplitPaneRight)
	{
		 Border line =BorderFactory.createLineBorder(Color.black);
		 
		AttributePanePanel = new JPanel();
		AttributePanePanel.setLayout(null);
		AttributePanePanel.setBackground(Color.orange);
		AttributePanePanel.setBounds(0, 0, 250, 600);
		
		AttributePaneText_Title = new JTextField("Attribute Pane");
		AttributePaneText_Title.setHorizontalAlignment(CENTER);
		AttributePaneText_Title.setBackground(Color.decode("0xCCCC66"));
		AttributePaneText_Title.setBorder(line);
		AttributePaneText_Title.setEditable(false);
		AttributePaneText_Title.setBounds(0, 0, 237, 30);
		
		AttributePaneText_Text= new JTextField("Text");
		AttributePaneText_Text.setHorizontalAlignment(CENTER);
		AttributePaneText_Text.setBorder(line);
		AttributePaneText_Text.setEditable(false);
		AttributePaneText_Text.setBounds(100, 63, 130, 35);
		
		AttributePaneText_X = new JTextField("X");
		AttributePaneText_X.setBorder(line);
		AttributePaneText_X.setHorizontalAlignment(CENTER);
		AttributePaneText_X.setBounds(100,137,130,35);
		
		AttributePaneText_Y = new JTextField("Y");
		AttributePaneText_Y.setBorder(line);
		AttributePaneText_Y.setHorizontalAlignment(CENTER);
		AttributePaneText_Y.setBounds(100,210,130,35);
		
		AttributePaneText_W = new JTextField("W");
		AttributePaneText_W.setBorder(line);
		AttributePaneText_W.setHorizontalAlignment(CENTER);
		AttributePaneText_W.setBounds(100,282,130,35);
		
		AttributePaneText_H= new JTextField("H");
		AttributePaneText_H.setBorder(line);
		AttributePaneText_H.setHorizontalAlignment(CENTER);
		AttributePaneText_H.setBounds(100, 357, 130, 35);
		
		AttributePaneText_color = new JTextField("color");
		AttributePaneText_color.setBorder(line);
		AttributePaneText_color.setHorizontalAlignment(CENTER);
		AttributePaneText_color.setBounds(100,430,130,35);
		
		
		AttributePanePanel.add(AttributePaneText_Title);
		AttributePanePanel.add(AttributePaneText_Text);
		AttributePanePanel.add(AttributePaneText_X);
		AttributePanePanel.add(AttributePaneText_Y);
		AttributePanePanel.add(AttributePaneText_W);
		AttributePanePanel.add(AttributePaneText_H);
		AttributePanePanel.add(AttributePaneText_color);
		AttributePanePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		AttributeLabel_Text =new JLabel("TEXT:");
		AttributeLabel_Text.setBounds(20, 63, 90, 35);
		
		AttributeLabel_X =new JLabel("X:");
		AttributeLabel_X.setBounds(20,137,90,35);
		
		AttributeLabel_Y =new JLabel("Y:");
		AttributeLabel_Y.setBounds(20, 210, 90, 35);
		
		AttributeLabel_W =new JLabel("W:");
		AttributeLabel_W.setBounds(20, 282, 90, 35);
		
		AttributeLabel_H =new JLabel("H:");
		AttributeLabel_H.setBounds(20,357,90,35);
		
		AttributeLabel_color =new JLabel("color:");
		AttributeLabel_color.setBounds(20, 430, 90,35);

		
		AttributePanePanel.add(AttributeLabel_Text);
		AttributePanePanel.add(AttributeLabel_X);
		AttributePanePanel.add(AttributeLabel_Y);
		AttributePanePanel.add(AttributeLabel_W);
		AttributePanePanel.add(AttributeLabel_H);
		AttributePanePanel.add(AttributeLabel_color);
		
		AttributeLabelButton = new JButton();
		AttributeLabelButton.setText("º¯°æ");
		AttributeLabelButton.setBounds(10,469,210, 40);
		AttributeLabelButton.setBackground(Color.decode("0xCCCC66"));
		AttributeLabelButton.setOpaque(true);
		AttributeLabelButton.setBorder(line);
		AttributePanePanel.add(AttributeLabelButton);
		
		AttributPaneScrollPane = new JScrollPane(AttributePanePanel);
		AttributPaneScrollPane.setBounds(0,0,250,600);
		
		AttributePanePanel_Base = new JPanel();
		AttributePanePanel_Base.setLayout(null);
		AttributePanePanel_Base.add(AttributPaneScrollPane);
		
	
		
		SplitPaneRight.setBackground(Color.ORANGE);
		SplitPaneRight.setRightComponent(AttributePanePanel_Base);
		
		
	}
	public void get_Action2(MakeAttribute Action2)
	{
		this.Action2 = Action2;
	}
	public void add_Action2()
	{
		AttributeLabelButton.addActionListener(Action2);
	}
	
	public void ReadInfo(String Text,int X,int Y,int W,int H,Color color)
	{
		System.out.println("attribute:"+X);
		AttributePaneText_Text.setText(Text);
		AttributePaneText_Text.setBackground(Color.GRAY);
		AttributePaneText_X.setText(String.valueOf(X));
		AttributePaneText_Y.setText(String.valueOf(Y));
		AttributePaneText_W.setText(String.valueOf(W));
		AttributePaneText_H.setText(String.valueOf(H));
		AttributePaneText_color.setText( Integer.toHexString(color.getRGB()).substring(2));
		AttributePanePanel.repaint();

	}

	public void SetInfo(JLabel EditLabel)
	{
		System.out.println("setinfo");
		System.out.println(Integer.parseInt(AttributePaneText_X.getText()));
		
		EditLabel.setBounds(Integer.parseInt(AttributePaneText_X.getText()), Integer.parseInt(AttributePaneText_Y.getText()), Integer.parseInt( AttributePaneText_W.getText()), Integer.parseInt(AttributePaneText_H.getText()) );
		EditLabel.setBackground(Color.decode("0x"+AttributePaneText_color.getText()));
		//EditLabel.setOpaque(true);
		System.out.println("setinfo color:"+Color.decode("0x"+AttributePaneText_color.getText()));
		
	
	}
	
}
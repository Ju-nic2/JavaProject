package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

import Control.doSelect;
import Control.Listeners.IntKeyListener;
import Model.Rectangles;

public class setAttributePane implements ActionListener,ItemListener{
  
	
	private JTextField  Att_X,Att_Y,Att_Width,Att_Height,Att_Text,Att_Name;
	private JPanel AttributePane;
	private JComboBox<String> comboBox = new JComboBox<String>();
	private int NEW_X,NEW_Y,NEW_Width,NEW_Height;
	private String FirstType,FirstColor,FirstText,FirstName,FirstX,FirstY,FirstWidth,ChangedColor,FirstHeight,NEW_NAME,NEW_TEXT,NEW_Type,NEW_Color;
	private JRadioButton rdbtnRed,rdbtnDefault,rdbtnGray,rdbtnPink,rdbtnCyan,rdbtnGreen,rdbtnBlue;
	private ButtonGroup BTGroup;
	private Rectangles tempRect;
	private IntKeyListener intKeyListener;
	
	setAttributePane(JPanel attributePane, JPanel contentPane, IntKeyListener intKeyListener){
		this.AttributePane = attributePane;
		this.intKeyListener = intKeyListener;
		AttributePane.setBackground(Color.LIGHT_GRAY);
		AttributePane.setLayout(null);
		AttributePane.setBounds(0, 75, 226, 576);
		
		JTextPane AttributePane_title = new JTextPane();
		AttributePane_title.setBounds(0, 25, 226, 48);
		AttributePane_title.setEditable(false);
		AttributePane_title.setBackground(Color.WHITE);
		AttributePane_title.setForeground(Color.GRAY);
		AttributePane_title.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 26));
		AttributePane_title.setText("   Attribute Pane");
		contentPane.add(AttributePane_title);
		buildForm();
	}
	
	public void showInfo(Rectangles rectInfo){
		getInfo(rectInfo);
		Att_X.setText(FirstX);
		Att_Y.setText(FirstY);
		Att_Width.setText(FirstWidth);
		Att_Height.setText(FirstHeight);
		Att_Text.setText(FirstText);
		Att_Name.setText(FirstName);
		
		if(comboBox.getItemCount() < 8){
			comboBox.addItem("JLabel");
			comboBox.addItem("JButton");
			comboBox.addItem("JTextArea");
			comboBox.addItem("JTextField");
			comboBox.addItem("JRadioButton");
			comboBox.addItem("JCheckBox");
			comboBox.addItem("JToggleButton");
			comboBox.addItem("JFormattedTextField");
		}
		if(rectInfo!=null && rectInfo.getType() != null){
			if(FirstType.equals("JLabel"))
				comboBox.setSelectedIndex(0);
			else if(FirstType.equals("JButton"))
				comboBox.setSelectedIndex(1);
			else if(FirstType.equals("JTextArea"))
				comboBox.setSelectedIndex(2);
			else if(FirstType.equals("JTextField"))
				comboBox.setSelectedIndex(3);
			else if(FirstType.equals("JRadioButton"))
				comboBox.setSelectedIndex(4);
			else if(FirstType.equals("JCheckBox"))
				comboBox.setSelectedIndex(5);
			else if(FirstType.equals("JToggleButton"))
				comboBox.setSelectedIndex(6);
			else if(FirstType.equals("JFormattedTextField"))
				comboBox.setSelectedIndex(7);
		}
		else{
			comboBox.removeAllItems();
		}
		
		BTGroup.clearSelection();
		
		if(FirstColor.equals("RED"))
			rdbtnRed.setSelected(true);
		else if(FirstColor.equals("GRAY"))
			rdbtnGray.setSelected(true);
		else if(FirstColor.equals("Default"))
			rdbtnDefault.setSelected(true);
		else if(FirstColor.equals("PINK"))
			rdbtnPink.setSelected(true);
		else if(FirstColor.equals("CYAN"))
			rdbtnCyan.setSelected(true);
		else if(FirstColor.equals("GREEN"))
			rdbtnGreen.setSelected(true);
		else if(FirstColor.equals("BLUE"))
			rdbtnBlue.setSelected(true);
		AttributePane.repaint();
	}
	private void buildForm(){
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(0, 80, 153, 7);
		AttributePane.add(lblNewLabel);
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setForeground(Color.DARK_GRAY);
		label.setBackground(Color.DARK_GRAY);
		label.setBounds(0, 175, 153, 7);
		AttributePane.add(label);
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setBackground(Color.DARK_GRAY);
		label_1.setBounds(0, 10, 153, 7);
		AttributePane.add(label_1);
		JLabel label_2 = new JLabel("");
		label_2.setOpaque(true);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setBackground(Color.DARK_GRAY);
		label_2.setBounds(0, 268, 153, 7);
		AttributePane.add(label_2);
		JLabel label_3 = new JLabel("");
		label_3.setOpaque(true);
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setBackground(Color.DARK_GRAY);
		label_3.setBounds(0, 453, 153, 7);
		AttributePane.add(label_3);
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(true);
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setBackground(Color.DARK_GRAY);
		label_4.setBounds(0, 342, 153, 7);
		AttributePane.add(label_4);
		JTextPane txtpnComponentssType_1 = new JTextPane();
		txtpnComponentssType_1.setText("Components's Type");
		txtpnComponentssType_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		txtpnComponentssType_1.setEditable(false);
		txtpnComponentssType_1.setBackground(Color.LIGHT_GRAY);
		txtpnComponentssType_1.setBounds(12, 465, 202, 21);
		AttributePane.add(txtpnComponentssType_1);
		JTextPane txtpnComponentssColor = new JTextPane();
		txtpnComponentssColor.setText("Components's Color");
		txtpnComponentssColor.setFont(new Font("±¼¸²", Font.BOLD, 12));
		txtpnComponentssColor.setEditable(false);
		txtpnComponentssColor.setBackground(Color.LIGHT_GRAY);
		txtpnComponentssColor.setBounds(12, 359, 202, 21);
		AttributePane.add(txtpnComponentssColor);
		JTextPane txtpnWidthHeight = new JTextPane();
		txtpnWidthHeight.setText("Rectangle's Width & Height ");
		txtpnWidthHeight.setFont(new Font("±¼¸²", Font.BOLD, 12));
		txtpnWidthHeight.setEditable(false);
		txtpnWidthHeight.setBackground(Color.LIGHT_GRAY);
		txtpnWidthHeight.setBounds(12, 97, 202, 21);
		AttributePane.add(txtpnWidthHeight);
		JTextPane txtpnWidth = new JTextPane();
		txtpnWidth.setText("Width : ");
		txtpnWidth.setEditable(false);
		txtpnWidth.setBackground(Color.LIGHT_GRAY);
		txtpnWidth.setBounds(12, 128, 48, 21);
		AttributePane.add(txtpnWidth);
		JTextPane txtpnHeight = new JTextPane();
		txtpnHeight.setText("Height : ");
		txtpnHeight.setEditable(false);
		txtpnHeight.setBackground(Color.LIGHT_GRAY);
		txtpnHeight.setBounds(120, 128, 53, 21);
		AttributePane.add(txtpnHeight);
		JTextPane txtpnStartingLocationOf = new JTextPane();
		txtpnStartingLocationOf.setFont(new Font("±¼¸²", Font.BOLD, 14));
		txtpnStartingLocationOf.setBackground(Color.LIGHT_GRAY);
		txtpnStartingLocationOf.setEditable(false);
		txtpnStartingLocationOf.setText("Starting Location");
		txtpnStartingLocationOf.setBounds(12, 21, 202, 21);
		AttributePane.add(txtpnStartingLocationOf);
		JTextPane txtpnX = new JTextPane();
		txtpnX.setEditable(false);
		txtpnX.setBackground(Color.LIGHT_GRAY);
		txtpnX.setText("X : ");
		txtpnX.setBounds(12, 46, 27, 21);
		AttributePane.add(txtpnX);
		JTextPane txtpnY = new JTextPane();
		txtpnY.setEditable(false);
		txtpnY.setText("Y : ");
		txtpnY.setBackground(Color.LIGHT_GRAY);
		txtpnY.setBounds(96, 46, 27, 21);
		AttributePane.add(txtpnY);
		JTextPane txtpnComponentssText = new JTextPane();
		txtpnComponentssText.setText("Components's Text Field");
		txtpnComponentssText.setFont(new Font("±¼¸²", Font.BOLD, 12));
		txtpnComponentssText.setEditable(false);
		txtpnComponentssText.setBackground(Color.LIGHT_GRAY);
		txtpnComponentssText.setBounds(12, 192, 202, 21);
		AttributePane.add(txtpnComponentssText);
		JTextPane txtpnText = new JTextPane();
		txtpnText.setText("Text :");
		txtpnText.setEditable(false);
		txtpnText.setBackground(Color.LIGHT_GRAY);
		txtpnText.setBounds(12, 223, 40, 21);
		AttributePane.add(txtpnText);
		JTextPane txtpnComponentssType = new JTextPane();
		txtpnComponentssType.setText("Components's Name");
		txtpnComponentssType.setFont(new Font("±¼¸²", Font.BOLD, 12));
		txtpnComponentssType.setEditable(false);
		txtpnComponentssType.setBackground(Color.LIGHT_GRAY);
		txtpnComponentssType.setBounds(12, 285, 202, 21);
		AttributePane.add(txtpnComponentssType);
		JTextPane txtpnType = new JTextPane();
		txtpnType.setText("Name :");
		txtpnType.setEditable(false);
		txtpnType.setBackground(Color.LIGHT_GRAY);
		txtpnType.setBounds(12, 307, 48, 21);
		AttributePane.add(txtpnType);
		
		Att_X = new JTextField();
		Att_X.setBounds(37, 52, 31, 18);
		Att_X.addKeyListener(intKeyListener);
		AttributePane.add(Att_X);
		
		Att_Y = new JTextField();
		Att_Y.setBounds(121, 52, 31, 18);
		Att_Y.addKeyListener(intKeyListener);
		AttributePane.add(Att_Y);

		Att_Width = new JTextField();
		Att_Width.setBounds(63, 134, 31, 18);
		Att_Width.addKeyListener(intKeyListener);
		AttributePane.add(Att_Width);
		
		Att_Height = new JTextField();
		Att_Height.setBounds(172, 134, 31, 18);
		Att_Height.addKeyListener(intKeyListener);
		AttributePane.add(Att_Height);
		
		
		Att_Text = new JTextField();
		Att_Text.setBounds(52, 229, 151, 19);
		AttributePane.add(Att_Text);
		
		Att_Name = new JTextField();
		Att_Name.setBounds(63, 313, 140, 19);
		AttributePane.add(Att_Name);
		
		rdbtnRed = new JRadioButton("RED");
		rdbtnRed.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		rdbtnRed.setBackground(Color.LIGHT_GRAY);
		rdbtnRed.setBounds(75, 386, 48, 23);
		AttributePane.add(rdbtnRed);
		
		rdbtnDefault = new JRadioButton("Default");
		rdbtnDefault.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		rdbtnDefault.setBackground(Color.LIGHT_GRAY);
		rdbtnDefault.setBounds(10, 386, 59, 23);
		AttributePane.add(rdbtnDefault);
		
		rdbtnBlue = new JRadioButton("BLUE");
		rdbtnBlue.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		rdbtnBlue.setBackground(Color.LIGHT_GRAY);
		rdbtnBlue.setBounds(129, 386, 50, 23);
		AttributePane.add(rdbtnBlue);
		
		rdbtnGray = new JRadioButton("GRAY");
		rdbtnGray.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		rdbtnGray.setBackground(Color.LIGHT_GRAY);
		rdbtnGray.setBounds(176, 386, 53, 23);
		AttributePane.add(rdbtnGray);
		
		rdbtnGreen = new JRadioButton("GREEN");
		rdbtnGreen.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		rdbtnGreen.setBackground(Color.LIGHT_GRAY);
		rdbtnGreen.setBounds(10, 421, 60, 23);
		AttributePane.add(rdbtnGreen);
		
		rdbtnPink = new JRadioButton("PINK");
		rdbtnPink.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		rdbtnPink.setBackground(Color.LIGHT_GRAY);
		rdbtnPink.setBounds(75, 421, 48, 23);
		AttributePane.add(rdbtnPink);
		
		rdbtnCyan = new JRadioButton("CYAN");
		rdbtnCyan.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		rdbtnCyan.setBackground(Color.LIGHT_GRAY);
		rdbtnCyan.setBounds(129, 421, 51, 23);
		AttributePane.add(rdbtnCyan);		
		
		BTGroup = new ButtonGroup();
		BTGroup.add(rdbtnCyan);
		BTGroup.add(rdbtnPink);
		BTGroup.add(rdbtnGreen);
		BTGroup.add(rdbtnGray);
		BTGroup.add(rdbtnBlue);
		BTGroup.add(rdbtnDefault);
		BTGroup.add(rdbtnRed);
		
		rdbtnCyan.addItemListener(this);
		rdbtnPink.addItemListener(this);
		rdbtnGreen.addItemListener(this);
		rdbtnGray.addItemListener(this);
		rdbtnBlue.addItemListener(this);
		rdbtnDefault.addItemListener(this);
		rdbtnRed.addItemListener(this);
		
		
		comboBox.setBounds(12, 494, 111, 21);
		comboBox.setMaximumRowCount(5);
		comboBox.addActionListener(this);
		AttributePane.add(comboBox);
		
		JButton Injection = new JButton("Injection");
		Injection.setFont(new Font("±¼¸²", Font.BOLD, 14));
		Injection.setForeground(Color.WHITE);
		Injection.setBackground(Color.DARK_GRAY);
		Injection.setBorder(new BevelBorder(BevelBorder.RAISED));
		Injection.setBounds(129, 550, 97, 23);
		Injection.addActionListener(this);
		AttributePane.add(Injection);
		
	}

	private void getInfo(Rectangles rectInfo){
		tempRect = rectInfo;
		if(rectInfo == null){
			FirstX = null;
			FirstY = null;
			FirstWidth =null;
			FirstHeight = null;
			FirstText = null;
			FirstName = null;
			FirstType = null;
		}
		else{
			FirstX = String.valueOf(rectInfo.getRect().getX());
			FirstY = String.valueOf(rectInfo.getRect().getY());
			FirstWidth = String.valueOf(rectInfo.getRect().getWidth());
			FirstHeight = String.valueOf(rectInfo.getRect().getHeight());
			FirstText = String.valueOf(rectInfo.getRect().getText());
			FirstName = rectInfo.getRect().getName();
			FirstType = rectInfo.getType();
			FirstColor = rectInfo.getColor();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JComboBox ){
			Object comboBox = e.getSource();
			this.FirstType = (String)(((JComboBox<String>) comboBox).getSelectedItem());
		}
		else{
			if(tempRect != null){
				NEW_X = Integer.parseInt(Att_X.getText());
				NEW_Y = Integer.parseInt(Att_Y.getText());
				NEW_Width = Integer.parseInt(Att_Width.getText());
				NEW_Height = Integer.parseInt(Att_Height.getText());
				NEW_NAME = Att_Name.getText();
				NEW_TEXT = Att_Text.getText();
				NEW_Type = FirstType;
				NEW_Color = ChangedColor;
				if(NEW_X > 600)
					NEW_X = 600;
				if(NEW_Y > 540)
					NEW_Y = 540;
				if(NEW_Width+NEW_X > 605)
					NEW_Width = 605-NEW_X;
				if(NEW_Height+NEW_Y > 545)
					NEW_Height = 545-NEW_Y;
				tempRect.getRect().setBounds(NEW_X, NEW_Y, NEW_Width, NEW_Height);
				tempRect.getRect().setName(NEW_NAME);
				tempRect.getRect().setText(NEW_TEXT);
				tempRect.setType(NEW_Type);
				tempRect.setColor(NEW_Color);
				new doSelect(tempRect,this);
			}
		
		}
			
	}

	public void itemStateChanged(ItemEvent e) {
		 AbstractButton sel = (AbstractButton)e.getItemSelectable();
		 this.ChangedColor = sel.getText();
	}
}

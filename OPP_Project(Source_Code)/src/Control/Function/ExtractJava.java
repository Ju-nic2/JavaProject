package Control.Function;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import Model.Model;
public class ExtractJava
{
	private JFileChooser SaveJava = new JFileChooser();
	FileWriter javaFile = null;
	private int x, y, width, height;
	private String Color,Type, Name, Text;

	public ExtractJava(Model storage)
	{
		SaveJava.setMultiSelectionEnabled(false);
		SaveJava.setFileSelectionMode(JFileChooser.FILES_ONLY);
		SaveJava.setDialogTitle("Save");
		SaveJava.setSelectedFile(new File("javaFile"));
		SaveJava.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("*.java", "java"));
		int returnVal = SaveJava.showSaveDialog(SaveJava);

		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			File getFile = SaveJava.getSelectedFile();
			try
			{
				javaFile = new FileWriter(getFile + ".java");
				javaFile.write("package JavaTest;\r\n");
				javaFile.write("import java.awt.Color;\r\n");
				javaFile.write("import javax.swing.*;\r\n");
				javaFile.write("import javax.swing.border.LineBorder;\r\n\r\n");


				javaFile.write("public class javaFile {\r\n\r\n" 
						+ "	public static void main(String[] args){\r\n\r\n"
						+ "		JFrame frame = new JFrame();\r\n"
						+ "		JPanel EditorPane = new JPanel();\r\n\r\n"
						);
				
				javaFile.write("		frame.setTitle("+"\""+"Project_ParFam_Java"+"\""+");\r\n"
						+ "		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\r\n"
						+ "		frame.setBounds(238, 89, 616, 580);\r\n"
						+ "		EditorPane.setBorder(new LineBorder(Color.GRAY, 4));\r\n"
						+ "		EditorPane.setBackground(Color.WHITE);\r\n"
						+ "		EditorPane.setLayout(null);\r\n"
						+ "		EditorPane.setBounds(238, 89, 612, 550);\r\n"
						+ "		frame.add(EditorPane);\r\n\r\n");
				
				for (int i = 0; i < storage.Rectcnt; i++)
				{

					x = storage.getRectBag()[i].getRect().getX();
					y = storage.getRectBag()[i].getRect().getY();
					width = storage.getRectBag()[i].getRect().getWidth();
					height = storage.getRectBag()[i].getRect().getHeight();
					Name = storage.getRectBag()[i].getRect().getName();
					Text = storage.getRectBag()[i].getRect().getText();
					Type = storage.getRectBag()[i].getType();
					Color = storage.getRectBag()[i].getColor();

					javaFile.write("		"+Type+" "+Name+" = new "+Type+"(\""+Text+"\");\r\n");
					javaFile.write("		"+Name+".setBounds("+x+","+y+","+width+","+height+");\r\n");
					javaFile.write("		"+Name+".setBorder(new LineBorder(Color.black,2));\r\n");
					javaFile.write("		"+Name+".setOpaque(true);\r\n");
					if(!Color.equals("Default"))
							javaFile.write("		"+Name+".setBackground(Color."+Color+");\r\n");
					javaFile.write("		EditorPane.add("+Name+");\r\n");
					
					
				}
				javaFile.write("		EditorPane.repaint();\r\n");
				javaFile.write("		frame.setResizable(false);\r\n"
						+ "		frame.setLocationRelativeTo(null);\r\n"
						+ "		frame.setVisible(true);\r\n\r\n");

				javaFile.write("	}\r\n");
				javaFile.write("}");
				javaFile.flush();
				javaFile.close();
				
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}

package Control.Function;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Control.Json.JSONObject;
import Control.Json.parser.JSONParser;
import Control.Json.parser.ParseException;
import Control.Listeners.Size_MoveListener;
import Model.Model;
import Model.Rectangles;
import View.setAttributePane;


public class Open {
	
	private JFileChooser Openjson = new JFileChooser();
	private JSONParser parser = new JSONParser();
	private Object obj;
	private Rectangles[] Rect;
	static String orout;

	String stringX, stringY, stringWidth, stringHeight, stringText, stringName, stringType, stringColor;
	Long longX, longY, longWidth, longHeight;
	int intX, intY, intWidth, intHeight;
	int j = 0;

	public Open(JPanel EditorPane, setAttributePane attributePane, Model storage, Size_MoveListener[] size_MoveListener){
		Rect = storage.getRectBag();
		Openjson.setMultiSelectionEnabled(false);
		Openjson.setFileSelectionMode(JFileChooser.FILES_ONLY);
		Openjson.setDialogTitle("Open");
		Openjson.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("*.json", "json"));
		int returnVal = Openjson.showOpenDialog(Openjson);

				
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {

				orout = Openjson.getSelectedFile().toString();
				orout = orout.replace('\\', '/');
				obj = parser.parse(new FileReader(orout));
				
				
				JSONObject jsonObject = (JSONObject) obj;
				
				
				for (int i = 0; i < jsonObject.size(); i++) {
					JSONObject njasonObject = (JSONObject) jsonObject.get((i + 1) + "¹ø ÄÄÆ÷³ÍÆ®");
					
					for (j = 0; j < njasonObject.size(); j++) {
						size_MoveListener[storage.Rectcnt] = new Size_MoveListener(EditorPane,attributePane,storage.getRectBag()[storage.Rectcnt]);
						
						longX = (Long) njasonObject.get("Rectangle " + (storage.Rectcnt + 1) + "'s X1");
						longY = (Long) njasonObject.get("Rectangle " + (storage.Rectcnt + 1) + "'s Y1");
						longWidth = (Long) njasonObject.get("Rectangle " + (storage.Rectcnt + 1) + "'s width");
						longHeight = (Long) njasonObject.get("Rectangle " + (storage.Rectcnt + 1) + "'s height");
						stringText = (String) njasonObject.get("Rectangle " + (storage.Rectcnt + 1) + "'s Text Field");
						stringName = (String) njasonObject.get("Rectangle " + (storage.Rectcnt + 1) + "'s Name");
						stringType = (String) njasonObject.get("Rectangle " + (storage.Rectcnt + 1) + "'s Type");
						stringColor = (String) njasonObject.get("Rectangle " + (storage.Rectcnt + 1) + "'s Color");
						
						
						if (longX == null || longY == null || longWidth == null || longHeight == null || stringText == null || stringName == null || stringType == null) continue;						
						
						stringX = longX.toString();
						stringY = longY.toString();
						stringWidth = longWidth.toString();
						stringHeight = longHeight.toString();
						
						intX = Integer.parseInt(stringX);
						intY = Integer.parseInt(stringY);
						intWidth = Integer.parseInt(stringWidth);
						intHeight = Integer.parseInt(stringHeight);
						
						Rect[storage.Rectcnt].getRect().setBounds(intX, intY, intWidth, intHeight);
						Rect[storage.Rectcnt].getRect().setName(stringName);
						Rect[storage.Rectcnt].getRect().setText(stringText);
						Rect[storage.Rectcnt].setType(stringType);
						Rect[storage.Rectcnt].getRect().setBorder(new LineBorder(Color.black,2));
						Rect[storage.Rectcnt].getRect().setOpaque(true);
						Rect[storage.Rectcnt].getRect().setBackground(Color.white);
						Rect[storage.Rectcnt].setColor(stringColor);
						Rect[storage.Rectcnt].getRect().addMouseListener(size_MoveListener[storage.Rectcnt]);
						Rect[storage.Rectcnt].getRect().addMouseMotionListener(size_MoveListener[storage.Rectcnt]);
						EditorPane.add(Rect[storage.Rectcnt].getRect());
						EditorPane.repaint();
						storage.Rectcnt++;
						
						if (longX != null && longY != null && longWidth != null && longHeight != null && stringText != null && stringName != null && stringType != null){
							longX = longY = longWidth = longHeight = null;
							stringText = stringName = stringType = null;
							
							break;
						}
						
					}
				}
				Save.rout = orout;
			}
				

			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (NullPointerException e){
				e.printStackTrace();
			}
		}
		
	}

	


}

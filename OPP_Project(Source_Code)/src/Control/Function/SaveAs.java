package Control.Function;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Control.Json.JSONObject;
import Model.Model;

public class SaveAs{

	private JFileChooser SaveAsjson = new JFileChooser();
	public static JSONObject AsRectinfo = new JSONObject();
	public static JSONObject AsJsonObject = new JSONObject();
	public static JLabel address = new JLabel(" ");
	FileWriter Asfile = null;
	String save;
	
	@SuppressWarnings("unchecked")
	public SaveAs(Model storage) {
		
		Save.show = JOptionPane.showConfirmDialog(null, "다른 이름으로 저장 하시겠습니까?", "저장 완료", JOptionPane.YES_NO_OPTION);
		
		if(Save.show == JOptionPane.YES_OPTION){
			Save.show = 1;
			SaveAsjson.setMultiSelectionEnabled(false);
			SaveAsjson.setFileSelectionMode(JFileChooser.FILES_ONLY);
			SaveAsjson.setDialogTitle("Save");
			SaveAsjson.setSelectedFile(new File(""));
			SaveAsjson.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("*.json", "json"));
			int returnVal = SaveAsjson.showSaveDialog(SaveAsjson);
			
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				
				File ff = SaveAsjson.getSelectedFile();
				
				if(Save.show == 1)
				{
					AsRectinfo.clear();
					AsJsonObject.clear();
					
					for (int i = 0; i < storage.getRectBag().length; i++) {
						
						if (storage.getRectBag()[i].getType() == null)
							break;

						AsRectinfo.put("Rectangle " + (i + 1) + "'s X1", storage.getRectBag()[i].getRect().getX());
						AsRectinfo.put("Rectangle " + (i + 1) + "'s Y1", storage.getRectBag()[i].getRect().getY());
						AsRectinfo.put("Rectangle " + (i + 1) + "'s width", storage.getRectBag()[i].getRect().getWidth());
						AsRectinfo.put("Rectangle " + (i + 1) + "'s height", storage.getRectBag()[i].getRect().getHeight());
						AsRectinfo.put("Rectangle " + (i + 1) + "'s Text Field", storage.getRectBag()[i].getRect().getText());
						AsRectinfo.put("Rectangle " + (i + 1) + "'s Name", storage.getRectBag()[i].getRect().getName());
						AsRectinfo.put("Rectangle " + (i + 1) + "'s Type", storage.getRectBag()[i].getType());
						AsRectinfo.put("Rectangle " + (i + 1) + "'s Color", storage.getRectBag()[i].getColor());
						AsJsonObject.put((i + 1) + "번 컴포넌트", AsRectinfo);
						AsRectinfo = new JSONObject();

					}

					try {
						Asfile = new FileWriter(ff + ".json");
						Asfile.write(AsJsonObject.toJSONString());
						Asfile.flush();
						Asfile.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					Save.rout = ff.getPath()+".json";
					Save.rout = Save.rout.replace("\\", "/");
				}
				
				Open.orout = Save.rout;
		
			}
		}
		else Save.show = 1000;
	}
}

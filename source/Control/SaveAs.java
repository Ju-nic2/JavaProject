package Control;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Control.Open;
import Control.Save;
import Control.Json.JSONObject;
import Model.ManageLabel;

public class SaveAs {
	private JFileChooser Savejson = new JFileChooser();
	static int show = 1000;
	private static JSONObject Nodeinfo = new JSONObject();
	private static JSONObject JsonObject = new JSONObject();
	FileWriter file = null;
	public static String rout;

	@SuppressWarnings("unchecked")
	public SaveAs(ManageLabel[] storage) {
		show = JOptionPane.showConfirmDialog(null, "다른 이름으로 저장 하시겠습니까?", "저장 완료", JOptionPane.YES_NO_OPTION);

		if (show == JOptionPane.YES_OPTION)
		{
			show = 1;
			Savejson.setMultiSelectionEnabled(false);
			Savejson.setFileSelectionMode(JFileChooser.FILES_ONLY);
			Savejson.setDialogTitle("Save");
			Savejson.setSelectedFile(new File("default"));
			Savejson.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("*.json", "json"));
			int returnVal = Savejson.showSaveDialog(Savejson);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{

				File getfile = Savejson.getSelectedFile();

				if (show == 1)
				{

					Nodeinfo.clear();
					JsonObject.clear();
					int i=0;
					while(storage[i]!=null)
					{
						

						Nodeinfo.put("Name", storage[i].getLabels().getText());
						Nodeinfo.put("PreLevel", storage[i].getPreLevel());
						Nodeinfo.put("NodeLevel", storage[i].getNodeLevel());
						Nodeinfo.put("X", storage[i].getLabels().getX());
						Nodeinfo.put("Y", storage[i].getLabels().getY());
						Nodeinfo.put("Width", storage[i].getLabels().getWidth());
						Nodeinfo.put("Height", storage[i].getLabels().getHeight());
						//Nodeinfo.put("Color", storage[i].getLabels().getBackground());
						JsonObject.put((i + 1) + "번 라벨", Nodeinfo);
						Nodeinfo = new JSONObject();
						i++;

					}
					
					try
					{
						file = new FileWriter(getfile + ".json");
						file.write(JsonObject.toJSONString());
						file.flush();
						file.close();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					rout = getfile.getPath() + ".json";
					rout = rout.replace("\\", "/");
				}
				
				Open.orout = Save.rout;
				
			}
		}

		else
			Save.show = 1000;

	}

	}



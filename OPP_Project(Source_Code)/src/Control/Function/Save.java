package Control.Function;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Control.Json.JSONObject;
import Model.Model;

public class Save
{
	private JFileChooser Savejson = new JFileChooser();
	static int show = 1000;
	private static JSONObject Rectinfo = new JSONObject();
	private static JSONObject JsonObject = new JSONObject();
	public static String rout;
	FileWriter file = null;

	@SuppressWarnings("unchecked")
	public Save(Model storage)
	{
		if (rout == null)
			show = 1000;
		else if (rout != null)
		{

			show = 1;
			if ((rout).equals(Open.orout) == true)
				show = 1;
			else if ((rout).equals(Open.orout) == false)
				show = 1000;
		}
		else
			show = 1;

		if (show != 1000)
		{

			Rectinfo.clear();
			JsonObject.clear();

			for (int i = 0; i < storage.getRectBag().length; i++)
			{
				if (storage.getRectBag()[i].getType() == null)
					break;
				Rectinfo.put("Rectangle " + (i + 1) + "'s X1", storage.getRectBag()[i].getRect().getX());
				Rectinfo.put("Rectangle " + (i + 1) + "'s Y1", storage.getRectBag()[i].getRect().getY());
				Rectinfo.put("Rectangle " + (i + 1) + "'s width", storage.getRectBag()[i].getRect().getWidth());
				Rectinfo.put("Rectangle " + (i + 1) + "'s height", storage.getRectBag()[i].getRect().getHeight());
				Rectinfo.put("Rectangle " + (i + 1) + "'s Text Field", storage.getRectBag()[i].getRect().getText());
				Rectinfo.put("Rectangle " + (i + 1) + "'s Name", storage.getRectBag()[i].getRect().getName());
				Rectinfo.put("Rectangle " + (i + 1) + "'s Type", storage.getRectBag()[i].getType());
				Rectinfo.put("Rectangle " + (i + 1) + "'s Color", storage.getRectBag()[i].getColor());
				JsonObject.put((i + 1) + "번 컴포넌트", Rectinfo);
				Rectinfo = new JSONObject();

			}

			try
			{
				file = new FileWriter(rout);
				file.write(JsonObject.toJSONString());
				file.flush();
				file.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else if (show == 1000)
		{

			show = JOptionPane.showConfirmDialog(null, "저장 하시겠습니까?", "저장 완료", JOptionPane.YES_NO_OPTION);

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

						Rectinfo.clear();
						JsonObject.clear();

						for (int i = 0; i < storage.getRectBag().length; i++)
						{
							if (storage.getRectBag()[i].getType() == null)
								break;

							Rectinfo.put("Rectangle " + (i + 1) + "'s X1", storage.getRectBag()[i].getRect().getX());
							Rectinfo.put("Rectangle " + (i + 1) + "'s Y1", storage.getRectBag()[i].getRect().getY());
							Rectinfo.put("Rectangle " + (i + 1) + "'s width", storage.getRectBag()[i].getRect().getWidth());
							Rectinfo.put("Rectangle " + (i + 1) + "'s height", storage.getRectBag()[i].getRect().getHeight());
							Rectinfo.put("Rectangle " + (i + 1) + "'s Text Field", storage.getRectBag()[i].getRect().getText());
							Rectinfo.put("Rectangle " + (i + 1) + "'s Name", storage.getRectBag()[i].getRect().getName());
							Rectinfo.put("Rectangle " + (i + 1) + "'s Type", storage.getRectBag()[i].getType());
							Rectinfo.put("Rectangle " + (i + 1) + "'s Color", storage.getRectBag()[i].getColor());
							JsonObject.put((i + 1) + "번 컴포넌트", Rectinfo);
							Rectinfo = new JSONObject();

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

					Open.orout = rout;
				}
			}

			else
				show = 1000;

		}
	}

}

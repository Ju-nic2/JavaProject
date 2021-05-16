package Control;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Control.Open;
import Control.Json.JSONObject;
import Model.ManageLabel;

public class Save {
   private JFileChooser Savejson = new JFileChooser();
   static int show = 1000;
   private static JSONObject Nodeinfo = new JSONObject();
   private static JSONObject JsonObject = new JSONObject();
   FileWriter file = null;
   public static String rout;
   
   @SuppressWarnings("unchecked")
   public Save(ManageLabel[] storage) 
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
      else {
         show = 1;
      }
         
      
      if(show != 1000)
      {

         Nodeinfo.clear();
         JsonObject.clear();
         int i=0;
       
         while(ManageLabel.LabelCount+1 !=i)
         {
            
            Nodeinfo.put("Name", storage[i].getLabels().getText());
            Nodeinfo.put("PreLevel", storage[i].getPreLevel());
            System.out.println("save 할때 nodeLevle: "+ storage[i].getNodeLevel());
            Nodeinfo.put("NodeLevel", storage[i].getNodeLevel());
            Nodeinfo.put("X", storage[i].getLabels().getX());
            Nodeinfo.put("Parent's X", storage[i].getParent().getLabels().getX());
            Nodeinfo.put("Y", storage[i].getLabels().getY());
            Nodeinfo.put("Parent's Y", storage[i].getParent().getLabels().getY());
            Nodeinfo.put("Width", storage[i].getLabels().getWidth());
            Nodeinfo.put("Parent's Width", storage[i].getParent().getLabels().getWidth());
            System.out.println("save 할때 Width: "+ storage[i].getLabels().getWidth());
            Nodeinfo.put("Height", storage[i].getLabels().getHeight());
            System.out.println("save 할때 Height: "+ storage[i].getLabels().getHeight());
            Nodeinfo.put("Parent's Height", storage[i].getParent().getLabels().getHeight());
            Nodeinfo.put("Color", Integer.toHexString(( storage[i].getLabels().getBackground().getRGB() )).substring(2)) ;
            //Nodeinfo.put("Color", storage[i].getLabels().getBackground());
            JsonObject.put((i + 1) + "번 라벨", Nodeinfo);
            Nodeinfo = new JSONObject();
            i++;
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
   
                  Nodeinfo.clear();
                  JsonObject.clear();
                  int i=0;
                  while(ManageLabel.LabelCount+1 !=i)
                  {
                     Nodeinfo.put("Name", storage[i].getLabels().getText());
                     Nodeinfo.put("PreLevel", storage[i].getPreLevel());
                     System.out.println("save 할때 nodeLevle: "+ storage[i].getNodeLevel());
                     Nodeinfo.put("NodeLevel", storage[i].getNodeLevel());
                     Nodeinfo.put("X", storage[i].getLabels().getX());
                     Nodeinfo.put("Parent's X", storage[i].getParent().getLabels().getX());
                     Nodeinfo.put("Y", storage[i].getLabels().getY());
                     Nodeinfo.put("Parent's Y", storage[i].getParent().getLabels().getY());
                     Nodeinfo.put("Width", storage[i].getLabels().getWidth());
                     System.out.println("save 할때 Width: "+ storage[i].getLabels().getWidth());
                     Nodeinfo.put("Parent's Width", storage[i].getParent().getLabels().getWidth());
                     Nodeinfo.put("Height", storage[i].getLabels().getHeight());
                     System.out.println("save 할때 Height: "+ storage[i].getLabels().getHeight());
                     Nodeinfo.put("Parent's Height", storage[i].getParent().getLabels().getHeight());
                     Nodeinfo.put("Color", Integer.toHexString(( storage[i].getLabels().getBackground().getRGB() )).substring(2)) ;
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
   
               Open.orout = rout;
            }
         }
   
         else
            show = 1000;
         
         }
         
      }
}
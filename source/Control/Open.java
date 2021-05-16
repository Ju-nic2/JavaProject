package Control;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import Control.Save;
import Control.Json.JSONObject;
import Control.Json.parser.JSONParser;
import Control.Json.parser.ParseException;
import Model.ManageLabel;
import Model.Tree;
import View.TextEditorPane;
import View.MindMapPane;

public class Open {
   private JFileChooser Openjson = new JFileChooser();
   private JSONParser parser = new JSONParser();
   private Object obj;

   private MakeAttribute Action2;
   private TextEditorPane emptyTextEditorPane;
 
 
   static String orout;
   
   Color color;
   String stringText, stringPreLevel, stringNodeLevel,stringX,stringY,stringPX,stringPY,stringW,stringPW,stringH,stringPH,stringColor;
   Long longPreLevel, longNodeLevel,longX,longY,longPX,longPY,longW,longPW,longH,longPH;
   int intPreLevel, intNodeLevel,intX,intY,intPX,intPY,intW,intPW,intH,intPH;
   int j=0;
   int yncopt;
   int intColor;

   public Open(Tree emptyTree,MindMapPane newMindMap,ManageLabel[] storage,TextEditorPane emptyTextEditorPane) {   
   {

	   if(ManageLabel.LabelCount!=0) {for(int i=0;i<=storage[0].getLabelCount();i++) {storage[i]=new ManageLabel();} }
	   ManageLabel.resetCount(0);
      this.emptyTextEditorPane=emptyTextEditorPane;
      Openjson.setMultiSelectionEnabled(false);
      Openjson.setFileSelectionMode(JFileChooser.FILES_ONLY);
      Openjson.setDialogTitle("Open");
      Openjson.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("*.json", "json"));
      int returnVal = Openjson.showOpenDialog(Openjson);
      
      Action2=  newMindMap.getAction();
      
      if (returnVal == JFileChooser.APPROVE_OPTION)
      {
         try {
   
            orout = Openjson.getSelectedFile().toString();
            System.out.print(1);
            System.out.println(orout);
            orout = orout.replace('\\', '/');
            System.out.print(2);
            System.out.println(orout);
            obj = parser.parse(new FileReader(orout));
            System.out.print(3);
            
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(4);
            storage = new ManageLabel[jsonObject.size()];
            
            int remember = 0;
            
            for (int i = 0; i < jsonObject.size(); i++)
            {
               storage[i] = new ManageLabel();
               
               System.out.println(6);
                  JSONObject njasonObject = (JSONObject) jsonObject.get((i + 1) + "번 라벨");
                  System.out.println(7);
                  stringText =  (String)njasonObject.get("Name");
                  System.out.println(stringText);
                  longPreLevel = (long)njasonObject.get("PreLevel");
                  System.out.println(longPreLevel);
                  longNodeLevel = (long)njasonObject.get("NodeLevel");
                  System.out.println("Open NODELEVEL:"+longNodeLevel);
                  longX = (long)njasonObject.get("X");
                  System.out.println(longX);
                  longPX = (long)njasonObject.get("Parent's X");
                  System.out.println(longPX);
                  longY = (long)njasonObject.get("Y");
                  System.out.println(longY);
                  longPY = (long)njasonObject.get("Parent's Y");
                  System.out.println(longPY);
                  longW = (long)njasonObject.get("Width");
                  System.out.println(longW);
                  longPW = (long)njasonObject.get("Parent's Width");
                  System.out.println(longPW);
                  longH = (long)njasonObject.get("Height");
                  System.out.println(longH);
                  longPH = (long)njasonObject.get("Parent's Height");
                  System.out.println(longPH);
                  stringColor = (String) njasonObject.get("Color");
                  
                  System.out.println("stringColor: "+stringColor);
                  color=Color.decode("0x"+stringColor);
              //    color=stringColor;
            //      System.out.println("color: "+color);
               
                                    
                  stringPreLevel = longPreLevel.toString();
                  stringNodeLevel = longNodeLevel.toString();
                  stringX = longX.toString();
                  stringPX = longPX.toString();
                  stringY = longY.toString();
                  stringPY = longPY.toString();
                  stringW = longW.toString();
                  System.out.println("Open Width:"+stringW);
                  stringPW = longPW.toString();
                  stringH = longH.toString();
                  stringPH = longPH.toString();
               
                  intPreLevel = Integer.parseInt(stringPreLevel);
                  intNodeLevel = Integer.parseInt(stringNodeLevel);
                  intX = Integer.parseInt(stringX);
                  intPX = Integer.parseInt(stringPX);
                  intY = Integer.parseInt(stringY);
                  intPY = Integer.parseInt(stringPY);
                  intW = Integer.parseInt(stringW);
                  System.out.println("Open Width:"+intW);
                  intPW = Integer.parseInt(stringPW);
                  intH = Integer.parseInt(stringH);
                  System.out.println("Open height:"+intH);
                  intPW = Integer.parseInt(stringPW);
                  
                  System.out.println(intPreLevel);
                  emptyTree.InsertNode(stringText, intNodeLevel, intPreLevel);
                  
                  System.out.println("여기1");
                  storage[i].setNodeLevel(intNodeLevel);
                  storage[i].setPreLevel(intPreLevel);
                  storage[i].setLabel(stringText);
                  if(i==0) {
                     storage[i].setParent(storage[i]);
                  }
                  else if (intNodeLevel > intPreLevel) {
                     storage[i].setParent(storage[i-1]);
                     
                  }
                  else if(intNodeLevel == intPreLevel) {
                     storage[i].setParent(storage[i-1].getParent());
                  }else if(intNodeLevel < intPreLevel) {
                     System.out.println("여기2");
                     ManageLabel tmp = storage[i-1].getParent();
                     System.out.println("여기3");
                     for(int k=0;k<intPreLevel-intNodeLevel;k++) {
                        System.out.println("여기4");
                        tmp=tmp.getParent();
                     }
                     storage[i].setParent(tmp);
                  }
                  System.out.println(intH+"확인");
                  storage[i].getLabels().setBounds(intX, intY, intW, intH);
                  System.out.println("시발H: "+storage[i].getLabels().getHeight());
             
                  storage[i].setLocInfo(storage[i].getLabels());
                  storage[i].getLabels().setBackground(color);
                  
                                
                  System.out.println(stringText);                  
                  System.out.println(intNodeLevel);
                  System.out.println(intX);
                  System.out.println(intPX);                
                  storage[i].setLabelCount(i);
                  
            }
            
            System.out.println("여기4");
            System.out.println("넘겨주기전12");
           // this.storage=storage;
          /*  for(int i=0;i<=this.storage[0].getLabelCount();i++)
            {
               System.out.print("넘기자 높이 12: "+this.storage[i].getLabels().getHeight());
            }*/
            emptyTextEditorPane.copyTextEditorPane(storage);
            System.out.println("넘겨주기전");
            for(int i=0;i<=storage[0].getLabelCount();i++)
            {
               System.out.print("넘기자 높이 : "+storage[i].getLabels().getHeight());
            }
            newMindMap.Open_AddLabel2Map(storage);
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
}
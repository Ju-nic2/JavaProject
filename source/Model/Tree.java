package Model;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import Control.MakeAttribute;
import View.MindMapPane.MyPanel;

public class Tree{
   private static Node parent;
   private static Node head;
   private static int TreeLevel;

   public Tree() { parent=null;}
  
   public Tree InsertNode(String word,int NodeLevel,int PreLevel)
      {
         
         System.out.println("insertNode start");
         
         Node newNode = new Node(word,NodeLevel,PreLevel,0,0);
         
         if(Tree.parent==null) //첫노드가 비어있을
         {           
            Tree.parent=newNode;
            Tree.parent.location=0;
            Tree.head = parent;
            System.out.println("word parent: "+parent.word);
         }
         else//첫노드가 비어있지 않을
         {  
           Node first = head;
            if(NodeLevel==1&&PreLevel==0) 
            {
               first.next = newNode;
               first.next.location=11;
            }
            else if(NodeLevel<PreLevel) {
            	int countSame=0;
            	int countF=0;
               for(int i=0;i<NodeLevel;i++) {
                  first=first.next;
                  System.out.println(first.word+"건너가는중");
                  while(first.same!=null) {
                	  if(NodeLevel-2==i) {
                		  countSame++;
                	  }
                	  if(NodeLevel-2==i) {
                		 countF++;
                	  }
                     System.out.println(first.word+"이동중"+countSame);
                     first=first.same;
                  }
               }
               if(NodeLevel>1) {
            	   first.same=newNode;
 	              first.same.location=10*(countSame+1)+(countF+2);
               }else {
	              first.same=newNode;
	              first.same.location=first.location+10;
               }
              System.out.println(first.word+"뒤에 연걸"+newNode.word+"구역 : "+first.same.location);
            }else if(NodeLevel==PreLevel) {
                for(int i=0;i<NodeLevel;i++) {
                    first=first.next;
                    System.out.println(first.word+"건너가는중");
                    while(first.same!=null) {
                       System.out.println(first.word+"이동중");
                       first=first.same;
                    }
                 }
                if(NodeLevel>1) {
                   first.same=newNode;
                   first.same.location=first.location+1;
                }else {
                   first.same=newNode;
                    first.same.location=first.location+10;
                }
                System.out.println(first.word+"뒤에 연걸"+newNode.word+"구역 : "+first.same.location);
              }
            else if(NodeLevel>PreLevel) {
               for(int i=1;i<NodeLevel;i++) {
                  first=first.next;
                  System.out.println(first.word+"건너가는중");
                  while(first.same!=null) {
                     first=first.same;
                     System.out.println(first.word+"이동중");
                  }
               }
         
            	int tmp = first.location/10;
            	 newNode.location=tmp*10+1;
            	 first.next = newNode;
            
            	 
            }
         }
         if(newNode.location==11 && newNode.NodeLevel == 1) {
            newNode.X = 300-50*newNode.NodeLevel;
            newNode.Y = 250-70*newNode.NodeLevel;
         }else if(newNode.location==11 && newNode.NodeLevel != 1) {
             newNode.X = 300-70*newNode.NodeLevel;
             newNode.Y = 250-70*newNode.NodeLevel;
          }
         else if(newNode.location==21) {
            newNode.X = 300+70*newNode.NodeLevel;
            newNode.Y = 250-70*newNode.NodeLevel;
         }else if(newNode.location==31) {
            newNode.X = 300-70*newNode.NodeLevel;
            newNode.Y = 250+70*newNode.NodeLevel;
         }else if(newNode.location==41) {
            newNode.X = 300+70*newNode.NodeLevel;
            newNode.Y = 250+70*newNode.NodeLevel;
         }
         System.out.println("전레벨 ㅣ: "+PreLevel+"지금레벨 /; "+NodeLevel+"지금단여"+parent.word);
         return this;
      }
   
   public void PrintNode2Map(ManageLabel []Label,MakeAttribute Action2,int number,Node parent,ManageLabel parentLabel,SelectColor color,int Level,MyPanel myPanel,boolean nextLine,boolean sameLine)
   {
      boolean visit= false;
      boolean nL=nextLine;
      boolean sL=sameLine;
      int Index_number=number;
      int level=Level;
      int realx,realy;
      Node first;
      ManageLabel prntLb=parentLabel;
      SelectColor LevelColor =color; 
      Border blackline  = BorderFactory.createLineBorder(Color.black);
     
      
      if(number==0)
      {
            System.out.println("추가되는 word"+"["+Index_number+"]: "+ parent.word);
            Label[Index_number]= new ManageLabel();
            Label[Index_number].setLabel(parent.word);
            Label[Index_number].setLabelCount(Index_number);
            Label[Index_number].setPreLevel(parent.preLevel);
            Label[Index_number].setNodeLevel(parent.NodeLevel);
            Label[Index_number].getLabels().setBorder(blackline);               
            Label[Index_number].getLabels().setBounds(300,250, 50, 20);
            Label[Index_number].getLabels().setLayout(null);
            Label[Index_number].getLabels().setBackground(color.useColor(level));
            Label[Index_number].getLabels().setOpaque(true);
            Label[Index_number].getLabels().addMouseListener(Action2);
            Label[Index_number].getLabels().addMouseMotionListener(Action2);
            Label[Index_number].setLocInfo(Label[Index_number].getLabels());//연결선계산  
            prntLb=Label[Index_number];
            Label[Index_number].setParent(prntLb);
            Index_number++;
      }
      else if (parent.location%10==1)
      {//뼈대
         System.out.println("추가되는 word"+"["+Index_number+"]: "+ parent.word);
         Label[Index_number]= new ManageLabel();
         Label[Index_number].setLabel(parent.word);
         Label[Index_number].setLabelCount(Index_number);
         Label[Index_number].setPreLevel(parent.preLevel);
         Label[Index_number].setNodeLevel(parent.NodeLevel);
         Label[Index_number].getLabels().setBorder(blackline);               
         Label[Index_number].getLabels().setBounds(parent.X,parent.Y, 50, 20);
         Label[Index_number].getLabels().setLayout(null);
         Label[Index_number].getLabels().setBackground(color.useColor(level));
         Label[Index_number].getLabels().setOpaque(true);
         Label[Index_number].getLabels().addMouseListener(Action2);
         Label[Index_number].getLabels().addMouseMotionListener(Action2);
         Label[Index_number].setLocInfo(Label[Index_number].getLabels());//연결선계산  
         Label[Index_number].setParent(prntLb);
      
         Index_number++;
      }
      else if (parent.location/10==1) 
      {
         if(parent.location%10==2) 
         {
            realx = (300-70*parent.NodeLevel)+70;
            realy = (250-70*parent.NodeLevel);
         }
         else if(parent.location%10==3) 
         {
            realx = (300-70*parent.NodeLevel);
            realy = (250-70*parent.NodeLevel)+90;
         }
         else 
         {
            System.out.println("자식은 최대 3명임 ");
            realx = 0;
            realy = 0;
         }
         System.out.println("추가되는 word"+"["+Index_number+"]: "+ parent.word);
         Label[Index_number]= new ManageLabel();
         Label[Index_number].setLabel(parent.word);
         Label[Index_number].setLabelCount(Index_number);
         Label[Index_number].setPreLevel(parent.preLevel);
         Label[Index_number].setNodeLevel(parent.NodeLevel);
         Label[Index_number].getLabels().setBorder(blackline);               
         Label[Index_number].getLabels().setBounds(realx,realy, 50, 20);
         Label[Index_number].getLabels().setLayout(null);
         Label[Index_number].getLabels().setBackground(color.useColor(level));
         Label[Index_number].getLabels().setOpaque(true);
         Label[Index_number].getLabels().addMouseListener(Action2);
         Label[Index_number].getLabels().addMouseMotionListener(Action2);
         Label[Index_number].setLocInfo(Label[Index_number].getLabels());//연결선계산   
         Label[Index_number].setParent(prntLb);
        
         parent.X=realx;
         parent.Y=realy;
         Index_number++;
      }
      else if (parent.location/10==2) 
      {
         if(parent.location%10==2) {
            realx = (300+70*parent.NodeLevel);
            realy = (250-70*parent.NodeLevel)+55;
         }else if(parent.location%10==3) {
            realx = (300+70*parent.NodeLevel)-55;
            realy = (250-70*parent.NodeLevel);
         }else
         {
            System.out.println("자식은 최대 3명임 ");
            realx = 0;
            realy = 0;
         }
         System.out.println("추가되는 word"+"["+Index_number+"]: "+ parent.word);
         Label[Index_number]= new ManageLabel();
         Label[Index_number].setLabel(parent.word);
         Label[Index_number].setLabelCount(Index_number);
         Label[Index_number].setPreLevel(parent.preLevel);
         Label[Index_number].setNodeLevel(parent.NodeLevel);
         Label[Index_number].getLabels().setBorder(blackline);               
         Label[Index_number].getLabels().setBounds(realx,realy, 50, 20);
         Label[Index_number].getLabels().setLayout(null);
         Label[Index_number].getLabels().setBackground(color.useColor(level));
         Label[Index_number].getLabels().setOpaque(true);
         Label[Index_number].getLabels(
        		 ).addMouseListener(Action2);
         Label[Index_number].getLabels().addMouseMotionListener(Action2);
         Label[Index_number].setLocInfo(Label[Index_number].getLabels());//연결선계산   
         Label[Index_number].setParent(prntLb);
        
         
         parent.X=realx;
         parent.Y=realy;
         Index_number++;
      }
      else if (parent.location/10==3) 
      {
         if(parent.location%10==2) {
            realx = (300-70*parent.NodeLevel);
            realy = (250+70*parent.NodeLevel)-55;
         }else if(parent.location%10==3) {
            realx = (300-70*parent.NodeLevel)+55;
            realy = (250+70*parent.NodeLevel);
         }else {
            System.out.println("자식은 최대 3명임 ");
            realx = 0;
            realy = 0;
         }
         System.out.println("추가되는 word"+"["+Index_number+"]: " +parent.word);
         Label[Index_number]= new ManageLabel();
         Label[Index_number].setLabel(parent.word);
         Label[Index_number].setLabelCount(Index_number);
         Label[Index_number].setPreLevel(parent.preLevel);
         Label[Index_number].setNodeLevel(parent.NodeLevel);
         Label[Index_number].getLabels().setBorder(blackline);               
         Label[Index_number].getLabels().setBounds(realx,realy, 50, 20);
         Label[Index_number].getLabels().setLayout(null);
         Label[Index_number].getLabels().setBackground(color.useColor(level));
         Label[Index_number].getLabels().setOpaque(true);
         Label[Index_number].getLabels().addMouseListener(Action2);
         Label[Index_number].getLabels().addMouseMotionListener(Action2);
         Label[Index_number].setLocInfo(Label[Index_number].getLabels());//연결선계산 
         Label[Index_number].setParent(prntLb);
        
         parent.X=realx;
         parent.Y=realy;
         Index_number++;
      }else if (parent.location/10==4) {
         if(parent.location%10==2) {
            realx = (300+70*parent.NodeLevel);
            realy = (250+70*parent.NodeLevel)-55;
         }else if(parent.location%10==3) {
            realx = (300+70*parent.NodeLevel)-55;
            realy = (250+70*parent.NodeLevel);
         }else {
            System.out.println("자식은 최대 3명임 ");
            realx = 0;
            realy = 0;
         }
         System.out.println("추가되는 word"+"["+Index_number+"]: "+ parent.word);
         Label[Index_number]= new ManageLabel();
         Label[Index_number].setLabel(parent.word);
         Label[Index_number].setLabelCount(Index_number);
         Label[Index_number].setPreLevel(parent.preLevel);
         Label[Index_number].setNodeLevel(parent.NodeLevel);
         Label[Index_number].getLabels().setBorder(blackline);               
         Label[Index_number].getLabels().setBounds(realx,realy, 50, 20);
         Label[Index_number].getLabels().setLayout(null);
         Label[Index_number].getLabels().setBackground(color.useColor(level));
         Label[Index_number].getLabels().setOpaque(true);
         Label[Index_number].getLabels().addMouseListener(Action2);
         Label[Index_number].getLabels().addMouseMotionListener(Action2);
         Label[Index_number].setLocInfo(Label[Index_number].getLabels());//연결선계산  
         Label[Index_number].setParent(prntLb);
        
         
         parent.X=realx;
         parent.Y=realy;
         Index_number++;
      }
   
      if(Level !=0)
      System.out.println("부모가 "+prntLb.getLabels().getText()+"일떄: "+sL);
      
      if(parent.next != null)
      {
         visit=true;
         prntLb=Label[Index_number-1];
         first=parent.next;
         System.out.println("parnet: "+parent.word+"first.next :"+first.word);
         System.out.println("getlablecount: "+Label[0].getLabelCount());
         nL=true;
         PrintNode2Map(Label,Action2, Index_number,first,prntLb,LevelColor,++Level,myPanel,nL,sL);
         nL=false;
       
      }
      if(parent.same !=null)
      {
    	  
         first=parent.same;
         sL=true;
        if(visit)
           Index_number=Label[0].getIndexNumber()+1;
        System.out.println("getlablecount: "+Label[0].getLabelCount());
     
         System.out.println("parnet: "+parent.word+"first.same :"+first.word);
         PrintNode2Map(Label,Action2,Index_number,first,parentLabel,LevelColor,level,myPanel,nL,sL);
      }
        
     System.out.println("함수끝 : " +parent.word);
    
      
   }
   public int getTreeLevel() {return TreeLevel;}
   public void setTreeLevel(int TreeLevel) {Tree.TreeLevel= TreeLevel;}
   public String getWord(){ return parent.word; }
   public int getLevel(){ return parent.NodeLevel;}
   
   public int  howManySame() {
         Node tmp = head;
         int k=0;
         for(int i=0;i<1;i++) {
            tmp=tmp.next;
         }
         System.out.println(tmp.word+"세임ㅁ");
         while(tmp.same!=null) {
            ++k;
            tmp=tmp.same;
         }
         return k;
      }
   public Node moveSameNode() {parent=parent.same; return parent;}
   public Node getSameNode() {return parent.same;}
   public Node moveNextNode() {parent=parent.next; return parent;}
   public Node getNextNode() {return parent.next;}
   public Node moveLevelFirstNode() {
       Node tmp = head;
       System.out.print(tmp.word);
      for(int i=0;i<1;i++) {
            tmp=tmp.next;
         }
      parent = tmp;
      System.out.print(tmp.word);
      return tmp;
   }
   public int SameLevelNodeCount(Node sameNode)
   {
      Node sameNodeStart = new Node();
      sameNodeStart = sameNode;
      int sameNodeCount=0;
      while(sameNodeStart.same !=null)
      {
         sameNodeStart=sameNodeStart.same;
         sameNodeCount++;
      }
      return sameNodeCount;
      
   }
   public int getX() {return parent.X;}
   public int getY() {return parent.Y;}
   public int getW() {return parent.W;}
   public int getH() {return parent.H;}
   public Node getRoot() {return head;}
   class Node
   {
      private String word;
      private Node next;
      private Node same;
      private int NodeLevel;
      private int X,Y,W,H;
      private int location;
      private int preLevel;
  
      public Node() {};
      public Node(String word,int NodeLevel,int preLevel, int X,int Y) 
      {
         this.word=word;
         this.NodeLevel=NodeLevel;
         this.preLevel=preLevel;
         this.X=X;
         this.Y=Y;
         this.location = 0;
         this.next=null;
         this.same=null;
         
      }
   }
}
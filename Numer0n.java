package Numer0n;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Numer0n extends JFrame implements ActionListener{
	JLabel label;
	public static JButton button;
	  public static JTextField text;
	  static DefaultTableModel tableModel1;//自分用
	  static DefaultTableModel tableModel2;//相手用
	  Player one = new Player();
	  public static int count = 1;
	  public static JPanel line;
	  public static JPanel line2;
	  public static JPanel line3;
	  public static JPanel line4;
	  public static JPanel line5;
	  public static JPanel line6;
	  public static JPanel line7;
	  public static JLabel label1 = new JLabel("");//
	  public static JLabel label2 = new JLabel("");//
	  public static JLabel label3 = new JLabel("");//
	  public static JLabel label4 = new JLabel("");//
	  public static JLabel label5 = new JLabel("");//
	  public static JLabel label6 = new JLabel("");//eat用
	  public static JLabel label7 = new JLabel("");//bite用
	  public static JLabel label8 = new JLabel("");//getText用
	    public static Player player;
	    public static Player enemy ;
	    static int[] answerown;//
	    static int[] userown ;//
	    static int[] answerenemy;//
	    static int[] userenemy;//
	    static boolean error1 = false;
	    public static int count2;
	  //public String[] tabledata;
	 private static JTable makeTable(TableModel model){
 	JTable table = new JTable(model);
     table.setShowVerticalLines(false);
     table.setShowHorizontalLines(false);
     table.setIntercellSpacing(new Dimension());
     return table;
 }
	 private String[] columnNames = {"NUMBER", "EAT", "BITE"};
	 Numer0n(String title/*,CountError count, boolean error1, int[] answer, int turn*/){
		    setTitle(title);
		    setBounds( 10, 10, 1000, 700);//window size
		    setLayout(new BorderLayout());

		    tableModel1
		    = new DefaultTableModel(columnNames, 0);
		    tableModel2
		    = new DefaultTableModel(columnNames, 0);

		    JTable lefttable = new JTable(tableModel1);
		    JTable righttable = new JTable(tableModel2);
		     
		    line=new JPanel();
			line.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			line.add(label1);
			add("North",line);

			JPanel box_01=new JPanel();
			box_01.setLayout(new BorderLayout());
			line5=new JPanel();
			line5.setLayout(new FlowLayout(FlowLayout.CENTER));
			line5.add(label2);
			
			box_01.add("North",line5);
			add("Center",box_01);
			
			JPanel box_02=new JPanel();
			box_02.setLayout(new BorderLayout());
			line4=new JPanel();
			line4.setLayout(new FlowLayout(FlowLayout.CENTER));			
			line4.add(label3);
			
			box_02.add("North",line4);
			box_01.add("Center",box_02);

			JPanel box_03=new JPanel();
			box_03.setLayout(new BorderLayout());
			line2=new JPanel();
			line2.setLayout(new FlowLayout(FlowLayout.CENTER));			
			label4.setText("重複しない３桁の数字を入力してください");				
			line2.add(label4);
			
			box_03.add("North",line2);
			box_02.add("Center",box_03);

			JPanel box_04=new JPanel();
			box_04.setLayout(new BorderLayout());
			line3=new JPanel();
			line3.setLayout(new FlowLayout(FlowLayout.CENTER));
		    text = new JTextField(15);
			line3.add(text);
			 button = new JButton("attack");
			button.addActionListener(this);
			line3.add(button);
			box_04.add("North",line3);
			box_03.add("Center",box_04);
			
			JPanel box_06=new JPanel();
			box_06.setLayout(new BorderLayout());
			line6=new JPanel();
			line6.setLayout(new FlowLayout(FlowLayout.CENTER));
			label5.setText("START");
			line6.add(label8);
			line6.add(label5);
			
			box_06.add("North",line6);
			box_04.add("Center",box_06);
			
			JPanel box_07=new JPanel();
			box_07.setLayout(new BorderLayout());
			line7=new JPanel();
			line7.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			line7.add(label6);
			line7.add(label7);
			
			box_07.add("North",line7);
			box_06.add("Center",box_07);
			
			
			JPanel box_05=new JPanel();
			box_05.setLayout(new BorderLayout());
			JSplitPane split = new JSplitPane();
			split.setDividerLocation(500);
			split.setPreferredSize(new Dimension(800, 450));//table size
			JScrollPane scroll1 = new JScrollPane(lefttable);
			JScrollPane scroll2 = new JScrollPane(righttable);
			split.setLeftComponent(scroll1);
	        split.setRightComponent(scroll2);
			box_05.add("North",split);
			box_07.add("Center",box_05);
			
		  }
	 //デザイン
	 
	 
	 public static int turn = 0;
  
  public String scan;

  static class Turn{
        
         public int Senkou(){
                 turn = (int)(Math.random()*100)%2;
                 return turn;
         }
         private static void showown(JLabel line,int count){
         	
                 if(count%2 == 1){  line.setText("自分のターン");
                 }
                 else {line.setText("CPUのターン");
                 }
         }
         private static void showturn(JLabel line, int count){
        	 line.setText(count+"ターン");
         }
         }
//攻撃
public void actionPerformed(ActionEvent e){
	String input = text.getText();
	label8.setText(input);
}

static class Player implements ActionListener{
	JButton exit;
	public void Win(JPanel line2,JPanel line3,boolean win){
		 exit = new JButton("exit");
		exit.addActionListener(this);
		if(win==true){
			JLabel label = new JLabel();
		
			line7.add(exit);
	}else{
		
		line7.add(exit);
	}
	}
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();
		if(obj == exit){
			//dispose();
			System.exit(0);//�I��
		}
	}
     public String ComAnswer(){

             String answer = "";

             String numeric = "0123456789";

             for (int i = 0; i<3; i++) {

                 int c = (int) (Math.random() * numeric.length());
                                //重複しない数字を生成
                  answer += numeric.substring(c, c + 1);

                  numeric = numeric.replaceFirst(numeric.substring(c, c + 1), "");

                                }              

                     return answer;
     }
   
}

public static void Error(){
	label4.setText("重複しない数字を入力してください");
}



//main
public static void main (String args[]){
 
 player = new Player();
  enemy = new Player();
int owncount=1;
int enemycount = 1;
 Turn t = new Turn();
 int turn = t.Senkou();
  answerown= new int[3];//相手の答え
  userown = new int[3];//自分の攻撃用
  answerenemy = new int[3];//自分の答え
  userenemy = new int[3];//相手の攻撃用
  String input = new String();
 int[] array = {0,1,2,3,4,5,6,7,8,9,};
 int remainder = 10;

//答えを生成
 for(int i = 0;i<3;i++){
     int select = (int)(Math.random()*remainder);
     answerown[i] = array[select];
     array[select] = array[remainder-1];
     remainder--;

 }
 //答えを生成
 for(int i = 0;i<3;i++){
     int select = (int)(Math.random()*remainder);
     answerenemy[i] = array[select];
     array[select] = array[remainder-1];
     remainder--;

 }
 
 Numer0n test = new Numer0n("NUMER0N"/*,check, error1, answerenemy, turn*/);

 test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 test.setVisible(true);
 String number = Arrays.toString(answerenemy);
 label1.setText("YOUR NUMBER " +number);
 Turn.showown(label3,count);
 //turnshow(label2,check);
 while(true){
if(turn%2==1){
	Turn.showturn(label2, owncount);
	 // label2.setText(owncount+"�^�[��");
	  Turn.showown(label3, turn);
	  //label3.setText("���Ȃ��̃^�[���ł�");
	text.setEnabled(true);
	  button.setEnabled(true);
	if(label8.getText()!= null){
		
	input = label8.getText();
	label8.setText("");
	} 
	
	 //text = new JTextField(15);
	 boolean error1= false;
     
	//長さが足りないとエラーをはく
	 int length = input.length();
	 if(length != 3){
	  error1 = true;
	 }
	 //０～９以外の文字があればエラーをはく
	 for(int i = 0; i<length; i++){
	   char c = input.charAt(i);
	   if(c<'0' || c>'9'){
	     error1 = true;
	   }
	 }
	 //重複していればエラーを吐く
	 for(int i = 0; i<length; i++){
	   for(int j = i+1; j<length; j++){
	     if(input.charAt(i) == input.charAt(j)){
	       error1 = true;
	     }
	   }
	 }
	 //エラー時
	 if(error1 == true){
	   label4.setText("重複しない数字を入力してください");
	  continue;
	 }
	 //inputをuserownに格納
	 for(int i = 0;i<3;i++){
	   userown[i] = Integer.parseInt(input.substring(i, (i+1)));
	 }
	 //hitの判定
	 int hit = 0;

	 for(int i = 0;i<3;i++){
	     if(userown[i] == answerown[i]){
	       hit++;
	     }
	   }


	 //biteの判定
	 int bite = 0;

	 for(int i = 0;i<3;i++){
	     for(int j = 0; j<length; j++){
	       if(userown[i] == answerown[j]){
	         bite++;
	       }
	     }
	   }
	 //ゲーム終了
	 if(hit == 3){
	 	   boolean pl1;
	 	   boolean pl2;
	 
	  	pl1=true;
	  	pl2=false;
	  	player.Win(line2,line3,pl1);
	  	//enemy.Win(line2,line3,pl2);
	  	String[] tabledata = {input, "3", "0"};
	      tableModel1.addRow(tabledata);
	      label4.setText("正解です!!");
	      label5.setText("お疲れさまでした!!");
	      label6.setText("");
	      label7.setText("");
	  break;
	 }
	 else{
	   String eat = String.valueOf(hit);
	   String bit = String.valueOf((bite-hit));
	  
	   String[] tabledata = {input, eat, bit};
	   tableModel1.addRow(tabledata);
	   text.setText("");
	   label5.setText(input);
	   label6.setText("EAT: " +eat);
	   label7.setText("BITE: " +bit);
	  owncount++;
	turn++;
	 }

	 //turn=Turn.shift(turn);
 }else {
	 //CPU用のフロー：改良して人間用にできるように無駄が多い
	 Turn.showturn(label2, enemycount);
	  Turn.showown(label3, turn);
	 text.setEnabled(false);//CPUターンは動かせないように
	  button.setEnabled(false);
	 String attack = enemy.ComAnswer();
     int length = attack.length();
	 if(length != 3){
	  error1 = true;
	 }
	 //
	 for(int i = 0; i<length; i++){
	   char c = attack.charAt(i);
	   if(c<'0' || c>'9'){
	     error1 = true;
	   }
	 }
	 //
	 for(int i = 0; i<length; i++){
	   for(int j = i+1; j<length; j++){
	     if(attack.charAt(i) == attack.charAt(j)){
	       error1 = true;
	     }
	   }
	 }
	 //エラー次
	 if(error1 == true){
	   label4.setText("重複しない数字を入力してください");
	  continue;
	 }
	 //str_userをuserに
	 for(int i = 0;i<3;i++){
	   userenemy[i] = Integer.parseInt(attack.substring(i, (i+1)));
	 }
	 //判定
	 int hit = 0;

	 for(int i = 0;i<3;i++){
	     if(userenemy[i] == answerenemy[i]){
	       hit++;
	     }
	   }


	 //
	 int bite = 0;

	 for(int i = 0;i<3;i++){
	     for(int j = 0; j<length; j++){
	       if(userenemy[i] == answerenemy[j]){
	         bite++;
	       }
	     }
	   }
	 //正解
	 if(hit == 3){
	 	   boolean pl1;
	 	   boolean pl2;
	 
	  	pl1=false;
	  	pl2=true;
	  	//player.Win(line2,line3,pl1);
	  	enemy.Win(line2,line3,pl2);
	  	String[] tabledata = {attack, "3", "0"};
	      tableModel2.addRow(tabledata);
	  

	  break;
	 }
	 else{
	   String eat = String.valueOf(hit);
	   String bit = String.valueOf((bite-hit));
	  
     String[] tabledata = {attack, eat, bit};
  	 tableModel2.addRow(tabledata);
  	 enemycount++;
   turn++;
 }
 }
 }
 
}}


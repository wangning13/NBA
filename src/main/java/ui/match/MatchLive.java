package ui.match;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import data.getdata.GetLive;
import businesslogic.playerbl.PlayerRank;
import businesslogicservice.playerblservice.PlayerRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable1;
import vo.TeamMonthMatchVO;

@SuppressWarnings("serial")
public class MatchLive extends MyPanel implements ActionListener {
	PlayerRankService prs = new PlayerRank();
	GetLive getLive = new GetLive();
	public boolean flag = false;
	Frame frame;
	JScrollPane pane1;
	MyTable1 table1;
	DefaultTableModel model1;
	String[] columnNames1 = { "时间", "球队", "事件","比分" };
    String totalScore = "0-0";
    ArrayList<String> scores = new ArrayList<String>(0) ;
	JLabel rankingBand = new JLabel(Img.MATCHBAND);
	JLabel teamIcon1 = new JLabel();
	JLabel teamIcon2 = new JLabel();
	JLabel point1 = new JLabel("0");
	JLabel point2 = new JLabel("0");
	JLabel point1_1 = new JLabel("0");
	JLabel point2_1 = new JLabel("0");
	JLabel point1_2 = new JLabel("0");
	JLabel point2_2 = new JLabel("0");
	JLabel point1_3 = new JLabel("0");
	JLabel point2_3 = new JLabel("0");
	JLabel point1_4 = new JLabel("0");
	JLabel point2_4 = new JLabel("0");
	JLabel jl1 = new JLabel("第一节");
	JLabel jl2 = new JLabel("第二节");
	JLabel jl3 = new JLabel("第三节");
	JLabel jl4 = new JLabel("第四节");
	JLabel jl5 = new JLabel("主队");
	JLabel jl6 = new JLabel("客队");


	Font font1 = new Font("黑体", Font.BOLD, 16);
	Font font2 = new Font("黑体", Font.BOLD, 40);

	public MatchLive(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		
		this.add(teamIcon1);
		teamIcon1.setBounds(30, 150, 100, 100);
		this.add(teamIcon2);
		teamIcon2.setBounds(922, 150, 100, 100);
		this.add(jl5);
		jl5.setBounds(200, 150, 70, 30);
		jl5.setFont(font1);
		this.add(jl6);
		jl6.setBounds(820, 150, 70, 30);
		jl6.setFont(font1);
		this.add(point1);
		point1.setBounds(190, 155, 200, 100);
		point1.setFont(font2);
		this.add(point2);
		point2.setBounds(810, 155, 200, 100);
		point2.setFont(font2);
		this.add(jl1);
		jl1.setBounds(313, 150, 100, 30);
		jl1.setFont(font1);
		this.add(jl2);
		jl2.setBounds(440, 150, 100, 30);
		jl2.setFont(font1);
		this.add(jl3);
		jl3.setBounds(570, 150, 100, 30);
		jl3.setFont(font1);
		this.add(jl4);
		jl4.setBounds(700, 150, 100, 30);
		jl4.setFont(font1);

		this.add(point1_1);
		point1_1.setBounds(325, 180, 100, 30);
		point1_1.setFont(font1);
		this.add(point1_2);
		point1_2.setBounds(455, 180, 100, 30);
		point1_2.setFont(font1);
		this.add(point1_3);
		point1_3.setBounds(585, 180, 100, 30);
		point1_3.setFont(font1);
		this.add(point1_4);
		point1_4.setBounds(715, 180, 100, 30);
		point1_4.setFont(font1);

		this.add(point2_1);
		point2_1.setBounds(325, 210, 100, 30);
		point2_1.setFont(font1);
		this.add(point2_2);
		point2_2.setBounds(455, 210, 100, 30);
		point2_2.setFont(font1);
		this.add(point2_3);
		point2_3.setBounds(585, 210, 100, 30);
		point2_3.setFont(font1);
		this.add(point2_4);
		point2_4.setBounds(715, 210, 100, 30);
		point2_4.setFont(font1);

		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 100);



		Object[][] data1 = null;
		model1 = new DefaultTableModel(new Object[][] {}, columnNames1);
		model1.setDataVector(data1, columnNames1);
		table1 = new MyTable1(model1);

		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane1 = new JScrollPane(table1);
		this.add(pane1);
		pane1.setBounds(0, 250, 1052, 400);
        timer runner=new timer();
        runner.start();
        
        
	}

	public void update(TeamMonthMatchVO temp) {
		ImageIcon icon = Img.loadTeam(temp.getHost());
		icon.setImage(icon.getImage().getScaledInstance(100, 100,
				Image.SCALE_DEFAULT));
		teamIcon1.setIcon(icon);

		icon = Img.loadTeam(temp.getGuest());
		icon.setImage(icon.getImage().getScaledInstance(100, 100,
				Image.SCALE_DEFAULT));
		teamIcon2.setIcon(icon);


		String score[] = temp.getScore().split("-");
		String first[] = temp.getFirst().split("-");
		String second[] = temp.getSecond().split("-");
		String third[] = temp.getThird().split("-");
		String fourth[] = temp.getFourth().split("-");

		point1.setText(score[0]);
		point2.setText(score[1]);
		point1_1.setText(first[0]);
		point2_1.setText(first[1]);
		point1_2.setText(second[0]);
		point2_2.setText(second[1]);
		point1_3.setText(third[0]);
		point2_3.setText(third[1]);
		point1_4.setText(fourth[0]);
		point2_4.setText(fourth[1]);

		GetLive getLive = new GetLive();
		ArrayList<ArrayList<String>> live = getLive.getLiveString(); 
		model1.setDataVector(getData(live), columnNames1);
		table1.setWidth();
		table1.updateUI();
		
		for(int i = 0;i<scores.size();i++){
			System.out.println(scores.get(i));
		}
		

		
		ArrayList<String> temps = new ArrayList<String>(0);
		for(int i = 0;i<scores.size();i++){
			temps.add(scores.get(scores.size()-i-1));
		}
		int num = temps.size();
		for(int i = 0;i<4-num;i++){
			if(temps.size()==0){
				temps.add("0-0");
			}
			else
				temps.add(temps.get(temps.size()-1));
				
		}
		
		for(int i = temps.size()-2;i>=0;i--){
			String[] temp2 = temps.get(i+1).split("-");
			String[] temp1 = temps.get(i).split("-");
			temps.set(i+1,String.valueOf(Integer.parseInt(temp2[0])-Integer.parseInt(temp1[0]))+"-"+String.valueOf(Integer.parseInt(temp2[1])-Integer.parseInt(temp1[1])));
		}
		score = this.totalScore.split("-");
		first = temps.get(0).split("-");
		second = temps.get(1).split("-");
		third = temps.get(2).split("-");
		fourth = temps.get(3).split("-");
		
		point1.setText(score[0]);
		point2.setText(score[1]);
		
		point1_1.setText(first[0]);
		point2_1.setText(first[1]);
		point1_2.setText(second[0]);
		point2_2.setText(second[1]);
		point1_3.setText(third[0]);
		point2_3.setText(third[1]);
		point1_4.setText(fourth[0]);
		point2_4.setText(fourth[1]);
	}
	
	public Object[][] getData(ArrayList<ArrayList<String>> live) {
		int num = live.size();
		Object[][] data = new Object[num][];
		boolean flag = true;
		boolean flag1 = false;
		scores.clear();
		for (int i = 0; i < num; i++) {
			
			if(live.get(i).size()==4){
			    Object[] temp = { live.get(i).get(0),
			        live.get(i).get(1),
					live.get(i).get(2),
					live.get(i).get(3),
					
			     };
			     data[i] = temp;
			     if(flag){
			    	 totalScore = live.get(i).get(3);
			    	 scores.add(live.get(i).get(3));
			    	 flag = false;
			     }
			     if(flag1){
			    	 scores.add(live.get(i).get(3));
			    	 flag1 = false;
			     }
			}
			else{
				Object[] temp = { "","",live.get(i).get(0),""
	
					 };
				data[i] = temp;
				if(live.get(i).get(0).equals("第3节结束")||live.get(i).get(0).equals("第2节结束")||live.get(i).get(0).equals("第1节结束")){
				    flag1 = true;	
				}
					}
		}
		return data;
	}
	
	public void update(){
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	ArrayList<ArrayList<String>> live = getLive.getLiveString(); 
	    		model1.setDataVector(getData(live), columnNames1);
	    		table1.setWidth();
	    		table1.updateUI();
	                 

		for(int i = 0;i<scores.size();i++){
			System.out.println(scores.get(i));
		}
		

		
		ArrayList<String> temps = new ArrayList<String>(0);
		for(int i = 0;i<scores.size();i++){
			temps.add(scores.get(scores.size()-i-1));
		}
		int num = temps.size();
		for(int i = 0;i<4-num;i++){
			if(temps.size()==0){
				temps.add("0-0");
			}
			else
				temps.add(temps.get(temps.size()-1));
				
		}
		
		for(int i = temps.size()-2;i>=0;i--){
			String[] temp2 = temps.get(i+1).split("-");
			String[] temp1 = temps.get(i).split("-");
			temps.set(i+1,String.valueOf(Integer.parseInt(temp2[0])-Integer.parseInt(temp1[0]))+"-"+String.valueOf(Integer.parseInt(temp2[1])-Integer.parseInt(temp1[1])));
		}
		String score[] = totalScore.split("-");
		String first[] = temps.get(0).split("-");
		String second[] = temps.get(1).split("-");
		String third[] = temps.get(2).split("-");
		String fourth[] = temps.get(3).split("-");
		
		point1.setText(score[0]);
		point2.setText(score[1]);
		
		point1_1.setText(first[0]);
		point2_1.setText(first[1]);
		point1_2.setText(second[0]);
		point2_2.setText(second[1]);
		point1_3.setText(third[0]);
		point2_3.setText(third[1]);
		point1_4.setText(fourth[0]);
		point2_4.setText(fourth[1]);
	                 }
		 });
	      
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("home")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		}
		if (e.getActionCommand().equals("back")) {		
			frame.change(this, Frame.matchesPanel);
			Frame.currentPanel = "matches";
			
		}

	}
	public class timer extends Thread 
	{

	public void run(){
	    for(int i=0;i<1000;i++){
	        System.out.println(i);
	        update();
	        try{
	            Thread.sleep(20000);//睡眠20000毫秒
	        }catch(InterruptedException e){e.printStackTrace();}
	    }
	}
	 
	}

}

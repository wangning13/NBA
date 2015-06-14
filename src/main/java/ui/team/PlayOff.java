package ui.team;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.IO;

@SuppressWarnings("serial")
public class PlayOff  extends MyPanel implements ActionListener{
	Frame frame;
	JLabel jl = new JLabel(Img.PLAYOFF);
	Font font1 = new Font("微软雅黑", Font.BOLD, 20);
	Font font2 = new Font("微软雅黑", Font.BOLD, 28);
	JLabel[] list = new JLabel[30];
	JLabel score1;
	JLabel score2;
	String[] score;
	String[] team;
	//ArrayList<JLabel> list = new ArrayList<JLabel>();
	public final static int HIGHT = 80;
	public final static int WIDTH = 100;
	
	public PlayOff(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
	
	    ArrayList<String> text = IO.readFile("data/playOff/14-15.txt");
	    score = text.get(0).split(",");
	    team = text.get(1).split(",");

        for(int i = 0;i<28;i++){
        	list[i] = new JLabel(score[i]);
        	this.add(list[i]);
    		list[i].setFont(font1);
			ImageIcon icon = Img.loadTeam1(team[i]);
			icon.setImage(icon.getImage().getScaledInstance(50, 50,
					Image.SCALE_DEFAULT));
			list[i].setIcon(icon);
        }
	    
	//	 l1 = new JLabel(score[0]);
        list[0].setBounds(80, 160-3, WIDTH, HIGHT);	 
	//	 l2 = new JLabel(score[0]);
        list[1].setLocation(80, 210-3);
        list[1].setSize(WIDTH, HIGHT);
	//	 l3 = new JLabel(score[0]);
        list[2].setSize(WIDTH, HIGHT);
        list[2].setLocation(80, 280-3);
	//	 l4 = new JLabel("l4");
        list[3].setSize(WIDTH, HIGHT);
        list[3].setLocation(80, 330-3);
	//	 l5 = new JLabel("l5");
        list[4].setSize(WIDTH, HIGHT);
        list[4].setLocation(80, 400-3);
	//	 l6 = new JLabel("l6");
        list[5].setSize(WIDTH, HIGHT);
        list[5].setLocation(80, 450-3);
	//	 l7 = new JLabel("l7");
        list[6].setSize(WIDTH, HIGHT);
        list[6].setLocation(80, 520-3);
	//	 l8 = new JLabel("l8");
        list[7].setSize(WIDTH, HIGHT);
        list[7].setLocation(80, 570-3);
	//	 r1 = new JLabel("r1");
        list[8].setSize(WIDTH, HIGHT);
        list[8].setLocation(910, 160-3);
	//	 r2 = new JLabel("r2");
        list[9].setLocation(910, 210-3);
        list[9].setSize(WIDTH, HIGHT);
	//	 r3 = new JLabel("r3");
        list[10].setLocation(910, 280-3);
        list[10].setSize(WIDTH, HIGHT);
	//	 r4 = new JLabel("r4");
        list[11].setLocation(910, 330-3);
        list[11].setSize(WIDTH, HIGHT);
	//	 r5 = new JLabel("r5");
        list[12].setLocation(910, 400-3);
        list[12].setSize(WIDTH, HIGHT);
	//	 r6 = new JLabel("r6");
        list[13].setLocation(910, 450-3);
        list[13].setSize(WIDTH, HIGHT);
	//	 r7 = new JLabel("r7");
        list[14].setLocation(910, 520-3);
        list[14].setSize(WIDTH, HIGHT);
	//	 r8 = new JLabel("r8");
        list[15].setLocation(910, 570-3);
        list[15].setSize(WIDTH, HIGHT);
		
	//	 ll1 = new JLabel("ll1");
        list[16].setSize(WIDTH, HIGHT);
        list[16].setLocation(230, 215);
	//	 ll2 = new JLabel("ll2");
        list[17].setSize(WIDTH, HIGHT);
        list[17].setLocation(230, 265);
	//	 ll3 = new JLabel("ll3");
        list[18].setSize(WIDTH, HIGHT);
        list[18].setLocation(230, 458);
	//	 ll4 = new JLabel("ll4");
        list[19].setSize(WIDTH, HIGHT);
        list[19].setLocation(230, 508);
	//	 rr1 = new JLabel("rr1");
        list[20].setSize(WIDTH, HIGHT);
        list[20].setLocation(750, 215);
	//	 rr2 = new JLabel("rr2");
        list[21].setSize(WIDTH, HIGHT);
        list[21].setLocation(750, 265);
	//	 rr3 = new JLabel("rr3");
        list[22].setSize(WIDTH, HIGHT);
        list[22].setLocation(750, 458);
	//	 rr4 = new JLabel("rr4");
        list[23].setSize(WIDTH, HIGHT);
        list[23].setLocation(750, 508);
		
	//	 lll1 = new JLabel("lll1");
        list[24].setSize(WIDTH, HIGHT);
        list[24].setLocation(315, 335);
	//	 lll2 = new JLabel("lll2");
        list[25].setSize(WIDTH, HIGHT);
        list[25].setLocation(315, 385);
	//	 rrr1 = new JLabel("rrr1");
        list[26].setSize(WIDTH, HIGHT);
        list[26].setLocation(650, 335);
  //	 rrr2 = new JLabel("rrr2");
        list[27].setSize(WIDTH, HIGHT);
        list[27].setLocation(650, 385);
		
    	list[28]= new JLabel();
    	this.add(list[28]);
        list[28].setSize(100, 100);
        list[28].setLocation(470, 240);
    	list[28].setFont(font2);
		ImageIcon icon = Img.loadTeam(team[28]);
		icon.setImage(icon.getImage().getScaledInstance(100, 100,
				Image.SCALE_DEFAULT));
		list[28].setIcon(icon);
		
    	list[29] = new JLabel();
    	this.add(list[29]);
        list[29].setSize(100, 100);
        list[29].setLocation(470, 420);
    	list[29].setFont(font2);
		ImageIcon icon1 = Img.loadTeam(team[29]);
		icon1.setImage(icon1.getImage().getScaledInstance(100, 100,
				Image.SCALE_DEFAULT));
		list[29].setIcon(icon1);
  
		score1 = new JLabel(score[28]);
		this.add(score1);
		score1.setBounds(510, 340, 40, 30);
		score1.setFont(font2);
		
		score2 = new JLabel(score[29]);
		this.add(score2);
		score2.setBounds(510, 390, 40, 30);
		score2.setFont(font2);
		


        this.add(jl);
        jl.setBounds(0, 150, 1052, 500);
        
        
	}
	
	public void update(String season){
	    ArrayList<String> text = IO.readFile("data/playOff/"+season+".txt");
	    score = text.get(0).split(",");
	    team = text.get(1).split(",");
        for(int i = 0;i<28;i++){
        	list[i].setText(score[i]);
			ImageIcon icon = Img.loadTeam1(team[i]);
			icon.setImage(icon.getImage().getScaledInstance(50, 50,
					Image.SCALE_DEFAULT));
			list[i].setIcon(icon);
        }
    	

		ImageIcon icon = Img.loadTeam(team[28]);
		icon.setImage(icon.getImage().getScaledInstance(100, 100,
				Image.SCALE_DEFAULT));
		list[28].setIcon(icon);
		
		ImageIcon icon1 = Img.loadTeam(team[29]);
		icon1.setImage(icon1.getImage().getScaledInstance(100, 100,
				Image.SCALE_DEFAULT));
		list[29].setIcon(icon1);
  
		score1.setText(score[28]);
;
		
		score2.setText(score[29]);

		
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		} else if (e.getActionCommand().equals("back")) {
			frame.change(this, Frame.rankingPanel);
			Frame.currentPanel = "ranking";
		} 
	}
}

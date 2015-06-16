package ui.team;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import businesslogic.playerbl.PlayerRank;
import businesslogic.teambl.TeamRank;
import businesslogicservice.playerblservice.PlayerRankService;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.player.MyComboBoxUI;
import ui.tools.JFreeUtils;
import ui.tools.Translate;
import vo.PlayerVO;
import vo.TeamVO;


@SuppressWarnings("serial")
public class TeamsCompare extends MyPanel implements ActionListener {
	Frame frame;
	TeamRankService trs = new TeamRank();
	String team1 = "";
	String team2 = "";
	JLabel teamIcon1 = new JLabel();
	JLabel teamIcon2 = new JLabel();
	JLabel jl1 = new JLabel("主队");
	JLabel jl2 = new JLabel("客队");
	JLabel score1 = new JLabel();
	JLabel score2 = new JLabel();
	JLabel jl = new JLabel();
	JLabel jl3 = new JLabel("比分预测");
	JLabel jl4 = new JLabel("历史数据");
	JLabel jl5 = new JLabel("得分");
	JLabel jl6 = new JLabel("篮板");
	JLabel jl7 = new JLabel("助攻");
	JLabel jl8 = new JLabel("三分%");
	JLabel jl9 = new JLabel("罚球%");
	
	JLabel l1 = new JLabel(Img.BLUE);
	JLabel l2 = new JLabel(Img.BLUE);
	JLabel l3 = new JLabel(Img.BLUE);
	JLabel l4 = new JLabel(Img.BLUE);
	JLabel l5 = new JLabel(Img.BLUE);
	JLabel r1 = new JLabel(Img.GREY);
	JLabel r2 = new JLabel(Img.GREY);
	JLabel r3 = new JLabel(Img.GREY);
	JLabel r4 = new JLabel(Img.GREY);
	JLabel r5 = new JLabel(Img.GREY);
	
	JLabel ll1 = new JLabel();
	JLabel ll2 = new JLabel();
	JLabel ll3 = new JLabel();
	JLabel ll4 = new JLabel();
	JLabel ll5 = new JLabel();
	JLabel rr1 = new JLabel();
	JLabel rr2 = new JLabel();
	JLabel rr3 = new JLabel();
	JLabel rr4 = new JLabel();
	JLabel rr5 = new JLabel();
	
	JComboBox<String> selectTeam1 = new JComboBox<String>();
	JComboBox<String> selectTeam2 = new JComboBox<String>();
	Font font = new Font("黑体", Font.BOLD, 16);
	Font font1 = new Font("黑体", Font.BOLD, 14);
	Font font2 = new Font("黑体", Font.BOLD, 40);
	JLabel blank = new JLabel(Img.BLANK);
	public TeamsCompare(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

		this.add(l1);
		this.add(l2);
		this.add(l3);
		this.add(l4);
		this.add(l5);
		this.add(r1);
		this.add(r2);
		this.add(r3);
		this.add(r4);
		this.add(r5);
		this.add(ll1);
		this.add(ll2);
		this.add(ll3);
		this.add(ll4);
		this.add(ll5);
		this.add(rr1);
		this.add(rr2);
		this.add(rr3);
		this.add(rr4);
		this.add(rr5);
		ll1.setFont(font);
		ll2.setFont(font);
		ll3.setFont(font);
		ll4.setFont(font);
		ll5.setFont(font);
		rr1.setFont(font);
		rr2.setFont(font);
		rr3.setFont(font);
		rr4.setFont(font);
		rr5.setFont(font);
		
		
		this.add(jl);
		jl.setBounds(250,150,552,495);
		
		this.add(jl3);
		jl3.setBounds(440,150,200,100);
		jl3.setFont(font2);
		
		this.add(jl4);
		jl4.setBounds(440,280,200,100);
		jl4.setFont(font2);
		
		this.add(jl5);
		jl5.setBounds(510,380,100,30);
		jl5.setFont(font1);
		this.add(jl6);
		jl6.setBounds(510,430,100,30);
		jl6.setFont(font1);
		this.add(jl7);
		jl7.setBounds(510,480,100,30);
		jl7.setFont(font1);
		this.add(jl8);
		jl8.setBounds(510,530,100,30);
		jl8.setFont(font1);
		this.add(jl9);
		jl9.setBounds(510,580,100,30);
		jl9.setFont(font1);
		
		this.add(score1);
		score1.setBounds(350,200,120,100);
		score1.setFont(font2);
		
		this.add(score2);
		score2.setBounds(600,200,120,100);
		score2.setFont(font2);
		
		this.add(teamIcon1);
		teamIcon1.setBounds(0, 150, 200, 200);
		this.add(jl1);
		jl1.setBounds(80,550,200,30);
		jl1.setFont(font);
		this.add(selectTeam1);
		selectTeam1.setBounds(30,600,140,30);
		selectTeam1.setFont(font1);
		selectTeam1.setUI(new MyComboBoxUI());

		this.add(teamIcon2);
		teamIcon2.setBounds(852, 150, 200, 200);
		this.add(jl2);
		jl2.setBounds(930,550,200,30);
		jl2.setFont(font);
		this.add(selectTeam2);
		selectTeam2.setBounds(880,600,140,30);
		selectTeam2.setFont(font1);
		selectTeam2.setUI(new MyComboBoxUI());

		this.add(blank);
		blank.setBounds(0,150,1052,500);
		
		selectTeam1.addItem("请选择球队");
		selectTeam1.addItem("圣安东尼奥马刺");
		selectTeam1.addItem("孟菲斯灰熊");
		selectTeam1.addItem("达拉斯小牛");
		selectTeam1.addItem("休斯顿火箭");
		selectTeam1.addItem("新奥尔良鹈鹕");
		selectTeam1.addItem("明尼苏达森林狼");
		selectTeam1.addItem("丹佛掘金");
		selectTeam1.addItem("尤他爵士");
		selectTeam1.addItem("波特兰开拓者");
		selectTeam1.addItem("俄克拉荷马雷霆");
		selectTeam1.addItem("萨克拉门托国王");
		selectTeam1.addItem("菲尼克斯太阳");
		selectTeam1.addItem("洛杉矶湖人");
		selectTeam1.addItem("洛杉矶快船");
		selectTeam1.addItem("金州勇士");
		selectTeam1.addItem("迈阿密热");
		selectTeam1.addItem("奥兰多魔术");
		selectTeam1.addItem("亚特兰大老鹰");
		selectTeam1.addItem("华盛顿奇才");
		selectTeam1.addItem("夏洛特黄蜂");
		selectTeam1.addItem("底特律活塞");
		selectTeam1.addItem("印第安纳步行者");
		selectTeam1.addItem("克里夫兰骑士");
		selectTeam1.addItem("芝加哥公牛");
		selectTeam1.addItem("密尔沃基雄鹿");
		selectTeam1.addItem("波士顿凯尔特人");
		selectTeam1.addItem("费城76人");
		selectTeam1.addItem("纽约尼克斯");
		selectTeam1.addItem("布鲁克林篮网");
		selectTeam1.addItem("多伦多猛龙");
		
		selectTeam2.addItem("请选择球队");
		selectTeam2.addItem("圣安东尼奥马刺");
		selectTeam2.addItem("孟菲斯灰熊");
		selectTeam2.addItem("达拉斯小牛");
		selectTeam2.addItem("休斯顿火箭");
		selectTeam2.addItem("新奥尔良鹈鹕");
		selectTeam2.addItem("明尼苏达森林狼");
		selectTeam2.addItem("丹佛掘金");
		selectTeam2.addItem("尤他爵士");
		selectTeam2.addItem("波特兰开拓者");
		selectTeam2.addItem("俄克拉荷马雷霆");
		selectTeam2.addItem("萨克拉门托国王");
		selectTeam2.addItem("菲尼克斯太阳");
		selectTeam2.addItem("洛杉矶湖人");
		selectTeam2.addItem("洛杉矶快船");
		selectTeam2.addItem("金州勇士");
		selectTeam2.addItem("迈阿密热");
		selectTeam2.addItem("奥兰多魔术");
		selectTeam2.addItem("亚特兰大老鹰");
		selectTeam2.addItem("华盛顿奇才");
		selectTeam2.addItem("夏洛特黄蜂");
		selectTeam2.addItem("底特律活塞");
		selectTeam2.addItem("印第安纳步行者");
		selectTeam2.addItem("克里夫兰骑士");
		selectTeam2.addItem("芝加哥公牛");
		selectTeam2.addItem("密尔沃基雄鹿");
		selectTeam2.addItem("波士顿凯尔特人");
		selectTeam2.addItem("费城76人");
		selectTeam2.addItem("纽约尼克斯");
		selectTeam2.addItem("布鲁克林篮网");
		selectTeam2.addItem("多伦多猛龙");

		
		selectTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if(selectTeam1.getSelectedIndex()!=0){
			       update1(Translate.translate(selectTeam1.getSelectedItem().toString()));
				}
			}			
		});
		
		selectTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if(selectTeam2.getSelectedIndex()!=0){
					update2(Translate.translate(selectTeam2.getSelectedItem().toString()));
				}
			}			
		});

	}

	public void update(String name) {
        team1 = name;
		ImageIcon icon = Img.loadTeam(name);
		icon.setImage(icon.getImage().getScaledInstance(200, 200,
				Image.SCALE_DEFAULT));
		teamIcon1.setIcon(icon);
		selectTeam1.setSelectedIndex(0);
	
		ImageIcon icon1 = Img.loadPlayer("NBA");
		icon1.setImage(icon1.getImage().getScaledInstance(85, 200,
				Image.SCALE_DEFAULT));
		teamIcon2.setIcon(icon1);
		selectTeam2.setSelectedIndex(0);
		
		score1.setText("0");
		score2.setText("0");
		
	    TeamVO teamData = trs.getTeamData("14-15", name);
	    
	    double score = teamData.getAverageScoring();
	    double background = teamData.getAverageBackboard();
	    double assist = teamData.getAverageAsist();
	    double threePercent = teamData.getThreePointShotPercentage();
	    double freePercent = teamData.getFreeThrowPercentage();
	    
	    l1.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(score))*300/120,380,Integer.parseInt(new DecimalFormat("0").format(score))*300/120 ,30);
	    l2.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(background))*300/100,430,Integer.parseInt(new DecimalFormat("0").format(background))*300/100 ,30);
	    l3.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(assist))*300/100,480,Integer.parseInt(new DecimalFormat("0").format(assist))*300/100 ,30);
	    l4.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(threePercent*100))*250/100,530,Integer.parseInt(new DecimalFormat("0").format(threePercent*100))*250/100 ,30);
	    l5.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(freePercent*100))*250/100,580,Integer.parseInt(new DecimalFormat("0").format(freePercent*100))*250/100 ,30);

	    ll1.setText(String.valueOf(score));
	    ll2.setText(String.valueOf(background));
	    ll3.setText(String.valueOf(assist));
	    ll4.setText(String.valueOf(threePercent));
	    ll5.setText(String.valueOf(freePercent));
	    ll1.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(score))*300/120,380,50 ,30);
	    ll2.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(background))*300/100,430,50 ,30);
	    ll3.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(assist))*300/100,480,50,30);
	    ll4.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(threePercent*100))*250/100,530,50 ,30);
	    ll5.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(freePercent*100))*250/100,580,50,30);
	
	    
	    r1.setBounds(0,0,0,0);
	    r2.setBounds(0,0,0,0);
	    r3.setBounds(0,0,0,0);
	    r4.setBounds(0,0,0,0);
	    r5.setBounds(0,0,0,0);
	    rr1.setBounds(0,0,0,0);
	    rr2.setBounds(0,0,0,0);
	    rr3.setBounds(0,0,0,0);
	    rr4.setBounds(0,0,0,0);
	    rr5.setBounds(0,0,0,0);
	    
	}
	
	public void update1(String name){
        team1 = name;
		ImageIcon icon = Img.loadTeam(name);
		icon.setImage(icon.getImage().getScaledInstance(200, 200,
				Image.SCALE_DEFAULT));
		teamIcon1.setIcon(icon);
		if(!team1.equals("")&&!team2.equals("")){
			double[] scores = trs.TwoScoring(team1, team2);
			score1.setText(String.valueOf(scores[0]));
			score2.setText(String.valueOf(scores[1]));
		}
		
		
	    TeamVO teamData = trs.getTeamData("14-15", name);
	    
	    double score = teamData.getAverageScoring();
	    double background = teamData.getAverageBackboard();
	    double assist = teamData.getAverageAsist();
	    double threePercent = teamData.getThreePointShotPercentage();
	    double freePercent = teamData.getFreeThrowPercentage();
	    
	    l1.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(score))*300/120,380,Integer.parseInt(new DecimalFormat("0").format(score))*300/120 ,30);
	    l2.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(background))*300/100,430,Integer.parseInt(new DecimalFormat("0").format(background))*300/100 ,30);
	    l3.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(assist))*300/100,480,Integer.parseInt(new DecimalFormat("0").format(assist))*300/100 ,30);
	    l4.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(threePercent*100))*250/100,530,Integer.parseInt(new DecimalFormat("0").format(threePercent*100))*250/100 ,30);
	    l5.setBounds( 485-Integer.parseInt(new DecimalFormat("0").format(freePercent*100))*250/100,580,Integer.parseInt(new DecimalFormat("0").format(freePercent*100))*250/100 ,30);

	    ll1.setText(String.valueOf(score));
	    ll2.setText(String.valueOf(background));
	    ll3.setText(String.valueOf(assist));
	    ll4.setText(String.valueOf(threePercent));
	    ll5.setText(String.valueOf(freePercent));
	    ll1.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(score))*300/120,380,50 ,30);
	    ll2.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(background))*300/100,430,50 ,30);
	    ll3.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(assist))*300/100,480,50,30);
	    ll4.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(threePercent*100))*250/100,530,50 ,30);
	    ll5.setBounds( 415-Integer.parseInt(new DecimalFormat("0").format(freePercent*100))*250/100,580,50,30);

	}
	
	public void update2(String name){
        team2 = name;
		ImageIcon icon = Img.loadTeam(name);
		icon.setImage(icon.getImage().getScaledInstance(200, 200,
				Image.SCALE_DEFAULT));
		teamIcon2.setIcon(icon);	
		if(!team1.equals("")&&!team2.equals("")){
			double[] scores = trs.TwoScoring(team1, team2);
			score1.setText(String.valueOf(scores[0]));
			score2.setText(String.valueOf(scores[1]));
		}
		
		
	    TeamVO teamData = trs.getTeamData("14-15", name);
	    
	    double score = teamData.getAverageScoring();
	    double background = teamData.getAverageBackboard();
	    double assist = teamData.getAverageAsist();
	    double threePercent = teamData.getThreePointShotPercentage();
	    double freePercent = teamData.getFreeThrowPercentage();
	    
	    r1.setBounds( 570,380,Integer.parseInt(new DecimalFormat("0").format(score))*300/120 ,30);
	    r2.setBounds( 570,430,Integer.parseInt(new DecimalFormat("0").format(background))*300/100 ,30);
	    r3.setBounds( 570,480,Integer.parseInt(new DecimalFormat("0").format(assist))*300/100 ,30);
	    r4.setBounds( 570,530,Integer.parseInt(new DecimalFormat("0").format(threePercent*100))*250/100 ,30);
	    r5.setBounds( 570,580,Integer.parseInt(new DecimalFormat("0").format(freePercent*100))*250/100 ,30);

	    rr1.setText(String.valueOf(score));
	    rr2.setText(String.valueOf(background));
	    rr3.setText(String.valueOf(assist));
	    rr4.setText(String.valueOf(threePercent));
	    rr5.setText(String.valueOf(freePercent));
	    rr1.setBounds( 600+Integer.parseInt(new DecimalFormat("0").format(score))*300/120,380,50,30);
	    rr2.setBounds( 600+Integer.parseInt(new DecimalFormat("0").format(background))*300/100,430,50,30);
	    rr3.setBounds( 600+Integer.parseInt(new DecimalFormat("0").format(assist))*300/100,480,50,30);
	    rr4.setBounds( 600+Integer.parseInt(new DecimalFormat("0").format(threePercent*100))*250/100,530,50 ,30);
	    rr5.setBounds( 600+Integer.parseInt(new DecimalFormat("0").format(freePercent*100))*250/100,580,50,30);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		} else if (e.getActionCommand().equals("back")) {
			frame.change(this, Frame.singleTeamPanel);
			Frame.currentPanel = "singleTeam";
		} 
	}
}

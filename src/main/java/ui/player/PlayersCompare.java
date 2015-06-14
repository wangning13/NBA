package ui.player;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import businesslogic.playerbl.PlayerRank;
import businesslogicservice.playerblservice.PlayerRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.JFreeUtils;
import ui.tools.Translate;
import vo.PlayerVO;


@SuppressWarnings("serial")
public class PlayersCompare extends MyPanel implements ActionListener {
	Frame frame;
	PlayerRankService prs = new PlayerRank();
	String player1 = "league";
	String player2 = "league";
	JLabel playerIcon1 = new JLabel(Img.loadPlayer("Jeremy Lin"));
	JLabel playerIcon2 = new JLabel(Img.loadPlayer("Jeremy Lin"));
	JLabel jl1 = new JLabel("");
	JLabel jl2 = new JLabel("");
	JLabel jl = new JLabel();
	JComboBox<String> selectTeam1 = new JComboBox<String>();
	JComboBox<String> selectPlayer1 = new JComboBox<String>();
	JComboBox<String> selectTeam2 = new JComboBox<String>();
	JComboBox<String> selectPlayer2 = new JComboBox<String>();
	Font font = new Font("黑体", Font.BOLD, 16);
	Font font1 = new Font("黑体", Font.BOLD, 12);
	JLabel blank = new JLabel(Img.BLANK);
	public PlayersCompare(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

		this.add(jl);
		jl.setBounds(250,150,552,495);
		
		this.add(playerIcon1);
		playerIcon1.setBounds(0, 150, 220, 350);
		this.add(jl1);
		jl1.setBounds(50,550,200,30);
		jl1.setFont(font);
		this.add(selectTeam1);
		selectTeam1.setBounds(5,600,120,25);
		selectTeam1.setFont(font1);
		selectTeam1.setUI(new MyComboBoxUI());
		this.add(selectPlayer1);
		selectPlayer1.setBounds(130,600,120,25);
		selectPlayer1.setFont(font1);
		selectPlayer1.setUI(new MyComboBoxUI());
		
		this.add(playerIcon2);
		playerIcon2.setBounds(827, 150, 220, 350);
		this.add(jl2);
		jl2.setBounds(852,550,200,30);
		jl2.setFont(font);
		this.add(selectTeam2);
		selectTeam2.setBounds(802,600,120,25);
		selectTeam2.setFont(font1);
		selectTeam2.setUI(new MyComboBoxUI());
		this.add(selectPlayer2);
		selectPlayer2.setBounds(927,600,120,25);
		selectPlayer2.setFont(font1);
		selectPlayer2.setUI(new MyComboBoxUI());
		
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
		
		selectPlayer1.addItem("请选择球员");
		selectPlayer2.addItem("请选择球员");
		
		selectTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if(selectTeam1.getSelectedIndex()!=0){
					ArrayList<String> players = prs.getAllPlayer("14-15", Translate.translate(selectTeam1.getSelectedItem().toString()));
					selectPlayer1.removeAllItems();
					selectPlayer1.addItem("请选择球员");
					for(int i=0;i<players.size();i++){
						selectPlayer1.addItem(players.get(i));
					}
				}
			}
			
		});
		
		selectTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if(selectTeam2.getSelectedIndex()!=0){
					ArrayList<String> players = prs.getAllPlayer("14-15", Translate.translate(selectTeam2.getSelectedItem().toString()));
					selectPlayer2.removeAllItems();
					selectPlayer2.addItem("请选择球员");
					for(int i=0;i<players.size();i++){
						selectPlayer2.addItem(players.get(i));
					}
				}
			}
			
		});
		
		selectPlayer1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if(selectPlayer1.getSelectedIndex()!=0&&selectPlayer1.getSelectedItem()!=null){
					update1(selectPlayer1.getSelectedItem().toString());
				}
			}
			
		});
		
		selectPlayer2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if(selectPlayer2.getSelectedIndex()!=0&&selectPlayer2.getSelectedItem()!=null){
					update2(selectPlayer2.getSelectedItem().toString());
				}
			}
			
		});
	}

	public void update(String name) {
        player1 = name;
		ImageIcon icon = Img.loadPlayer(name);
		icon.setImage(icon.getImage().getScaledInstance(220, 350,
				Image.SCALE_DEFAULT));
		playerIcon1.setIcon(icon);
		jl1.setText(name);
		selectTeam1.setSelectedIndex(0);
		selectPlayer1.setSelectedIndex(0);
		
		player2 = "league";
		ImageIcon icon1 = Img.loadPlayer("NBA");
		icon1.setImage(icon1.getImage().getScaledInstance(128, 300,
				Image.SCALE_DEFAULT));
		playerIcon2.setIcon(icon1);
		jl2.setText("Average of League");
		selectTeam2.setSelectedIndex(0);
		selectPlayer2.setSelectedIndex(0);
		updateChart();
	}
	
	public void update1(String name){
        player1 = name;
		ImageIcon icon = Img.loadPlayer(name);
		icon.setImage(icon.getImage().getScaledInstance(220, 350,
				Image.SCALE_DEFAULT));
		playerIcon1.setIcon(icon);
		jl1.setText(name);
		
		updateChart();
	}
	
	public void update2(String name){
        player2 = name;
		ImageIcon icon = Img.loadPlayer(name);
		icon.setImage(icon.getImage().getScaledInstance(220, 350,
				Image.SCALE_DEFAULT));
		playerIcon2.setIcon(icon);
		jl2.setText(name);
		
		updateChart();
	}
	
	public void updateChart(){
		PlayerVO playerData1 = prs.getPlayerdata("14-15", player1);
		PlayerVO playerData2 = prs.getPlayerdata("14-15", player2);
		
	    //初始化数据
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    dataset.setValue(playerData1.getAverageScoring(), player1, "场均得分");
	    dataset.setValue(playerData2.getAverageScoring(), player2, "场均得分");

	    dataset.setValue(playerData1.getAverageBackboard(), player1, "场均篮板");
	    dataset.setValue(playerData2.getAverageBackboard(), player2, "场均篮板");


	    dataset.setValue(playerData1.getAverageAssist(), player1, "场均助攻");
	    dataset.setValue(playerData2.getAverageAssist(), player2, "场均助攻");
	

	    dataset.setValue(playerData1.getAverageSteal(), player1, "场均抢断");
	    dataset.setValue(playerData2.getAverageSteal(), player2, "场均抢断");
	
	    dataset.setValue(playerData1.getAverageBlock(), player1, "场均盖帽");
	    dataset.setValue(playerData2.getAverageBlock(), player2, "场均盖帽");
	
    	dataset.setValue(playerData1.getAverageTurn(), player1, "场均失误");
    	dataset.setValue(playerData2.getAverageTurn(), player2, "场均失误");
	
    	dataset.setValue(playerData1.getAverageFoul(),player1, "场均犯规");
	    dataset.setValue(playerData2.getAverageFoul(), player2, "场均犯规");

	    //生成图表
	    JFreeChart chart = JFreeUtils.createBarChart(dataset, "球员数据对比柱状图", "数据项", "赛季数据",true);
	    //生成图片
	    JFreeUtils.drawToOutputStream("graphics/chart/柱状图.JPG", chart, 552, 495);
		ImageIcon icon = new ImageIcon(
				"graphics/chart/柱状图.JPG");
		icon.setImage(icon.getImage().getScaledInstance(552, 495,
				Image.SCALE_DEFAULT));
		jl.setIcon(icon);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		} else if (e.getActionCommand().equals("back")) {
			frame.change(this, Frame.singlePlayerPanel);
			Frame.currentPanel = "singlePlayer";
		} 
	}
}

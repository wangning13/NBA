package ui.player;

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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import businesslogic.playerbl.PlayerRank;
import businesslogicservice.playerblservice.PlayerRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.JFreeUtils;
import ui.tools.Translate;
import vo.PlayerMatchVO;
import vo.PlayerVO;


@SuppressWarnings("serial")
public class PlayerAnalyze extends MyPanel implements ActionListener {
	Frame frame;
	PlayerRankService prs = new PlayerRank();
	String player1 = "league";
	JLabel playerIcon1 = new JLabel(Img.loadPlayer("Jeremy Lin"));
	JLabel jl1 = new JLabel("");
	JLabel chart1 = new JLabel();
	JComboBox<String> selectTeam1 = new JComboBox<String>();
	JComboBox<String> selectPlayer1 = new JComboBox<String>();
	Font font = new Font("黑体", Font.BOLD, 16);
	Font font1 = new Font("黑体", Font.BOLD, 12);
	JLabel blank = new JLabel(Img.BLANK);
	public PlayerAnalyze(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

		this.add(chart1);
		chart1.setBounds(250,150,802,500);

		
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
	
		selectPlayer1.addItem("请选择球员");

		selectTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if(selectTeam1.getSelectedIndex()!=0){
					ArrayList<String> players = prs.getAllPlayer("13-14", Translate.translate(selectTeam1.getSelectedItem().toString()));
					selectPlayer1.removeAllItems();
					selectPlayer1.addItem("请选择球员");
					for(int i=0;i<players.size();i++){
						selectPlayer1.addItem(players.get(i));
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
	
	public void updateChart(){
		ArrayList<PlayerMatchVO> playerData1 = prs.getPlayerRecentFiveMatch(player1);
		String team = prs.getPlayerdata("13-14", player1).getTeam();
		//初始化数据
		String chartTitle = "得分统计图形";
		String chartSeriesDesc = "近五场得分曲线";
		String chartXdesc = "时间";
		String chartYdesc = "得分";
		String timeFormat = "dd";//yyyy-MM-dd
		String periodType = "DAY";
		int dateInterval = 1;
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		TimeSeries dayseries = new TimeSeries(chartSeriesDesc, Day.class);
		for(int i=0;i<playerData1.size();i++){
		    dayseries.add(new Day(1+i*7,1,2013), playerData1.get(i).getScoring());
		}
		//存储至集合对象中
		dataset.addSeries(dayseries);
		//生成图表
		JFreeChart chart = JFreeUtils.createLineChart(chartTitle,chartXdesc,chartYdesc,
		periodType,dateInterval,timeFormat,dataset);
		//生成图片
	    JFreeUtils.drawToOutputStream("graphics/chart/折线图.JPG", chart, 802, 500);
		ImageIcon icon = new ImageIcon(
				"graphics/chart/折线图.JPG");
		icon.setImage(icon.getImage().getScaledInstance(802, 500,
				Image.SCALE_DEFAULT));
		chart1.setIcon(icon);
		

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

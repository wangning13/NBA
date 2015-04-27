package ui.player;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.playerbl.PlayerRank;
import businesslogic.teambl.TeamRank;
import businesslogicservice.playerblservice.PlayerRankService;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable1;
import ui.tools.Translate;
import vo.PlayerMatchVO;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class Statistics extends MyPanel implements ActionListener {
	int flag = 0;
	DecimalFormat df = new DecimalFormat("#.0");
	ArrayList<PlayerVO> players;
	String term2;
	String term3;
	String term4;
	String term5;
	String term6;
	String key;
	String order;
	PlayerRankService prs = new PlayerRank();
	TeamRankService trs = new TeamRank();
	Frame frame;
	JScrollPane pane;
	MyTable1 table;
	DefaultTableModel model;
	String[] columnNames = { "球员", "球队", "出场", "首发", "篮板", "助攻",
			"在场时间", "投篮命中率", "三分命中率", "罚球命中率", "进攻", "防守", "抢断", "盖帽",
			"失误", "犯规", "得分", "效率", "GmSc效率值", "真实命中率", "投篮效率", "篮板率",
			"进攻篮板率", "防守篮板率", "助攻率", "抢断率", "盖帽率", "失误率", "使用率", "场均得分",
			"场均时间", "场均篮板", "场均助攻", "场均投篮命中", "场均投篮出手", "场均三分命中", "场均三分出手",
			"场均罚球命中", "场均罚球出手", "场均进攻", "场均防守", "场均抢断", "场均盖帽", "场均失误",
			"场均犯规数" };

	String[] columnNames1_1 = { "球员", "球队", "得分",
			"时间", "篮板", "助攻", "投篮", "三分",
			"罚球", "进攻", "防守", "抢断", "盖帽", "失误",
			"犯规" };
	String[] columnNames1_2 = { "球员", "球队", "出场", "首发", "篮板", "助攻",
			 "投篮", "三分",
			"罚球", "进攻", "防守", "抢断", "盖帽",
			"失误", "犯规", "得分" };
	String[] columnNames1_3 = { "球员", "球队",  "投篮", "三分", "罚球", "篮板","前篮板", "后篮板", "助攻", "抢断", "盖帽", "失误", "使用率",
			"效率","GmSc", "真实命中", "投篮效率" };
	
	String[] columnNames1 = { "球员", "对手", "时间", "得分", "投篮",
			"三分", "罚球", "前篮板", "后篮板", "篮板", "助攻",
			"盖帽", "犯规", "抢断", "失误" };

	JLabel rankingBand = new JLabel(Img.RANKINGBAND);

	JComboBox<String> type = new JComboBox<String>();
	JButton descending = new JButton("降序");
	JButton ascending = new JButton("升序");
	Font font1 = new Font("黑体", Font.BOLD, 16);
	Font font2 = new Font("黑体", Font.BOLD, 18);
	JLabel jl1 = new JLabel("对所有球员排序：");
	JLabel jl2 = new JLabel("筛选前50名：");
	JComboBox<String> posision = new JComboBox<String>();
	JComboBox<String> area = new JComboBox<String>();
	JComboBox<String> term = new JComboBox<String>();
	JComboBox<String> hot = new JComboBox<String>();
	JComboBox<String> term1 = new JComboBox<String>();
	JComboBox<String> option = new JComboBox<String>();
	JButton filter = new JButton("筛选");
	JButton search = new JButton("查询");

	public Statistics(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

		type.addItem("得分");
		type.addItem("球员名称");
		type.addItem("所属球队");
		type.addItem("参赛场数");
		type.addItem("先发场数");
		type.addItem("篮板数");
		type.addItem("助攻数");
		type.addItem("在场时间");
		type.addItem("投篮命中率");
		type.addItem("三分命中率");
		type.addItem("罚球命中率");
		type.addItem("进攻数");
		type.addItem("防守数");
		type.addItem("抢断数");
		type.addItem("盖帽数");
		type.addItem("失误数");
		type.addItem("犯规数");
		type.addItem("效率");
		type.addItem("GmSc效率值");
		type.addItem("真实命中率");
		type.addItem("投篮效率");
		type.addItem("篮板率");
		type.addItem("进攻篮板率");
		type.addItem("防守篮板率");
		type.addItem("助攻率");
		type.addItem("抢断率");
		type.addItem("盖帽率");
		type.addItem("失误率");
		type.addItem("使用率");
		type.setUI(new MyComboBoxUI());
		posision.addItem("前锋");
		posision.addItem("中锋");
		posision.addItem("后卫");
		posision.setUI(new MyComboBoxUI());
		area.addItem("东部");
		area.addItem("西部");
		area.addItem("东南区");
		area.addItem("大西洋区");
		area.addItem("中部区");
		area.addItem("西南区");
		area.addItem("西北区");
		area.addItem("太平洋区");
		area.setUI(new MyComboBoxUI());
		term.addItem("得分");
		term.addItem("篮板");
		term.addItem("助攻");
		term.addItem("得分/篮板/助攻");
		term.addItem("盖帽");
		term.addItem("抢断");
		term.addItem("犯规");
		term.addItem("失误");
		term.addItem("在场时间");
		term.addItem("效率");
		term.addItem("投篮");
		term.addItem("三分");
		term.addItem("罚球");
		term.addItem("两双");
		term.setUI(new MyComboBoxUI());
		hot.addItem("当日热点");
		hot.addItem("赛季热点");
		hot.addItem("进步最快");
		hot.setUI(new MyComboBoxUI());
		term1.addItem("得分");
		term1.addItem("篮板");
		term1.addItem("助攻");
		term1.addItem("盖帽");
		term1.addItem("抢断");
		term1.setUI(new MyComboBoxUI());
		this.add(jl1);
		jl1.setBounds(20, 175, 180, 20);
		jl1.setFont(font1);

		this.add(type);
		type.setBounds(150, 175, 110, 20);
		type.setFont(font1);

		this.add(descending);
		descending.setBounds(270, 172, 60, 25);
		descending.addActionListener(this);
		descending.setActionCommand("descending");
		descending.setUI(new MyButtonUI());

		this.add(ascending);
		ascending.setBounds(340, 172, 60, 25);
		ascending.addActionListener(this);
		ascending.setActionCommand("ascending");
		ascending.setUI(new MyButtonUI());

		this.add(jl2);
		jl2.setBounds(560, 160, 180, 20);
		jl2.setFont(font1);

		this.add(posision);
		posision.setBounds(660, 160, 70, 20);
		posision.setFont(font1);

		this.add(area);
		area.setBounds(740, 160, 80, 20);
		area.setFont(font1);

		this.add(term);
		term.setBounds(830, 160, 140, 20);
		term.setFont(font1);

		this.add(hot);
		hot.setBounds(760, 190, 100, 20);
		hot.setFont(font1);
		hot.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (hot.getSelectedIndex() == 0) {
					term1.removeAllItems();
					term1.addItem("得分");
					term1.addItem("篮板");
					term1.addItem("助攻");
					term1.addItem("盖帽");
					term1.addItem("抢断");
				} else if (hot.getSelectedIndex() == 1) {
					term1.removeAllItems();
					term1.addItem("场均得分");
					term1.addItem("场均篮板");
					term1.addItem("场均助攻");
					term1.addItem("场均盖帽");
					term1.addItem("场均抢断");
					term1.addItem("三分命中率");
					term1.addItem("投篮命中率");
					term1.addItem("罚球命中率");
				} else if (hot.getSelectedIndex() == 2) {
					term1.removeAllItems();
					term1.addItem("场均得分");
					term1.addItem("场均篮板");
					term1.addItem("场均助攻");
				}
			}
		});

		this.add(term1);
		term1.setBounds(870, 190, 100, 20);
		term1.setFont(font1);

		this.add(filter);
		filter.setBounds(980, 157, 60, 25);
		filter.addActionListener(this);
		filter.setActionCommand("filter");
		filter.setUI(new MyButtonUI());

		this.add(search);
		search.setBounds(980, 187, 60, 25);
		search.addActionListener(this);
		search.setActionCommand("search");
		search.setUI(new MyButtonUI());

		option.addItem("场均数据");
		option.addItem("赛季数据");
		option.addItem("效率评估");
		this.add(option);
		option.setBounds(430, 164, 110, 40);
		option.setFont(font2);
	//	option.setUI(new MyComboBoxUI());
		option.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if(flag!=3){
				Object[][] data = getData(players);
				model.setDataVector(data, getColumnNames());
				table.setWidth();
				table.updateUI();
				}
			}
		});
		
		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);
        players = prs.getAllPlayerdata("13-14","scoring","DESC");
		Object[][] data = getData(players);
		model = new DefaultTableModel(new Object[][] {}, columnNames1_1);
		model.setDataVector(data, columnNames1_1);

		table = new MyTable1(model);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane = new JScrollPane(table);
		this.add(pane);
		pane.setBounds(0, 220, 1052, 430);
	}
/*
	public Object[][] getData(ArrayList<PlayerVO> players) {
		int num = players.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = { players.get(i).getPlayerName(),
					players.get(i).getTeam(), players.get(i).getAppearance(),
					players.get(i).getFirstPlay(),
					players.get(i).getBackboard(), players.get(i).getAssist(),
					players.get(i).getMinutes(),
					players.get(i).getFielfGoalShotPercentage(),
					players.get(i).getThreePointShotPercentage(),
					players.get(i).getFreeThrowPercentage(),
					players.get(i).getOffensiveRebound(),
					players.get(i).getDefensiveRebound(),
					players.get(i).getSteal(), players.get(i).getBlock(),
					players.get(i).getTurnOver(), players.get(i).getFoul(),
					players.get(i).getScoring(),
					players.get(i).getEfficiency(),
					players.get(i).getGmScEfficiency(),
					players.get(i).getTrueShootingPercentage(),
					players.get(i).getShootingEfficiency(),
					players.get(i).getBackboardPercentage(),
					players.get(i).getOffensiveReboundPercentage(),
					players.get(i).getDefensiveReboundPercentage(),
					players.get(i).getAssistPercentage(),
					players.get(i).getStealPercentage(),
					players.get(i).getBlockPercentage(),
					players.get(i).getTurnOverPercentage(),
					players.get(i).getUsage(),
					players.get(i).getAverageScoring(),
					players.get(i).getAverageMinute(),
					players.get(i).getAverageBackboard(),
					players.get(i).getAverageAssist(),
					players.get(i).getAverageFieldGoal(),
					players.get(i).getAverageFieldGoalAttempts(),
					players.get(i).getAverageThreePointFieldGoal(),
					players.get(i).getAverageThreePointFieldGoalAttempts(),
					players.get(i).getAverageFreeThrow(),
					players.get(i).getAverageFreeThrowAttempts(),
					players.get(i).getAverageOffensiveRebound(),
					players.get(i).getAverageDefensiveRebound(),
					players.get(i).getAverageSteal(),
					players.get(i).getAverageBlock(),
					players.get(i).getAverageTurn(),
					players.get(i).getAverageFoul() };
			data[i] = temp;
		}
		return data;
	}*/
	public Object[][] getData(ArrayList<PlayerVO> players) {
          if(option.getSelectedIndex()==0)
        	  return getData_1(players);
          if(option.getSelectedIndex()==1)
        	  return getData_2(players);
          else
        	  return getData_3(players);
	}
	public Object[][] getData_1(ArrayList<PlayerVO> players) {
		int num = players.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = { players.get(i).getPlayerName(),
					players.get(i).getTeam(),
					players.get(i).getAverageScoring(),
					players.get(i).getAverageMinute(),
					players.get(i).getAverageBackboard(),
					players.get(i).getAverageAssist(),
					players.get(i).getAverageFieldGoal()+"-"+
					players.get(i).getAverageFieldGoalAttempts(),
					players.get(i).getAverageThreePointFieldGoal()+"-"+
					players.get(i).getAverageThreePointFieldGoalAttempts(),
					players.get(i).getAverageFreeThrow()+"-"+
					players.get(i).getAverageFreeThrowAttempts(),
					players.get(i).getAverageOffensiveRebound(),
					players.get(i).getAverageDefensiveRebound(),
					players.get(i).getAverageSteal(),
					players.get(i).getAverageBlock(),
					players.get(i).getAverageTurn(),
					players.get(i).getAverageFoul() };
			data[i] = temp;
		}
		return data;
	}
	
	public Object[][] getData_2(ArrayList<PlayerVO> players) {
		int num = players.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = { players.get(i).getPlayerName(),
					players.get(i).getTeam(), players.get(i).getAppearance(),
					players.get(i).getFirstPlay(),
					players.get(i).getBackboard(), players.get(i).getAssist(),
					players.get(i).getFieldGoal()+"-"+
		           	players.get(i).getFieldGoalAttempts(),
		          	players.get(i).getThreePointFieldGoal()+"-"+
		           	players.get(i).getThreePointFieldGoalAttempts(),
		        	players.get(i).getFreeThrow()+"-"+
		        	players.get(i).getFreeThrowAttempts(),
					players.get(i).getOffensiveRebound(),
					players.get(i).getDefensiveRebound(),
					players.get(i).getSteal(), players.get(i).getBlock(),
					players.get(i).getTurnOver(), players.get(i).getFoul(),
					players.get(i).getScoring(),
};
			data[i] = temp;
		}
		return data;
	}
	
	public Object[][] getData_3(ArrayList<PlayerVO> players) {
		int num = players.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = { players.get(i).getPlayerName(),
					players.get(i).getTeam(), 
					df.format(players.get(i).getFielfGoalShotPercentage()*100)+"%",
					df.format(players.get(i).getThreePointShotPercentage()*100)+"%",
					df.format(players.get(i).getFreeThrowPercentage()*100)+"%",
					df.format(players.get(i).getBackboardPercentage()*100)+"%",
					df.format(players.get(i).getOffensiveReboundPercentage()*100)+"%",
					df.format(players.get(i).getDefensiveReboundPercentage()*100)+"%",
					df.format(players.get(i).getAssistPercentage()*100)+"%",
					df.format(players.get(i).getStealPercentage()*100)+"%",
					df.format(players.get(i).getBlockPercentage()*100)+"%",
					df.format(players.get(i).getTurnOverPercentage()*100)+"%",
					df.format(players.get(i).getUsage()*100)+"%",
					players.get(i).getEfficiency(),
					players.get(i).getGmScEfficiency(),
					df.format(players.get(i).getTrueShootingPercentage()*100)+"%",
					df.format(players.get(i).getShootingEfficiency()*100)+"%",
	};
			data[i] = temp;
		}
		return data;
	}

	public Object[][] getData1(ArrayList<PlayerMatchVO> matches) {
		int num = matches.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = {
					matches.get(i).getPlayername(),
					trs.getTeamMatch(matches.get(i).getDate(),
							matches.get(i).getTeam()).getOpponent(),
					matches.get(i).getMinutes(), matches.get(i).getScoring(),
					matches.get(i).getFieldGoal()+"-"+
					matches.get(i).getFieldGoalAttempts(),
					matches.get(i).getThreepointFieldGoal()+"-"+
					matches.get(i).getThreepointFieldGoalAttempts(),
					matches.get(i).getFreeThrow()+"-"+
					matches.get(i).getFreeThrowAttempts(),
					matches.get(i).getOffensiveRebound(),
					matches.get(i).getDefensiveRebound(),
					matches.get(i).getBackboard(), matches.get(i).getAssist(),
					matches.get(i).getBlock(), matches.get(i).getFoul(),
					matches.get(i).getSteal(), matches.get(i).getTurnOver() };
			data[i] = temp;
		}
		return data;
	}
	
	public String[] getColumnNames(){

			if(option.getSelectedIndex()==0)
				return columnNames1_1;
			else if(option.getSelectedIndex()==1)
				return columnNames1_2;
			else
				return columnNames1_3;
	}

	public void update() {
		Object[][] data = getData(prs.getAllPlayerdata("13-14", "scoring",
				"DESC"));
		model.setDataVector(data, getColumnNames());
		table.setWidth();
		table.updateUI();
	/*	if (flag == 0) {
			Object[][] data = getData(prs.getAllPlayerdata("13-14", "scoring",
					"DESC"));
			model.setDataVector(data, columnNames);
			table.setWidth();
			table.updateUI();
		} else if (flag == 1) {
			Object[][] data = getData(prs.getAllPlayerdata("13-14", term2,
					order));
			model.setDataVector(data, columnNames);
			table.setWidth();
			table.updateUI();
		} else if (flag == 2) {
			Object[][] data = getData(prs.getFirstFifty("13-14", term3, term4,
					term5));
			model.setDataVector(data, columnNames);
			table.setWidth();
			table.updateUI();
		} else if (flag == 3) {
			Object[][] data = getData1(prs.getDayTop(term6));
			model.setDataVector(data, columnNames1);
			table.setWidth();
			table.updateUI();
		} else if (flag == 4) {
			Object[][] data = getData(prs.getSeasonTop("13-14", term6));
			model.setDataVector(data, columnNames);
			table.setWidth();
			table.updateUI();
		} else if (flag == 5) {
			Object[][] data = getData(prs.getMostImporvedPlayer("13-14", key));
			model.setDataVector(data, columnNames);
			table.setWidth();
			table.updateUI();
		}
		*/
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")
				|| e.getActionCommand().equals("back")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		}

		else if (e.getActionCommand().equals("descending")) {
			flag = 1;
			term2 = Translate.translate1(type.getSelectedItem().toString());
			order = "DESC";
			players = prs.getAllPlayerdata("13-14",
					Translate.translate1(type.getSelectedItem().toString()),
					"DESC");
			Object[][] data = getData(players);
			model.setDataVector(data, getColumnNames());
			table.setWidth();
			table.updateUI();

		} else if (e.getActionCommand().equals("ascending")) {
			flag = 1;
			term2 = Translate.translate1(type.getSelectedItem().toString());
			order = "ASC";
			players = prs.getAllPlayerdata("13-14",
					Translate.translate1(type.getSelectedItem().toString()),
					"ASC");
			Object[][] data = getData(players);
			model.setDataVector(data, getColumnNames());
			table.setWidth();
			table.updateUI();

		} else if (e.getActionCommand().equals("filter")) {
			flag = 2;
			term3 = Translate.translate1(posision.getSelectedItem().toString());
			term4 = Translate.translate1(area.getSelectedItem().toString());
			term5 = Translate.translate1(term.getSelectedItem().toString());
			players = prs
					.getFirstFifty("13-14", Translate.translate1(posision
							.getSelectedItem().toString()), Translate
							.translate1(area.getSelectedItem().toString()),
							Translate.translate1(term.getSelectedItem()
									.toString()));
			Object[][] data = getData(players);
			model.setDataVector(data, getColumnNames());
			table.setWidth();
			table.updateUI();
			
		} else if (e.getActionCommand().equals("search")) {
			term6 = Translate.translate1(term1.getSelectedItem().toString());
			if (hot.getSelectedIndex() == 0) {
				flag = 3;
				Object[][] data = getData1(prs.getDayTop(Translate
						.translate1(term1.getSelectedItem().toString())));
				model.setDataVector(data, columnNames1);
				table.setWidth();
				table.updateUI();
				
			} else if (hot.getSelectedIndex() == 1) {
				flag = 4;
				players = prs.getSeasonTop("13-14", Translate
						.translate1(term1.getSelectedItem().toString()));
				Object[][] data = getData(players);
				model.setDataVector(data, getColumnNames());
				table.setWidth();
				table.updateUI();
				
			} else if (hot.getSelectedIndex() == 2) {
				flag = 5;
				if (term1.getSelectedIndex() == 0)
					key = "nearlyFivePercentage";
				else if (term1.getSelectedIndex() == 1)
					key = "nearlyFiveBackboardPercentage";
				else
					key = "nearlyFiveAssistPercentage";
				players = prs.getMostImporvedPlayer("13-14",
						key);
				Object[][] data = getData(players);
				model.setDataVector(data, getColumnNames());
				table.setWidth();
				table.updateUI();
				
			}
			
		}
	}

}

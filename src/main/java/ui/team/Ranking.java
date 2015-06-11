package ui.team;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import businesslogic.teambl.TeamRank;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.player.MyComboBoxUI;
import ui.tools.MyTable1;
import ui.tools.Translate;
import vo.TeamVO;

@SuppressWarnings("serial")
public class Ranking extends MyPanel implements ActionListener {
	int flag = 0;
	DecimalFormat df = new DecimalFormat("#.0");
	ArrayList<TeamVO> teams;
	Object[][] data;
	String area = "";
	String term1 = "win";
	String term2 = "";
	String order = "DESC";
	TeamRankService trs = new TeamRank();
	Frame frame;
	JScrollPane pane1;
	MyTable1 table1;
	DefaultTableModel model1;
	String[] columnNames1 = { "球队", "场次", "投篮命中率", "三分命中率", "罚球命中率", "胜率", "进攻回合",
			"进攻效率", "防守效率", "前篮板效率", "后篮板效率", "抢断效率", "助攻效率", "投篮命中",
			"投篮出手", "三分命中", "三分出数", "罚球命中", "罚球出手", "进攻篮板",
			"防守篮板", "篮板", "助攻", "抢断", "盖帽", "失误", "犯规",
			"得分" };
	String[] columnNames1_1 = { "球队", "场次", "投篮", "三分", "罚球", "前篮板",
			"后篮板", "篮板", "助攻", "抢断", "盖帽", "失误", "犯规",
			"得分" };
	String[] columnNames1_2 = { "球队", "场次", "投篮", "三分", "罚球", "胜率", "进攻回合",
			"进攻效率", "防守效率", "前篮板率", "后篮板率", "抢断效率", "助攻效率" };
	String[] columnNames2 = { "球队", "场次","投篮命中率", "三分命中率", "罚球命中率", "胜率", "进攻回合",
			"进攻效率", "助攻效率", "投篮命中", "投篮出手", "三分命中", "三分出手",
			"罚球命中", "罚球出手", "进攻篮板", "防守篮板", "篮板", "助攻",
			"抢断", "盖帽", "失误", "犯规", "得分" };
	String[] columnNames2_1 = { "球队", "场次", "投篮", "三分","罚球", "前篮板", "后篮板", "篮板", "助攻",
			"抢断", "盖帽", "失误", "犯规", "得分" };
	String[] columnNames2_2 = { "球队", "场次","投篮命中率", "三分命中率", "罚球命中率", "胜率", "进攻回合",
			"进攻效率", "助攻效率"};
	JLabel rankingBand = new JLabel(Img.RANKINGBAND);
	JRadioButton jrb1 = new JRadioButton("西部");
	JRadioButton jrb2 = new JRadioButton("东部");
	JRadioButton jrb3 = new JRadioButton("西南区");
	JRadioButton jrb4 = new JRadioButton("西北区");
	JRadioButton jrb5 = new JRadioButton("太平洋区");
	JRadioButton jrb6 = new JRadioButton("东南区");
	JRadioButton jrb7 = new JRadioButton("中部区");
	JRadioButton jrb8 = new JRadioButton("大西洋区");
	JLabel jl = new JLabel("赛季热点:");
	JLabel jl1 = new JLabel("赛季选择:");
	
	ButtonGroup group = new ButtonGroup();
	JComboBox<String> type = new JComboBox<String>();
	JComboBox<String> term = new JComboBox<String>();
	JComboBox<String> option = new JComboBox<String>();
	JComboBox<String> season = new JComboBox<String>();
	JButton descending = new JButton("降序");
	JButton ascending = new JButton("升序");
	JButton search = new JButton("查询");
	Font font1 = new Font("黑体", Font.BOLD, 16);
	Font font2 = new Font("黑体", Font.BOLD, 18);
	public Ranking(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

		this.add(jrb1);
		jrb1.setBounds(200, 165, 90, 20);
		jrb1.setFont(font1);
		jrb1.addActionListener(this);
		jrb1.setActionCommand("west");
		this.add(jrb2);
		jrb2.setBounds(200, 185, 90, 20);
		jrb2.setFont(font1);
		jrb2.addActionListener(this);
		jrb2.setActionCommand("east");
		this.add(jrb3);
		jrb3.setBounds(290, 165, 90, 20);
		jrb3.setFont(font1);
		jrb3.addActionListener(this);
		jrb3.setActionCommand("southwest");
		this.add(jrb4);
		jrb4.setBounds(380, 165, 90, 20);
		jrb4.setFont(font1);
		jrb4.addActionListener(this);
		jrb4.setActionCommand("northwest");
		this.add(jrb5);
		jrb5.setBounds(470, 165, 95, 20);
		jrb5.setFont(font1);
		jrb5.addActionListener(this);
		jrb5.setActionCommand("pacific");
		this.add(jrb6);
		jrb6.setBounds(290, 185, 90, 20);
		jrb6.setFont(font1);
		jrb6.addActionListener(this);
		jrb6.setActionCommand("southeast");
		this.add(jrb7);
		jrb7.setBounds(380, 185, 90, 20);
		jrb7.setFont(font1);
		jrb7.addActionListener(this);
		jrb7.setActionCommand("central");
		this.add(jrb8);
		jrb8.setBounds(470, 185, 95, 20);
		jrb8.setFont(font1);
		jrb8.addActionListener(this);
		jrb8.setActionCommand("atlantic");
		group.add(jrb1);
		group.add(jrb2);
		group.add(jrb3);
		group.add(jrb4);
		group.add(jrb5);
		group.add(jrb6);
		group.add(jrb7);
		group.add(jrb8);

		type.addItem("胜率");
		type.addItem("球队名称");
		type.addItem("场次");
		type.addItem("投篮命中数");
		type.addItem("投篮出手数");
		type.addItem("三分命中数");
		type.addItem("三分出手数");
		type.addItem("罚球命中数");
		type.addItem("罚球出手数");
		type.addItem("进攻篮板数");
		type.addItem("防守篮板数");
		type.addItem("篮板数");
		type.addItem("助攻数");
		type.addItem("抢断数");
		type.addItem("盖帽数");
		type.addItem("失误数");
		type.addItem("犯规数");
		type.addItem("比赛得分");
		type.addItem("投篮命中率");
		type.addItem("三分命中率");
		type.addItem("罚球命中率");
		type.addItem("进攻回合");
		type.addItem("进攻效率");
		type.addItem("防守效率");
		type.addItem("进攻篮板效率");
		type.addItem("防守篮板效率");
		type.addItem("抢断效率");
		type.addItem("助攻效率");
		this.add(type);
		type.setBounds(750, 160, 110, 20);
		type.setFont(font1);
		type.setUI(new MyComboBoxUI());

		option.addItem("场均数据");
		option.addItem("效率评估");
		this.add(option);
		option.setBounds(610, 164, 110, 40);
		option.setFont(font2);
	//	option.setUI(new MyComboBoxUI());
		option.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				Object[][] data = getData(teams);
				model1.setDataVector(data, getColumnNames1());
				table1.setWidth();
				table1.updateUI();
			}
		});
		
		this.add(jl1);
		jl1.setBounds(5, 170, 100, 30);
		jl1.setFont(font1);
		
		season.addItem("13-14");
		season.addItem("14-15");	
		season.addItem("12-13");	
		season.addItem("11-12");
		season.addItem("10-11");	
		this.add(season);
		season.setBounds(90, 176, 80, 20);
		season.setFont(font1);
		season.setUI(new MyComboBoxUI());
		season.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				teams = trs.getAllTeamdata(season.getSelectedItem().toString(), "wins", "DESC");
				Object[][] data = getData(teams);
				model1.setDataVector(data, getColumnNames1());
				table1.setWidth();
				table1.updateUI();
			}
		});
		
		this.add(descending);
		descending.setBounds(880, 157, 60, 25);
		descending.addActionListener(this);
		descending.setActionCommand("descending");
		descending.setUI(new MyButtonUI());

		this.add(ascending);
		ascending.setBounds(950, 157, 60, 25);
		ascending.addActionListener(this);
		ascending.setActionCommand("ascending");
		ascending.setUI(new MyButtonUI());

		term.removeAllItems();
		term.addItem("场均得分");
		term.addItem("场均篮板");
		term.addItem("场均助攻");
		term.addItem("场均盖帽");
		term.addItem("场均抢断");
		term.addItem("三分命中率");
		term.addItem("投篮命中率");
		term.addItem("罚球命中率");
		term.setUI(new MyComboBoxUI());
		this.add(term);
		term.setBounds(830, 190, 110, 20);
		term.setFont(font1);
		this.add(jl);
		jl.setBounds(750, 190, 80, 20);
		jl.setFont(font1);

		this.add(search);
		search.setBounds(950, 187, 60, 25);
		search.addActionListener(this);
		search.setActionCommand("search");
		search.setUI(new MyButtonUI());

		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);
		teams = trs.getAllTeamdata(season.getSelectedItem().toString(), "wins", "DESC");
		Object[][] data = getData(teams);
		model1 = new DefaultTableModel(new Object[][] {}, columnNames1);
		model1.setDataVector(data, columnNames1_1);
		table1 = new MyTable1(model1);

	    table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane1 = new JScrollPane(table1);
		this.add(pane1);
		pane1.setBounds(0, 220, 1052, 430);

	}
/*
	public Object[][] getData(ArrayList<TeamVO> teams) {
		int num = teams.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = { teams.get(i).getTeamName(),
					teams.get(i).getMatches(),
					teams.get(i).getFieldGoalPercentage(),
					teams.get(i).getThreePointShotPercentage(),
					teams.get(i).getFreeThrowPercentage(),
					teams.get(i).getWinningPercentage(),
					teams.get(i).getPossessions(),
					teams.get(i).getOffensiveEfficiency(),
					teams.get(i).getDefensiveEfficiency(),
					teams.get(i).getOffensivebackboardEfficiency(),
					teams.get(i).getDefensivebackboardEfficiency(),
					teams.get(i).getStealEfficiency(),
					teams.get(i).getAssistEfficiency(),
					teams.get(i).getAverageFieldGoal(),
					teams.get(i).getAverageFieldGoalAttempts(),
					teams.get(i).getAverageThreePointFieldGoal(),
					teams.get(i).getAverageThreePointFieldGoalAttempts(),
					teams.get(i).getAverageFreeThrow(),
					teams.get(i).getAverageFreeThrowAttempts(),
					teams.get(i).getAverageOffensiveRebound(),
					teams.get(i).getAverageDefensiveRebound(),
					teams.get(i).getAverageBackboard(),
					teams.get(i).getAverageAsist(),
					teams.get(i).getAverageSteal(),
					teams.get(i).getAverageBlock(),
					teams.get(i).getAverageTurnOver(),
					teams.get(i).getAverageFoul(),
					teams.get(i).getAverageScoring() };
			data[i] = temp;
		}
		return data;
	}
*/
	public Object[][] getData(ArrayList<TeamVO> teams){
		if(option.getSelectedIndex()==1){
			if(flag==3)
				return getData1_2(teams);
			else
			    return getData_2(teams);
		}
		else {
				return getData_1(teams);
		}
	}
	
	public String[] getColumnNames1(){
		if(flag==3){
			if(option.getSelectedIndex()==0)
				return columnNames2_1;
			else return columnNames2_2;
		}
		else{
		    if(option.getSelectedIndex()==0)
		    	return columnNames1_1;
	    	else return columnNames1_2;
		}
	
	}
	
	public Object[][] getData_1(ArrayList<TeamVO> teams) {
		int num = teams.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = { teams.get(i).getTeamName(),
					teams.get(i).getMatches(),
					teams.get(i).getAverageFieldGoal()+"-"+
					teams.get(i).getAverageFieldGoalAttempts(),
					teams.get(i).getAverageThreePointFieldGoal()+"-"+
					teams.get(i).getAverageThreePointFieldGoalAttempts(),
					teams.get(i).getAverageFreeThrow()+"-"+
					teams.get(i).getAverageFreeThrowAttempts(),
					teams.get(i).getAverageOffensiveRebound(),
					teams.get(i).getAverageDefensiveRebound(),
					teams.get(i).getAverageBackboard(),
					teams.get(i).getAverageAsist(),
					teams.get(i).getAverageSteal(),
					teams.get(i).getAverageBlock(),
					teams.get(i).getAverageTurnOver(),
					teams.get(i).getAverageFoul(),
					teams.get(i).getAverageScoring() };
			data[i] = temp;
		}
		return data;
	}
	
	public Object[][] getData_2(ArrayList<TeamVO> teams) {
		int num = teams.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = { teams.get(i).getTeamName(),
					teams.get(i).getMatches(),
					df.format(teams.get(i).getFieldGoalPercentage()*100)+"%",
					df.format(teams.get(i).getThreePointShotPercentage()*100)+"%",
					df.format(teams.get(i).getFreeThrowPercentage()*100)+"%",
					df.format(teams.get(i).getWinningPercentage()*100)+"%",
					teams.get(i).getPossessions(),
					teams.get(i).getOffensiveEfficiency(),
					teams.get(i).getDefensiveEfficiency(),
					df.format(teams.get(i).getOffensivebackboardEfficiency()*100)+"%",
					df.format(teams.get(i).getDefensivebackboardEfficiency()*100)+"%",
					teams.get(i).getStealEfficiency(),
					teams.get(i).getAssistEfficiency(),
					};
			data[i] = temp;
		}
		return data;
	}
	
	public Object[][] getData1_2(ArrayList<TeamVO> teams) {
		int num = teams.size();
		Object[][] data = new Object[num][];
		for (int i = 0; i < num; i++) {
			Object[] temp = { teams.get(i).getTeamName(),
					teams.get(i).getMatches(),
					df.format(teams.get(i).getFieldGoalPercentage()*100)+"%",
					df.format(teams.get(i).getThreePointShotPercentage()*100)+"%",
					df.format(teams.get(i).getFreeThrowPercentage()*100)+"%",
					df.format(teams.get(i).getWinningPercentage()*100)+"%",
					teams.get(i).getPossessions(),
					teams.get(i).getOffensiveEfficiency(),
					teams.get(i).getAssistEfficiency(),
 };
			data[i] = temp;
		}
		return data;
	}

	public void update() {
		teams = trs.getAllTeamdata(season.getSelectedItem().toString(), "wins",
				"DESC");
		 data = getData(teams);
	//	model1.setDataVector(data, getColumnNames1());
	//table1.updateUI();
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	model1.setDataVector(data, getColumnNames1());
	        	table1.setWidth();
	        	table1.updateUI();
	                 }
		 });
		/*if (flag == 0) {
			Object[][] data = getData(trs.getAllTeamdata(season.getSelectedItem().toString(), "wins",
					"DESC"));
			model1.setDataVector(data, columnNames1);
			table1.setWidth();
			table1.updateUI();
		}
		if (flag == 1) {
			if (area.equals("W") || area.equals("E")) {
				Object[][] data = getData(trs.getTeamData(season.getSelectedItem().toString(),
						"`east/west`='" + area + "'", "wins", "DESC"));
				model1.setDataVector(data, columnNames1);
				table1.setWidth();
				table1.updateUI();
			} else {
				Object[][] data = getData(trs.getTeamData(season.getSelectedItem().toString(),
						"`partition`='" + area + "'", "wins", "DESC"));
				model1.setDataVector(data, columnNames1);
				table1.setWidth();
				table1.updateUI();
			}
		} else if (flag == 2) {
			Object[][] data = getData(trs.getAllTeamdata(season.getSelectedItem().toString(), term1, order));
			model1.setDataVector(data, columnNames1);
			table1.setWidth();
			table1.updateUI();
		} else if (flag == 3) {
			Object[][] data = getData(trs.getSeasonTop(season.getSelectedItem().toString(), term2));
			model1.setDataVector(data, columnNames1);
			table1.setWidth();
			table1.updateUI();
		}
		*/
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("west")) {
			/*
			 * pane1.setVisible(true); pane2.setVisible(true);
			 */
			flag = 1;
			area = "W";
            teams = trs.getTeamData(season.getSelectedItem().toString(),
					"`east/west`='W'", "wins", "DESC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("east")) {
			/*
			 * pane1.setVisible(false); pane2.setVisible(false);
			 * pane3.setVisible(true); pane4.setVisible(true);
			 * pane5.setVisible(true); pane6.setVisible(true);
			 * pane7.setVisible(true); pane8.setVisible(true);
			 */
			flag = 1;
			area = "E";
			teams = trs.getTeamData(season.getSelectedItem().toString(),
					"`east/west`='E'", "wins", "DESC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("southwest")) {
			flag = 1;
			area = "Southwest";
			teams = trs.getTeamData(season.getSelectedItem().toString(),
					"`partition`='Southwest'", "wins", "DESC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("northwest")) {
			flag = 1;
			area = "Northwest";
			teams = trs.getTeamData(season.getSelectedItem().toString(),
					"`partition`='Northwest'", "wins", "DESC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("pacific")) {
			flag = 1;
			area = "Pacific";
			teams = trs.getTeamData(season.getSelectedItem().toString(),
					"`partition`='Pacific'", "wins", "DESC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("southeast")) {
			flag = 1;
			area = "Southeast";
			teams = trs.getTeamData(season.getSelectedItem().toString(),
					"`partition`='Southeast'", "wins", "DESC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("central")) {
			flag = 1;
			area = "Central";
			teams = trs.getTeamData(season.getSelectedItem().toString(),
					"`partition`='Central'", "wins", "DESC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("atlantic")) {
			flag = 1;
			area = "Atlantic";
			teams = trs.getTeamData(season.getSelectedItem().toString(),
					"`partition`='Atlantic'", "wins", "DESC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("home")
				|| e.getActionCommand().equals("back")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		} else if (e.getActionCommand().equals("descending")) {
			/*
			 * pane1.setVisible(false); pane2.setVisible(false);
			 * pane3.setVisible(false); pane4.setVisible(false);
			 * pane5.setVisible(false); pane6.setVisible(false);
			 * pane7.setVisible(false); pane8.setVisible(false);
			 * jrb1.setSelected(false); jrb2.setSelected(false);
			 */
			flag = 2;
			order = "DESC";
			term1 = Translate.translate1(type.getSelectedItem().toString());
			teams = trs.getAllTeamdata(season.getSelectedItem().toString(),
					Translate.translate1(type.getSelectedItem().toString()),
					"DESC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("ascending")) {
			/*
			 * pane1.setVisible(false); pane2.setVisible(false);
			 * pane3.setVisible(false); pane4.setVisible(false);
			 * pane5.setVisible(false); pane6.setVisible(false);
			 * pane7.setVisible(false); pane8.setVisible(false);
			 * jrb1.setSelected(false); jrb2.setSelected(false);
			 */
			flag = 2;
			order = "ASC";
			term1 = Translate.translate1(type.getSelectedItem().toString());
			teams = trs.getAllTeamdata(season.getSelectedItem().toString(),
					Translate.translate1(type.getSelectedItem().toString()),
					"ASC");
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		} else if (e.getActionCommand().equals("search")) {
			flag = 3;
			term2 = Translate.translate1(term.getSelectedItem().toString());
			teams = trs.getSeasonTop(season.getSelectedItem().toString(),
					Translate.translate1(term.getSelectedItem().toString()));
			Object[][] data = getData(teams);
			model1.setDataVector(data, getColumnNames1());
			table1.setWidth();
			table1.updateUI();
		}

	}

}

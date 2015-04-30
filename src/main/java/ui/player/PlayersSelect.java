package ui.player;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import businesslogic.playerbl.PlayerRank;
import businesslogicservice.playerblservice.PlayerRankService;
import ui.main.Frame;
import ui.main.MyButton;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayersSelect extends MyPanel implements ActionListener {
	PlayerRankService prs = new PlayerRank();
	Frame frame;
	Boolean isStart = false;
	JScrollPane pane;
	JScrollPane pane1;
	MyTable table;
	MyTable table1;
	DefaultTableModel model;
	DefaultTableModel model1;
	JLabel jl = new JLabel("球员搜索");
	MyButton search = new MyButton(Img.SEARCH1,Img.SEARCH2);
	MyButton showAll = new MyButton(Img.SHOWALL1,Img.SHOWALL2);
	JTextField jtf = new JTextField(50);
	JLabel rankingBand = new JLabel(Img.RANKINGBAND);
	//JRadioButton jrb1 = new JRadioButton("按球队查找");
	//ButtonGroup group = new ButtonGroup();
	String[] columnNames = { "圣安东尼奥马刺", "孟菲斯灰熊", "达拉斯小牛", "休斯顿火箭", "新奥尔良鹈鹕",
			"明尼苏达森林狼", "丹佛掘金", "尤他爵士", "波特兰开拓者", "俄克拉荷马雷霆", "萨克拉门托国王",
			"菲尼克斯太阳", "洛杉矶湖人", "洛杉矶快船", "金州勇士", "迈阿密热", "奥兰多魔术", "亚特兰大老鹰",
			"华盛顿奇才", "夏洛特黄蜂", "底特律活塞", "印第安纳步行者", "克里夫兰骑士", "芝加哥公牛", "密尔沃基雄鹿",
			"波士顿凯尔特人", "费城76人", "纽约尼克斯", "布鲁克林篮网", "多伦多猛龙" };
	String[] columnNames1 = { "姓名","球队" };
	Font font1 = new Font("黑体", Font.BOLD, 16);

	public PlayersSelect(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

	/*	this.add(jrb1);
		jrb1.setBounds(20, 170, 120, 30);
		jrb1.setFont(font1);
		jrb1.setSelected(true);
		jrb1.addActionListener(this);
		jrb1.setActionCommand("byTeam");
		group.add(jrb1);
		
		*/
		this.add(jl);
		jl.setBounds(690, 173, 120, 20);
		jl.setFont(font1);
		
		this.add(jtf);
		jtf.setBounds(770, 173, 120, 20);
		
		this.add(search);
		search.setBounds(910, 170, 25, 25);
		search.addActionListener(this);
		search.setActionCommand("search");
		
		this.add(showAll);
		showAll.setBounds(960, 173, 60, 20);
		showAll.addActionListener(this);
		showAll.setActionCommand("showAll");
		
		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);

		Object[][] data = getData();
		model = new DefaultTableModel(new Object[][] {}, columnNames);
		model.setDataVector(data, columnNames);
		table = new MyTable(model);
		
		

		// table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane = new JScrollPane(table);
		this.add(pane);
		pane.setBounds(0, 220, 1052, 430);

		table.addMouseListener(new MouseAdapter() { // 这里使用MouseAdapter代替MouseListener，因为MouseListener要重写的方法太多
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				jump(row, column);
			}
		});
		
		Object[][] data1 = null;
		model1 = new DefaultTableModel(new Object[][] {}, columnNames1);
		model1.setDataVector(data1, columnNames1);
		table1 = new MyTable(model1);
		
		

		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane1 = new JScrollPane(table1);
		this.add(pane1);
		pane1.setBounds(0, 220, 1052, 430);

		table1.addMouseListener(new MouseAdapter() { // 这里使用MouseAdapter代替MouseListener，因为MouseListener要重写的方法太多
			public void mouseClicked(MouseEvent e) {
				int row = table1.getSelectedRow();
				int column = table1.getSelectedColumn();
				if(column==0)
				jump1(row, column);
			}
		});
		pane1.setVisible(false);
	}

	public Object[][] getData() {
		ArrayList<String> SASPlayers = prs.getAllPlayer("13-14", "SAS");
		ArrayList<String> MEMPlayers = prs.getAllPlayer("13-14", "MEM");
		ArrayList<String> DALPlayers = prs.getAllPlayer("13-14", "DAL");
		ArrayList<String> HOUPlayers = prs.getAllPlayer("13-14", "HOU");
		ArrayList<String> NOPPlayers = prs.getAllPlayer("13-14", "NOP");
		ArrayList<String> MINPlayers = prs.getAllPlayer("13-14", "MIN");
		ArrayList<String> DENPlayers = prs.getAllPlayer("13-14", "DEN");
		ArrayList<String> UTAPlayers = prs.getAllPlayer("13-14", "UTA");
		ArrayList<String> PORPlayers = prs.getAllPlayer("13-14", "POR");
		ArrayList<String> OKCPlayers = prs.getAllPlayer("13-14", "OKC");
		ArrayList<String> SACPlayers = prs.getAllPlayer("13-14", "SAC");
		ArrayList<String> PHXPlayers = prs.getAllPlayer("13-14", "PHX");
		ArrayList<String> LALPlayers = prs.getAllPlayer("13-14", "LAL");
		ArrayList<String> LACPlayers = prs.getAllPlayer("13-14", "LAC");
		ArrayList<String> GSWPlayers = prs.getAllPlayer("13-14", "GSW");
		ArrayList<String> MIAPlayers = prs.getAllPlayer("13-14", "MIA");
		ArrayList<String> ORLPlayers = prs.getAllPlayer("13-14", "ORL");
		ArrayList<String> ATLPlayers = prs.getAllPlayer("13-14", "ATL");
		ArrayList<String> WASPlayers = prs.getAllPlayer("13-14", "WAS");
		ArrayList<String> CHAPlayers = prs.getAllPlayer("13-14", "CHA");
		ArrayList<String> DETPlayers = prs.getAllPlayer("13-14", "DET");
		ArrayList<String> INDPlayers = prs.getAllPlayer("13-14", "IND");
		ArrayList<String> CLEPlayers = prs.getAllPlayer("13-14", "CLE");
		ArrayList<String> CHIPlayers = prs.getAllPlayer("13-14", "CHI");
		ArrayList<String> MILPlayers = prs.getAllPlayer("13-14", "MIL");
		ArrayList<String> BOSPlayers = prs.getAllPlayer("13-14", "BOS");
		ArrayList<String> PHIPlayers = prs.getAllPlayer("13-14", "PHI");
		ArrayList<String> NYKPlayers = prs.getAllPlayer("13-14", "NYK");
		ArrayList<String> BKNPlayers = prs.getAllPlayer("13-14", "BKN");
		ArrayList<String> TORPlayers = prs.getAllPlayer("13-14", "TOR");

		for (int i = 0; i < 21; i++) {
			SASPlayers.add("");
			MEMPlayers.add("");
			DALPlayers.add("");
			HOUPlayers.add("");
			NOPPlayers.add("");
			MINPlayers.add("");
			DENPlayers.add("");
			UTAPlayers.add("");
			PORPlayers.add("");
			OKCPlayers.add("");
			SACPlayers.add("");
			PHXPlayers.add("");
			LALPlayers.add("");
			LACPlayers.add("");
			GSWPlayers.add("");
			MIAPlayers.add("");
			ORLPlayers.add("");
			ATLPlayers.add("");
			WASPlayers.add("");
			CHAPlayers.add("");
			DETPlayers.add("");
			INDPlayers.add("");
			CLEPlayers.add("");
			CHIPlayers.add("");
			MILPlayers.add("");
			BOSPlayers.add("");
			PHIPlayers.add("");
			NYKPlayers.add("");
			BKNPlayers.add("");
			TORPlayers.add("");
		}
		Object[][] data = new Object[20][];
		for (int i = 0; i < 20; i++) {
			Object temp[] = { SASPlayers.get(i), MEMPlayers.get(i),
					DALPlayers.get(i), HOUPlayers.get(i), NOPPlayers.get(i),
					MINPlayers.get(i), DENPlayers.get(i), UTAPlayers.get(i),
					PORPlayers.get(i), OKCPlayers.get(i), SACPlayers.get(i),
					PHXPlayers.get(i), LALPlayers.get(i), LACPlayers.get(i),
					GSWPlayers.get(i), MIAPlayers.get(i), ORLPlayers.get(i),
					ATLPlayers.get(i), WASPlayers.get(i), CHAPlayers.get(i),
					DETPlayers.get(i), INDPlayers.get(i), CLEPlayers.get(i),
					CHIPlayers.get(i), MILPlayers.get(i), BOSPlayers.get(i),
					PHIPlayers.get(i), NYKPlayers.get(i), BKNPlayers.get(i),
					TORPlayers.get(i) };
			data[i] = temp;
		}
		return data;
	}

	public void update() {
        if(!isStart){
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	    		model.setDataVector(getData(), columnNames);
	    		table.setWidth();
	        	table.updateUI();
	        	pane.setVisible(true);
	        	pane1.setVisible(false);
	                 }
		 });
        }
	}
	public void update1() {
        isStart = false;
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	    		model.setDataVector(getData(), columnNames);
	    		table.setWidth();
	        	table.updateUI();
	        	pane.setVisible(true);
	        	pane1.setVisible(false);
	                 }
		 });
	}

	public void jump(int row, int column) {
		if (table.getValueAt(row, column) != null) {
			String name = table.getValueAt(row, column).toString();
			if (!name.equals("")) {
				frame.change(this, Frame.singlePlayerPanel);
				Frame.singlePlayerPanel.update(name);
				Frame.singlePlayerPanel.flag = false;
				Frame.currentPanel = "singlePlayer";
			}
		}
	}
	
	public void jump1(int row, int column) {
		if (table1.getValueAt(row, column) != null) {
			String name = table1.getValueAt(row, column).toString();
			if (!name.equals("")) {
				frame.change(this, Frame.singlePlayerPanel);
				Frame.singlePlayerPanel.update(name);
				Frame.singlePlayerPanel.flag = false;
				Frame.currentPanel = "singlePlayer";
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")
				|| e.getActionCommand().equals("back")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		}
		else if (e.getActionCommand().equals("search")&&!jtf.getText().equals("")) {
			ArrayList<PlayerVO> players = prs.getPlayerName("13-14",jtf.getText());
			int num = players.size();
			Object[][] data = new Object[num][];
			for (int i = 0; i < num; i++) {
				Object temp[] = { players.get(i).getPlayerName(), players.get(i).getTeam()};
				data[i] = temp;
			}
		//	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    		model1.setDataVector(data, columnNames1);
    		table1.setWidth();
        	table1.updateUI();
        	pane.setVisible(false);
        	pane1.setVisible(true);
        	isStart = true;
		}
		else if (e.getActionCommand().equals("showAll")) {
            update();
            isStart = false;
		}
	}
}

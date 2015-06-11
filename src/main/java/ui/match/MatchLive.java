package ui.match;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.playerbl.PlayerRank;
import businesslogicservice.playerblservice.PlayerRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable1;
import vo.PlayerMatchVO;
import vo.TeamMonthMatchVO;

@SuppressWarnings("serial")
public class MatchLive extends MyPanel implements ActionListener {
	PlayerRankService prs = new PlayerRank();
	public boolean flag = false;
	Frame frame;
	JScrollPane pane1;
	MyTable1 table1;
	DefaultTableModel model1;
	String[] columnNames1 = { "时间", "球队", "事件","比分" };

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

}

package ui.team;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.teambl.TeamRank;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable1;
import vo.TeamMonthMatchVO;


@SuppressWarnings("serial")
public class Refer extends MyPanel implements ActionListener {
	Frame frame;
	TeamRankService trs = new TeamRank();
    JLabel jl = new JLabel("胜负影响因素");
	Font font = new Font("黑体", Font.BOLD, 16);
	Font font1 = new Font("黑体", Font.BOLD, 14);
	Font font2 = new Font("黑体", Font.BOLD, 40);
	JLabel blank = new JLabel(Img.BLANK);
	JScrollPane pane1;
	MyTable1 table1;
	DefaultTableModel model1;
	String[] columnNames1 = {" " ,"主客场", "篮板", "失误", "助攻", "抢断", "盖帽","投篮命中", "三分命中", "罚球命中","对手篮板","对手投篮出手","对手失误","对手罚球"};
	double[] result1 = trs.LinerRegression("14-15");
	double[] result2 = trs.RegressionCoefficient("14-15");
	public Refer(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
        this.add(jl);
        jl.setBounds(50,160,150,50);
        jl.setFont(font1);

		Object[][] data1 = getData();
		model1 = new DefaultTableModel(new Object[][] {}, columnNames1);
		model1.setDataVector(data1, columnNames1);
		table1 = new MyTable1(model1);  
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane1 = new JScrollPane(table1);
		this.add(pane1);
		pane1.setBounds(0, 200, 1052, 100);

		this.add(blank);
		blank.setBounds(0,150,1052,500);
		

	}

	public void update(String name) {


	}
	
	public Object[][] getData() {

		for(int i = 0;i<result1.length;i++){
			System.out.println("第"+i+"个："+result1[i]);
		}
		
		for(int i = 0;i<result2.length;i++){
			System.out.println("第"+i+"个："+result2[i]);
		}
		
		Object[][] data = new Object[2][];
				
		Object[] temp = {"正/负相关","+","+","-","+","+","+","+","+","+","-","-","+","+","-"};
		data[0] = temp;
		Object[] temp1 = {"偏回归系数",result2[0],result2[1],result2[2],result2[4],result2[5],result2[6],result2[7],result2[8],result2[9],result2[10],result2[12],result2[13],result2[14]};
		data[1] = temp1;
		return data;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		} else if (e.getActionCommand().equals("back")) {
			frame.change(this, Frame.teamsComparePanel);
			Frame.currentPanel = "teamsCompare";
		} 
	}
}

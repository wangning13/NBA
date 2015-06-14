package ui.team;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ui.main.Frame;
import ui.main.MyButton;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;
import ui.tools.Translate;

@SuppressWarnings("serial")
public class TeamsSelect extends MyPanel implements ActionListener {
	Frame frame;
	JScrollPane pane;
	MyTable table;
	DefaultTableModel model;
	String[] columnNames = { "西南区", "西北区", "太平洋区", "东南区", "中区", "大西洋区" };
	JLabel jl1 = new JLabel("西南区");
	JLabel jl2 = new JLabel("西北区");
	JLabel jl3 = new JLabel("太平洋区");
	JLabel jl4 = new JLabel("东南区");
	JLabel jl5 = new JLabel("中区");
	JLabel jl6 = new JLabel("大西洋区");
	MyButton SAS = new MyButton(getIcon("SAS"), getIcon("SAS"));
	MyButton MEM = new MyButton(getIcon("MEM"), getIcon("MEM"));
	MyButton DAL = new MyButton(getIcon("DAL"), getIcon("DAL"));
	MyButton HOU = new MyButton(getIcon("HOU"), getIcon("HOU"));
	MyButton NOP = new MyButton(getIcon("NOP"), getIcon("NOP"));

	MyButton MIN = new MyButton(getIcon("MIN"), getIcon("MIN"));
	MyButton DEN = new MyButton(getIcon("DEN"), getIcon("DEN"));
	MyButton UTA = new MyButton(getIcon("UTA"), getIcon("UTA"));
	MyButton POR = new MyButton(getIcon("POR"), getIcon("POR"));
	MyButton OKC = new MyButton(getIcon("OKC"), getIcon("OKC"));

	MyButton SAC = new MyButton(getIcon("SAC"), getIcon("SAC"));
	MyButton PHX = new MyButton(getIcon("PHX"), getIcon("PHX"));
	MyButton LAL = new MyButton(getIcon("LAL"), getIcon("LAL"));
	MyButton LAC = new MyButton(getIcon("LAC"), getIcon("LAC"));
	MyButton GSW = new MyButton(getIcon("GSW"), getIcon("GSW"));

	MyButton MIA = new MyButton(getIcon("MIA"), getIcon("MIA"));
	MyButton ORL = new MyButton(getIcon("ORL"), getIcon("ORL"));
	MyButton ATL = new MyButton(getIcon("ATL"), getIcon("ATL"));
	MyButton WAS = new MyButton(getIcon("WAS"), getIcon("WAS"));
	MyButton CHA = new MyButton(getIcon("CHA"), getIcon("CHA"));

	MyButton DET = new MyButton(getIcon("DET"), getIcon("DET"));
	MyButton IND = new MyButton(getIcon("IND"), getIcon("IND"));
	MyButton CLE = new MyButton(getIcon("CLE"), getIcon("CLE"));
	MyButton CHI = new MyButton(getIcon("CHI"), getIcon("CHI"));
	MyButton MIL = new MyButton(getIcon("MIL"), getIcon("MIL"));

	MyButton BOS = new MyButton(getIcon("BOS"), getIcon("BOS"));
	MyButton PHI = new MyButton(getIcon("PHI"), getIcon("PHI"));
	MyButton NYK = new MyButton(getIcon("NYK"), getIcon("NYK"));
	MyButton BKN = new MyButton(getIcon("BKN"), getIcon("BKN"));
	MyButton TOR = new MyButton(getIcon("TOR"), getIcon("TOR"));

	// JLabel rankingBand = new JLabel(Img.RANKINGBAND);
	// JLabel jl = new JLabel("NBA球队");

	Font font1 = new Font("黑体", Font.BOLD, 16);

	public TeamsSelect(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

		// this.add(jl);
		// jl.setBounds(20, 170, 100, 30);
		// jl.setFont(font1);

		this.add(SAS);
		SAS.setBounds(0, 185 - 3, 175, 93);
		SAS.addActionListener(this);
		SAS.setActionCommand("SAS");
		this.add(MEM);
		MEM.setBounds(0, 278 - 3, 175, 93);
		MEM.addActionListener(this);
		MEM.setActionCommand("MEM");
		this.add(DAL);
		DAL.setBounds(0, 371 - 3, 175, 93);
		DAL.addActionListener(this);
		DAL.setActionCommand("DAL");
		this.add(HOU);
		HOU.setBounds(0, 464 - 3, 175, 93);
		HOU.addActionListener(this);
		HOU.setActionCommand("HOU");
		this.add(NOP);
		NOP.setBounds(0, 557 - 3, 175, 93);
		NOP.addActionListener(this);
		NOP.setActionCommand("NOP");

		this.add(MIN);
		MIN.setBounds(175, 185 - 3, 175, 93);
		MIN.addActionListener(this);
		MIN.setActionCommand("MIN");
		this.add(DEN);
		DEN.setBounds(175, 278 - 3, 175, 93);
		DEN.addActionListener(this);
		DEN.setActionCommand("DEN");
		this.add(UTA);
		UTA.setBounds(175, 371 - 3, 175, 93);
		UTA.addActionListener(this);
		UTA.setActionCommand("UTA");
		this.add(POR);
		POR.setBounds(175, 464 - 3, 175, 93);
		POR.addActionListener(this);
		POR.setActionCommand("POR");
		this.add(OKC);
		OKC.setBounds(175, 557 - 3, 175, 93);
		OKC.addActionListener(this);
		OKC.setActionCommand("OKC");

		this.add(SAC);
		SAC.setBounds(350, 185 - 3, 175, 93);
		SAC.addActionListener(this);
		SAC.setActionCommand("SAC");
		this.add(PHX);
		PHX.setBounds(350, 278 - 3, 175, 93);
		PHX.addActionListener(this);
		PHX.setActionCommand("PHX");
		this.add(LAL);
		LAL.setBounds(350, 371 - 3, 175, 93);
		LAL.addActionListener(this);
		LAL.setActionCommand("LAL");
		this.add(LAC);
		LAC.setBounds(350, 464 - 3, 175, 93);
		LAC.addActionListener(this);
		LAC.setActionCommand("LAC");
		this.add(GSW);
		GSW.setBounds(350, 557 - 3, 175, 93);
		GSW.addActionListener(this);
		GSW.setActionCommand("GSW");

		this.add(MIA);
		MIA.setBounds(526, 185 - 3, 175, 93);
		MIA.addActionListener(this);
		MIA.setActionCommand("MIA");
		this.add(ORL);
		ORL.setBounds(526, 278 - 3, 175, 93);
		ORL.addActionListener(this);
		ORL.setActionCommand("ORL");
		this.add(ATL);
		ATL.setBounds(526, 371 - 3, 175, 93);
		ATL.addActionListener(this);
		ATL.setActionCommand("ATL");
		this.add(WAS);
		WAS.setBounds(526, 464 - 3, 175, 93);
		WAS.addActionListener(this);
		WAS.setActionCommand("WAS");
		this.add(CHA);
		CHA.setBounds(526, 557 - 3, 175, 93);
		CHA.addActionListener(this);
		CHA.setActionCommand("CHA");

		this.add(DET);
		DET.setBounds(701, 185 - 3, 175, 93);
		DET.addActionListener(this);
		DET.setActionCommand("DET");
		this.add(IND);
		IND.setBounds(701, 278 - 3, 175, 93);
		IND.addActionListener(this);
		IND.setActionCommand("IND");
		this.add(CLE);
		CLE.setBounds(701, 371 - 3, 175, 93);
		CLE.addActionListener(this);
		CLE.setActionCommand("CLE");
		this.add(CHI);
		CHI.setBounds(701, 464 - 3, 175, 93);
		CHI.addActionListener(this);
		CHI.setActionCommand("CHI");
		this.add(MIL);
		MIL.setBounds(701, 557 - 3, 175, 93);
		MIL.addActionListener(this);
		MIL.setActionCommand("MIL");

		this.add(BOS);
		BOS.setBounds(877, 185 - 3, 175, 93);
		BOS.addActionListener(this);
		BOS.setActionCommand("BOS");
		this.add(PHI);
		PHI.setBounds(877, 278 - 3, 175, 93);
		PHI.addActionListener(this);
		PHI.setActionCommand("PHI");
		this.add(NYK);
		NYK.setBounds(877, 371 - 3, 175, 93);
		NYK.addActionListener(this);
		NYK.setActionCommand("NYK");
		this.add(BKN);
		BKN.setBounds(877, 464 - 3, 175, 93);
		BKN.addActionListener(this);
		BKN.setActionCommand("BKN");
		this.add(TOR);
		TOR.setBounds(877, 557 - 3, 175, 93);
		TOR.addActionListener(this);
		TOR.setActionCommand("TOR");

		// this.add(rankingBand);
		// rankingBand.setBounds(0, 150, 1052, 70);

		Object[][] data = getData();
		model = new DefaultTableModel(data, columnNames);
		model.setDataVector(data, columnNames);
		table = new MyTable(model);
		table.setRowHeight(93);
		table.setFont(new Font("隶书", 0, 20));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pane = new JScrollPane(table);
		this.add(pane);
		pane.setBounds(0, 150, 1052, 500);

		/*
		 * table.addMouseListener(new MouseAdapter() {
		 * //这里使用MouseAdapter代替MouseListener，因为MouseListener要重写的方法太多 public void
		 * mouseClicked(MouseEvent e) { int row = table.getSelectedRow(); int
		 * column = table.getSelectedColumn(); jump(row,column); } });
		 */
	}

	public Object[][] getData() {
		Object[][] data = new Object[5][];
		Object temp1[] = { "", "", "", "", "", "" };
		Object temp2[] = { "", "", "", "", "", "" };
		Object temp3[] = { "", "", "", "", "", "" };
		Object temp4[] = { "", "", "", "", "", "" };
		Object temp5[] = { "", "", "", "", "", "" };
		data[0] = temp1;
		data[1] = temp2;
		data[2] = temp3;
		data[3] = temp4;
		data[4] = temp5;
		return data;
	}

	public void jump(int row, int column) {
		String temp = table.getValueAt(row, column).toString();
		String team = Translate.translate(temp);
		frame.change(this, Frame.singleTeamPanel);
		Frame.singleTeamPanel.update(team);
		Frame.singleTeamPanel.flag = false;
		Frame.currentPanel = "singleTeam";
	}

	public Image getIcon(String team) {
		ImageIcon icon = Img.loadTeam(team);
		Image temp = new ImageIcon(icon.getImage().getScaledInstance(175, 93,
				Image.SCALE_DEFAULT)).getImage();
		return temp;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("home")
				|| e.getActionCommand().equals("back")) {
			frame.change(this, Frame.mainFrame);
			Frame.currentPanel = "main";
		} else if (e.getActionCommand().length() == 3) {
			String team = e.getActionCommand();
			frame.change(this, Frame.singleTeamPanel);
			Frame.singleTeamPanel.update(team);
			Frame.singleTeamPanel.flag = false;
			Frame.currentPanel = "singleTeam";
		}
	}

}

package ui.team;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import businesslogic.playerbl.PlayerRank;
import businesslogicservice.playerblservice.PlayerRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.JFreeUtils;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class TeamAnalyze extends MyPanel implements ActionListener {
	Frame frame;
	DecimalFormat df1=new DecimalFormat("#.0");
	PlayerRankService prs = new PlayerRank();
    String team;
	JLabel teamIcon1 = new JLabel(Img.loadTeam("HOU"));
	JLabel chart1 = new JLabel();
	JLabel board = new JLabel(Img.BOARD2);
    JLabel jl = new JLabel("队内贡献率排行榜");
    JLabel jl1 = new JLabel("");
    JLabel jl2 = new JLabel("");
    JLabel jl3 = new JLabel("");
    
    JLabel jl4 = new JLabel();
    JLabel jl5 = new JLabel();
    JLabel jl6 = new JLabel();
    	
	Font font = new Font("黑体", Font.BOLD, 16);
	Font font1 = new Font("黑体", Font.BOLD, 12);
	JLabel blank = new JLabel(Img.BLANK);
	public TeamAnalyze(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;


		this.add(chart1);
		chart1.setBounds(220,150,832,500);
		
		this.add(teamIcon1);
		teamIcon1.setBounds(0, 150, 200, 200);
		
		this.add(jl);
		jl.setBounds(50, 350, 200, 30);
		jl.setFont(font);
		this.add(jl1);
		jl1.setBounds(20, 440, 200, 30);
		jl1.setFont(font);
		this.add(jl2);
		jl2.setBounds(20, 530, 200, 30);
		jl2.setFont(font);
		this.add(jl3);
		jl3.setBounds(20, 620, 200, 30);
		jl3.setFont(font);
		
		this.add(jl4);
		jl4.setBounds(72, 380, 75, 60);
		this.add(jl5);
		jl5.setBounds(72, 470, 75, 60);
		this.add(jl6);
		jl6.setBounds(72, 560, 75, 60);


		this.add(board);
		board.setBounds(0,150,220,500);

		this.add(blank);
		blank.setBounds(0,150,1052,500);

	}

	public void update(String team) {
        this.team = team;
		ImageIcon icon = Img.loadTeam(team);
		icon.setImage(icon.getImage().getScaledInstance(200, 200,
				Image.SCALE_DEFAULT));
		teamIcon1.setIcon(icon);
		
		updateChart();
	}
	

	
	public void updateChart(){
		ArrayList<String> players = prs.getAllPlayer("14-15", team);
		//初始化数据
		DefaultPieDataset dataset1 = new DefaultPieDataset();
		

		for(int i=0;i<players.size();i++){
			for(int j=i+1;j<players.size();j++){
				if(prs.getPlayerdata("14-15", players.get(i)).getEfficiency()<prs.getPlayerdata("14-15", players.get(j)).getEfficiency()){
					String temp = players.get(i);
					players.set(i, players.get(j));
					players.set(j, temp);
				}
			}
		}
		
		for(int i=0;i<players.size();i++){
			PlayerVO playerData = prs.getPlayerdata("14-15", players.get(i));
		//	if(playerData.getEfficiency()>5)
			    dataset1.setValue(players.get(i),Double.parseDouble(df1.format(playerData.getEfficiency())));
		}
		

	
		jl1.setText("1  "+players.get(0));
		jl2.setText("2  "+players.get(1));
		jl3.setText("3  "+players.get(2));
		ImageIcon icon1 = Img.load(players.get(0));
		icon1.setImage(icon1.getImage().getScaledInstance(75, 60,
				Image.SCALE_DEFAULT));
		jl4.setIcon(icon1);
		
		ImageIcon icon2 = Img.load(players.get(1));
		icon2.setImage(icon2.getImage().getScaledInstance(75, 60,
				Image.SCALE_DEFAULT));
		jl5.setIcon(icon2);
		
		ImageIcon icon3 = Img.load(players.get(2));
		icon3.setImage(icon3.getImage().getScaledInstance(75, 60,
				Image.SCALE_DEFAULT));
		jl6.setIcon(icon3);
		
		
		//生成图表
		JFreeChart chart = JFreeUtils.createPieChart(dataset1,"球员贡献率图",true);
		//生成图片
		JFreeUtils.drawToOutputStream("graphics/chart/饼图.JPG", chart, 832, 500);
		ImageIcon icon = new ImageIcon(
				"graphics/chart/饼图.JPG");
		icon.setImage(icon.getImage().getScaledInstance(832, 500,
				Image.SCALE_DEFAULT));
		chart1.setIcon(icon);
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

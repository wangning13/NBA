package businesslogicservice.teamblservice;

import java.util.ArrayList;

import vo.TeamMatchVO;
import vo.TeamMonthMatchVO;
import vo.TeamVO;
import vo.TeaminfoVO;

public interface TeamRankService {
	// 根据分区联盟，属性条件，正序倒序返回球队数据的数组
	public ArrayList<TeamVO> getTeamData(String season, String condition,
			String key, String order);

	// 根据球队返回球队信息
	public TeaminfoVO getTeamInfo(String teamName);

	// 根据球队返回球队数据
	public TeamVO getTeamData(String season, String teamName);

	// 根据属性条件，正序倒序返回球队数据的数组
	public ArrayList<TeamVO> getAllTeamdata(String season, String key,
			String order);

	public ArrayList<TeamMonthMatchVO> getTeamMonthMatch(String month,
			String team);

	public TeamMatchVO getTeamMatch(String date, String team);

	public ArrayList<TeamMonthMatchVO> getTeamRecentFiveMatch(String season,String team);

	public ArrayList<TeamVO> getSeasonTop(String season, String condition);
	//最近15场
	public ArrayList<TeamMonthMatchVO> getRecentFifteen();
	//通过多元线性回归方程预测球队得分
    public double[] TwoScoring(String TeamName1,String TeamName2);
    
	/*
	 * 多元线性回归方程，数组表示 系数a1,a2,a3,...am,a0。 数组大小m+1
	 * 自变量分别是
	 * 0主客场、1篮板数、2失误数、3犯规数、4助攻数、5抢断数、6盖帽数、7投篮命中率、8三分命中率、9罚球命中率、10对手篮板数、
	 * 11对手投篮命中数、
	 * 12对手投篮出手次数、13对手失误数、14对手罚球数
	 * 
	 */
    public double[] LinerRegression(String season);
    //偏回归系数，数组表示 m个自变量的偏回归系数,数组大小m
    public double[] RegressionCoefficient(String season);
    
    public double[] HostOrGuest(String season);

}

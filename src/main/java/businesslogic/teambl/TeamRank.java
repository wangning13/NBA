package businesslogic.teambl;

import java.text.DecimalFormat;
import java.util.ArrayList;

import po.TeamMatchPO;
import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamMatchVO;
import vo.TeamMonthMatchVO;
import vo.TeamVO;
import vo.TeaminfoVO;
import businesslogicservice.teamblservice.TeamRankService;
import data.getdata.GetTeamdata;
import dataservice.getdatadataservice.GetTeamdataDataService;

public class TeamRank implements TeamRankService{
	DecimalFormat df=new DecimalFormat("#.0000");
	
	private  ArrayList<TeamPO> Ranking(String season,String condition,String order) {
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			teamPOs = g.getSomeTeamdata(season,condition, "wins", order);
			for (int i = 0; i < teamPOs.size(); i++) {
				Calculate calculate = new Calculate();
				teamPOs.set(i, calculate.Calculate(teamPOs.get(i)));
				
			}
	
		return teamPOs;
	}
	
    private ArrayList<TeamVO>  gettingTeamData(String season,String condition, String key,String order) {
    	ArrayList<TeamVO> teamVOs = new ArrayList<TeamVO>();
    	ArrayList<TeamPO> teamPOs2 = null;
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			Sort sort = new Sort();
			teamPOs2 = sort.Sort(this.Ranking(season,condition,order), key, order);
			for (int i = 0; i < teamPOs2.size(); i++) {
				GetTeamVO getTeamVO = new GetTeamVO();
				TeamVO teamVO = getTeamVO.GetTeamVO(teamPOs2.get(i));
				teamVOs.add(teamVO);
			}
		return teamVOs;
	}
    
    public ArrayList<TeamVO>  getTeamData(String season,String condition, String key,String order){
    	ArrayList<TeamVO> teamVOs = gettingTeamData(season,condition, key, order);
    	return teamVOs;
    } 
    
    public TeaminfoVO getTeamInfo(String teamName){
    	TeaminfoPO  teaminfoPO = null;
    	TeaminfoVO teaminfoVO = null;
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			teaminfoPO = g.getTeaminfo(teamName);
			teaminfoVO = new TeaminfoVO(teaminfoPO.getName(), teaminfoPO.getAbbr(), teaminfoPO.getCity(), teaminfoPO.getLeague(), teaminfoPO.getPartition(), teaminfoPO.getCourt(), teaminfoPO.getYear());
			
    	return teaminfoVO;
    }
    
    public TeamVO getTeamData(String season,String teamName){
    	ArrayList<TeamVO> teamVOs = getAllTeamdata(season,"wins", "DESC");
    	int teamRank = 0;
    	TeamVO teamVO = new TeamVO();
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			TeamPO teamPO = g.getTeamdata(season,teamName);
			for (int i = 0; i < teamVOs.size(); i++) {
				if (teamName.equals(teamVOs.get(i).getTeamName())) {
					teamRank = teamVOs.get(i).getRank();
				}
			}
			GetTeamVO getTeamVO = new GetTeamVO();
			
			teamVO = getTeamVO.GetTeamVO(teamPO);
    	return teamVO;
    }
    
    public ArrayList<TeamVO> getAllTeamdata(String season,String key,String order){

    	return this.getTeamData(season,"1", key, order);
    }
	
    public ArrayList<TeamMonthMatchVO> getTeamMonthMatch(String month,String team){
		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = new ArrayList<TeamMonthMatchVO>();
		ArrayList<TeamMatchPO> teamMatchPOs = new ArrayList<TeamMatchPO>();
		GetTeamdataDataService g;
			g = new GetTeamdata();
			teamMatchPOs = g.getTeamMonthMatch(month, team);
			for (int i = 0; i < teamMatchPOs.size(); i++) {
				ArrayList<TeamMatchPO> teamMatchPOs2 = g.getTeamMonthMatch(month, teamMatchPOs.get(i).getOpponent());
				for (int j = 0; j < teamMatchPOs2.size(); j++) {
					if (teamMatchPOs2.get(j).getOpponent().equals(team) && teamMatchPOs2.get(j).getDate().equals(teamMatchPOs.get(i).getDate())) {
						String data = teamMatchPOs.get(i).getDate();
						String host = "";
						String guest = "";
						if (teamMatchPOs.get(i).getHostGuest().equals("h")) {
							host = team;
							guest = teamMatchPOs2.get(j).getName();
						}else {
							host = teamMatchPOs2.get(j).getName();
							guest = team;
						}
						String score = teamMatchPOs.get(i).getTotal() + "-" + teamMatchPOs2.get(j).getTotal();
						String first = teamMatchPOs.get(i).getFirst() + "-" + teamMatchPOs2.get(j).getFirst();
						String second = teamMatchPOs.get(i).getSecond() + "-" + teamMatchPOs2.get(j).getSecond();
						String third = teamMatchPOs.get(i).getThird() + "-" + teamMatchPOs2.get(j).getThird();
						String fourth = teamMatchPOs.get(i).getFourth() + "-" + teamMatchPOs2.get(j).getFourth();
						TeamMonthMatchVO teamMonthMatchVO = new TeamMonthMatchVO(data, host, guest, score, first, second, third, fourth);
						teamMonthMatchVOs.add(teamMonthMatchVO);
					}
				}
				
			}
			
		return teamMonthMatchVOs;
	}
    
    public TeamMatchVO getTeamMatch(String date,String team){
    	TeamMatchVO teamMatchVO = new TeamMatchVO();
    	TeamMatchPO teamMatchPO = new TeamMatchPO();
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			teamMatchPO = g.getTeamMatch(date, team);
			teamMatchVO = new TeamMatchVO(teamMatchPO.getDate(),
					teamMatchPO.getHostGuest(), 
					teamMatchPO.getName(),
					teamMatchPO.getOpponent(),
					teamMatchPO.getWinLose(), 
					teamMatchPO.getTotal(),
					teamMatchPO.getFirst(), 
					teamMatchPO.getSecond(), 
					teamMatchPO.getThird(), 
					teamMatchPO.getFourth());
    	return teamMatchVO;
    }
    
    public ArrayList<TeamMonthMatchVO> getTeamRecentFiveMatch(String team){
    	ArrayList<TeamMatchPO> teamMatchPOs = new ArrayList<TeamMatchPO>();
    	ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = new ArrayList<TeamMonthMatchVO>();
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			teamMatchPOs = g.getTeamRecentFiveMatch(team);
			for (int i = 0; i < 5; i++) {
				String host = "";
				String guest = "";
				String score = "";
				String first = "";
				String second = "";
				String third = "";
				String fourth = "";
				
				if (teamMatchPOs.get(i).getHostGuest().equals("h")) {
					host = team;
					guest = teamMatchPOs.get(i).getOpponent();
					score = teamMatchPOs.get(i).getTotal() + "-" + teamMatchPOs.get(i+5).getTotal();
					first = teamMatchPOs.get(i).getFirst() + "-" + teamMatchPOs.get(i+5).getFirst();
					second = teamMatchPOs.get(i).getSecond() + "-" + teamMatchPOs.get(i+5).getSecond();
					third = teamMatchPOs.get(i).getThird() + "-" + teamMatchPOs.get(i+5).getThird();
					fourth = teamMatchPOs.get(i).getFourth() + "-" + teamMatchPOs.get(i+5).getFourth();
				}else {
					host = teamMatchPOs.get(i).getOpponent();
					guest = team;
					score = teamMatchPOs.get(i+5).getTotal() + "-" + teamMatchPOs.get(i).getTotal();
					first = teamMatchPOs.get(i+5).getFirst() + "-" + teamMatchPOs.get(i).getFirst();
					second = teamMatchPOs.get(i+5).getSecond() + "-" + teamMatchPOs.get(i).getSecond();
					third = teamMatchPOs.get(i+5).getThird() + "-" + teamMatchPOs.get(i).getThird();
					fourth = teamMatchPOs.get(i+5).getFourth() + "-" + teamMatchPOs.get(i).getFourth();
				}
				TeamMonthMatchVO teamMonthMatchVO = new TeamMonthMatchVO(
						teamMatchPOs.get(i).getDate(),
						host,
						guest,
						score,
						first,
						second,
						third,
						fourth);
				teamMonthMatchVOs.add(teamMonthMatchVO);
			}
    	return teamMonthMatchVOs;
    }
    
    public ArrayList<TeamVO> getSeasonTop(String season,String condition){
    	ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
    	ArrayList<TeamPO> teamPOs2 = new ArrayList<TeamPO>();
    	ArrayList<TeamVO> teamVOs = new ArrayList<TeamVO>();
    	GetTeamdataDataService g;
 			g = new GetTeamdata();
			teamPOs = g.getAllTeamdata(season, "wins", "DESC");
			for (int i = 0; i < teamPOs.size(); i++) {
				Calculate calculate = new Calculate();
				teamPOs.set(i, calculate.Calculate(teamPOs.get(i)));
			}
			Sort sort = new Sort();
			teamPOs2 = sort.Sort(teamPOs, condition, "DESC");
			for (int i = 0; i < 5; i++) {
				GetTeamVO getTeamVO = new GetTeamVO();
				TeamVO teamVO = getTeamVO.GetTeamVO(teamPOs2.get(i));
				teamVOs.add(teamVO);
			}
    	return teamVOs;
    }

}


package dataservice.getdatadataservice;

import java.util.ArrayList;

import po.TeamMatchPO;
import po.TeamPO;
import po.TeaminfoPO;

public interface GetTeamdataDataService {

	public TeamPO getTeamdata(String season, String teamName);

	public TeaminfoPO getTeaminfo(String teamName);

	public ArrayList<String> getTeamPlayer(String season, String teamName);

	public ArrayList<TeamPO> getAllTeamdata(String season, String key,
			String order);

	public ArrayList<TeamPO> getSomeTeamdata(String season, String condition,
			String key, String order);

	public ArrayList<TeamMatchPO> getTeamMonthMatch(String season,String month, String team);

	public TeamMatchPO getTeamMatch(String season,String date, String team);

	public ArrayList<TeamMatchPO> getTeamRecentFiveMatch(String season,String team);

	public ArrayList<TeamMatchPO> getRecentFifteen();
	
}

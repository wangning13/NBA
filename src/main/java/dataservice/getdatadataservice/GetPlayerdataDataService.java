package dataservice.getdatadataservice;

import java.util.ArrayList;

import po.PlayerMatchPO;
import po.PlayerPO;
import po.PlayerinfoPO;

public interface GetPlayerdataDataService {

	public PlayerPO getPlayerdata(String season,String playerName);
	
	public PlayerinfoPO getPlayerinfo(String playerName);
	
	public ArrayList<PlayerPO> getAllPlayerdata(String season,String key,String order);
	
	public ArrayList<PlayerPO> getSomePlayerdata(String season,String position,String partition,String key,String order);
	
	public ArrayList<PlayerPO> getByEfficiency(ArrayList<PlayerPO> po,String key,String order);
	//一场比赛一个球队所有球员数据
	public ArrayList<PlayerMatchPO> getPlayerMatchdata(String date,String team);
	
	public ArrayList<PlayerMatchPO> getPlayerMonthMatch(String month,String player);
	
	public ArrayList<PlayerMatchPO> getPlayerRecentFiveMatch(String player);
	
	public ArrayList<PlayerMatchPO> getDayTop(String condition);
	//仅适用于场均
	public ArrayList<PlayerPO> getSeasonTop(String season,String condition);
}

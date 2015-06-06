package businesslogic.playerbl;

import java.text.DecimalFormat;
import java.util.ArrayList;

import po.PlayerMatchPO;
import po.PlayerPO;
import po.PlayerinfoPO;
import vo.PlayerMatchVO;
import vo.PlayerVO;
import vo.PlayerinfoVO;
import businesslogicservice.playerblservice.PlayerRankService;
import data.getdata.GetPlayerdata;
import data.getdata.GetTeamdata;
import dataservice.getdatadataservice.GetPlayerdataDataService;
import dataservice.getdatadataservice.GetTeamdataDataService;

public class PlayerRank implements PlayerRankService{
	DecimalFormat df=new DecimalFormat("#.0000");
	
	String[] allPlayer;
	public ArrayList<String> getAllPlayer(String season,String teamName){
		ArrayList<String> teamPlayerList1;
		ArrayList<String> teamPlayerList2 = new ArrayList<String>();
		GetTeamdataDataService g;
			g = new GetTeamdata();
			teamPlayerList1 = g.getTeamPlayer(season,teamName);
			for (int i = 0; i < teamPlayerList1.size(); i++) {
				if (!teamPlayerList1.get(i).equals(null)) {
					teamPlayerList2.add(teamPlayerList1.get(i));
				}
			}

		return teamPlayerList2;
		
	}
	
	public PlayerVO getPlayerdata(String season,String playerName){
		ArrayList<PlayerPO> playerPOs = new ArrayList<>();
		
		GetPlayerdataDataService g ;
		PlayerPO playerPO = new PlayerPO();
		PlayerVO playerVO = new PlayerVO() ;
		g = new GetPlayerdata();
		if (playerName.equals("league")) {
			playerPOs = g.getAllPlayerdata(season, "backboard", "DESC");
			int scoring = 0;//平均得分
			int backboard = 0;//平均篮板
			int assist = 0;//平均助攻
			int freeThrow = 0;//平均罚球命中数
			int threePointFieldGoal = 0;//平均三分命中数
			int steal = 0;//平均抢断数
			int block= 0; //平均盖帽数
			int turnOver = 0 ;//平均失误数
			int foul = 0;//平均犯规数
			for (int i = 0; i < playerPOs.size(); i++) {
				scoring = scoring + playerPOs.get(i).getScoring();
				backboard = backboard + playerPOs.get(i).getBackboard();
				assist = assist + playerPOs.get(i).getAssist();
				freeThrow  = freeThrow + playerPOs.get(i).getFreeThrow();
				threePointFieldGoal = threePointFieldGoal + playerPOs.get(i).getThreePointFieldGoal();
				steal = steal + playerPOs.get(i).getSteal();
				block = block + playerPOs.get(i).getBlock();
				turnOver = turnOver + playerPOs.get(i).getTurnOver();
				foul = foul + playerPOs.get(i).getFoul();
			}
			scoring = scoring/playerPOs.size();
			backboard = backboard/playerPOs.size();
			assist = assist/playerPOs.size();
			freeThrow = freeThrow/playerPOs.size();
			threePointFieldGoal = threePointFieldGoal/playerPOs.size();
			steal = steal/playerPOs.size();
			block = block/playerPOs.size();
			turnOver = turnOver/playerPOs.size();
			foul = foul/playerPOs.size();
			playerVO = new PlayerVO("league", null, 0, 0, backboard, 0, assist, 
					0, 0, 0, 0, 0, 0, 
					0, threePointFieldGoal, 0, 
					0, 0, freeThrow, 
					0, 0, 0, 0, 
					0, 0, 0, steal, 0,
					block, 0, turnOver, 0, foul, 0, scoring, 0, 
					0, 0, 0, 0, 0, 
					0, 0, 0, 0, 0, 
					0, 0, 0, 
					0, 0, 0, 
					0, 0, 0, 0, 0, 
					0, 0, 0, 0,
					0, 0, 0, 0, 0, 
					0, 0, 0, 0, 
					0, 0, 0,
					0, 0);
			
		}else {
			playerPO = g.getPlayerdata(season,playerName);
			Calculate calculate = new Calculate();
			playerPO = calculate.Calculate(playerPO);
				
			GetPlayerVO getPlayerVO = new GetPlayerVO();
			playerVO = getPlayerVO.getPlayerVO(playerPO);
		}
		
		
		return playerVO;
	}
	
	public PlayerinfoVO getPlayerinfo(String playerName){
		GetPlayerdataDataService g;
		PlayerinfoPO playerinfoPO = new PlayerinfoPO();
		PlayerinfoVO playerinfoVO = new PlayerinfoVO();
			g = new GetPlayerdata();
			playerinfoPO = g.getPlayerinfo(playerName);
			if (playerinfoPO==null) {
				playerinfoVO = new PlayerinfoVO("",
						"", 
						"", 
						"", 
						0, 
						"",
						0, 
						"", 
						"");
			}else {
				playerinfoVO = new PlayerinfoVO(playerinfoPO.getName(),
						playerinfoPO.getNumber(), 
						playerinfoPO.getPosition(), 
						playerinfoPO.getHeight(), 
						playerinfoPO.getWeight(), 
						playerinfoPO.getBirth(),
						playerinfoPO.getAge(), 
						playerinfoPO.getExp(), 
						playerinfoPO.getSchool());
			}
	 	return playerinfoVO;
	}
	
	public ArrayList<PlayerVO> getAllPlayerdata(String season,String key,String order){
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g;
			g = new GetPlayerdata();
			playerPOs = g.getAllPlayerdata(season,"backboard", order);
			for (int i = 0; i < playerPOs.size(); i++) {
				Calculate calculate = new Calculate();
				playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
				}
			Sort sort = new Sort();
			ArrayList<PlayerPO> playerPOs2 = sort.Sort(playerPOs, key, order);
			for (int i = 0; i < playerPOs2.size(); i++) {
				GetPlayerVO getPlayerVO = new GetPlayerVO();
				PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs2.get(i));
				playerVOs.add(playerVO);
			}
		return playerVOs;
	}
	
	//筛选前50名
	public ArrayList<PlayerVO> getFirstFifty(String season,String position,String partition,String key){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		GetPlayerdataDataService g;
 			g = new GetPlayerdata();
			if (key.equals("weightAverage")) {
				playerPOs = g.getSomePlayerdata(season,position, partition, "scoring", "DESC");
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getScoring()+playerPOs.get(j).getBackboard()+playerPOs.get(j).getAssist() < playerPOs.get(j+1).getScoring()+playerPOs.get(j+1).getBackboard()+playerPOs.get(j+1).getAssist()) {
							PlayerPO tempPlayerPO = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, tempPlayerPO);
						}
					}
				}
				for (int i = 0; i < Math.min(50, playerPOs.size()); i++) {
					Calculate calculate = new Calculate();
					playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
				}
				
				
				for (int i = 0; i < Math.min(50, playerPOs.size()); i++){
					GetPlayerVO getPlayerVO = new GetPlayerVO();
					PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs.get(i));
					playerVOs.add(playerVO);
				}
			}else {
				playerPOs = g.getSomePlayerdata(season,position, partition, "scoring", "DESC");
				for (int i = 0; i < Math.min(50, playerPOs.size()); i++) {
					Calculate calculate = new Calculate();
					playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
				}
				Sort sort = new Sort();
				ArrayList<PlayerPO> playerPOs2 = sort.Sort(playerPOs, key, "DESC");
				for (int i = 0; i < Math.min(50, playerPOs2.size()); i++) {
					GetPlayerVO getPlayerVO = new GetPlayerVO();
					PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs2.get(i));
					playerVOs.add(playerVO);
				
				}
			}
		return playerVOs;
		
	}
	
	//一场比赛一个球队所有球员数据
	public ArrayList<PlayerMatchVO> getPlayerMatchdata(String date,String team){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
			g = new GetPlayerdata();
			playerMatchPOs = g.getPlayerMatchdata(date, team);
			for (int i = 0; i < playerMatchPOs.size(); i++) {
				GetPlayerMatchVO getPlayerMatchVO = new GetPlayerMatchVO();
				PlayerMatchVO playerMatchVO = getPlayerMatchVO.getPlayerMatchVO(playerMatchPOs.get(i));
				playerMatchVOs.add(playerMatchVO);
				
			}
		return playerMatchVOs;
	}
	
	
	public ArrayList<PlayerMatchVO> getPlayerMonthMatch(String month,String player){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
			g = new GetPlayerdata();
			playerMatchPOs = g.getPlayerMonthMatch(month, player);
//			System.out.println(playerMatchPOs.size());
			for (int i = 0; i < playerMatchPOs.size(); i++) {
				GetPlayerMatchVO getPlayerMatchVO = new GetPlayerMatchVO();
				PlayerMatchVO playerMatchVO = getPlayerMatchVO.getPlayerMatchVO(playerMatchPOs.get(i));
				playerMatchVOs.add(playerMatchVO);
				
			}
		return playerMatchVOs;
		
	}
	
	public ArrayList<PlayerMatchVO> getPlayerRecentFiveMatch(String player){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
			g = new GetPlayerdata();
			playerMatchPOs = g.getPlayerRecentFiveMatch(player);
			for (int i = 0; i < playerMatchPOs.size(); i++) {
				GetPlayerMatchVO getPlayerMatchVO = new GetPlayerMatchVO();
				PlayerMatchVO playerMatchVO = getPlayerMatchVO.getPlayerMatchVO(playerMatchPOs.get(i));
				playerMatchVOs.add(playerMatchVO);
				
			}
		return playerMatchVOs;
	}
	
	public ArrayList<PlayerMatchVO> getDayTop(String condition){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
			g = new GetPlayerdata();
			playerMatchPOs = g.getDayTop(condition);
			for (int i = 0; i < playerMatchPOs.size(); i++) {
				GetPlayerMatchVO getPlayerMatchVO = new GetPlayerMatchVO();
				PlayerMatchVO playerMatchVO = getPlayerMatchVO.getPlayerMatchVO(playerMatchPOs.get(i));
				playerMatchVOs.add(playerMatchVO);
				
			}
		return playerMatchVOs;
	}
	
	
	
	public ArrayList<PlayerVO> getSeasonTop(String season,String condition){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		GetPlayerdataDataService g;
			g = new GetPlayerdata();
			playerPOs = g.getAllPlayerdata(season, "backboard", "DESC");
			int playerPOsSize = playerPOs.size();
			for (int i = 0; i < playerPOs.size(); i++) {
				Calculate calculate = new Calculate();
				playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
			Sort sort = new Sort();
			
			playerPOs2 = sort.Sort(playerPOs, condition, "DESC");
			int number = 0;
			if (playerPOsSize<5) {
				number = playerPOsSize;
			}else {
				number = 5;
			}
			for (int i = 0; i < number; i++) {
				GetPlayerVO getPlayerVO = new GetPlayerVO();
				PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs2.get(i));
				playerVOs.add(playerVO);
				
			}
		return playerVOs;
	}
	 
	
	public ArrayList<PlayerVO> getMostImporvedPlayer(String season,String key){
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g;
			g = new GetPlayerdata();
			playerPOs = g.getAllPlayerdata(season, "backboard", "DESC");
			int playerPOsSize = playerPOs.size();
			for (int i = 0; i < playerPOs.size(); i++) {
				Calculate calculate = new Calculate();
				playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
			Sort sort = new Sort();
			playerPOs2 = sort.Sort(playerPOs, key, "DESC");
			int number = 0;
			if (playerPOsSize<5) {
				number = playerPOsSize;
			}else {
				number = 5;
			}
			for (int i = 0; i < number; i++) {
				GetPlayerVO getPlayerVO = new GetPlayerVO();
				PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs2.get(i));
				playerVOs.add(playerVO);
			}
	
		
		return playerVOs;
	}
	public ArrayList<PlayerVO> getPlayerName(String season,String key){
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getPlayerName(season, key);
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		for (int i = 0; i < playerPOs.size(); i++) {
			GetPlayerVO getPlayerVO = new GetPlayerVO();
			PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs.get(i));
			playerVOs.add(playerVO);
		}
		
		return playerVOs;
	}
	
}

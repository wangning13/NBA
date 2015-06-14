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
		DecimalFormat df1=new DecimalFormat("#.0");
		ArrayList<PlayerPO> playerPOs = new ArrayList<>();
		ArrayList<PlayerVO> playerVOs = new ArrayList<>();
		GetPlayerdataDataService g ;
		PlayerPO playerPO = new PlayerPO();
		PlayerVO playerVO = new PlayerVO() ;
		g = new GetPlayerdata();
		if (playerName.equals("league")) {
			playerPOs = g.getAllPlayerdata(season, "backboard", "DESC");
			double averageScoring = 0;//平均得分
			double averageBackboard = 0;//平均篮板
			double averageAssist = 0;//平均助攻
			double averageFreeThrow = 0;//平均罚球命中数
			double averageThreePointFieldGoal = 0;//平均三分命中数
			double averageSteal = 0;//平均抢断数
			double averageBlock = 0; //平均盖帽数
			double averageTurn = 0;//平均失误数
			double averageFoul = 0;//平均犯规数
			for (int i = 0; i < playerPOs.size(); i++) {
				
				Calculate calculate = new Calculate();
				playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
					
				GetPlayerVO getPlayerVO = new GetPlayerVO();
				playerVO = getPlayerVO.getPlayerVO(playerPOs.get(i));
				playerVOs.add(playerVO);
				
			}
			for (int i = 0; i < playerVOs.size(); i++) {
				averageScoring = averageScoring + playerVOs.get(i).getAverageScoring();
				averageBackboard = averageBackboard + playerVOs.get(i).getAverageBackboard();
				averageAssist = averageAssist + playerVOs.get(i).getAverageAssist();
				averageFreeThrow  = averageFreeThrow + playerVOs.get(i).getAverageFreeThrow();
				averageThreePointFieldGoal = averageThreePointFieldGoal + playerVOs.get(i).getAverageThreePointFieldGoal();
				averageSteal = averageSteal + playerVOs.get(i).getAverageSteal();
				averageBlock = averageBlock + playerVOs.get(i).getAverageBlock();
				averageTurn = averageTurn + playerVOs.get(i).getAverageTurn();
				averageFoul = averageFoul + playerVOs.get(i).getAverageFoul();
			}
			averageScoring = Double.parseDouble(df1.format(averageScoring/playerVOs.size()));
			averageBackboard = Double.parseDouble(df1.format(averageBackboard/playerVOs.size()));
			averageAssist = Double.parseDouble(df1.format(averageAssist/playerVOs.size()));
			averageFreeThrow  = Double.parseDouble(df1.format(averageFreeThrow/playerVOs.size()));
			averageThreePointFieldGoal = Double.parseDouble(df1.format(averageThreePointFieldGoal/playerVOs.size()));
			averageSteal = Double.parseDouble(df1.format(averageSteal/playerVOs.size()));
			averageBlock = Double.parseDouble(df1.format(averageBlock/playerVOs.size()));
			averageTurn = Double.parseDouble(df1.format(averageTurn/playerVOs.size()));
			averageFoul = Double.parseDouble(df1.format(averageFoul/playerVOs.size()));
			playerVO = new PlayerVO("league", null, 0, 0, 0, averageBackboard, 0,
					averageAssist, 0, 0, 0, 0, 0, 
					0, 0, averageThreePointFieldGoal, 
					0, 0, 0, averageFreeThrow,
					0, 0, 0, 0,
					0, 0, 0, averageSteal, 0, averageBlock, 0, 
					averageTurn, 0, averageFoul, 0, averageScoring, 0, 0,
					0, 0, 0, 0, 0, 
					0, 0, 0, 0, 
					0, 0, 0, 
					0, 0, 0, 0,
					0, 0, 0, 0, 
					0, 0, 0, 0,
					0, 0, 0, 0, 0,
					0, 0, 0, 0,
					0, 0, 0, 0);
			
			
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
	//近5场
	public ArrayList<PlayerMatchVO> getPlayerRecentFiveMatch(String season,String player){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
			g = new GetPlayerdata();
			playerMatchPOs = g.getPlayerRecentFiveMatch(season,player);
			for (int i = 0; i < playerMatchPOs.size(); i++) {
				GetPlayerMatchVO getPlayerMatchVO = new GetPlayerMatchVO();
				PlayerMatchVO playerMatchVO = getPlayerMatchVO.getPlayerMatchVO(playerMatchPOs.get(i));
				playerMatchVOs.add(playerMatchVO);
				
			}
		return playerMatchVOs;
	}
	//近10场
	public ArrayList<PlayerMatchVO> getPlayerRecentSeasonMatch(String season,String player){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
			g = new GetPlayerdata();
			playerMatchPOs = g.getPlayerRecentSeasonMatch(season,player);
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
	
	//求球员得分和球员球龄的相关系数
	public double getPlayerPearson(String season){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata(season, "scoring", "DESC");
		int [][] xy = new int[playerPOs.size()][2];
		double r = 0;
		for (int i = 0; i <playerPOs.size(); i++) {
			xy[i][0] = playerPOs.get(i).getScoring();
			xy[i][1] = Integer.parseInt(getPlayerinfo(playerPOs.get(i).getPlayerName()).getExp());
		}
		int a = 0;
		int b = 0;
		double c = 0.0;
		double d = 0.0;
		for (int i = 0; i < playerPOs.size(); i++) {
			a = a + xy[i][0]*xy[i][1];
		}
		a = a * playerPOs.size();
		int b1 = 0;
		int b2 = 0;
		for (int i = 0; i < playerPOs.size(); i++) {
			b1 = b1 + xy[i][0];
		}
		for (int i = 0; i < playerPOs.size(); i++) {
			b2 = b2 + xy[i][1];
		}
		b = b1 * b2;
		double x_average = (double)b1/playerPOs.size();
		double y_average = (double)b2/playerPOs.size();
		double c1 = 0;
		for (int i = 0; i < playerPOs.size(); i++) {
			c1 = c1 + (xy[i][0] - x_average) * (xy[i][0] - x_average);
		}
		c = Math.sqrt(c1);
		double d1 = 0;
		for (int i = 0; i < playerPOs.size(); i++) {
			d1 = d1 + (xy[i][1] - y_average) * (xy[i][1] - y_average);
		}
		d = Math.sqrt(d1);
		r = (double)(a+b)/(c+d);
		
		return r;
	}
	
}

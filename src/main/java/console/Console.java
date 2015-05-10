package console;

import java.io.PrintStream;
import java.util.ArrayList;

import rmi.Server;
import test.data.TeamHighInfo;
import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamNormalInfo;
import vo.PlayerMatchVO;
import vo.PlayerVO;
import vo.TeamVO;
import businesslogic.playerbl.PlayerRank;
import businesslogic.teambl.TeamRank;
import businesslogicservice.playerblservice.PlayerRankService;
import businesslogicservice.teamblservice.TeamRankService;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;

public class Console {
	PrintStream out;

	@CmdCommand(names = {"-player"},description = "Show player data")
	public class PlayerModel {
		PlayerRankService prs = new PlayerRank();
		boolean isAvg = true;
		boolean isSeason = true;
		boolean isHigh = false;
		boolean isDesc = true;
		String term = "all";
		String field;
		int num = 50;
		ArrayList<String> filter = new ArrayList<String>(0);
		ArrayList<String> sort = new ArrayList<String>(0);
		ArrayList<PlayerVO> players = new ArrayList<PlayerVO>(0);
		@CmdOption(names = {"-avg"},description = "Show average player data")
		public void setAvgPlayer() {
			isAvg = true;
		//	out.println("Show average player data");
		}
		
		@CmdOption(names = {"-total"},description = "Show total player data")
		public void setTotalPlayer() {
			isAvg = false;
			//out.println("Show total player data");
		}
		
		@CmdOption(names = {"-all"},description = "Show all player data")
		public void setAllPlayer() {
			term = "all";
			//out.println("Show all player data");
		}
		
		@CmdOption(names = {"-hot"},args = { "filed" },description = "Show hot player ")
		public void setHotPlayer(String field) {
			term = "hot";
			this.field = field;
			//out.println("Show hot player:"+this.field );
		}
		
		
		@CmdOption(names = {"-king"},args = {"field"},description = "Show king player ")
		public void setKingPlayer(String field) {
			term = "king";
			this.field = field;
			//out.println("Show king player:"+ this.field);
		}

		@CmdOption(names = {"-season"},description = "Show season king player data",maxCount = 1,minCount = 0,requires = {"-king"},conflictsWith = {"-daily"})
		public void setKingSeasonPlayer() {
			isSeason = true;
		//	out.println("Show season king player data");
		}
		
		@CmdOption(names = {"-daily"},description = "Show daily king player data",maxCount = 1,minCount = 0,requires = {"-king"},conflictsWith = {"-season"})
		public void setKingDailyPlayer() {
			isSeason = false;
			//out.println("Show daily king player data");
		}
		
		@CmdOption(names = { "-n" }, args = { "filed" }, maxCount = 1, minCount = 0)
		public void setNum(String filed) {
			this.num = Integer.parseInt(filed);
			//out.println(this.num);
		}
		
		@CmdOption(names = { "-high" })
		public void setHigh() {
			this.isHigh = true;
			//System.out.println("isHigh:"+this.isHigh);
		}
		
	
	  	@CmdOption(names = {"-filter"},args = {"field"},description = "filter filed", maxCount = 1, minCount = 0)
		public void setField(String field) {
	  		String[] temps = field.split(",");
	  		for(int i=0;i<temps.length;i++){
	  			filter.add(temps[i]);
			    String[] temp = temps[i].split("\\.");
			//    out.println(temp[0]+":"+temp[1]);
	  		}
		}	

	   @CmdOption(names = {"-sort"},args = {"field"},description = "set sort", maxCount = 1, minCount = 0)
		public void setSortAsc(String field) {
	  		String[] temps = field.split(",");
	  		for(int i=0;i<temps.length;i++){
	  			sort.add(temps[i]);
			    String[] temp = temps[i].split("\\.");
			//    out.println(temp[0]+":"+temp[1]);
	  		}
		}
		
	    public ArrayList<PlayerVO> filter(ArrayList<PlayerVO> players){
		   int num = filter.size();
		   for(int i = 0;i<num;i++){
			   String temps = filter.get(i);
			   String[] temp = temps.split("\\.");
			   if(temp[0].equals("position")&&!temp[1].equals("ALL")){		   
				   for(int j = 0;j<players.size();j++){
					 if(!prs.getPlayerinfo((players.get(j).getPlayerName())).getPosition().equals(temp[1])){
						 players.remove(j);
						 j--;
					 } 
				  }
			   }
			   else if(temp[0].equals("league")&&!temp[1].equals("ALL")){
				   for(int j = 0;j<players.size();j++){
					 if(!(((players.get(j).getTeam().equals("SAS")||players.get(j).getTeam().equals("MEM")||players.get(j).getTeam().equals("DAL")||players.get(j).getTeam().equals("HOU")||players.get(j).getTeam().equals("NOP")||players.get(j).getTeam().equals("MIN")||players.get(j).getTeam().equals("DEN")||players.get(j).getTeam().equals("UTA")||players.get(j).getTeam().equals("POR")||players.get(j).getTeam().equals("OKC")||players.get(j).getTeam().equals("SAC")||players.get(j).getTeam().equals("PHX")||players.get(j).getTeam().equals("LAL")||players.get(j).getTeam().equals("LAC")||players.get(j).getTeam().equals("GSW"))&&temp[1].equals("W"))||((players.get(j).getTeam().equals("MIA")||players.get(j).getTeam().equals("ATL")||players.get(j).getTeam().equals("WAS")||players.get(j).getTeam().equals("CHA")||players.get(j).getTeam().equals("DET")||players.get(j).getTeam().equals("IND")||players.get(j).getTeam().equals("CLE")||players.get(j).getTeam().equals("ORL")||players.get(j).getTeam().equals("CHI")||players.get(j).getTeam().equals("MIL")||players.get(j).getTeam().equals("BOS")||players.get(j).getTeam().equals("PHI")||players.get(j).getTeam().equals("NYK")||players.get(j).getTeam().equals("BKN")||players.get(j).getTeam().equals("TOR"))&&temp[1].equals("E"))) ){
						 players.remove(j);
						 j--;
					 } 
				   }
			   }
			   else if(temp[0].equals("age")&&!temp[1].equals("ALL")){		   
				   for(int j = 0;j<players.size();j++){
					 if(!((prs.getPlayerinfo((players.get(j).getPlayerName())).getAge()<=22&&temp[1].equals("<=22"))||(((prs.getPlayerinfo((players.get(j).getPlayerName())).getAge()>22)&&(prs.getPlayerinfo((players.get(j).getPlayerName())).getAge()<=25))&&temp[1].equals("22< X <=25"))||(((prs.getPlayerinfo((players.get(j).getPlayerName())).getAge()>25)&&(prs.getPlayerinfo((players.get(j).getPlayerName())).getAge()<=30))&&temp[1].equals("25< X <=30"))||prs.getPlayerinfo((players.get(j).getPlayerName())).getAge()>30&&temp[1].equals(">30"))){
						 players.remove(j);
						 j--;
					 } 
				  }
			   }
		   }
		   
		   
		   return players;
	   }
	
		public String translate(String string){
			String result = "scoring";
			if(string.equals("score")){
				result = "scoring";
			}
			else if(string.equals("rebound")){
				result = "backboard";
			}
			return result;	
		}
		
		public void print(){
			if(!isHigh){
	    		if(isAvg){
		    		if(term.equals("all")){
		    			players = prs.getAllPlayerdata("13-14", "scoring", "DESC");
		    			players = filter(players);
			    		int n = players.size();
			    		if(num>n)
			    			num=n;
			    		
			    		for(int i =0;i<num;i++){
			    			PlayerNormalInfo player = new PlayerNormalInfo();
			    			player.setAge(prs.getPlayerinfo((players.get(i).getPlayerName())).getAge());
			    			player.setAssist(players.get(i).getAverageAssist());
			    			player.setBlockShot(players.get(i).getAverageBlock());
			    			player.setDefend(players.get(i).getAverageDefensiveRebound());
			    			player.setEfficiency(players.get(i).getEfficiency());
			    			player.setFault(players.get(i).getAverageTurn());
			    			player.setFoul(players.get(i).getAverageFoul());
			    			player.setMinute(players.get(i).getAverageMinute());
			    			player.setName(players.get(i).getPlayerName());
			    			player.setNumOfGame(players.get(i).getAppearance());
			    			player.setOffend(players.get(i).getAverageOffensiveRebound());
			    			player.setPenalty(players.get(i).getFreeThrowPercentage());
			    			player.setPoint(players.get(i).getAverageScoring());
			    			player.setRebound(players.get(i).getAverageBackboard());
			    			player.setShot(players.get(i).getFielfGoalShotPercentage());
			    			player.setStart(players.get(i).getFirstPlay());
			    			player.setSteal(players.get(i).getAverageSteal());
			    			player.setTeamName(players.get(i).getTeam());
			    			player.setThree(players.get(i).getThreePointShotPercentage());
			    		}
	    			}
		    		else if(term.equals("hot")){
			    		players = prs.getMostImporvedPlayer("13-14", translate(field));
			    		int n = players.size();
			    		if(num>n)
			    			num=n;
			    		
			    		for(int i =0;i<num;i++){
			    			PlayerHotInfo player = new PlayerHotInfo();
			    			player.setField(field);
			    			player.setName(players.get(i).getPlayerName());
			    			player.setPosition(prs.getPlayerinfo(players.get(i).getPlayerName()).getPosition());
                            player.setUpgradeRate(players.get(i).getNearlyFivePercentage());
                            if(field.equals("score")){
                            	player.setValue(players.get(i).getScoring());
                            }
                            else if(field.equals("rebound")){
                            	player.setValue(players.get(i).getBackboard());
                            }
                            else{
                            	player.setValue(players.get(i).getAssist());
                            }
			    		}
		    		}
		    		else if(term.equals("king")){
		      			if(isSeason){
		     			players = prs.getSeasonTop("13-14", translate(field));
		      			}
		    			else{
		    				ArrayList<PlayerMatchVO> players = prs.getDayTop(translate(field));
		    				int n = players.size();
		    				for(int i=0 ;i<n;i++){
		    					this.players.add(prs.getPlayerdata("13-14",players.get(i).getPlayername()));
		    				}
			    		}
		      			int n = players.size();
			    		if(num>n)
			    			num=n;
			    		
			    		for(int i =0;i<num;i++){
			    			PlayerKingInfo player = new PlayerKingInfo();
			    			player.setField(field);
			    			player.setName(players.get(i).getPlayerName());
			    			player.setPosition(prs.getPlayerinfo(players.get(i).getPlayerName()).getPosition());
                            player.setTeamName(players.get(i).getTeam());
                            if(field.equals("score")){
                            	player.setValue(players.get(i).getScoring());
                            }
                            else if(field.equals("rebound")){
                            	player.setValue(players.get(i).getBackboard());
                            }
                            else{
                            	player.setValue(players.get(i).getAssist());
                            }
                          
			    		}
			    	}
	    		}
			    else{
			    	players = prs.getAllPlayerdata("13-14", "scoring", "DESC");
			    	players = filter(players);
			    	
		    		int n = players.size();
		    		if(num>n)
		    			num=n;
		    		
		    		for(int i =0;i<num;i++){
		    			PlayerNormalInfo player = new PlayerNormalInfo();
		    			player.setAge(prs.getPlayerinfo((players.get(i).getPlayerName())).getAge());
		    			player.setAssist(players.get(i).getAssist());
		    			player.setBlockShot(players.get(i).getBlock());
		    			player.setDefend(players.get(i).getDefensiveRebound());
		    			player.setEfficiency(players.get(i).getEfficiency());
		    			player.setFault(players.get(i).getTurnOver());
		    			player.setFoul(players.get(i).getFoul());
		    			player.setMinute(players.get(i).getMinutes());
		    			player.setName(players.get(i).getPlayerName());
		    			player.setNumOfGame(players.get(i).getAppearance());
		    			player.setOffend(players.get(i).getOffensiveRebound());
		    			player.setPenalty(players.get(i).getFreeThrowPercentage());
		    			player.setPoint(players.get(i).getScoring());
		    			player.setRebound(players.get(i).getBackboard());
		    			player.setShot(players.get(i).getFielfGoalShotPercentage());
		    			player.setStart(players.get(i).getFirstPlay());
		    			player.setSteal(players.get(i).getSteal());
		    			player.setTeamName(players.get(i).getTeam());
		    			player.setThree(players.get(i).getThreePointShotPercentage());
		    			
		    		}
			    }

			}
			else{
				players = prs.getAllPlayerdata("13-14", "trueShootingPercentage", "DESC");
	    		int n = players.size();
	    		if(num>n)
	    			num=n;
	    		
	    		for(int i =0;i<num;i++){
	    			PlayerHighInfo player = new PlayerHighInfo();
	    			player.setAssistEfficient(players.get(i).getAssistPercentage());
	    			player.setBlockShotEfficient(players.get(i).getBackboardPercentage());
	    			player.setDefendReboundEfficient(players.get(i).getDefensiveReboundPercentage());
	    			player.setFaultEfficient(players.get(i).getTurnOverPercentage());
	    			player.setFrequency(players.get(i).getUsage());
	    			player.setGmSc(players.get(i).getGmScEfficiency());
	//////    /////////			player.getLeague();
                    player.setName(players.get(i).getPlayerName());
                    player.setOffendReboundEfficient(players.get(i).getOffensiveReboundPercentage());
	    			player.setPosition(prs.getPlayerinfo(players.get(i).getPlayerName()).getPosition());
	    			player.setRealShot(players.get(i).getTrueShootingPercentage());
	    			player.setReboundEfficient(players.get(i).getBackboardPercentage());
	    			player.setShotEfficient(players.get(i).getShootingEfficiency());
	    			player.setStealEfficient(players.get(i).getStealPercentage());
	    			player.setTeamName(players.get(i).getTeam());
	    		}
			}
			//out.println("result");
		}
	
	}
	
	@CmdCommand(names = {"-team"},description = "Show team data")
	public class TeamModel {

		TeamRankService trs = new TeamRank();
		boolean isAvg = true;
		boolean isAll = true;
		int num = 30;
		boolean isHigh = false;
		String field = "";
		String order = "desc";
		
		@CmdOption(names = {"-avg"},description = "Show average team data")
		public void setAvgTeam() {
			
		}
		
		@CmdOption(names = {"-total"},description = "Show total team data")
		public void setTotalTeam() {
			isAvg = false;
		}
		
		@CmdOption(names = {"-all"},description = "Show all team data")
		public void setAllTeam() {
			
		}
		
		@CmdOption(names = {"-hot"},args = {"field"},description = "Show hot team data")
		public void setHotTeam(String field) {
			isAll = false;
			this.field = field;
		}
		
		@CmdOption(names = {"-n"},args = {"number"},description = "Show number of team data")
		public void setTeamNum(String number) {
			num = Integer.parseInt(number);
		}
		
		@CmdOption(names = {"-high"},description = "Show high team data")
		public void setTeamHigh() {
			isHigh = true;
		}
		
		@CmdOption(names = {"-sort"},args = {"field.sortOrder"},description = "Show sort of team data")
		public void setTeamSort(String s) {
			String[] temp = s.split("\\.");
			field = temp[0];
			order = temp[1];
		}
		
		public String translate(String field) {
			switch (field) {
			case "score":
				field = "scoring";
				break;
			case "point":
				field = "scoring";
				break;
			case "rebound":
				field = "backboard";
				break;
			case "blockShot":
				field = "block";
				break;
			case "fault":
				field = "turnOver";
				break;
			case "shot":
				field = "fieldGoalPercentage";
				break;
			case "three":
				field = "threePointShotPercentage";
				break;
			case "penalty":
				field = "freeThrowPercentage";
				break;
			case "defendRebound":
				field = "defensiveRebound";
				break;
			case "offendRebound":
				field = "offensiveRebound";
				break;
			case "winRate":
				field = "winningPercentage";
				break;
			case "offendEfficient":
				field = "offensiveEfficiency";
				break;
			case "defendEfficient":
				field = "defensiveEfficiency";
				break;
			case "offendReboundEfficient":
				field = "offensivebackboardEfficiency";
				break;
			case "defendReboundEfficient":
				field = "defensivebackboardEfficiency";
				break;
			case "stealEfficient":
				field = "stealEfficiency";
				break;
			case "assistEfficient":
				field = "assistEfficiency";
				break;
			default:
				break;
			}
			return field;
		}
		
		public void print() {
			ArrayList<TeamVO> teamList;
			if (!isHigh) {
				field = field.equals("") ? "score" : field;
			} else {
				field = field.equals("") ? "winRate" : field;
			}
			if (isAvg && isAll && isHigh) {
				teamList = trs.getAllTeamdata(Server.initial_season, translate(field), order);
				if (teamList.size() < num) {
					num = teamList.size();
				}
				for (int i = 0; i < num; i++) {
					TeamHighInfo highInfo = new TeamHighInfo();
					highInfo.setWinRate(teamList.get(i).getWinningPercentage());
					highInfo.setAssistEfficient(teamList.get(i).getAssistEfficiency());
					highInfo.setDefendEfficient(teamList.get(i).getDefensiveEfficiency());
					highInfo.setDefendReboundEfficient(teamList.get(i).getDefensivebackboardEfficiency());
					highInfo.setOffendReboundEfficient(teamList.get(i).getOffensivebackboardEfficiency());
					highInfo.setStealEfficient(teamList.get(i).getStealEfficiency());
					highInfo.setTeamName(teamList.get(i).getTeamName());
					highInfo.setOffendEfficient(teamList.get(i).getOffensiveEfficiency());
					highInfo.setOffendRound(teamList.get(i).getPossessions());
				}
			} else if (isAvg && isAll && !isHigh) {
				teamList = trs.getAllTeamdata(Server.initial_season, translate(field), order);
				if (teamList.size() < num) {
					num = teamList.size();
				}
				for (int i = 0; i < num; i++) {
					TeamNormalInfo normalInfo = new TeamNormalInfo();
					normalInfo.setAssist(teamList.get(i).getAverageAsist());
					normalInfo.setBlockShot(teamList.get(i).getAverageBlock());
					normalInfo.setDefendRebound(teamList.get(i).getAverageDefensiveRebound());
					normalInfo.setFault(teamList.get(i).getAverageTurnOver());
					normalInfo.setFoul(teamList.get(i).getAverageFoul());
					normalInfo.setNumOfGame(teamList.get(i).getMatches());
					normalInfo.setOffendRebound(teamList.get(i).getAverageOffensiveRebound());
					normalInfo.setPenalty(teamList.get(i).getFreeThrowPercentage());
					normalInfo.setPoint(teamList.get(i).getAverageScoring());
					normalInfo.setRebound(teamList.get(i).getAverageBackboard());
					normalInfo.setShot(teamList.get(i).getAverageFieldGoal());
					normalInfo.setSteal(teamList.get(i).getAverageSteal());
					normalInfo.setTeamName(teamList.get(i).getTeamName());
					normalInfo.setThree(teamList.get(i).getAverageThreePointFieldGoal());
				}
			} else if (isAvg && !isAll && isHigh) {
				teamList = trs.getAllTeamdata(Server.initial_season, translate(field), order);
				if (teamList.size() < num) {
					num = teamList.size();
				}
				for (int i = 0; i < num; i++) {
					TeamHighInfo highInfo = new TeamHighInfo();
					highInfo.setWinRate(teamList.get(i).getWinningPercentage());
					highInfo.setAssistEfficient(teamList.get(i).getAssistEfficiency());
					highInfo.setDefendEfficient(teamList.get(i).getDefensiveEfficiency());
					highInfo.setDefendReboundEfficient(teamList.get(i).getDefensivebackboardEfficiency());
					highInfo.setOffendReboundEfficient(teamList.get(i).getOffensivebackboardEfficiency());
					highInfo.setStealEfficient(teamList.get(i).getStealEfficiency());
					highInfo.setTeamName(teamList.get(i).getTeamName());
					highInfo.setOffendEfficient(teamList.get(i).getOffensiveEfficiency());
					highInfo.setOffendRound(teamList.get(i).getPossessions());
				}				
			} else if (!isAvg && isAll && isHigh) {
				teamList = trs.getAllTeamdata(Server.initial_season, translate(field), order);
				if (teamList.size() < num) {
					num = teamList.size();
				}
				for (int i = 0; i < num; i++) {
					TeamHighInfo highInfo = new TeamHighInfo();
					highInfo.setWinRate(teamList.get(i).getWinningPercentage());
					highInfo.setAssistEfficient(teamList.get(i).getAssistEfficiency());
					highInfo.setDefendEfficient(teamList.get(i).getDefensiveEfficiency());
					highInfo.setDefendReboundEfficient(teamList.get(i).getDefensivebackboardEfficiency());
					highInfo.setOffendReboundEfficient(teamList.get(i).getOffensivebackboardEfficiency());
					highInfo.setStealEfficient(teamList.get(i).getStealEfficiency());
					highInfo.setTeamName(teamList.get(i).getTeamName());
					highInfo.setOffendEfficient(teamList.get(i).getOffensiveEfficiency());
					highInfo.setOffendRound(teamList.get(i).getPossessions());
				}
			} else if (isAvg && !isAll && !isHigh) {
				teamList = trs.getAllTeamdata(Server.initial_season, translate(field), order);
				if (teamList.size() < num) {
					num = teamList.size();
				}
				for (int i = 0; i < num; i++) {
					TeamNormalInfo normalInfo = new TeamNormalInfo();
					normalInfo.setAssist(teamList.get(i).getAverageAsist());
					normalInfo.setBlockShot(teamList.get(i).getAverageBlock());
					normalInfo.setDefendRebound(teamList.get(i).getAverageDefensiveRebound());
					normalInfo.setFault(teamList.get(i).getAverageTurnOver());
					normalInfo.setFoul(teamList.get(i).getAverageFoul());
					normalInfo.setNumOfGame(teamList.get(i).getMatches());
					normalInfo.setOffendRebound(teamList.get(i).getAverageOffensiveRebound());
					normalInfo.setPenalty(teamList.get(i).getFreeThrowPercentage());
					normalInfo.setPoint(teamList.get(i).getAverageScoring());
					normalInfo.setRebound(teamList.get(i).getAverageBackboard());
					normalInfo.setShot(teamList.get(i).getAverageFieldGoal());
					normalInfo.setSteal(teamList.get(i).getAverageSteal());
					normalInfo.setTeamName(teamList.get(i).getTeamName());
					normalInfo.setThree(teamList.get(i).getAverageThreePointFieldGoal());
				}
			} else if (!isAvg && isAll && !isHigh) {
				teamList = trs.getAllTeamdata(Server.initial_season, translate(field), order);
				if (teamList.size() < num) {
					num = teamList.size();
				}
				for (int i = 0; i < num; i++) {
					TeamNormalInfo normalInfo = new TeamNormalInfo();
					normalInfo.setAssist(teamList.get(i).getAssist());
					normalInfo.setBlockShot(teamList.get(i).getBlock());
					normalInfo.setDefendRebound(teamList.get(i).getDefensiveRebound());
					normalInfo.setFault(teamList.get(i).getTurnOver());
					normalInfo.setFoul(teamList.get(i).getFoul());
					normalInfo.setNumOfGame(teamList.get(i).getMatches());
					normalInfo.setOffendRebound(teamList.get(i).getOffensiveRebound());
					normalInfo.setPenalty(teamList.get(i).getFreeThrowPercentage());
					normalInfo.setPoint(teamList.get(i).getScoring());
					normalInfo.setRebound(teamList.get(i).getBackboard());
					normalInfo.setShot(teamList.get(i).getFieldGoal());
					normalInfo.setSteal(teamList.get(i).getSteal());
					normalInfo.setTeamName(teamList.get(i).getTeamName());
					normalInfo.setThree(teamList.get(i).getThreePointFieldGoal());
				}
			} else if (!isAvg && !isAll && isHigh) {
				teamList = trs.getAllTeamdata(Server.initial_season, translate(field), order);
				if (teamList.size() < num) {
					num = teamList.size();
				}
				for (int i = 0; i < num; i++) {
					TeamHighInfo highInfo = new TeamHighInfo();
					highInfo.setWinRate(teamList.get(i).getWinningPercentage());
					highInfo.setAssistEfficient(teamList.get(i).getAssistEfficiency());
					highInfo.setDefendEfficient(teamList.get(i).getDefensiveEfficiency());
					highInfo.setDefendReboundEfficient(teamList.get(i).getDefensivebackboardEfficiency());
					highInfo.setOffendReboundEfficient(teamList.get(i).getOffensivebackboardEfficiency());
					highInfo.setStealEfficient(teamList.get(i).getStealEfficiency());
					highInfo.setTeamName(teamList.get(i).getTeamName());
					highInfo.setOffendEfficient(teamList.get(i).getOffensiveEfficiency());
					highInfo.setOffendRound(teamList.get(i).getPossessions());
				}
			} else if (!isAvg && !isAll && !isHigh) {
				teamList = trs.getAllTeamdata(Server.initial_season, translate(field), order);
				if (teamList.size() < num) {
					num = teamList.size();
				}
				for (int i = 0; i < num; i++) {
					TeamNormalInfo normalInfo = new TeamNormalInfo();
					normalInfo.setAssist(teamList.get(i).getAssist());
					normalInfo.setBlockShot(teamList.get(i).getBlock());
					normalInfo.setDefendRebound(teamList.get(i).getDefensiveRebound());
					normalInfo.setFault(teamList.get(i).getTurnOver());
					normalInfo.setFoul(teamList.get(i).getFoul());
					normalInfo.setNumOfGame(teamList.get(i).getMatches());
					normalInfo.setOffendRebound(teamList.get(i).getOffensiveRebound());
					normalInfo.setPenalty(teamList.get(i).getFreeThrowPercentage());
					normalInfo.setPoint(teamList.get(i).getScoring());
					normalInfo.setRebound(teamList.get(i).getBackboard());
					normalInfo.setShot(teamList.get(i).getFieldGoal());
					normalInfo.setSteal(teamList.get(i).getSteal());
					normalInfo.setTeamName(teamList.get(i).getTeamName());
					normalInfo.setThree(teamList.get(i).getThreePointFieldGoal());
				}
			}
		}
		
	}
	
	public void execute(PrintStream out, String[] args) {
		this.out = out;
		CmdlineParser cp;
		switch (args[0]) {
		case "-player":
			PlayerModel p = new PlayerModel();
			cp = new CmdlineParser(p);
			cp.parse(args);
			break;

		case "-team":
			TeamModel t = new TeamModel();
			cp = new CmdlineParser(t);
			cp.parse(args);
			break;
		}
	}
	
	public static void main(String[] args){
		Console console = new Console();
		console.execute(System.out, new String[]{"-player","-king","score","-season","-n","10","-filter","position.F,league.West,age.<=22","-sort","score.desc,foul.asc"});
	}
	
}

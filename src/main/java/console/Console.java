package console;

import java.io.PrintStream;
import java.util.ArrayList;

import test.data.PlayerNormalInfo;
import vo.PlayerVO;
import businesslogic.playerbl.PlayerRank;
import businesslogicservice.playerblservice.PlayerRankService;
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
		@CmdOption(names = {"-avg"},description = "Show average player data")
		public void setAvgPlayer() {
			isAvg = true;
			out.println("Show average player data");
		}
		
		@CmdOption(names = {"-total"},description = "Show total player data")
		public void setTotalPlayer() {
			isAvg = false;
			out.println("Show total player data");
		}
		
		@CmdOption(names = {"-all"},description = "Show all player data")
		public void setAllPlayer() {
			term = "all";
			out.println("Show all player data");
		}
		
		@CmdOption(names = {"-hot"},args = { "filed" },description = "Show hot player ")
		public void setHotPlayer(String field) {
			term = "hot";
			this.field = field;
			out.println("Show hot player:"+this.field );
		}
		
		
		@CmdOption(names = {"-king"},args = {"field"},description = "Show king player ")
		public void setKingPlayer(String field) {
			term = "king";
			this.field = field;
			out.println("Show king player:"+ this.field);
		}

		@CmdOption(names = {"-season"},description = "Show season king player data",maxCount = 1,minCount = 0,requires = {"-king"},conflictsWith = {"-daily"})
		public void setKingSeasonPlayer() {
			isSeason = true;
			out.println("Show season king player data");
		}
		
		@CmdOption(names = {"-daily"},description = "Show daily king player data",maxCount = 1,minCount = 0,requires = {"-king"},conflictsWith = {"-season"})
		public void setKingDailyPlayer() {
			isSeason = false;
			out.println("Show daily king player data");
		}
		
		@CmdOption(names = { "-n" }, args = { "filed" }, maxCount = 1, minCount = 0)
		public void setNum(String filed) {
			this.num = Integer.parseInt(filed);
			System.out.println(this.num);
		}
		
		@CmdOption(names = { "-high" })
		public void setHigh() {
			this.isHigh = true;
			System.out.println("isHigh:"+this.isHigh);
		}
		
	
	  	@CmdOption(names = {"-filter"},args = {"field"},description = "filter filed", maxCount = 1, minCount = 0)
		public void setField(String field) {
	  		String[] temps = field.split(",");
	  		for(int i=0;i<temps.length;i++){
	  			filter.add(temps[i]);
			    String[] temp = temps[i].split("\\.");
			    out.println(temp[0]+":"+temp[1]);
	  		}
		}	

	   @CmdOption(names = {"-sort"},args = {"field"},description = "set sort", maxCount = 1, minCount = 0)
		public void setSortAsc(String field) {
	  		String[] temps = field.split(",");
	  		for(int i=0;i<temps.length;i++){
	  			sort.add(temps[i]);
			    String[] temp = temps[i].split("\\.");
			    out.println(temp[0]+":"+temp[1]);
	  		}
		}
		
	
		public void print(){
			if(isAvg){
				if(term.equals("all")){
					ArrayList<PlayerVO> players = prs.getAllPlayerdata("13-14", "scoring", "DESC");
		//		PlayerNormalInfo player = new PlayerNormalInfo();
				
				}
				else if(term.equals("hot")){
					ArrayList<PlayerVO> players = prs.getMostImporvedPlayer("13-14", field);
				}
				else if(term.equals("king")){
					
				}
			}
			else{
				
			}
			out.println("result");
		}
	}
	
	@CmdCommand(names = {"-team"},description = "Show team data")
	public class TeamModel {

		boolean isAvg = true;
		boolean isAll = true;
		int num = 30;
		boolean isHigh = false;
		String field;
		String order;
		
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
		
		public void print() {
			if (isAvg && isAll && isHigh) {

			} else if (isAvg && isAll && !isHigh) {
				
			} else if (isAvg && !isAll && isHigh) {
				
			} else if (!isAvg && isAll && isHigh) {
				
			} else if (isAvg && !isAll && !isHigh) {
		
			} else if (!isAvg && isAll && !isHigh) {
		
			} else if (!isAvg && !isAll && isHigh) {
		
			} else if (!isAvg && !isAll && !isHigh) {
		
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

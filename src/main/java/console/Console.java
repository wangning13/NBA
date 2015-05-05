package console;

import java.io.PrintStream;

import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;

public class Console {
	PrintStream out;

	@CmdCommand(names = {"-player"},description = "Show player data")
	public class PlayerModel {
		boolean isAvg = true;
		boolean isSeason = true;
		boolean isHigh = false;
		String term = "all";
		String field;
		int num = 50;
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
		
	/*	@CmdOption(names = {"score"},description = "Show score player ")
		public void setScorePlayer() {
			field = "score";
			out.println("Show score player ");
		}
		
		@CmdOption(names = {"rebound"},description = "Show rebound player ")
		public void setReboundPlayer() {
			field = "rebound";
			out.println("Show Rebound player ");
		}
		
		@CmdOption(names = {"assist"},description = "Show assist player ")
		public void setAssistPlayer() {
			field = "assist";
			out.println("Show assist player ");
		}
*/
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
		
	/*过滤功能
	 * 	@CmdOption(names = {"-filter"},args = {"field"},description = "filter filed")
		public void setField(String field) {
			String[] temp = field.split(".");
			out.println(temp[0]+":"+temp[1]);
		}
		*/
	/*	排序
	 * 
	 * @CmdOption(names = {"-sort field.asc"},description = "setAsc")
		public void setSortAsc() {
			out.println("setAsc");
		}
		
		@CmdOption(names = {"-sort field.desc"},description = "setDesc")
		public void setSortDesc() {
			out.println("setDesc");
		}
		*/
	
		public void print(){
			if(isAvg){
				
			}
			else{
				
			}
			out.println("result");
		}
	}
	
	@CmdCommand(names = {"-team"},description = "Show team data")
	public class TeamModel {
		
		
		
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
		console.execute(System.out, new String[]{"-player","-avg","-king","score","-season","-n","10"});
	}
	
}

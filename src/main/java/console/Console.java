package console;

import java.io.PrintStream;

import businesslogic.playerbl.PlayerRank;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;

public class Console {
	
	public static PrintStream out;

	@CmdCommand(names = {"-player"},description = "Show player data")
	public class PlayerModel {
		
		@CmdOption(names = {"-king"},args = {"score","season"},description = "Show season player king")
		public void setSeasonPlayerKing(String score,String season) {
			PlayerRank p = new PlayerRank();
			p.getSeasonTop(season, score);
			out.print("lll");
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
		console.execute(System.out, new String[]{"-player","-king","score","-season"});
	}
	
}

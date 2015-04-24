package businesslogic.teambl;

import java.text.DecimalFormat;

import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamVO;

public class GetTeamVO {
	DecimalFormat df1=new DecimalFormat("#.0");
	DecimalFormat df2=new DecimalFormat("#.00");
	DecimalFormat df3=new DecimalFormat("#.000");
	public TeamVO GetTeamVO(TeamPO teamPO){
		TeamVO teamVO = new TeamVO(0,
				teamPO.getOpponentFieldGoal(),
				teamPO.getOpponentFieldGoalAttempts(),
				teamPO.getOpponentTurnOver(),
				teamPO.getOpponentFreeThrowAttempts(),
				teamPO.getOppenentScoring(),
				teamPO.getTeamName(),
				teamPO.getMatches(),
				teamPO.getWins(),
				teamPO.getFieldGoal(),
				Double.parseDouble(df1.format(((double)teamPO.getFieldGoal())/teamPO.getMatches())),
				teamPO.getFieldGoalAttempts(),
				Double.parseDouble(df1.format(((double)teamPO.getFieldGoalAttempts())/teamPO.getMatches())),
				teamPO.getThreePointFieldGoal(),
				Double.parseDouble(df1.format(((double)teamPO.getThreePointFieldGoal())/teamPO.getMatches())),
				teamPO.getThreePointFieldGoalAttempts(),
				Double.parseDouble(df1.format(((double)teamPO.getThreePointFieldGoalAttempts())/teamPO.getMatches())),
				teamPO.getFreeThrow(),
				Double.parseDouble(df1.format(((double)teamPO.getFreeThrow())/teamPO.getMatches())),
				teamPO.getFreeThrowAttempts(),
				Double.parseDouble(df1.format(((double)teamPO.getFreeThrowAttempts())/teamPO.getMatches())),
				teamPO.getOffensiveRebound(),
				Double.parseDouble(df1.format(((double)teamPO.getOffensiveRebound())/teamPO.getMatches())),
				teamPO.getDefensiveRebound(),
				Double.parseDouble(df1.format(((double)teamPO.getDefensiveRebound())/teamPO.getMatches())),
				teamPO.getOpponentOffensiveRebound(),
				Double.parseDouble(df1.format(((double)teamPO.getOpponentOffensiveRebound())/teamPO.getMatches())),
				teamPO.getOpponentDefensiveRebound(),
				Double.parseDouble(df1.format(((double)teamPO.getOpponentDefensiveRebound())/teamPO.getMatches())),
				teamPO.getBackboard(),
				Double.parseDouble(df1.format(((double)teamPO.getBackboard())/teamPO.getMatches())),
				teamPO.getAssist(),
				Double.parseDouble(df1.format(((double)teamPO.getAssist())/teamPO.getMatches())),
				teamPO.getSteal(),
				Double.parseDouble(df1.format(((double)teamPO.getSteal())/teamPO.getMatches())),
				teamPO.getBlock(),
				Double.parseDouble(df1.format(((double)teamPO.getBlock())/teamPO.getMatches())),
				teamPO.getTurnOver(),
				Double.parseDouble(df1.format(((double)teamPO.getTurnOver())/teamPO.getMatches())),
				teamPO.getFoul(),
				Double.parseDouble(df1.format(((double)teamPO.getFoul())/teamPO.getMatches())),
				teamPO.getScoring(),
				Double.parseDouble(df1.format(((double)teamPO.getScoring())/teamPO.getMatches())),
				Double.parseDouble(df3.format(teamPO.getFieldGoalPercentage())),
				Double.parseDouble(df3.format(teamPO.getThreePointShotPercentage())),
				Double.parseDouble(df3.format(teamPO.getFreeThrowPercentage())),
				Double.parseDouble(df3.format(teamPO.getWinningPercentage())),
				Double.parseDouble(df1.format(teamPO.getPossessions())),
				Double.parseDouble(df1.format(teamPO.getOffensiveEfficiency())),
				Double.parseDouble(df1.format(teamPO.getDefensiveEfficiency())),
				Double.parseDouble(df1.format(teamPO.getOffensivebackboardEfficiency())),
				Double.parseDouble(df1.format(teamPO.getDefensivebackboardEfficiency())),
				Double.parseDouble(df1.format(teamPO.getStealEfficiency())),
				Double.parseDouble(df1.format(teamPO.getAssistEfficiency())));
		return teamVO;
	}

}

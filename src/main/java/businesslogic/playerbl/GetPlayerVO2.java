package businesslogic.playerbl;

import java.text.DecimalFormat;

import po.PlayerPO;
import vo.PlayerVO;

public class GetPlayerVO2 {
	DecimalFormat df = new DecimalFormat("#.0000");

	public PlayerVO getPlayerVO2(PlayerPO playerPO) {
		PlayerVO playerVO = new PlayerVO();
		if (playerPO.getAppearance() == 0) {
			playerVO = new PlayerVO(
					playerPO.getPlayerName(),
					playerPO.getTeam(),
					playerPO.getAppearance(),
					playerPO.getFirstPlay(),
					playerPO.getBackboard(),
					0,
					playerPO.getAssist(),
					0,
					Double.parseDouble(df.format(playerPO.getMinutes())),
					0,
					playerPO.getFieldGoal(),
					0,
					playerPO.getFieldGoalAttempts(),
					0,
					playerPO.getThreePointFieldGoal(),
					0,
					playerPO.getThreePointFieldGoalAttempts(),
					0,
					playerPO.getFreeThrow(),
					0,
					playerPO.getFreeThrowAttempts(),
					0,
					playerPO.getOffensiveRebound(),
					0,
					playerPO.getDefensiveRebound(),
					0,
					playerPO.getSteal(),
					0,
					playerPO.getBlock(),
					0,
					playerPO.getTurnOver(),
					0,
					playerPO.getFoul(),
					0,
					playerPO.getScoring(),
					0,
					playerPO.getTeamFieldGoalAttempts(),
					playerPO.getTeamBackboard(),
					playerPO.getTeamFieldGoal(),
					playerPO.getTeamFreeThrow(),
					playerPO.getTeamOffensiveRebound(),
					playerPO.getTeamDefensiveRebound(),
					Double.parseDouble(df.format(playerPO.getTeamMinutes())),
					playerPO.getTeamFreeThrowAttempts(),
					playerPO.getTeamTurnOver(),
					playerPO.getOpponentBackBoard(),
					playerPO.getOpponentOffensiveRebound(),
					playerPO.getOpponentDefensiveRebound(),
					playerPO.getOpponentFieldGoalAttempts(),
					playerPO.getOpponentThreePointFieldGoalAttempts(),
					Double.parseDouble(df.format(playerPO
							.getFieldGoalShotPercentage())),
					Double.parseDouble(df.format(playerPO
							.getThreePointShotPercentage())),
					Double.parseDouble(df.format(playerPO
							.getFreeThrowPercentage())),
					Double.parseDouble(df.format(playerPO.getEfficiency())),
					Double.parseDouble(df.format(playerPO.getGmScEfficiency())),
					Double.parseDouble(df.format(playerPO
							.getNearlyFivePercentage())), Double.parseDouble(df
							.format(playerPO.getTrueShootingPercentage())),
					Double.parseDouble(df.format(playerPO
							.getShootingEfficiency())), Double.parseDouble(df
							.format(playerPO.getBackboardPercentage())), Double
							.parseDouble(df.format(playerPO
									.getOffensiveReboundPercentage())), Double
							.parseDouble(df.format(playerPO
									.getDefensiveReboundPercentage())), Double
							.parseDouble(df.format(playerPO
									.getAssistPercentage())), Double
							.parseDouble(df.format(playerPO
									.getStealPercentage())), Double
							.parseDouble(df.format(playerPO
									.getBlockPercentage())), Double
							.parseDouble(df.format(playerPO
									.getTurnOverPercentage())), Double
							.parseDouble(df.format(playerPO.getUsage())),
					Double.parseDouble(df.format(playerPO
							.getPreviousAverageScoring())), Double
							.parseDouble(df.format(playerPO
									.getNearlyFiveAverageScoring())), playerPO
							.getDoubleDouble(), Double
							.parseDouble(df.format(playerPO
									.getNearlyFiveBackboardPercentage())),
					Double.parseDouble(df.format(playerPO
							.getNearlyFiveAssistPercentage())), Double
							.parseDouble(df.format(playerPO
									.getPreviousAverageBackboard())), Double
							.parseDouble(df.format(playerPO
									.getNearlyFiveAverageBackboard())), Double
							.parseDouble(df.format(playerPO
									.getPreviousAverageAssist())), Double
							.parseDouble(df.format(playerPO
									.getNearlyFiveAverageAssist())));
		} else {
			playerVO = new PlayerVO(
					playerPO.getPlayerName(),
					playerPO.getTeam(),
					playerPO.getAppearance(),
					playerPO.getFirstPlay(),
					playerPO.getBackboard() * playerPO.getAppearance(),
					playerPO.getBackboard(),
					playerPO.getAssist() * playerPO.getAppearance(),
					playerPO.getAssist(),
					Double.parseDouble(df.format(playerPO.getMinutes()
							* playerPO.getAppearance())),
					Double.parseDouble(df.format(playerPO.getMinutes())),
					playerPO.getFieldGoal() * playerPO.getAppearance(),
					playerPO.getFieldGoal(),
					playerPO.getFieldGoalAttempts() * playerPO.getAppearance(),
					playerPO.getFieldGoalAttempts(),
					playerPO.getThreePointFieldGoal()
							* playerPO.getAppearance(),
					playerPO.getThreePointFieldGoal(),
					playerPO.getThreePointFieldGoalAttempts()
							* playerPO.getAppearance(),
					playerPO.getThreePointFieldGoalAttempts(),
					playerPO.getFreeThrow() * playerPO.getAppearance(),
					playerPO.getFreeThrow(),
					playerPO.getFreeThrowAttempts() * playerPO.getAppearance(),
					playerPO.getFreeThrowAttempts(),
					playerPO.getOffensiveRebound() * playerPO.getAppearance(),
					playerPO.getOffensiveRebound(),
					playerPO.getDefensiveRebound() * playerPO.getAppearance(),
					playerPO.getDefensiveRebound(),
					playerPO.getSteal() * playerPO.getAppearance(),
					playerPO.getSteal(),
					playerPO.getBlock() * playerPO.getAppearance(),
					playerPO.getBlock(),
					playerPO.getTurnOver() * playerPO.getAppearance(),
					playerPO.getTurnOver(),
					playerPO.getFoul() * playerPO.getAppearance(),
					playerPO.getFoul(),
					playerPO.getScoring() * playerPO.getAppearance(),
					playerPO.getScoring(),
					playerPO.getTeamFieldGoalAttempts()
							* playerPO.getAppearance(),
					playerPO.getTeamBackboard(),
					playerPO.getTeamFieldGoal() * playerPO.getAppearance(),
					playerPO.getTeamFreeThrow(),
					playerPO.getTeamOffensiveRebound()
							* playerPO.getAppearance(),
					playerPO.getTeamDefensiveRebound(),
					Double.parseDouble(df.format(playerPO.getTeamMinutes())),
					playerPO.getTeamFreeThrowAttempts(),
					playerPO.getTeamTurnOver(),
					playerPO.getOpponentBackBoard(),
					playerPO.getOpponentOffensiveRebound(),
					playerPO.getOpponentDefensiveRebound(),
					playerPO.getOpponentFieldGoalAttempts(),
					playerPO.getOpponentThreePointFieldGoalAttempts(),
					Double.parseDouble(df.format(playerPO
							.getFieldGoalShotPercentage())),
					Double.parseDouble(df.format(playerPO
							.getThreePointShotPercentage())),
					Double.parseDouble(df.format(playerPO
							.getFreeThrowPercentage())),
					Double.parseDouble(df.format(playerPO.getEfficiency())),
					Double.parseDouble(df.format(playerPO.getGmScEfficiency())),
					Double.parseDouble(df.format(playerPO
							.getNearlyFivePercentage())), Double.parseDouble(df
							.format(playerPO.getTrueShootingPercentage())),
					Double.parseDouble(df.format(playerPO
							.getShootingEfficiency())), Double.parseDouble(df
							.format(playerPO.getBackboardPercentage())), Double
							.parseDouble(df.format(playerPO
									.getOffensiveReboundPercentage())), Double
							.parseDouble(df.format(playerPO
									.getDefensiveReboundPercentage())), Double
							.parseDouble(df.format(playerPO
									.getAssistPercentage())), Double
							.parseDouble(df.format(playerPO
									.getStealPercentage())), Double
							.parseDouble(df.format(playerPO
									.getBlockPercentage())), Double
							.parseDouble(df.format(playerPO
									.getTurnOverPercentage())), Double
							.parseDouble(df.format(playerPO.getUsage())),
					Double.parseDouble(df.format(playerPO
							.getPreviousAverageScoring())), Double
							.parseDouble(df.format(playerPO
									.getNearlyFiveAverageScoring())), playerPO
							.getDoubleDouble(), Double
							.parseDouble(df.format(playerPO
									.getNearlyFiveBackboardPercentage())),
					Double.parseDouble(df.format(playerPO
							.getNearlyFiveAssistPercentage())), Double
							.parseDouble(df.format(playerPO
									.getPreviousAverageBackboard())), Double
							.parseDouble(df.format(playerPO
									.getNearlyFiveAverageBackboard())), Double
							.parseDouble(df.format(playerPO
									.getPreviousAverageAssist())), Double
							.parseDouble(df.format(playerPO
									.getNearlyFiveAverageAssist())));
		}
		return playerVO;
	}

}

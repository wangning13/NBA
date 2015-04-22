package businesslogic.playerbl;

import java.text.DecimalFormat;

import po.PlayerPO;
import po.PlayerinfoPO;
import vo.PlayerVO;

public class GetPlayerVO {
	DecimalFormat df = new DecimalFormat("#.0000");

	public PlayerVO getPlayerVO(PlayerPO playerPO) {
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
					playerPO.getBackboard(),
					Double.parseDouble(df.format(((double) playerPO
							.getBackboard()) / playerPO.getAppearance())),
					playerPO.getAssist(),
					Double.parseDouble(df.format(((double) playerPO.getAssist() / playerPO
							.getAppearance()))),
					Double.parseDouble(df.format(playerPO.getMinutes())),
					Double.parseDouble(df.format(((double) playerPO
							.getMinutes() / playerPO.getAppearance()))),
					playerPO.getFieldGoal(),
					Double.parseDouble(df.format(((double) playerPO
							.getFieldGoal() / playerPO.getAppearance()))),
					playerPO.getFieldGoalAttempts(),
					Double.parseDouble(df.format(((double) playerPO
							.getFieldGoalAttempts() / playerPO.getAppearance()))),
					playerPO.getThreePointFieldGoal(),
					Double.parseDouble(df.format(((double) playerPO
							.getThreePointFieldGoal() / playerPO
							.getAppearance()))),
					playerPO.getThreePointFieldGoalAttempts(),
					Double.parseDouble(df.format(((double) playerPO
							.getThreePointFieldGoalAttempts() / playerPO
							.getAppearance()))),
					playerPO.getFreeThrow(),
					Double.parseDouble(df.format(((double) playerPO
							.getFreeThrow() / playerPO.getAppearance()))),
					playerPO.getFreeThrowAttempts(),
					Double.parseDouble(df.format(((double) playerPO
							.getFreeThrowAttempts() / playerPO.getAppearance()))),
					playerPO.getOffensiveRebound(),
					Double.parseDouble(df.format(((double) playerPO
							.getOffensiveRebound() / playerPO.getAppearance()))),
					playerPO.getDefensiveRebound(),
					Double.parseDouble(df.format(((double) playerPO
							.getDefensiveRebound() / playerPO.getAppearance()))),
					playerPO.getSteal(),
					Double.parseDouble(df.format(((double) playerPO.getSteal() / playerPO
							.getAppearance()))),
					playerPO.getBlock(),
					Double.parseDouble(df.format(((double) playerPO.getBlock() / playerPO
							.getAppearance()))),
					playerPO.getTurnOver(),
					Double.parseDouble(df.format(((double) playerPO
							.getTurnOver() / playerPO.getAppearance()))),
					playerPO.getFoul(),
					Double.parseDouble(df.format(((double) playerPO.getFoul() / playerPO
							.getAppearance()))),
					playerPO.getScoring(),
					Double.parseDouble(df.format(((double) playerPO
							.getScoring() / playerPO.getAppearance()))),
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
		}
		return playerVO;
	}

}

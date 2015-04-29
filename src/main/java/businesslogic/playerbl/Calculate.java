package businesslogic.playerbl;

import java.text.DecimalFormat;

import po.PlayerPO;

public class Calculate {
	DecimalFormat df1=new DecimalFormat("#.0");
	DecimalFormat df2=new DecimalFormat("#.00");
	DecimalFormat df3=new DecimalFormat("#.000");
	
	public PlayerPO Calculate(PlayerPO playerPO){
		
		if (playerPO.getFieldGoalAttempts()==0) {
			playerPO.setFieldGoalShotPercentage(0);
		}else {
			playerPO.setFieldGoalShotPercentage(Double.parseDouble(df3.format((double)playerPO.getFieldGoal()/playerPO.getFieldGoalAttempts())));
		}
		if (playerPO.getThreePointFieldGoalAttempts()==0) {
			playerPO.setThreePointShotPercentage(0);
		}else {
			playerPO.setThreePointShotPercentage(Double.parseDouble(df3.format(((double)playerPO.getThreePointFieldGoal())/playerPO.getThreePointFieldGoalAttempts())));

		}
		if (playerPO.getFreeThrowAttempts()==0) {
			playerPO.setFreeThrowPercentage(0);
		}else {
			playerPO.setFreeThrowPercentage(Double.parseDouble(df3.format(((double)playerPO.getFreeThrow())/playerPO.getFreeThrowAttempts())));

		}
		if (playerPO.getAppearance()==0) {
			playerPO.setEfficiency(0);
			playerPO.setGmScEfficiency(0);
		}else {
			playerPO.setEfficiency(Double.parseDouble(df3.format((double)(playerPO.getScoring()/playerPO.getAppearance()+(double)playerPO.getBackboard()/playerPO.getAppearance()+(double)playerPO.getAssist()/playerPO.getAppearance()+(double)playerPO.getSteal()/playerPO.getAppearance()+(double)playerPO.getBlock()/playerPO.getAppearance())-((double)playerPO.getFieldGoalAttempts()/playerPO.getAppearance()-(double)playerPO.getFieldGoal()/playerPO.getAppearance())-((double)playerPO.getFreeThrowAttempts()/playerPO.getAppearance()-(double)playerPO.getFreeThrow()/playerPO.getAppearance())-(double)playerPO.getTurnOver()/playerPO.getAppearance())));
			playerPO.setGmScEfficiency(Double.parseDouble(df3.format((double)playerPO.getScoring()/playerPO.getAppearance()+0.4*(double)playerPO.getFieldGoal()/playerPO.getAppearance()-0.7*(double)playerPO.getFieldGoalAttempts()/playerPO.getAppearance()-0.4*((double)playerPO.getFreeThrowAttempts()/playerPO.getAppearance()-(double)playerPO.getFreeThrow()/playerPO.getAppearance())+0.7*(double)playerPO.getOffensiveRebound()/playerPO.getAppearance()+0.3*(double)playerPO.getDefensiveRebound()/playerPO.getAppearance()+(double)playerPO.getSteal()/playerPO.getAppearance()+0.7*(double)playerPO.getAssist()/playerPO.getAppearance()+0.7*(double)playerPO.getBlock()/playerPO.getAppearance()-0.4*(double)playerPO.getFoul()/playerPO.getAppearance()-(double)playerPO.getTurnOver()/playerPO.getAppearance())));
		}
		
		if (playerPO.getPreviousAverageScoring()==0) {
			playerPO.setNearlyFivePercentage(0);
		}else {
			playerPO.setNearlyFivePercentage(Double.parseDouble(df3.format((playerPO.getNearlyFiveAverageScoring()-playerPO.getPreviousAverageScoring())/playerPO.getPreviousAverageScoring())));

		}
		if ((2*(playerPO.getFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()))==0) {
			playerPO.setTrueShootingPercentage(0);
		}else {
			playerPO.setTrueShootingPercentage(Double.parseDouble(df3.format(playerPO.getScoring()/(2*(playerPO.getFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts())))));
		}
		if (playerPO.getFieldGoalAttempts()==0) {
			playerPO.setShootingEfficiency(0);
		}else {
			playerPO.setShootingEfficiency(Double.parseDouble(df3.format((((double)playerPO.getFieldGoal()+0.5*playerPO.getThreePointFieldGoal())/playerPO.getFieldGoalAttempts()))));
		}
		if (playerPO.getMinutes()==0) {
			playerPO.setBackboardPercentage(0);
			playerPO.setOffensiveReboundPercentage(0);
			playerPO.setDefensiveReboundPercentage(0);
			playerPO.setAssistPercentage(0);
			playerPO.setStealPercentage(0);
			playerPO.setBlockPercentage(0);
		}else {
			if (playerPO.getTeamBackboard()+playerPO.getOpponentBackBoard()==0) {
				playerPO.setBackboardPercentage(0);
			}
			else {
				playerPO.setBackboardPercentage(Double.parseDouble(df3.format(playerPO.getBackboard()*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/(playerPO.getTeamBackboard()+playerPO.getOpponentBackBoard()))));
			}
			if (playerPO.getTeamOffensiveRebound()+playerPO.getOpponentOffensiveRebound()==0) {
				playerPO.setOffensiveReboundPercentage(0);
			}else {
				playerPO.setOffensiveReboundPercentage(Double.parseDouble(df3.format(playerPO.getOffensiveRebound()*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/(playerPO.getTeamOffensiveRebound()+playerPO.getOpponentOffensiveRebound()))));
			}
			if (playerPO.getTeamDefensiveRebound()+playerPO.getOpponentDefensiveRebound()==0) {
				playerPO.setDefensiveReboundPercentage(0);
			}else {
				playerPO.setDefensiveReboundPercentage(Double.parseDouble(df3.format(playerPO.getDefensiveRebound()*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/(playerPO.getTeamDefensiveRebound()+playerPO.getOpponentDefensiveRebound()))));
			}
			if (playerPO.getMinutes()==0 || playerPO.getTeamMinutes()==0) {
				playerPO.setAssistPercentage(0);
			}else {
				playerPO.setAssistPercentage(Double.parseDouble(df3.format(playerPO.getAssist()/(playerPO.getMinutes()/(playerPO.getTeamMinutes()/5)*(playerPO.getTeamFieldGoal()+playerPO.getTeamFreeThrow()-playerPO.getFieldGoal()-playerPO.getFreeThrow())))));
			}
			if (playerPO.getTeamMinutes()==0||playerPO.getOpponentOffensiveRebound()==0) {
				playerPO.setStealPercentage(0);
			}else {
				playerPO.setStealPercentage(Double.parseDouble(df3.format(playerPO.getSteal()*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/playerPO.getOpponentOffensiveRebound())));
			}
			if (playerPO.getTeamMinutes()==0||playerPO.getOpponentFieldGoalAttempts()-playerPO.getOpponentThreePointFieldGoalAttempts()==0) {
				playerPO.setBlockPercentage(0);
			}else {
				playerPO.setBlockPercentage(Double.parseDouble(df3.format(((double)playerPO.getBlock()*(playerPO.getTeamMinutes())/5)/playerPO.getMinutes()/(playerPO.getOpponentFieldGoalAttempts()-playerPO.getOpponentThreePointFieldGoalAttempts()))));
			}
		}
		if ((playerPO.getFieldGoalAttempts()-playerPO.getThreePointFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver())==0) {
			playerPO.setTurnOverPercentage(0);
		}else {
			
			playerPO.setTurnOverPercentage(Double.parseDouble(df3.format(playerPO.getTurnOver()/(playerPO.getFieldGoalAttempts()+playerPO.getThreePointFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver()))));

		}
		if (playerPO.getMinutes()==0||(playerPO.getTeamFieldGoalAttempts()+0.44*playerPO.getTeamFreeThrowAttempts()+playerPO.getTeamTurnOver())==0) {
			playerPO.setUsage(0);
			
		}else {
			playerPO.setUsage(Double.parseDouble(df3.format((playerPO.getFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver())*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/(playerPO.getTeamFieldGoalAttempts()+0.44*playerPO.getTeamFreeThrowAttempts()+playerPO.getTeamTurnOver()))));

		}
		if (playerPO.getPreviousAverageBackboard()==0) {
			playerPO.setNearlyFiveBackboardPercentage(0);
		}else {
			playerPO.setNearlyFiveBackboardPercentage(Double.parseDouble(df3.format((playerPO.getNearlyFiveAverageBackboard()-playerPO.getPreviousAverageBackboard())/playerPO.getPreviousAverageBackboard())));

		}
		if (playerPO.getPreviousAverageAssist()==0) {
			playerPO.setNearlyFiveAssistPercentage(0);
		}else {
			playerPO.setNearlyFiveAssistPercentage(Double.parseDouble(df3.format((playerPO.getNearlyFiveAverageAssist()-playerPO.getPreviousAverageAssist())/playerPO.getPreviousAverageAssist())));

		}
		return playerPO;
	}

}

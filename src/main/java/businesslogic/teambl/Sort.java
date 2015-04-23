package businesslogic.teambl;

import java.util.ArrayList;

import po.TeamPO;

public class Sort {
	public ArrayList<TeamPO> Sort(ArrayList<TeamPO> teamPOs,String key,String order) {
		
		switch (key) {
		case "winningPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getWinningPercentage()<=teamPOs.get(j+1).getWinningPercentage()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getWinningPercentage()>teamPOs.get(j+1).getWinningPercentage()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "teamName":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getTeamName().compareTo(teamPOs.get(j+1).getTeamName())<=0) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getTeamName().compareTo(teamPOs.get(j+1).getTeamName())>0) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "matches":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getMatches()<=teamPOs.get(j+1).getMatches()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getMatches()>teamPOs.get(j+1).getMatches()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "fieldGoal":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFieldGoal()<=teamPOs.get(j+1).getFieldGoal()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFieldGoal()>teamPOs.get(j+1).getFieldGoal()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "fieldGoalAttempts":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFieldGoalAttempts()<=teamPOs.get(j+1).getFieldGoalAttempts()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFieldGoalAttempts()>teamPOs.get(j+1).getFieldGoalAttempts()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "threePointFieldGoal":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getThreePointFieldGoal()<=teamPOs.get(j+1).getThreePointFieldGoal()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getThreePointFieldGoal()>teamPOs.get(j+1).getThreePointFieldGoal()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "threePointFieldGoalAttempts":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getThreePointFieldGoalAttempts()<=teamPOs.get(j+1).getThreePointFieldGoalAttempts()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getThreePointFieldGoalAttempts()>teamPOs.get(j+1).getThreePointFieldGoalAttempts()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "freeThrow":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFreeThrow()<=teamPOs.get(j+1).getFreeThrow()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFreeThrow()>teamPOs.get(j+1).getFreeThrow()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "freeThrowAttempts":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFreeThrowAttempts()<=teamPOs.get(j+1).getFreeThrowAttempts()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFreeThrowAttempts()>teamPOs.get(j+1).getFreeThrowAttempts()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "offensiveRebound":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getOffensiveRebound()<=teamPOs.get(j+1).getOffensiveRebound()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getOffensiveRebound()>teamPOs.get(j+1).getOffensiveRebound()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "defensiveRebound":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getDefensiveRebound()<=teamPOs.get(j+1).getDefensiveRebound()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getDefensiveRebound()>teamPOs.get(j+1).getDefensiveRebound()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "backboard":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getBackboard()<=teamPOs.get(j+1).getBackboard()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getBackboard()>teamPOs.get(j+1).getBackboard()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "assist":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getAssist()<=teamPOs.get(j+1).getAssist()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getAssist()>teamPOs.get(j+1).getAssist()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "steal":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getSteal()<=teamPOs.get(j+1).getSteal()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getSteal()>teamPOs.get(j+1).getSteal()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "block":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getBlock()<=teamPOs.get(j+1).getBlock()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getBlock()>teamPOs.get(j+1).getBlock()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "turnOver":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getTurnOver()<=teamPOs.get(j+1).getTurnOver()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getTurnOver()>teamPOs.get(j+1).getTurnOver()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "foul":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFoul()<=teamPOs.get(j+1).getFoul()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFoul()>teamPOs.get(j+1).getFoul()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "scoring":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getScoring()<=teamPOs.get(j+1).getScoring()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getScoring()>teamPOs.get(j+1).getScoring()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "fieldGoalShotPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFieldGoalPercentage()<=teamPOs.get(j+1).getFieldGoalPercentage()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFieldGoalPercentage()>teamPOs.get(j+1).getFieldGoalPercentage()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "threePointShotPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getThreePointShotPercentage()<=teamPOs.get(j+1).getThreePointShotPercentage()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getThreePointShotPercentage()>teamPOs.get(j+1).getThreePointShotPercentage()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "freeThrowPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFreeThrowPercentage()<=teamPOs.get(j+1).getFreeThrowPercentage()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getFreeThrowPercentage()>teamPOs.get(j+1).getFreeThrowPercentage()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "possessions":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getPossessions()<=teamPOs.get(j+1).getPossessions()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getPossessions()>teamPOs.get(j+1).getPossessions()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "offensiveEfficiency":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getOffensiveEfficiency()<=teamPOs.get(j+1).getOffensiveEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getOffensiveEfficiency()>teamPOs.get(j+1).getOffensiveEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "defensiveEfficiency":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getDefensiveEfficiency()<=teamPOs.get(j+1).getDefensiveEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getDefensiveEfficiency()>teamPOs.get(j+1).getDefensiveEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "offensivebackboardEfficiency":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getOffensivebackboardEfficiency()<=teamPOs.get(j+1).getOffensivebackboardEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getOffensivebackboardEfficiency()>teamPOs.get(j+1).getOffensivebackboardEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "defensivebackboardEfficiency":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getDefensivebackboardEfficiency()<=teamPOs.get(j+1).getDefensivebackboardEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getDefensivebackboardEfficiency()>teamPOs.get(j+1).getDefensivebackboardEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;	
		case "stealEfficiency":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getStealEfficiency()<=teamPOs.get(j+1).getStealEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getStealEfficiency()>teamPOs.get(j+1).getStealEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;	
		case "assistEfficiency":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getAssistEfficiency()<=teamPOs.get(j+1).getAssistEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getAssistEfficiency()>teamPOs.get(j+1).getAssistEfficiency()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;	
		case "wins":
			if (order.equals("DESC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getWins()<=teamPOs.get(j+1).getWins()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < teamPOs.size()-1; i++) {
					for (int j = 0; j < teamPOs.size()-i-1; j++) {
						if (teamPOs.get(j).getWins()>teamPOs.get(j+1).getWins()) {
							TeamPO temp = teamPOs.get(j);
							teamPOs.set(j, teamPOs.get(j+1));
							teamPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		default:
			System.err.println("You input error in team!");
			break;
		}
		
		return teamPOs;
	}

}

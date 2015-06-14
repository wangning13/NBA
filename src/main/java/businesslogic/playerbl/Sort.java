package businesslogic.playerbl;

import java.util.ArrayList;

import po.PlayerPO;

public class Sort {
	
	public ArrayList<PlayerPO> Sort(ArrayList<PlayerPO> playerPOs,String condition,String order) {
		String key = condition;
		switch (key) {
		case "scoring":
			
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getScoring()<=playerPOs.get(j+1).getScoring()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getScoring()>playerPOs.get(j+1).getScoring()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			
			break;
		case "playerName":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getPlayerName().compareTo(playerPOs.get(j+1).getPlayerName())<=0) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getPlayerName().compareTo(playerPOs.get(j+1).getPlayerName())>0) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "team":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getTeam().compareTo(playerPOs.get(j+1).getTeam())<=0) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getTeam().compareTo(playerPOs.get(j+1).getTeam())>0) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "appearance":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getAppearance()<=playerPOs.get(j+1).getAppearance()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getAppearance()>playerPOs.get(j+1).getAppearance()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "firstPlay":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getFirstPlay()<=playerPOs.get(j+1).getFirstPlay()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getFirstPlay()>playerPOs.get(j+1).getFirstPlay()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "backboard":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getBackboard()<=playerPOs.get(j+1).getBackboard()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getBackboard()>playerPOs.get(j+1).getBackboard()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "assist":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getAssist()<=playerPOs.get(j+1).getAssist()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getAssist()>playerPOs.get(j+1).getAssist()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "minutes":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getMinutes()<=playerPOs.get(j+1).getMinutes()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getMinutes()>playerPOs.get(j+1).getMinutes()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "fieldGoalShotPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getFieldGoalShotPercentage()<=playerPOs.get(j+1).getFieldGoalShotPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getFieldGoalShotPercentage()>playerPOs.get(j+1).getFieldGoalShotPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "threePointShotPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getThreePointShotPercentage()<=playerPOs.get(j+1).getThreePointShotPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getThreePointShotPercentage()>playerPOs.get(j+1).getThreePointShotPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "freeThrowPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getFreeThrowPercentage()<=playerPOs.get(j+1).getFreeThrowPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getFreeThrowPercentage()>playerPOs.get(j+1).getFreeThrowPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "offensiveRebound":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getOffensiveRebound()<=playerPOs.get(j+1).getOffensiveRebound()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getOffensiveRebound()>playerPOs.get(j+1).getOffensiveRebound()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "defensiveRebound":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getDefensiveRebound()<=playerPOs.get(j+1).getDefensiveRebound()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getDefensiveRebound()>playerPOs.get(j+1).getDefensiveRebound()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "steal":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getSteal()<=playerPOs.get(j+1).getSteal()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getSteal()>playerPOs.get(j+1).getSteal()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "block":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getBlock()<=playerPOs.get(j+1).getBlock()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getBlock()>playerPOs.get(j+1).getBlock()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "turnOver":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getTurnOver()<=playerPOs.get(j+1).getTurnOver()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getTurnOver()>playerPOs.get(j+1).getTurnOver()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "foul":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getFoul()<=playerPOs.get(j+1).getFoul()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getFoul()>playerPOs.get(j+1).getFoul()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "efficiency":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getEfficiency()<=playerPOs.get(j+1).getEfficiency()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getEfficiency()>playerPOs.get(j+1).getEfficiency()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "GmScEfficiency":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getGmScEfficiency()<=playerPOs.get(j+1).getGmScEfficiency()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getGmScEfficiency()>playerPOs.get(j+1).getGmScEfficiency()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "trueShootingPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getTrueShootingPercentage()<=playerPOs.get(j+1).getTrueShootingPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getTrueShootingPercentage()>playerPOs.get(j+1).getTrueShootingPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "shootingEfficiency":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getShootingEfficiency()<=playerPOs.get(j+1).getShootingEfficiency()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getShootingEfficiency()>playerPOs.get(j+1).getShootingEfficiency()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "backboardPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getBackboardPercentage()<=playerPOs.get(j+1).getBackboardPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getBackboardPercentage()>playerPOs.get(j+1).getBackboardPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "offensiveReboundPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getOffensiveReboundPercentage()<=playerPOs.get(j+1).getOffensiveReboundPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getOffensiveReboundPercentage()>playerPOs.get(j+1).getOffensiveReboundPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "defensiveReboundPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getDefensiveReboundPercentage()<=playerPOs.get(j+1).getDefensiveReboundPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getDefensiveReboundPercentage()>playerPOs.get(j+1).getDefensiveReboundPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "assistPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getAssistPercentage()<=playerPOs.get(j+1).getAssistPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getAssistPercentage()>playerPOs.get(j+1).getAssistPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "stealPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getStealPercentage()<=playerPOs.get(j+1).getStealPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getStealPercentage()>playerPOs.get(j+1).getStealPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "blockPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getBlockPercentage()<=playerPOs.get(j+1).getBlockPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getBlockPercentage()>playerPOs.get(j+1).getBlockPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "turnOverPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getTurnOverPercentage()<=playerPOs.get(j+1).getTurnOverPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getTurnOverPercentage()>playerPOs.get(j+1).getTurnOverPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "usage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getUsage()<=playerPOs.get(j+1).getUsage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getUsage()>playerPOs.get(j+1).getUsage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "nearlyFivePercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getNearlyFivePercentage()<=playerPOs.get(j+1).getNearlyFivePercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getNearlyFivePercentage()>playerPOs.get(j+1).getNearlyFivePercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "nearlyFiveBackboardPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getNearlyFiveBackboardPercentage()<=playerPOs.get(j+1).getNearlyFiveBackboardPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getNearlyFiveBackboardPercentage()>playerPOs.get(j+1).getNearlyFiveBackboardPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		case "nearlyFiveAssistPercentage":
			if (order.equals("DESC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getNearlyFiveAssistPercentage()<=playerPOs.get(j+1).getNearlyFiveAssistPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}else if (order.equals("ASC")) {
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getNearlyFiveAssistPercentage()>playerPOs.get(j+1).getNearlyFiveAssistPercentage()) {
							PlayerPO temp = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, temp);
							
						}
					}
				}
			}
			break;
		default:
			System.err.println("You input error in player!");
			break;
		}
		return playerPOs;
	}

}

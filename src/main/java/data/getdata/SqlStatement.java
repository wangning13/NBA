package data.getdata;

public class SqlStatement {

	public static String countTeamMatches(String teamName, String season,String thisSeason) {
		String r = "SELECT COUNT(name) FROM `matches" + thisSeason + "` WHERE name='" + teamName
				+ "' AND " + season;
		return r;
	}

	public static String countTeamWins(String teamName, String season,String thisSeason) {
		String r = "SELECT COUNT(name) FROM `matches" + thisSeason + "` WHERE name='" + teamName
				+ "' AND `win/lose`='w' AND " + season;
		return r;
	}

	public static String countTeamSum(String teamName, String season,String thisSeason) {
		String r = "SELECT SUM(fieldGoal),SUM(fieldGoalAttempts),SUM(`threepointFieldGoal`),SUM(`threepointFieldGoalAttempts`),SUM(freeThrow),SUM(freeThrowAttempts),SUM(offensiveRebound),SUM(defensiveRebound),SUM(backboard),SUM(assist),SUM(steal),SUM(block),SUM(turnOver),SUM(foul),SUM(scoring),SUM(minutes) FROM `playerdata" + thisSeason + "` WHERE team='"
				+ teamName + "' AND " + season;
		return r;
	}

	public static String getTeamName() {
		String r = "SELECT abbr FROM teaminfo";
		return r;
	}

	public static String getTeamOpponent(String teamName, String season,String thisSeason) {
		String r = "SELECT date,opponent FROM `matches" + thisSeason + "` WHERE name='" + teamName
				+ "' AND " + season;
		return r;
	}

	public static String getTeamOpponentSum(String date, String opponent,String thisSeason) {
		String r = "SELECT SUM(fieldGoal),SUM(fieldGoalAttempts),SUM(freeThrowAttempts),SUM(offensiveRebound),SUM(defensiveRebound),SUM(turnOver),SUM(scoring),SUM(backBoard),SUM(threePointFieldGoalAttempts) FROM `playerdata" + thisSeason + "` WHERE date='"
				+ date + "' AND team='" + opponent + "'";
		return r;
	}

	public static String getTeaminfo(String teamName) {
		String r = "SELECT * FROM teaminfo WHERE abbr='" + teamName + "'";
		return r;
	}

	public static String countPlayerMatches(String playerName, String season,String thisSeason) {
		String r = "SELECT COUNT(playername) FROM `playerdata" + thisSeason + "` WHERE playername='"
				+ playerName + "' AND " + season;
		return r;
	}

	public static String countPlayerSum(String playerName, String season,String thisSeason) {
		String r = "SELECT SUM(fieldGoal),SUM(fieldGoalAttempts),SUM(`threepointFieldGoal`),SUM(`threepointFieldGoalAttempts`),SUM(freeThrow),SUM(freeThrowAttempts),SUM(offensiveRebound),SUM(defensiveRebound),SUM(backboard),SUM(assist),SUM(minutes),SUM(steal),SUM(block),SUM(turnOver),SUM(foul),SUM(scoring) FROM `playerdata" + thisSeason + "` WHERE playername='"
				+ playerName + "' AND " + season;
		return r;
	}

	public static String getPlayerinfo(String playerName) {
		String r = "SELECT * FROM playerinfo WHERE name='" + playerName + "'";
		return r;
	}

	public static String getPlayerFirstPlay(String playerName, String season,String thisSeason) {
		String r = "SELECT COUNT(*) FROM `playerdata" + thisSeason + "` WHERE position !=''AND playername='"
				+ playerName + "' AND " + season;
		return r;
	}

	public static String getPlayerTeam(String playerName,String season) {
		String r = "SELECT team FROM `playerdata" + season + "` WHERE playername='"
				+ playerName + "' ORDER BY date DESC LIMIT 1";
		return r;
	}

	public static String countTeamSumForPlayer(String teamName, String season,String thisSeason) {
		String r = "SELECT SUM(fieldGoal),SUM(fieldGoalAttempts),SUM(freeThrow),SUM(offensiveRebound),SUM(defensiveRebound),SUM(minutes),SUM(freeThrowAttempts),SUM(backboard),SUM(turnOver) FROM `playerdata" + thisSeason + "` WHERE team='"
				+ teamName + "' AND " + season;
		return r;
	}

	public static String getOpponentSumForPlayer(String date, String opponent,String thisSeason) {
		String r = "SELECT SUM(fieldGoalAttempts),SUM(threePointFieldGoalAttempts),SUM(backBoard),SUM(offensiveRebound),SUM(defensiveRebound) FROM `playerdata" + thisSeason + "` WHERE date='"
				+ date + "' AND team='" + opponent + "'";
		return r;
	}
}

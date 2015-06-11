package data.initial;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InitialDatabase {

	public static String driver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://127.0.0.1:3306/nba";
	public static String user = "root";
	public static String password = "123";
	public static String datasource = "data";

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		File f = new File(datasource + "/matches");
		String[] directorylist = f.list();
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			conn.setAutoCommit(false);
			String sql = "DELETE FROM teaminfo";
			statement.addBatch(sql);
			for (int i = 0; i < directorylist.length; i++) {
				sql = "DROP TABLE IF EXISTS `matches" + directorylist[i] + "`";
				statement.addBatch(sql);
				sql = "DROP TABLE IF EXISTS `playerdata" + directorylist[i] + "`";
				statement.addBatch(sql);
				sql = "DROP TABLE IF EXISTS `playersum" + directorylist[i] + "`";
				statement.addBatch(sql);
				sql = "DROP TABLE IF EXISTS `teamsum" + directorylist[i] + "`";
				statement.addBatch(sql);
				sql = "CREATE TABLE IF NOT EXISTS `matches" + directorylist[i] + "` (`date` varchar(255),`host/guest` varchar(1),`name` varchar(3),`opponent` varchar(3), `win/lose` varchar(1),`total` int(11),`first` int(11),`second` int(11), `third` int(11), `fourth` int(11))";
				statement.addBatch(sql);
				sql = "CREATE TABLE IF NOT EXISTS `playerdata" + directorylist[i] + "` ( `date` varchar(255), `team` varchar(255), `playername` varchar(255), `position` varchar(255), `minutes` double, `fieldGoal` int(11), `fieldGoalAttempts` int(11) , `threepointFieldGoal` int(11) , `threepointFieldGoalAttempts` int(11) , `freeThrow` int(11), `freeThrowAttempts` int(11), `offensiveRebound` int(11), `defensiveRebound` int(11) , `backboard` int(11) , `assist` int(11) , `steal` int(11), `block` int(11),`turnOver` int(11),`foul` int(11) ,`scoring` int(11) ,PRIMARY KEY (`date`,`team`,`playername`))";
				statement.addBatch(sql);
				sql = "CREATE TABLE `playersum"
						+ directorylist[i]
						+ "` (`playerName`	varchar(255),`team`	varchar(255),`appearance`	INTEGER,	`firstPlay`	INTEGER,`backboard`	INTEGER,	`assist`	INTEGER,	`minutes`	REAL,`fieldGoal`	INTEGER,`fieldGoalAttempts`	INTEGER,`threePointFieldGoal` INTEGER,`threePointFieldGoalAttempts` INTEGER,`freeThrow`	INTEGER,`freeThrowAttempts` INTEGER, `offensiveRebound` INTEGER, `defensiveRebound`	INTEGER,	`steal` INTEGER, `block`	INTEGER,	`turnOver` INTEGER, `foul` INTEGER, `scoring` INTEGER, `previousAverageScoring` INTEGER, `nearlyFiveAverageScoring` INTEGER,previousAverageBackboard INTEGER,nearlyFiveAverageBackboard INTEGER,previousAverageAssist INTEGER,nearlyFiveAverageAssist INTEGER,	`doubleDouble` INTEGER, PRIMARY KEY(playerName,team))";
				statement.addBatch(sql);
				sql = "CREATE TABLE `teamsum"
						+ directorylist[i]
						+ "` (`opponentFieldGoal`	INTEGER,`opponentFieldGoalAttempts` INTEGER,`opponentTurnOver` INTEGER,`opponentFreeThrowAttempts`	INTEGER,	`oppenentScoring`	INTEGER,	`teamName`	varchar(255),`matches` INTEGER,`wins`	INTEGER,`fieldGoal`	INTEGER,	`fieldGoalAttempts` INTEGER,`threePointFieldGoal`	INTEGER,	`threePointFieldGoalAttempts`	INTEGER,	`freeThrow`	INTEGER,	`freeThrowAttempts`	INTEGER,	`offensiveRebound`	INTEGER,	`defensiveRebound`	INTEGER,	`opponentOffensiveRebound`	INTEGER,	`opponentDefensiveRebound` INTEGER,`backboard`	INTEGER,	`assist`	INTEGER,	`steal`	INTEGER,	`block`	INTEGER,	`turnOver` INTEGER,`foul` INTEGER,`scoring`	INTEGER,	`minutes`	REAL,`opponentBackBoard` INTEGER,`opponentThreePointFieldGoalAttempts`	INTEGER);";
				statement.addBatch(sql);
			} 
			statement.executeBatch();
			conn.commit();
			new InitialTeaminfo(statement);
			conn.commit();
			for (int i = 0; i < directorylist.length; i++) {
				new InitialMatches(conn, datasource + "/matches/" + directorylist[i]);
				conn.commit();
				new InitialPlayerdata(conn, datasource + "/matches/" + directorylist[i]);
				conn.commit();
				new InitialPlayersum(conn, statement,directorylist[i]);
				conn.commit();
				new InitialTeamsum(conn, statement,directorylist[i]);
				conn.commit();
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		time = System.currentTimeMillis() - time;
		System.out.println(time);
	}
}

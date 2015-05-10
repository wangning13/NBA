package rmi;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;

import data.initial.InitialDatabase;
import data.update.UpdateDatabase;

public class Server {

	public static String initial_season = "";
	public static String[] matches;
	public static ArrayList<String> season;
	Timer timer;

	public Server() {
		season = new ArrayList<String>();
		try {
			File f = new File(InitialDatabase.datasource + "/matches");
			matches = f.list();
			if (matches.length > 0) {
				initial_season = matches[matches.length/2].substring(0, matches[matches.length/2].indexOf("_"));
			}
			if (initial_season.equals("")) {
				Class.forName(InitialDatabase.driver);
				Connection conn = DriverManager.getConnection(InitialDatabase.url);
				conn.setAutoCommit(false);
				Statement statement = conn.createStatement();
				String sql = "DELETE FROM playerdata";
				statement.addBatch(sql);
				sql = "DELETE FROM matches";
				statement.addBatch(sql);
				sql = "DELETE FROM `playersum13-14`";
				statement.addBatch(sql);
				sql = "DELETE FROM `teamsum13-14`";
				statement.addBatch(sql);
				statement.executeBatch();
				conn.commit();
			}
			for (int i = 0; i < matches.length; i++) {
				String[] temp = matches[i].split("_");
				if (!season.contains(temp[0])) {
					season.add(temp[0]);
				}
			}

			timer = new Timer();
			timer.schedule(new UpdateDatabase(), 0, 5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package data.initial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerCompare {

	public static void main(String[] args) {
		File f = new File("data/players/info");
		String[] names = f.list();
		String dataFile = "data/matches/14-15";
		f = new File(dataFile);
		String[] matches = f.list();
		ArrayList<String> playerNames = new ArrayList<String>();
		for(String match : matches) {
			try {
				FileReader fr = new FileReader(dataFile + "/" + match);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while ((line = br.readLine()) != null) {
					if (line.contains(";") && line.charAt(0) >= 65 && line.charAt(0) <= 90) {
						String name = line.substring(0, line.indexOf(";"));
						boolean isIn = false;
						for(String temp : names) {
							if (temp.equals(name)) {
								isIn = true;
								break;
							}
						}
						if (!isIn && !playerNames.contains(name)) {
							playerNames.add(name);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (String temp : playerNames) {
			try {
				FileWriter fw = new FileWriter("data/players/info/" + temp);
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

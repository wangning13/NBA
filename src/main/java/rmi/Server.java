package rmi;

import java.io.File;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Timer;

import data.getdata.GetPlayerdata;
import data.getdata.GetTeamdata;
import data.update.UpdateDatabase;
import dataservice.getdatadataservice.GetPlayerdataDataService;
import dataservice.getdatadataservice.GetTeamdataDataService;

public class Server {

	public static String[] matches;
	public static ArrayList<String> season;
	public static ArrayList<Integer> seasonNum;
	Timer timer;
	public Server() {
		season=new ArrayList<String>();
		seasonNum = new ArrayList<Integer>();
		try {
			File f=new File("data/matches");
			matches=f.list();
			for (int i = 0; i < matches.length; i++) {
				String[] temp=matches[i].split("_");
				if(!season.contains(temp[0])) {
					season.add(temp[0]);
					seasonNum.add(0);
				}
				for (int j = 0; j < season.size(); j++) {
					if (temp[0].equals(season.get(j))) {
						seasonNum.set(j, seasonNum.get(j)+1);
					}
				}
			}
	
			timer = new Timer();
	        timer.schedule(new UpdateDatabase(), 0,5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

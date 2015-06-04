package data.crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class Crawler extends BreadthCrawler {
	
	private static Map<String,String> nameCorrector = new HashMap<String, String>();
	
    public static void main(String[] args) throws Exception{  
    	Crawler crawler=new Crawler();
    	Pattern p=Pattern.compile("\\d{4}[0-1][1-2][0-3][0-9]");
    	for (int i = 20150501; i > 20141001; i--) {
            Matcher m=p.matcher(Integer.toString(i));
            if (m.find()) {
        		crawler.addSeed("http://www.nba.com/gameline/" + i + "/");
			}
		}
        crawler.addRegex("http://www.nba.com/gameline/\\d{8}/");
        crawler.addRegex("http://www.nba.com/games/\\d{8}/[A-Z]{6}/gameinfo.html");
        crawler.addRegex("http://www.nba.com/playerfile/[a-z]{1,10}(_[a-z]{1,10}){1,3}/index.html"); 
        crawler.setThreads(30);
       	crawler.start(3);
       	File f = new File("temp");
       	String[] matches = f.list();
       	for (int i = 0; i < matches.length; i++) {
       		ArrayList<String> content = new ArrayList<String>();
			FileReader fr = new FileReader("temp/" + matches[i]);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null) {
				if (line.contains(";") && line.charAt(0) >= 65 && line.charAt(0) <= 90) {
					line = nameCorrector.get(line.substring(0, line.indexOf(";"))) + line.substring(line.indexOf(";"), line.length());
				}
				content.add(line);
			}
			FileWriter fw = new FileWriter("temp/" + matches[i]);
			for (int j = 0; j < content.size(); j++) {
				fw.write(content.get(j)+"\r\n");
			}
			br.close();
			fw.close();
		}
    }

	@Override
    public void visit(Page page) {
        System.out.println("正在抽取"+page.getUrl());
    	String[] temp = page.getUrl().split("/"); 
        if (temp[4].charAt(0) >= 97 && temp[4].charAt(0) <= 122) {
			String[] fullName = temp[4].split("_");
			fullName[0] = fullName[0].substring(0, 1).toUpperCase() + fullName[0].substring(1, fullName[0].length());
			fullName[1] = fullName[1].substring(0, 1).toUpperCase() + fullName[1].substring(1, fullName[1].length());
			if (nameCorrector.get(fullName[0].substring(0, 1).toUpperCase() + "." + fullName[1]) == null) {
				nameCorrector.put(fullName[0].substring(0, 1).toUpperCase() + "." + fullName[1], fullName[0] + " " + fullName[1]);
			}

		}
        String origin = page.getDoc().select("div[id=nbaGIboxscore]").select("table[id=nbaGITeamStats]").select("td").text();
        if (!origin.equals("")) {
        	if (temp[5].equals("WSTEST") || temp[5].equals("WLDUSA")) {
    			return;
    		}
        	String guestTeam = temp[5].substring(0,3);
        	String hostTeam = temp[5].substring(3,6);
        	String title = temp[4].substring(4,6);
        	if (title.equals("01") || title.equals("02") || title.equals("03") || title.equals("04") || title.equals("05") || title.equals("06")) {
				title = Integer.toString((Integer.parseInt(temp[4].substring(2, 4))-1)) + "-" + temp[4].substring(2,4);
			} else {
				title = temp[4].substring(2,4) + "-" + Integer.toString((Integer.parseInt(temp[4].substring(2, 4))+1));
			}
        	title = title + "_" + temp[4].substring(4, 6) + "-" + temp[4].substring(6, 8) + "_" + guestTeam + "-" + hostTeam;
            origin = origin.replace(". ", ".");
            String guest = origin.substring(origin.indexOf("pts") + 3, origin.indexOf("Total"));
            origin = origin.substring(origin.lastIndexOf("pts") + 3, origin.length());
            String host = origin.substring(0, origin.indexOf("Total"));
            ArrayList<String> flag = new ArrayList<String>();
            flag.add("DN");
            flag.add("NW");
            String node = "";
            int index = guest.length();
            for (String s : flag) {
            	if (guest.contains(s) && guest.indexOf(s) < index) {
            		node = s;
					index = guest.indexOf(s);
				}
            }
            if (!node.equals("")) {
				guest = guest.substring(0, index - 1);
				guest = guest.substring(0, guest.lastIndexOf(".")-2);
			}
            node = "";
            index = host.length();
            for (String s : flag) {
            	if (host.contains(s) && host.indexOf(s) < index) {
					node = s;
					index = host.indexOf(s);
				}
            }
            if (!node.equals("")) {
				host = host.substring(0, index - 1);
				host = host.substring(0, host.lastIndexOf(".")-2);
			}
            guest = guest.substring(1, guest.length());
            host = host.substring(1, host.length());
            guest = guest.replace(" ", ";");
            host = host.replace(" ", ";");

            ArrayList<String> content = new ArrayList<String>();
            String line = temp[4].substring(4, 6) + "-" + temp[4].substring(6, 8) + ";" + guestTeam + "-" + hostTeam + ";";
            String totalScore = page.getDoc().select("div[id=nbaGIQtrScrs]").select("td[class=nbaGIQtrPtsLast]").text();
            temp = totalScore.split(" ");
            line = line + temp[0] + "-" + temp[1] + ";";
            content.add(line);
            String detailScore = page.getDoc().select("div[id=nbaGIQtrScrs]").select("td[class=nbaGIQtrPts]").text();
            temp = detailScore.split(" ");
            line = "";
            for (int i = 0; i < 4; i++) {
				line = line + temp[i] + "-" + temp[i+4] +";";
			}
            content.add(line);
            //主客队球员数据
            content.add(guestTeam);
            ArrayList<String> regex = new ArrayList<String>();
            Pattern p=Pattern.compile("\\d;[A-Z]\\.");
            Matcher m=p.matcher(guest);
            while(m.find()) {
            	regex.add(m.group());
            }      
            for (int i = 0; i < regex.size(); i++) {
            	line = guest.substring(0, guest.indexOf(regex.get(i))+2);
            	line = formatName(line);
            	temp = line.split(";");
            	line = "";
            	for (int j = 0; j < 3; j++) {
					line = line + temp[j] +";";
				}
            	for (int j = 3; j < 6; j++) {
					String[] part = temp[j].split("-");
					line = line + part[0] + ";" + part[1] +";";
				}
            	for (int j = 7; j < 11; j++) {
					line = line + temp[j] + ";";
				}
            	line = line + temp[12] + ";" + temp[14] + ";" + temp[13] + ";" + temp[11] + ";" + temp[16] + ";";
            	content.add(line);
            	guest = guest.substring(guest.indexOf(regex.get(i))+2, guest.length());
			}
            guest = formatName(guest);
            temp = guest.split(";");
        	guest = "";
        	for (int j = 0; j < 3; j++) {
        		guest = guest + temp[j] +";";
			}
        	for (int j = 3; j < 6; j++) {
				String[] part = temp[j].split("-");
				guest = guest + part[0] + ";" + part[1] +";";
			}
        	for (int j = 7; j < 11; j++) {
        		guest = guest + temp[j] + ";";
			}
        	guest = guest + temp[12] + ";" + temp[14] + ";" + temp[13] + ";" + temp[11] + ";" + temp[16];
            content.add(guest + ";");
            regex.clear();
            content.add(hostTeam);
            Matcher ma=p.matcher(host);
            while(ma.find()) {
            	regex.add(ma.group());
            } 
            for (int i = 0; i < regex.size(); i++) {
				line = host.substring(0, host.indexOf(regex.get(i))+2);
				line = formatName(line);
            	temp = line.split(";");
            	line = "";
            	for (int j = 0; j < 3; j++) {
					line = line + temp[j] +";";
				}
            	for (int j = 3; j < 6; j++) {
					String[] part = temp[j].split("-");
					line = line + part[0] + ";" + part[1] +";";
				}
            	for (int j = 7; j < 11; j++) {
					line = line + temp[j] + ";";
				}
            	line = line + temp[12] + ";" + temp[14] + ";" + temp[13] + ";" + temp[11] + ";" + temp[16] + ";";
				content.add(line);
				host = host.substring(host.indexOf(regex.get(i))+2, host.length());
			}
            host = formatName(host);
            temp = host.split(";");
            host = "";
        	for (int j = 0; j < 3; j++) {
        		host = host + temp[j] +";";
			}
        	for (int j = 3; j < 6; j++) {
				String[] part = temp[j].split("-");
				host = host + part[0] + ";" + part[1] +";";
			}
        	for (int j = 7; j < 11; j++) {
        		host = host + temp[j] + ";";
			}
        	host = host + temp[12] + ";" + temp[14] + ";" + temp[13] + ";" + temp[11] + ";" + temp[16];
            content.add(host + ";");
        	try {
				FileWriter fw = new FileWriter("temp/" + title);
	            for (int i = 0; i < content.size(); i++) {
					fw.write(content.get(i)+"\r\n");
				}
	            fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
	
	public String formatName(String line) {
		System.out.println(line);
		String r = "";
        Pattern pa = Pattern.compile("[FCG ];\\d");
    	Matcher m = pa.matcher(line);
    	String temp = "";
    	if (m.find()) {
        	temp = line.substring(0, line.indexOf(m.group()));
        	r = line.substring(line.indexOf(m.group()), line.length());
		}
    	if (temp.endsWith(".")) {
			temp = temp + ";";
		}
    	temp = temp.substring(0, temp.length()-1);
    	temp = temp.replace(";", " ");
    	temp = temp + ";";
    	r = temp + r;
		return r;
	}
	
}

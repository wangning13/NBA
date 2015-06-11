package data.getdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GetLive {

	public ArrayList<ArrayList<String>> getLiveString() {
		ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>();
		try {
			FileReader fr = new FileReader("test");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null) {
				ArrayList<String> Temp = new ArrayList<String>();
				if (line.contains(":")) {
					Temp.add(line.substring(0, line.indexOf(":")+3));
					Temp.add(line.substring(line.indexOf(":")+3, line.indexOf(":")+5));
					line = line.substring(line.indexOf(":")+5, line.length());
					if (line.startsWith(" ")) {
						line = line.substring(1, line.length());
					}
					int in = line.lastIndexOf("-")-1;
					while(line.charAt(in) >= 48 && line.charAt(in) <= 57) {
						in--;
					}
					Temp.add(line.substring(0, in+1));
					Temp.add(line.substring(in+1, line.length()));
				} else if (line.contains("\"")) {
					Temp.add(line.substring(0, line.indexOf("\"")+1));
					Temp.add(line.substring(line.indexOf("\"")+1, line.indexOf("\"")+3));
					line = line.substring(line.indexOf("\"")+3, line.length());
					if (line.startsWith(" ")) {
						line = line.substring(1, line.length());
					}
					int in = line.lastIndexOf("-")-1;
					while(line.charAt(in) >= 48 && line.charAt(in) <= 57) {
						in--;
					}
					Temp.add(line.substring(0, in+1));
					Temp.add(line.substring(in+1, line.length()));
				} else {
					Temp.add(line);
				}
				r.add(Temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
}

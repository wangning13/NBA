package data.crawler;

import java.util.Timer;

public class test {

	public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new PlayerLiveTask(), 0, 20000);
	}
	
}

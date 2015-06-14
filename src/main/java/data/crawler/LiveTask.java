package data.crawler;

import java.util.TimerTask;

public class LiveTask extends TimerTask {
	
	@Override
	public void run() {
    	LiveCrawler crawler=new LiveCrawler("live/");
        crawler.addSeed("http://g.hupu.com/nba/daily/playbyplay_" + LiveCrawler.num + ".html");
        try {
			crawler.start(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

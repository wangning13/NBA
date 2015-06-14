package data.crawler;

import java.util.TimerTask;

public class PlayerLiveTask extends TimerTask {

	@Override
	public void run() {
        PlayerLiveCrawler crawler=new PlayerLiveCrawler("pLive");
        crawler.addSeed("http://g.hupu.com/nba/daily/boxscore_" + LiveCrawler.num + ".html");
        try {
        	crawler.start(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

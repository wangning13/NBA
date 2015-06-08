package data.crawler;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cn.edu.hfut.dmic.webcollector.crawler.DeepCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class LiveCrawler extends DeepCrawler {
	
    public static void main(String[] args) throws Exception{
    	LiveCrawler crawler=new LiveCrawler("live/");
        crawler.addSeed("http://g.hupu.com/nba/daily/playbyplay_150120.html");
        crawler.start(1);
    }

	public LiveCrawler(String crawlPath) {
        super(crawlPath);
    }

    @Override
    public Links visitAndGetNextLinks(Page page) {
        HtmlUnitDriver driver=PageUtils.getDriver(page);
        List<WebElement> divInfos=driver.findElementsByCssSelector("table[matchid=150120]");
        for(WebElement divInfo:divInfos){
            System.out.println(divInfo.getText());
        }
        return null;
    }
	
}

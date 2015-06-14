package data.crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cn.edu.hfut.dmic.webcollector.crawler.DeepCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class PlayerLiveCrawler extends DeepCrawler {

	public PlayerLiveCrawler(String crawlPath) {
		super(crawlPath);
		// TODO Auto-generated constructor stub
	}

    @Override
    public Links visitAndGetNextLinks(Page page) {
        HtmlUnitDriver driver=PageUtils.getDriver(page);
        List<WebElement> divInfos=driver.findElementsByCssSelector("div[class='table_list_live']");
        try {
			FileWriter fr = new FileWriter("playerLive");
			for(WebElement divInfo:divInfos){
				List<WebElement> info = divInfo.findElements(By.cssSelector("tr"));
				for (WebElement temp : info) {
					//fr.write(temp.getText()+"\r\n");
				}
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
}

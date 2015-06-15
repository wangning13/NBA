package data.crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
			ArrayList<String> host = new ArrayList<String>();
			ArrayList<String> guest = new ArrayList<String>();
			int flag = 0;
			int index = 0;
			String line = "";
			for(WebElement divInfo:divInfos){
				List<WebElement> info = divInfo.findElements(By.cssSelector("td"));
				for (WebElement temp : info) {
					index ++;
					String item = temp.getText();
					if (item.equals("首发")) {
						flag ++;
					}
					if (index == 16) {
						host.add(line);
						fr.write(line+"\r\n");
						index = 0;
						line = "";
					} else {
						line = line + item + ";";
					}
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

package ui.main;

import java.util.Timer;

import data.crawler.LiveTask;
import data.crawler.PlayerLiveTask;
import rmi.Server;
import ui.main.Frame;

public class Main {
	public static Frame frame = null;
	public static void main(String[] args) {
	//	new Server();
		frame = new Frame();
		
    /*    Timer timer = new Timer();
        timer.schedule(new LiveTask(), 0, 20000);
        
        Timer timer1 = new Timer();
        timer.schedule(new PlayerLiveTask(), 0, 20000);
        */
	}
}

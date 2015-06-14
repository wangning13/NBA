package ui.main;

import java.util.Timer;

import data.crawler.LiveTask;
import rmi.Server;
import ui.main.Frame;

public class Main {
	public static Frame frame = null;
	public static void main(String[] args) {
	//	new Server();
		frame = new Frame();
		
        Timer timer = new Timer();
        timer.schedule(new LiveTask(), 0, 20000);
	}
}

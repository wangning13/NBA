package ui.main;

import rmi.Server;
import ui.main.Frame;

public class Main {
	public static Frame frame = null;
	public static void main(String[] args) {
		new Server();
		frame = new Frame();
	}
}

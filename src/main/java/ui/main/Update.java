package ui.main;

import java.util.TimerTask;

public class Update extends TimerTask{
    Frame frame; 
	public Update(Frame frame){
		this.frame = frame;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		frame.update();
	}
	 

}

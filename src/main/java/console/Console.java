package console;

import java.io.PrintStream;

public class Console {

	public void execute(PrintStream out, String[] args) {
		switch (args[0]) {
		case "--datasource":
			
			break;
		
		case "-player":
			new PlayerModel();
			break;
		
		case "-team":
			
			break;
		}
	}
	
}

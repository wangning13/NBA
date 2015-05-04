package console;

import java.io.PrintStream;

public class Console {

	public void execute(PrintStream out, String[] args) {

	}
	
	public static void main(String[] args){
		Console console = new Console();
		console.execute(System.out, args);
	}
	
}

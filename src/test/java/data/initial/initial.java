package data.initial;

import static org.junit.Assert.*;

import org.junit.Test;

public class initial {
	@Test
	public void InitialDatabaseTest(){
		InitialDatabase initialDatabase = new InitialDatabase();
		initialDatabase.main(null);
		assertTrue(true);
	}
	

}

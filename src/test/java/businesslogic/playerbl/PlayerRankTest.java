package businesslogic.playerbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import vo.PlayerMatchVO;
import vo.PlayerVO;
import vo.PlayerinfoVO;

public class PlayerRankTest {
	PlayerRank playerRank = new PlayerRank();
	@Test
	public void getAllPlayerTest(){
		String season = "13-14";
		String teamName = "SAS";
		ArrayList<String> teamPlayerList = playerRank.getAllPlayer(season, teamName);
		int number = teamPlayerList.size();
		assertEquals(15,number);
	}
	@Test
	public void getPlayerDataTest(){
		String season = "13-14";
		String playerName = "Kevin Durant";
		PlayerVO playerVO = playerRank.getPlayerdata(season, playerName);
		String team = playerVO.getTeam();
		assertEquals(team, "OKC");
	}
	@Test
	public void getPlayerinfoTest(){
		String playerName = "Kevin Durant";
		PlayerinfoVO playerinfoVO = playerRank.getPlayerinfo(playerName);
		String number = playerinfoVO.getNumber();
		assertEquals("35", number);
	}
	@Test
	public void getPlayerinfoNullTest(){
		String playerName = "abc";
		PlayerinfoVO playerinfoVO = playerRank.getPlayerinfo(playerName);
		String number = playerinfoVO.getNumber();
		assertEquals("", number);
	}
	@Test
	public void getAllPlayerdataTest(){
		String season = "13-14";
		String key = "backboard";
		String order = "DESC";
		ArrayList<PlayerVO> playerVOs = playerRank.getAllPlayerdata(season, key, order);
		boolean desc = true;
		for (int i = 0; i < playerVOs.size()-1; i++) {
			if (playerVOs.get(i).getBackboard()<playerVOs.get(i+1).getBackboard()) {
				desc = false;
			}
		}
		assertTrue(desc);
	}
	@Test
	public void getAllPlayerdataTest2(){
		String season = "13-14";
		String key = "backboard";
		String order = "ASC";
		ArrayList<PlayerVO> playerVOs = playerRank.getAllPlayerdata(season, key, order);
		boolean desc = true;
		for (int i = 0; i < playerVOs.size()-1; i++) {
			if (playerVOs.get(i).getBackboard()>playerVOs.get(i+1).getBackboard()) {
				desc = false;
			}
		}
		assertTrue(desc);
	}
	@Test
	public void getFirstFiftyTest(){
		String season = "13-14";
		String position = "G";
		String partition = "league:W";
		String key = "backboard";
		ArrayList<PlayerVO> playerVOs = playerRank.getFirstFifty(season, position, partition, key);
		assertEquals(50, playerVOs.size());
	}
	@Test
	public void getFirstFifty2Test(){
		String season = "13-14";
		String position = "G";
		String partition = "league:W";
		String key = "weightAverage";
		ArrayList<PlayerVO> playerVOs = playerRank.getFirstFifty(season, position, partition, key);
		assertEquals(50, playerVOs.size());
	}
	@Test
	public void getPlayerMatchdataTest(){
		String date = "13-10-29";
		String team = "LAL";
		ArrayList<PlayerMatchVO> playerMatchVOs = playerRank.getPlayerMatchdata(date, team);
		boolean notNull = true;
		if (playerMatchVOs.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void getPlayerMonthMatchTest(){
		String month = "13-10";
		String player = "Ed Davis";
		ArrayList<PlayerMatchVO> playerMatchVOs = playerRank.getPlayerMonthMatch(month, player);
		boolean notNull = true;
		if (playerMatchVOs.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void getPlayerRencentFiveMatchTest(){
		String player = "Ed Davis";
		ArrayList<PlayerMatchVO> playerMatchVOs = playerRank.getPlayerRecentFiveMatch("13-14",player);
		int number = playerMatchVOs.size();
		assertEquals(number, 5);
	}
	@Test
	public void getDayTop(){
		String condition = "backboard";
		ArrayList<PlayerMatchVO> playerMatchVOs = playerRank.getDayTop(condition);
		boolean notNull = true;
		if (playerMatchVOs.size()==0) {
			notNull = false;
			
		}
		assertTrue(notNull);
		
	}
	@Test
	public void getSeasonTopTest(){
		String season = "13-14";
		String condition = "backboard";
		ArrayList<PlayerVO> playerVOs = playerRank.getSeasonTop(season, condition);
		boolean notNull = true;
		if (playerVOs.size()==0) {
			notNull = false;
			
		}
		assertTrue(notNull);
	}
	@Test
	public void getMostImporvedPlayerTest(){
		String season = "13-14";
		String key = "backboard";
		ArrayList<PlayerVO> playerVOs = playerRank.getMostImporvedPlayer(season, key);
		boolean notNull = true;
		if (playerVOs.size()==0) {
			notNull = false;
			
		}
		assertTrue(notNull);
	}

}

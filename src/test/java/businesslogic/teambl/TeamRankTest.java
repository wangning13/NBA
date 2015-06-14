package businesslogic.teambl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import vo.TeamMatchVO;
import vo.TeamMonthMatchVO;
import vo.TeamVO;
import vo.TeaminfoVO;

public class TeamRankTest {
	TeamRank teamRank = new TeamRank();
	
	@Test
	public void RankingTest(){
		String season = "13-14";
		String condition = "`partition`='Atlantic'";
		String key = "wins";
		String order = "DESC";
		ArrayList<TeamVO> teamVOs = teamRank.getTeamData(season, condition, key, order);
		boolean notNull = true;
		if (teamVOs.size()==0) {
			notNull = false;
					
		}
		assertTrue(notNull);
	}
	@Test
	public void getTeaminfoTest(){
		String teamName = "SAS";
		TeaminfoVO teaminfoVO = teamRank.getTeamInfo(teamName);
		String partion = teaminfoVO.getPartition();
		boolean notNull = true;
		if (partion.isEmpty()) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void getTeamData2(){
		String season = "13-14";
		String teamName = "SAS";
		TeamVO teamVO = teamRank.getTeamData(season, teamName);
		int matches = teamVO.getMatches();
		boolean notNull = true;
		if (matches==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void getTeamMonthMatchTest(){
		String month = "13-10";
		String team = "LAL";
		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = teamRank.getTeamMonthMatch(month, team);
		boolean notNull = true;
		if (teamMonthMatchVOs.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void getTeamMatch(){
		String date = "13-10-29";
		String team = "LAL";
		TeamMatchVO teamMatchVO = teamRank.getTeamMatch(date, team);
		boolean isTrue = true;
		if (teamMatchVO.getTotal()!=teamMatchVO.getFirst()+teamMatchVO.getSecond()+teamMatchVO.getThird()+teamMatchVO.getFourth()) {
			isTrue = false;
		}
		assertTrue(isTrue);
	}
	@Test
	public void getTeamRecentFiveMatchTest(){
		String team = "LAL";
		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = teamRank.getTeamRecentFiveMatch(team);
		int number = teamMonthMatchVOs.size();
		assertEquals(number, 5);
	}
	@Test
	public void getSeasonTopTest(){
		String season = "13-14";
		String condition = "backboard";
		ArrayList<TeamVO> teamVOs = teamRank.getSeasonTop(season, condition);
		int number = teamVOs.size();
		assertEquals(number, 5);
		
	}
//	@Test
//	public void getRecentFifteenTest(){
//		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = teamRank.getRecentFifteen();
//		boolean notNull = true;
//		if (teamMonthMatchVOs.size()==0) {
//			notNull = false;
//		}
//		assertTrue(notNull);
//	}

}

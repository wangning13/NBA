package businesslogic.teambl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import po.TeaminfoPO;
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
	
	

}

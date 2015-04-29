package businesslogic.teambl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import data.getdata.GetTeamdata;
import dataservice.getdatadataservice.GetTeamdataDataService;
import po.TeamPO;
import vo.TeamVO;

public class SortTest {
	
	@Test
	public void SortTest1(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "winningPercentage", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest2(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "winningPercentage", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest3(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "teamName", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest4(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "teamName", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest5(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "matches", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest6(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "matches", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest7(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "fieldGoal", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest8(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "fieldGoal", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest9(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "fieldGoalAttempts", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest10(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "fieldGoalAttempts", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest11(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "threePointFieldGoal", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest12(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "threePointFieldGoal", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest13(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "threePointFieldGoalAttempts", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest14(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "threePointFieldGoalAttempts", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest15(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "freeThrow", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest16(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "freeThrow", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest17(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "freeThrowAttempts", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest18(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "freeThrowAttempts", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest19(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "offensiveRebound", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest20(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "offensiveRebound", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest21(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "defensiveRebound", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest22(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "defensiveRebound", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest23(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "backboard", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest24(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "backboard", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest25(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "assist", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest26(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "assist", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest27(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "steal", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest28(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "steal", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest29(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "block", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest30(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "block", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest31(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "turnOver", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest32(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "turnOver", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest33(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "foul", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest34(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "foul", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest35(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "scoring", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest36(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "scoring", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest37(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "fieldGoalShotPercentage", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest38(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "fieldGoalShotPercentage", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest39(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "threePointShotPercentage", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest40(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "threePointShotPercentage", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest41(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "freeThrowPercentage", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest42(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "freeThrowPercentage", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest43(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "possessions", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest44(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "possessions", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest45(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "offensiveEfficiency", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest46(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "offensiveEfficiency", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest47(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "defensiveEfficiency", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest48(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "defensiveEfficiency", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest49(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "offensivebackboardEfficiency", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest50(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "offensivebackboardEfficiency", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest51(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "defensivebackboardEfficiency", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest52(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "defensivebackboardEfficiency", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest53(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "stealEfficiency", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest54(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "stealEfficiency", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest55(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "stealEfficiency", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest56(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "stealEfficiency", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest57(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "assistEfficiency", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest58(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "assistEfficiency", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest59(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "DESC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "wins", "DESC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest60(){
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
		GetTeamdataDataService g = new GetTeamdata();
		teamPOs = g.getAllTeamdata("13-14", "wins", "ASC");
		Sort sort = new Sort();
		ArrayList<TeamPO> teamPOs2 = sort.Sort(teamPOs, "wins", "ASC");
		boolean notNull = true;
		if (teamPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
}
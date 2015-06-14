package businesslogic.playerbl;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import po.PlayerPO;
import data.getdata.GetPlayerdata;
import dataservice.getdatadataservice.GetPlayerdataDataService;

public class SortTest {
	@Test
	public void SortTest1(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "scoring", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest2(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "scoring", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest3(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "playerName", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest4(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "playerName", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest5(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "team", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest6(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "team", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest7(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "appearance", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest8(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "appearance", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest9(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "firstPlay", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest10(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "firstPlay", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest11(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "backboard", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest12(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "backboard", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest13(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "assist", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest14(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "assist", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest15(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "minutes", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest16(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "minutes", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest17(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "fieldGoalShotPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest18(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "fieldGoalShotPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest19(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "threePointShotPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest20(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "threePointShotPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest21(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "freeThrowPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest22(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "freeThrowPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest23(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "offensiveRebound", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest24(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "offensiveRebound", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest25(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "defensiveRebound", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest26(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "defensiveRebound", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest27(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "steal", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest28(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "steal", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest29(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "block", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest30(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "block", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest31(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "turnOver", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest32(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "turnOver", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest33(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "foul", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest34(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "foul", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest35(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "efficiency", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest36(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "efficiency", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest37(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "GmScEfficiency", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest38(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "GmScEfficiency", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest39(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "trueShootingPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest40(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "trueShootingPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest41(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "shootingEfficiency", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest42(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "shootingEfficiency", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest43(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "backboardPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest44(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "backboardPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest45(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "offensiveReboundPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest46(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "offensiveReboundPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest47(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "defensiveReboundPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest48(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "defensiveReboundPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest49(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "assistPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest50(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "assistPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest51(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "stealPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest52(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "stealPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest53(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "blockPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest54(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "blockPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest55(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "turnOverPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest56(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "turnOverPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest57(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "usage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest58(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "usage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest59(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "nearlyFivePercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest60(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "nearlyFivePercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest61(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "nearlyFiveBackboardPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest62(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "nearlyFiveBackboardPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest63(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "nearlyFiveAssistPercentage", "DESC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	@Test
	public void SortTest64(){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g = new GetPlayerdata();
		playerPOs = g.getAllPlayerdata("13-14", "backboard", "DESC");
		for (int i = 0; i < playerPOs.size(); i++) {
			Calculate calculate = new Calculate();
			playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
		Sort sort = new Sort();
		playerPOs2 = sort.Sort(playerPOs, "nearlyFiveAssistPercentage", "ASC");
		boolean notNull = true;
		if (playerPOs2.size()==0) {
			notNull = false;
		}
		assertTrue(notNull);
	}
	

}

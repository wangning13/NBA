package businesslogic.teambl;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.regexp.recompile;

import po.TeamMatchPO;
import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamMatchVO;
import vo.TeamMonthMatchVO;
import vo.TeamVO;
import vo.TeaminfoVO;
import businesslogicservice.teamblservice.TeamRankService;
import data.getdata.GetTeamdata;
import dataservice.getdatadataservice.GetTeamdataDataService;

public class TeamRank implements TeamRankService{
	DecimalFormat df=new DecimalFormat("#.0000");
	
	private  ArrayList<TeamPO> Ranking(String season,String condition,String order) {
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			teamPOs = g.getSomeTeamdata(season,condition, "wins", order);
			for (int i = 0; i < teamPOs.size(); i++) {
				Calculate calculate = new Calculate();
				teamPOs.set(i, calculate.Calculate(teamPOs.get(i)));
				
			}
	
		return teamPOs;
	}
	
    private ArrayList<TeamVO>  gettingTeamData(String season,String condition, String key,String order) {
    	ArrayList<TeamVO> teamVOs = new ArrayList<TeamVO>();
    	ArrayList<TeamPO> teamPOs2 = null;
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			Sort sort = new Sort();
			teamPOs2 = sort.Sort(this.Ranking(season,condition,order), key, order);
			for (int i = 0; i < teamPOs2.size(); i++) {
				GetTeamVO getTeamVO = new GetTeamVO();
				TeamVO teamVO = getTeamVO.GetTeamVO(teamPOs2.get(i));
				teamVOs.add(teamVO);
			}
		return teamVOs;
	}
    
    public ArrayList<TeamVO>  getTeamData(String season,String condition, String key,String order){
    	ArrayList<TeamVO> teamVOs = gettingTeamData(season,condition, key, order);
    	return teamVOs;
    } 
    
    public TeaminfoVO getTeamInfo(String teamName){
    	TeaminfoPO  teaminfoPO = null;
    	TeaminfoVO teaminfoVO = null;
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			teaminfoPO = g.getTeaminfo(teamName);
			teaminfoVO = new TeaminfoVO(teaminfoPO.getName(), teaminfoPO.getAbbr(), teaminfoPO.getCity(), teaminfoPO.getLeague(), teaminfoPO.getPartition(), teaminfoPO.getCourt(), teaminfoPO.getYear());
			
    	return teaminfoVO;
    }
    
    public TeamVO getTeamData(String season,String teamName){
    	ArrayList<TeamVO> teamVOs = getAllTeamdata(season,"wins", "DESC");
    	int teamRank = 0;
    	TeamVO teamVO = new TeamVO();
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			TeamPO teamPO = g.getTeamdata(season,teamName);
			for (int i = 0; i < teamVOs.size(); i++) {
				if (teamName.equals(teamVOs.get(i).getTeamName())) {
					teamRank = teamVOs.get(i).getRank();
				}
			}
			GetTeamVO getTeamVO = new GetTeamVO();
			
			teamVO = getTeamVO.GetTeamVO(teamPO);
    	return teamVO;
    }
    
    public ArrayList<TeamVO> getAllTeamdata(String season,String key,String order){

    	return this.getTeamData(season,"1", key, order);
    }
	
    public ArrayList<TeamMonthMatchVO> getTeamMonthMatch(String month,String team){
		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = new ArrayList<TeamMonthMatchVO>();
		ArrayList<TeamMatchPO> teamMatchPOs = new ArrayList<TeamMatchPO>();
		GetTeamdataDataService g;
			g = new GetTeamdata();
			teamMatchPOs = g.getTeamMonthMatch(month, team);
			for (int i = 0; i < teamMatchPOs.size(); i++) {
				ArrayList<TeamMatchPO> teamMatchPOs2 = g.getTeamMonthMatch(month, teamMatchPOs.get(i).getOpponent());
				for (int j = 0; j < teamMatchPOs2.size(); j++) {
					if (teamMatchPOs2.get(j).getOpponent().equals(team) && teamMatchPOs2.get(j).getDate().equals(teamMatchPOs.get(i).getDate())) {
						String data = teamMatchPOs.get(i).getDate();
						String host = "";
						String guest = "";
						String score = "";
						String first = "";
						String second = "";
						String third = "";
						String fourth = "";
						if (teamMatchPOs.get(i).getHostGuest().equals("h")) {
							host = team;
							guest = teamMatchPOs2.get(j).getName();
							score = teamMatchPOs.get(i).getTotal() + "-" + teamMatchPOs2.get(j).getTotal();
							first = teamMatchPOs.get(i).getFirst() + "-" + teamMatchPOs2.get(j).getFirst();
							second = teamMatchPOs.get(i).getSecond() + "-" + teamMatchPOs2.get(j).getSecond();
							third = teamMatchPOs.get(i).getThird() + "-" + teamMatchPOs2.get(j).getThird();
							fourth = teamMatchPOs.get(i).getFourth() + "-" + teamMatchPOs2.get(j).getFourth();
						}else {
							host = teamMatchPOs2.get(j).getName();
							guest = team;
							score = teamMatchPOs2.get(j).getTotal() + "-" + teamMatchPOs.get(i).getTotal();
							first = teamMatchPOs2.get(j).getFirst() + "-" + teamMatchPOs.get(i).getFirst();
							second = teamMatchPOs2.get(j).getSecond() + "-" + teamMatchPOs.get(i).getSecond();
							third = teamMatchPOs2.get(j).getThird() + "-" + teamMatchPOs.get(i).getThird();
							fourth = teamMatchPOs2.get(j).getFourth() + "-" + teamMatchPOs.get(i).getFourth();
						}
						
						TeamMonthMatchVO teamMonthMatchVO = new TeamMonthMatchVO(data, host, guest, score, first, second, third, fourth);
						teamMonthMatchVOs.add(teamMonthMatchVO);
					}
				}
				
			}
			
		return teamMonthMatchVOs;
	}
    
    public TeamMatchVO getTeamMatch(String date,String team){
    	TeamMatchVO teamMatchVO = new TeamMatchVO();
    	TeamMatchPO teamMatchPO = new TeamMatchPO();
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			teamMatchPO = g.getTeamMatch(date, team);
			teamMatchVO = new TeamMatchVO(teamMatchPO.getDate(),
					teamMatchPO.getHostGuest(), 
					teamMatchPO.getName(),
					teamMatchPO.getOpponent(),
					teamMatchPO.getWinLose(), 
					teamMatchPO.getTotal(),
					teamMatchPO.getFirst(), 
					teamMatchPO.getSecond(), 
					teamMatchPO.getThird(), 
					teamMatchPO.getFourth());
    	return teamMatchVO;
    }
    
    public ArrayList<TeamMonthMatchVO> getTeamRecentFiveMatch(String season,String team){
    	ArrayList<TeamMatchPO> teamMatchPOs = new ArrayList<TeamMatchPO>();
    	ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = new ArrayList<TeamMonthMatchVO>();
    	GetTeamdataDataService g;
			g = new GetTeamdata();
			teamMatchPOs = g.getTeamRecentFiveMatch(season,team);
			int teamMatchPOsSize = teamMatchPOs.size();
			int number = 0;
			if (teamMatchPOsSize<10) {
				number = teamMatchPOsSize;
			}else {
				number = 10;
			}
			for (int i = 0; i < number/2; i++) {
				String host = "";
				String guest = "";
				String score = "";
				String first = "";
				String second = "";
				String third = "";
				String fourth = "";
				
				if (teamMatchPOs.get(i).getHostGuest().equals("h")) {
					host = team;
					guest = teamMatchPOs.get(i).getOpponent();
					score = teamMatchPOs.get(i).getTotal() + "-" + teamMatchPOs.get(i+number/2).getTotal();
					first = teamMatchPOs.get(i).getFirst() + "-" + teamMatchPOs.get(i+number/2).getFirst();
					second = teamMatchPOs.get(i).getSecond() + "-" + teamMatchPOs.get(i+number/2).getSecond();
					third = teamMatchPOs.get(i).getThird() + "-" + teamMatchPOs.get(i+number/2).getThird();
					fourth = teamMatchPOs.get(i).getFourth() + "-" + teamMatchPOs.get(i+number/2).getFourth();
				}else {
					host = teamMatchPOs.get(i).getOpponent();
					guest = team;
					score = teamMatchPOs.get(i+number/2).getTotal() + "-" + teamMatchPOs.get(i).getTotal();
					first = teamMatchPOs.get(i+number/2).getFirst() + "-" + teamMatchPOs.get(i).getFirst();
					second = teamMatchPOs.get(i+number/2).getSecond() + "-" + teamMatchPOs.get(i).getSecond();
					third = teamMatchPOs.get(i+number/2).getThird() + "-" + teamMatchPOs.get(i).getThird();
					fourth = teamMatchPOs.get(i+number/2).getFourth() + "-" + teamMatchPOs.get(i).getFourth();
				}
				TeamMonthMatchVO teamMonthMatchVO = new TeamMonthMatchVO(
						teamMatchPOs.get(i).getDate(),
						host,
						guest,
						score,
						first,
						second,
						third,
						fourth);
				teamMonthMatchVOs.add(teamMonthMatchVO);
			}
    	return teamMonthMatchVOs;
    }
    
    public ArrayList<TeamVO> getSeasonTop(String season,String condition){
    	ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
    	ArrayList<TeamPO> teamPOs2 = new ArrayList<TeamPO>();
    	ArrayList<TeamVO> teamVOs = new ArrayList<TeamVO>();
    	GetTeamdataDataService g;
 			g = new GetTeamdata();
			teamPOs = g.getAllTeamdata(season, "wins", "DESC");
			int teamPOsSize = teamPOs.size();
			for (int i = 0; i < teamPOs.size(); i++) {
				Calculate calculate = new Calculate();
				teamPOs.set(i, calculate.Calculate(teamPOs.get(i)));
			}
			Sort sort = new Sort();
			teamPOs2 = sort.Sort(teamPOs, condition, "DESC");
			int number = 0;
			if (teamPOsSize<5) {
				number = teamPOsSize;
			}else {
				number = 5;
			}
			for (int i = 0; i < number; i++) {
				GetTeamVO getTeamVO = new GetTeamVO();
				TeamVO teamVO = getTeamVO.GetTeamVO(teamPOs2.get(i));
				teamVOs.add(teamVO);
			}
    	return teamVOs;
    }
    //多元线性回归方程，数组表示 a1,a2,a3,...am,a0,大小m+1
    public double[] LinerRegression(String season) {
    	GetTeamdataDataService g = new GetTeamdata();
		ArrayList<ArrayList<TeamPO>> r = g.getHostGuestdata(season);
		ArrayList<TeamPO> host = r.get(0);
		ArrayList<TeamPO> guest = r.get(1);
		
		int m = 9;
		int n = host.size()+guest.size();
		double[][] x = new double[m][n];
		double[] y = new double[n];
		for (int i = 0; i < host.size(); i++) {
			x[0][i]= 1; 
			x[1][i]= host.get(i).getBackboard();
			x[2][i]= host.get(i).getTurnOver();
			x[3][i]= host.get(i).getFoul();
			x[4][i]= host.get(i).getAssist();
			x[5][i]= host.get(i).getSteal();
			x[6][i]= host.get(i).getBlock();
			x[7][i]= host.get(i).getOpponentDefensiveRebound()+host.get(i).getOpponentOffensiveRebound();
			x[8][i]= host.get(i).getOpponentTurnOver();
			y[i]= host.get(i).getScoring(); 
		}
		for (int i = host.size(); i < n; i++) {
			x[0][i]= -1; 
			x[1][i]= guest.get(i-host.size()).getBackboard();
			x[2][i]= guest.get(i-host.size()).getTurnOver();
			x[3][i]= guest.get(i-host.size()).getFoul();
			x[4][i]= guest.get(i-host.size()).getAssist();
			x[5][i]= guest.get(i-host.size()).getSteal();
			x[6][i]= guest.get(i-host.size()).getBlock();
			x[7][i]= guest.get(i-host.size()).getOpponentDefensiveRebound()+host.get(i-host.size()).getOpponentOffensiveRebound();
			x[8][i]= guest.get(i-host.size()).getOpponentTurnOver();
			y[i]= guest.get(i-host.size()).getScoring(); 
		}
		double[] a = sqt2(x,y,m,n);
		return a;
	}
    
    //偏回归系数，数组表示 m个自变量的偏回归系数
    public double[] RegressionCoefficient(String season) {
    	GetTeamdataDataService g = new GetTeamdata();
		ArrayList<ArrayList<TeamPO>> r = g.getHostGuestdata(season);
		ArrayList<TeamPO> host = r.get(0);
		ArrayList<TeamPO> guest = r.get(1);
		
		int m = 10;
		int n = host.size()+guest.size();
		double[][] x = new double[m][n];
		double[] y = new double[n];
		for (int i = 0; i < host.size(); i++) {
			x[0][i]= 1; 
			x[1][i]= host.get(i).getBackboard();
			x[2][i]= host.get(i).getTurnOver();
			x[3][i]= host.get(i).getFoul();
			x[4][i]= host.get(i).getAssist();
			x[5][i]= host.get(i).getSteal();
			x[6][i]= host.get(i).getBlock();
			x[7][i]= host.get(i).getOpponentDefensiveRebound()+host.get(i).getOpponentOffensiveRebound();
			x[8][i]= host.get(i).getOpponentTurnOver();
			y[i]= host.get(i).getScoring();
		}
		for (int i = host.size(); i < n; i++) {
			x[0][i]= -1; 
			x[1][i]= guest.get(i-host.size()).getBackboard();
			x[2][i]= guest.get(i-host.size()).getTurnOver();
			x[3][i]= guest.get(i-host.size()).getFoul();
			x[4][i]= guest.get(i-host.size()).getAssist();
			x[5][i]= guest.get(i-host.size()).getSteal();
			x[6][i]= guest.get(i-host.size()).getBlock();
			x[7][i]= guest.get(i-host.size()).getOpponentDefensiveRebound()+host.get(i-host.size()).getOpponentOffensiveRebound();
			x[8][i]= guest.get(i-host.size()).getOpponentTurnOver();
			y[i]= guest.get(i-host.size()).getScoring(); 
		}
		double[] v=  sqt3(x,y,m,n);
		return v;
	}
    
    /**
	 * 多元线性回归分析
	 * 
	 * @param x[m][n]
	 *            每一列存放m个自变量的观察值
	 * @param y[n]
	 *            存放随即变量y的n个观察值
	 * @param m
	 *            自变量的个数
	 * @param n
	 *            观察数据的组数
	 * @param a
	 *            返回回归系数a0,...,am
	 * @param dt[4]
	 *            dt[0]偏差平方和q,dt[1] 平均标准偏差s dt[2]返回复相关系数r dt[3]返回回归平方和u
	 * @param v[m]
	 *            返回m个自变量的偏相关系数
	 */
    
    public static double[]  sqt4(double[][] x, double[] y, int m, int n) {
    	double[] a = new double[m+1];
    	double[] dt = new double[4];
    	double[] v = new double[m];
		int i, j, k, mm;
		double q, e, u, p, yy, s, r, pp;
		double[] b = new double[(m + 1) * (m + 1)];
		mm = m + 1;
		b[mm * mm - 1] = n;
		for (j = 0; j <= m - 1; j++) {
			p = 0.0;
			for (i = 0; i <= n - 1; i++)
				p = p + x[j][i];
			b[m * mm + j] = p;
			b[j * mm + m] = p;
		}
		for (i = 0; i <= m - 1; i++)
			for (j = i; j <= m - 1; j++) {
				p = 0.0;
				for (k = 0; k <= n - 1; k++)
					p = p + x[i][k] * x[j][k];
				b[j * mm + i] = p;
				b[i * mm + j] = p;
			}
		a[m] = 0.0;
		for (i = 0; i <= n - 1; i++)
			a[m] = a[m] + y[i];
		for (i = 0; i <= m - 1; i++) {
			a[i] = 0.0;
			for (j = 0; j <= n - 1; j++)
				a[i] = a[i] + x[i][j] * y[j];
		}
		chlk(b, mm, 1, a);
		yy = 0.0;
		for (i = 0; i <= n - 1; i++)
			yy = yy + y[i] / n;
		q = 0.0;
		e = 0.0;
		u = 0.0;
		for (i = 0; i <= n - 1; i++) {
			p = a[m];
			for (j = 0; j <= m - 1; j++)
				p = p + a[j] * x[j][i];
			q = q + (y[i] - p) * (y[i] - p);
			e = e + (y[i] - yy) * (y[i] - yy);
			u = u + (yy - p) * (yy - p);
		}
		s = Math.sqrt(q / n);
		r = Math.sqrt(1.0 - q / e);
		for (j = 0; j <= m - 1; j++) {
			p = 0.0;
			for (i = 0; i <= n - 1; i++) {
				pp = a[m];
				for (k = 0; k <= m - 1; k++)
					if (k != j)
						pp = pp + a[k] * x[k][i];
				p = p + (y[i] - pp) * (y[i] - pp);
			}
			v[j] = Math.sqrt(1.0 - q / p);
		}
		dt[0] = q;
		dt[1] = s;
		dt[2] = r;
		dt[3] = u;
		return dt;
    }
    
    public static double[]  sqt3(double[][] x, double[] y, int m, int n) {
    	double[] a = new double[m+1];
    	double[] dt = new double[4];
    	double[] v = new double[m];
		int i, j, k, mm;
		double q, e, u, p, yy, s, r, pp;
		double[] b = new double[(m + 1) * (m + 1)];
		mm = m + 1;
		b[mm * mm - 1] = n;
		for (j = 0; j <= m - 1; j++) {
			p = 0.0;
			for (i = 0; i <= n - 1; i++)
				p = p + x[j][i];
			b[m * mm + j] = p;
			b[j * mm + m] = p;
		}
		for (i = 0; i <= m - 1; i++)
			for (j = i; j <= m - 1; j++) {
				p = 0.0;
				for (k = 0; k <= n - 1; k++)
					p = p + x[i][k] * x[j][k];
				b[j * mm + i] = p;
				b[i * mm + j] = p;
			}
		a[m] = 0.0;
		for (i = 0; i <= n - 1; i++)
			a[m] = a[m] + y[i];
		for (i = 0; i <= m - 1; i++) {
			a[i] = 0.0;
			for (j = 0; j <= n - 1; j++)
				a[i] = a[i] + x[i][j] * y[j];
		}
		chlk(b, mm, 1, a);
		yy = 0.0;
		for (i = 0; i <= n - 1; i++)
			yy = yy + y[i] / n;
		q = 0.0;
		e = 0.0;
		u = 0.0;
		for (i = 0; i <= n - 1; i++) {
			p = a[m];
			for (j = 0; j <= m - 1; j++)
				p = p + a[j] * x[j][i];
			q = q + (y[i] - p) * (y[i] - p);
			e = e + (y[i] - yy) * (y[i] - yy);
			u = u + (yy - p) * (yy - p);
		}
		s = Math.sqrt(q / n);
		r = Math.sqrt(1.0 - q / e);
		for (j = 0; j <= m - 1; j++) {
			p = 0.0;
			for (i = 0; i <= n - 1; i++) {
				pp = a[m];
				for (k = 0; k <= m - 1; k++)
					if (k != j)
						pp = pp + a[k] * x[k][i];
				p = p + (y[i] - pp) * (y[i] - pp);
			}
			v[j] = Math.sqrt(1.0 - q / p);
		}
		dt[0] = q;
		dt[1] = s;
		dt[2] = r;
		dt[3] = u;
		return v;
	}

    public static double[]  sqt2(double[][] x, double[] y, int m, int n) {
    	double[] a = new double[m+1];
    	double[] dt = new double[4];
    	double[] v = new double[m];
		int i, j, k, mm;
		double q, e, u, p, yy, s, r, pp;
		double[] b = new double[(m + 1) * (m + 1)];
		mm = m + 1;
		b[mm * mm - 1] = n;
		for (j = 0; j <= m - 1; j++) {
			p = 0.0;
			for (i = 0; i <= n - 1; i++)
				p = p + x[j][i];
			b[m * mm + j] = p;
			b[j * mm + m] = p;
		}
		for (i = 0; i <= m - 1; i++)
			for (j = i; j <= m - 1; j++) {
				p = 0.0;
				for (k = 0; k <= n - 1; k++)
					p = p + x[i][k] * x[j][k];
				b[j * mm + i] = p;
				b[i * mm + j] = p;
			}
		a[m] = 0.0;
		for (i = 0; i <= n - 1; i++)
			a[m] = a[m] + y[i];
		for (i = 0; i <= m - 1; i++) {
			a[i] = 0.0;
			for (j = 0; j <= n - 1; j++)
				a[i] = a[i] + x[i][j] * y[j];
		}
		chlk(b, mm, 1, a);
		yy = 0.0;
		for (i = 0; i <= n - 1; i++)
			yy = yy + y[i] / n;
		q = 0.0;
		e = 0.0;
		u = 0.0;
		for (i = 0; i <= n - 1; i++) {
			p = a[m];
			for (j = 0; j <= m - 1; j++)
				p = p + a[j] * x[j][i];
			q = q + (y[i] - p) * (y[i] - p);
			e = e + (y[i] - yy) * (y[i] - yy);
			u = u + (yy - p) * (yy - p);
		}
		s = Math.sqrt(q / n);
		r = Math.sqrt(1.0 - q / e);
		for (j = 0; j <= m - 1; j++) {
			p = 0.0;
			for (i = 0; i <= n - 1; i++) {
				pp = a[m];
				for (k = 0; k <= m - 1; k++)
					if (k != j)
						pp = pp + a[k] * x[k][i];
				p = p + (y[i] - pp) * (y[i] - pp);
			}
			v[j] = Math.sqrt(1.0 - q / p);
		}
		dt[0] = q;
		dt[1] = s;
		dt[2] = r;
		dt[3] = u;
		return a;
	}

	private static int chlk(double[] a, int n, int m, double[] d) {
		int i, j, k, u, v;
		if ((a[0] + 1.0 == 1.0) || (a[0] < 0.0)) {
			System.out.println("fail\n");
			return (-2);
		}
		a[0] = Math.sqrt(a[0]);
		for (j = 1; j <= n - 1; j++)
			a[j] = a[j] / a[0];
		for (i = 1; i <= n - 1; i++) {
			u = i * n + i;
			for (j = 1; j <= i; j++) {
				v = (j - 1) * n + i;
				a[u] = a[u] - a[v] * a[v];
			}
			if ((a[u] + 1.0 == 1.0) || (a[u] < 0.0)) {
				System.out.println("fail\n");
				return (-2);
			}
			a[u] = Math.sqrt(a[u]);
			if (i != (n - 1)) {
				for (j = i + 1; j <= n - 1; j++) {
					v = i * n + j;
					for (k = 1; k <= i; k++)
						a[v] = a[v] - a[(k - 1) * n + i] * a[(k - 1) * n + j];
					a[v] = a[v] / a[u];
				}
			}
		}
		for (j = 0; j <= m - 1; j++) {
			d[j] = d[j] / a[0];
			for (i = 1; i <= n - 1; i++) {
				u = i * n + i;
				v = i * m + j;
				for (k = 1; k <= i; k++)
					d[v] = d[v] - a[(k - 1) * n + i] * d[(k - 1) * m + j];
				d[v] = d[v] / a[u];
			}
		}
		for (j = 0; j <= m - 1; j++) {
			u = (n - 1) * m + j;
			d[u] = d[u] / a[n * n - 1];
			for (k = n - 1; k >= 1; k--) {
				u = (k - 1) * m + j;
				for (i = k; i <= n - 1; i++) {
					v = (k - 1) * n + i;
					d[u] = d[u] - a[v] * d[i * m + j];
				}
				v = (k - 1) * n + k - 1;
				d[u] = d[u] / a[v];
			}
		}
		return (2);
	}
	
	//研究主客场对球队最终得分的影响结果是否显著
	public double[] HostOrGuest(String season) {
		double[] a = new double[5];
		GetTeamdataDataService g = new GetTeamdata();
		ArrayList<ArrayList<TeamPO>> teampoList = g.getHostGuestdata(season);
		ArrayList<TeamPO> host = teampoList.get(0);
		ArrayList<TeamPO> guest = teampoList.get(1);
		int r = host.size();
		double[] x = new double[host.size()];
		double[] y = new double[guest.size()];
		for (int i = 0; i < x.length; i++) {
			x[i] = host.get(i).getScoring();
		}
		for (int i = 0; i < y.length; i++) {
			y[i] = guest.get(i).getScoring();
		}
		double x_all = 0.0;
		for (int i = 0; i < x.length; i++) {
			x_all = x_all + x[i];
		}
		double y_all = 0.0;
		for (int i = 0; i < y.length; i++) {
			y_all = y_all + y[i];
		}
		double x_average = 	(double)x_all/x.length;	
		double y_average = (double)y_all/y.length;
		double xy_average = (double)(x_all+y_all)/(x.length+y.length);
		double St = 0;//总偏差平方和
		for (int i = 0; i < x.length; i++) {
			St = St + (x[i]-xy_average)*(x[i]-xy_average);
		}
		for (int i = 0; i < y.length; i++) {
			St = St + (y[i]-xy_average)*(y[i]-xy_average);
		}
		double Sa = 0;//水平间偏差平方和
		Sa = Sa + (x_average-xy_average)*(x_average-xy_average);
		Sa = Sa + (y_average-xy_average)*(y_average-xy_average);
		Sa = Sa*r;
		double Se = 0;//水平内偏差平方和
		for (int i = 0; i < r; i++) {
			Se = Se + (x[i]-x_average)*(x[i]-x_average);
		}
		for (int i = 0; i < r; i++) {
			Se = Se + (y[i]-y_average)*(y[i]-y_average);
		}
		int ft = 2*r-1;//St的自由度
		int fa = 1;//Sa的自由度
		int fe = 2*r-2;//Se的自由度
		double Va = Sa/fa;
		double Ve = Se/fe;
		double F = Va/Ve;
		
		
		
		return a;
	}



}


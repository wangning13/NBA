package vo;

public class TeamVO {
	int rank;
	int opponentFieldGoal;// 对手投篮命中数
	int opponentFieldGoalAttempts;// 对手投篮出手次数
	int opponentTurnOver;// 对手失误数
	int opponentFreeThrowAttempts;// 对手罚球数
	int oppenentScoring;// 对手得分
	String teamName;// 球队名称
	int matches;// 比赛场数
	int wins;// 胜利场数
	int fieldGoal;// 投篮命中数
	double averageFieldGoal;// 场均投篮命中数
	int fieldGoalAttempts;// 投篮出手次数
	double averageFieldGoalAttempts;// 场均投篮出手次数
	int threePointFieldGoal;// 三分命中数
	double averageThreePointFieldGoal;// 场均三分命中数
	int threePointFieldGoalAttempts;// 三分出手数
	double averageThreePointFieldGoalAttempts;// 场均三分出手数
	int freeThrow;// 罚球命中数
	double averageFreeThrow;// 场均罚球命中数
	int freeThrowAttempts;// 罚球出手数
	double averageFreeThrowAttempts;// 场均罚球出手数
	int offensiveRebound;// 进攻篮板数
	double averageOffensiveRebound;// 场均进攻篮板数
	int defensiveRebound;// 防守篮板数
	double averageDefensiveRebound;// 场均防守篮板数
	int opponentOffensiveRebound;// 对手进攻篮板数
	double averageOpponentOffensiveRebound;// 场均对手进攻篮板数
	int opponentDefensiveRebound;// 对手防守篮板数
	double averageOpponentDffensiveRebound;// 场均对手防守篮板数
	int backboard;// 篮板数
	double averageBackboard;// 场均篮板数
	int assist;// 助攻数
	double averageAsist;// 场均助攻数
	int steal;// 抢断数
	double averageSteal;// 场均抢断数
	int block;// 盖帽数
	double averageBlock;// 场均盖帽数
	int turnOver;// 失误数
	double averageTurnOver;// 场均失误数
	int foul;// 犯规数
	double averageFoul;// 场均犯规数
	int scoring;// 比赛得分
	double averageScoring;// 场均比赛得分

	double fieldGoalPercentage;// 投篮命中率
	double threePointShotPercentage;// 三分命中率
	double freeThrowPercentage;// 三分命中率
	double winningPercentage;// 胜率
	double possessions;// 进攻回合
	double offensiveEfficiency;// 进攻效率
	double defensiveEfficiency;// 防守效率
	double offensivebackboardEfficiency;// 进攻篮板效率
	double defensivebackboardEfficiency;// 防守篮板效率
	double stealEfficiency;// 抢断效率
	double assistEfficiency;// 助攻效率

	public TeamVO(int rank, int opponentFieldGoal,
			int opponentFieldGoalAttempts, int opponentTurnOver,
			int opponentFreeThrowAttempts, int oppenentScoring,
			String teamName, int matches, int wins, int fieldGoal,
			double averageFieldGoal, int fieldGoalAttempts,
			double averageFieldGoalAttempts, int threePointFieldGoal,
			double averageThreePointFieldGoal, int threePointFieldGoalAttempts,
			double averageThreePointFieldGoalAttempts, int freeThrow,
			double averageFreeThrow, int freeThrowAttempts,
			double averageFreeThrowAttempts, int offensiveRebound,
			double averageOffensiveRebound, int defensiveRebound,
			double averageDefensiveRebound, int opponentOffensiveRebound,
			double averageOpponentOffensiveRebound,
			int opponentDefensiveRebound,
			double averageOpponentDffensiveRebound, int backboard,
			double averageBackboard, int assist, double averageAsist,
			int steal, double averageSteal, int block, double averageBlock,
			int turnOver, double averageTurnOver, int foul, double averageFoul,
			int scoring, double averageScoring, double fieldGoalPercentage,
			double threePointShotPercentage, double freeThrowPercentage,
			double winningPercentage, double possessions,
			double offensiveEfficiency, double defensiveEfficiency,
			double offensivebackboardEfficiency,
			double defensivebackboardEfficiency, double stealEfficiency,
			double assistEfficiency) {
		super();
		this.rank = rank;
		this.opponentFieldGoal = opponentFieldGoal;
		this.opponentFieldGoalAttempts = opponentFieldGoalAttempts;
		this.opponentTurnOver = opponentTurnOver;
		this.opponentFreeThrowAttempts = opponentFreeThrowAttempts;
		this.oppenentScoring = oppenentScoring;
		this.teamName = teamName;
		this.matches = matches;
		this.wins = wins;
		this.fieldGoal = fieldGoal;
		this.averageFieldGoal = averageFieldGoal;
		this.fieldGoalAttempts = fieldGoalAttempts;
		this.averageFieldGoalAttempts = averageFieldGoalAttempts;
		this.threePointFieldGoal = threePointFieldGoal;
		this.averageThreePointFieldGoal = averageThreePointFieldGoal;
		this.threePointFieldGoalAttempts = threePointFieldGoalAttempts;
		this.averageThreePointFieldGoalAttempts = averageThreePointFieldGoalAttempts;
		this.freeThrow = freeThrow;
		this.averageFreeThrow = averageFreeThrow;
		this.freeThrowAttempts = freeThrowAttempts;
		this.averageFreeThrowAttempts = averageFreeThrowAttempts;
		this.offensiveRebound = offensiveRebound;
		this.averageOffensiveRebound = averageOffensiveRebound;
		this.defensiveRebound = defensiveRebound;
		this.averageDefensiveRebound = averageDefensiveRebound;
		this.opponentOffensiveRebound = opponentOffensiveRebound;
		this.averageOpponentOffensiveRebound = averageOpponentOffensiveRebound;
		this.opponentDefensiveRebound = opponentDefensiveRebound;
		this.averageOpponentDffensiveRebound = averageOpponentDffensiveRebound;
		this.backboard = backboard;
		this.averageBackboard = averageBackboard;
		this.assist = assist;
		this.averageAsist = averageAsist;
		this.steal = steal;
		this.averageSteal = averageSteal;
		this.block = block;
		this.averageBlock = averageBlock;
		this.turnOver = turnOver;
		this.averageTurnOver = averageTurnOver;
		this.foul = foul;
		this.averageFoul = averageFoul;
		this.scoring = scoring;
		this.averageScoring = averageScoring;
		this.fieldGoalPercentage = fieldGoalPercentage;
		this.threePointShotPercentage = threePointShotPercentage;
		this.freeThrowPercentage = freeThrowPercentage;
		this.winningPercentage = winningPercentage;
		this.possessions = possessions;
		this.offensiveEfficiency = offensiveEfficiency;
		this.defensiveEfficiency = defensiveEfficiency;
		this.offensivebackboardEfficiency = offensivebackboardEfficiency;
		this.defensivebackboardEfficiency = defensivebackboardEfficiency;
		this.stealEfficiency = stealEfficiency;
		this.assistEfficiency = assistEfficiency;
	}

	public TeamVO() {
		// TODO Auto-generated constructor stub
	}

	public int getRank() {
		return rank;
	}

	public int getOpponentFieldGoal() {
		return opponentFieldGoal;
	}

	public int getOpponentFieldGoalAttempts() {
		return opponentFieldGoalAttempts;
	}

	public int getOpponentTurnOver() {
		return opponentTurnOver;
	}

	public int getOpponentFreeThrowAttempts() {
		return opponentFreeThrowAttempts;
	}

	public int getOppenentScoring() {
		return oppenentScoring;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getMatches() {
		return matches;
	}

	public int getWins() {
		return wins;
	}

	public int getFieldGoal() {
		return fieldGoal;
	}

	public double getAverageFieldGoal() {
		return averageFieldGoal;
	}

	public int getFieldGoalAttempts() {
		return fieldGoalAttempts;
	}

	public double getAverageFieldGoalAttempts() {
		return averageFieldGoalAttempts;
	}

	public int getThreePointFieldGoal() {
		return threePointFieldGoal;
	}

	public double getAverageThreePointFieldGoal() {
		return averageThreePointFieldGoal;
	}

	public int getThreePointFieldGoalAttempts() {
		return threePointFieldGoalAttempts;
	}

	public double getAverageThreePointFieldGoalAttempts() {
		return averageThreePointFieldGoalAttempts;
	}

	public int getFreeThrow() {
		return freeThrow;
	}

	public double getAverageFreeThrow() {
		return averageFreeThrow;
	}

	public int getFreeThrowAttempts() {
		return freeThrowAttempts;
	}

	public double getAverageFreeThrowAttempts() {
		return averageFreeThrowAttempts;
	}

	public int getOffensiveRebound() {
		return offensiveRebound;
	}

	public double getAverageOffensiveRebound() {
		return averageOffensiveRebound;
	}

	public int getDefensiveRebound() {
		return defensiveRebound;
	}

	public double getAverageDefensiveRebound() {
		return averageDefensiveRebound;
	}

	public int getOpponentOffensiveRebound() {
		return opponentOffensiveRebound;
	}

	public double getAverageOpponentOffensiveRebound() {
		return averageOpponentOffensiveRebound;
	}

	public int getOpponentDefensiveRebound() {
		return opponentDefensiveRebound;
	}

	public double getAverageOpponentDffensiveRebound() {
		return averageOpponentDffensiveRebound;
	}

	public int getBackboard() {
		return backboard;
	}

	public double getAverageBackboard() {
		return averageBackboard;
	}

	public int getAssist() {
		return assist;
	}

	public double getAverageAsist() {
		return averageAsist;
	}

	public int getSteal() {
		return steal;
	}

	public double getAverageSteal() {
		return averageSteal;
	}

	public int getBlock() {
		return block;
	}

	public double getAverageBlock() {
		return averageBlock;
	}

	public int getTurnOver() {
		return turnOver;
	}

	public double getAverageTurnOver() {
		return averageTurnOver;
	}

	public int getFoul() {
		return foul;
	}

	public double getAverageFoul() {
		return averageFoul;
	}

	public int getScoring() {
		return scoring;
	}

	public double getAverageScoring() {
		return averageScoring;
	}

	public double getFieldGoalPercentage() {
		return fieldGoalPercentage;
	}

	public double getThreePointShotPercentage() {
		return threePointShotPercentage;
	}

	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	public double getWinningPercentage() {
		return winningPercentage;
	}

	public double getPossessions() {
		return possessions;
	}

	public double getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public double getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public double getOffensivebackboardEfficiency() {
		return offensivebackboardEfficiency;
	}

	public double getDefensivebackboardEfficiency() {
		return defensivebackboardEfficiency;
	}

	public double getStealEfficiency() {
		return stealEfficiency;
	}

	public double getAssistEfficiency() {
		return assistEfficiency;
	}


}

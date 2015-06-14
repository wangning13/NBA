package vo;

public class PlayerMatchVO {
	String date;
	String team;
	String playername;
	String position;
	double minutes;
	int fieldGoal;
	int fieldGoalAttempts;
	int threepointFieldGoal;
	int threepointFieldGoalAttempts;
	int freeThrow;
	int freeThrowAttempts;
	int offensiveRebound;
	int defensiveRebound;
	int backboard;
	int assist;
	int steal;
	int block;
	int turnOver;
	int foul;
	int scoring;

	public PlayerMatchVO(String date, String team, String playername,
			String position, double minutes, int fieldGoal,
			int fieldGoalAttempts, int threepointFieldGoal,
			int threepointFieldGoalAttempts, int freeThrow,
			int freeThrowAttempts, int offensiveRebound, int defensiveRebound,
			int backboard, int assist, int steal, int block, int turnOver,
			int foul, int scoring) {
		super();
		this.date = date;
		this.team = team;
		this.playername = playername;
		this.position = position;
		this.minutes = minutes;
		this.fieldGoal = fieldGoal;
		this.fieldGoalAttempts = fieldGoalAttempts;
		this.threepointFieldGoal = threepointFieldGoal;
		this.threepointFieldGoalAttempts = threepointFieldGoalAttempts;
		this.freeThrow = freeThrow;
		this.freeThrowAttempts = freeThrowAttempts;
		this.offensiveRebound = offensiveRebound;
		this.defensiveRebound = defensiveRebound;
		this.backboard = backboard;
		this.assist = assist;
		this.steal = steal;
		this.block = block;
		this.turnOver = turnOver;
		this.foul = foul;
		this.scoring = scoring;
	}

	public String getDate() {
		return date;
	}

	public String getTeam() {
		return team;
	}

	public String getPlayername() {
		return playername;
	}

	public String getPosition() {
		return position;
	}

	public double getMinutes() {
		return minutes;
	}

	public int getFieldGoal() {
		return fieldGoal;
	}

	public int getFieldGoalAttempts() {
		return fieldGoalAttempts;
	}

	public int getThreepointFieldGoal() {
		return threepointFieldGoal;
	}

	public int getThreepointFieldGoalAttempts() {
		return threepointFieldGoalAttempts;
	}

	public int getFreeThrow() {
		return freeThrow;
	}

	public int getFreeThrowAttempts() {
		return freeThrowAttempts;
	}

	public int getOffensiveRebound() {
		return offensiveRebound;
	}

	public int getDefensiveRebound() {
		return defensiveRebound;
	}

	public int getBackboard() {
		return backboard;
	}


	public int getAssist() {
		return assist;
	}

	public int getSteal() {
		return steal;
	}

	public int getBlock() {
		return block;
	}

	public int getTurnOver() {
		return turnOver;
	}

	public int getFoul() {
		return foul;
	}


	public int getScoring() {
		return scoring;
	}


}

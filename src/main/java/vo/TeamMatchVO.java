package vo;

import java.io.Serializable;

public class TeamMatchVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;
	String hostGuest;
	String name;
	String opponent;
	String winLose;
	int total;
	int first;
	int second;
	int third;
	int fourth;

	public TeamMatchVO(String date, String hostGuest, String name,
			String opponent, String winLose, int total, int first, int second,
			int third, int fourth) {
		super();
		this.date = date;
		this.hostGuest = hostGuest;
		this.name = name;
		this.opponent = opponent;
		this.winLose = winLose;
		this.total = total;
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}

	public TeamMatchVO() {
		// TODO Auto-generated constructor stub
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDate() {
		return date;
	}

	public String getHostGuest() {
		return hostGuest;
	}

	public String getName() {
		return name;
	}

	public String getOpponent() {
		return opponent;
	}

	public String getWinLose() {
		return winLose;
	}

	public int getTotal() {
		return total;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public int getThird() {
		return third;
	}

	public int getFourth() {
		return fourth;
	}

}

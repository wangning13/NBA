package vo;

public class TeamMonthMatchVO {
	String date;
	String host;
	String guest;
	String score;
	String first;
	String second;
	String third;
	String fourth;

	public TeamMonthMatchVO(String date, String host, String guest,
			String score, String first, String second, String third,
			String fourth) {
		super();
		this.date = date;
		this.host = host;
		this.guest = guest;
		this.score = score;
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}

	public String getDate() {
		return date;
	}

	public String getHost() {
		return host;
	}

	public String getGuest() {
		return guest;
	}

	public String getScore() {
		return score;
	}

	public String getFirst() {
		return first;
	}

	public String getSecond() {
		return second;
	}

	public String getThird() {
		return third;
	}

	public String getFourth() {
		return fourth;
	}

	
}

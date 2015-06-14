package vo;

public class PlayerinfoVO {
	String name;// 球员姓名
	String number;// 球员号码
	String position;// 球员位置
	String height;// 球员身高
	int weight;// 球员体重
	String birth;// 球员生日
	int age;// 球员年龄
	String exp;// 球龄
	String school;// 学校

	public PlayerinfoVO(String name, String number, String position,
			String height, int weight, String birth, int age, String exp,
			String school) {
		super();
		this.name = name;
		this.number = number;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.birth = birth;
		this.age = age;
		this.exp = exp;
		this.school = school;
	}

	public PlayerinfoVO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	

	public String getNumber() {
		return number;
	}

	

	public String getPosition() {
		return position;
	}

	

	public String getHeight() {
		return height;
	}

	

	public int getWeight() {
		return weight;
	}

	

	public String getBirth() {
		return birth;
	}

	

	public int getAge() {
		return age;
	}

	

	public String getExp() {
		return exp;
	}

	

	public String getSchool() {
		return school;
	}

	

}

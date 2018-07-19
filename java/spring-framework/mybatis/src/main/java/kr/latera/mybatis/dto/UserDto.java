package kr.latera.mybatis.dto;

public class UserDto {
	private String userid;
	private String name;
	private String gender;
	private String city;

	public String getUserid() { return userid; }
	public String getName() { return name; }
	public String getGender() { return gender; }
	public String getCity() { return city; }
	
	public void setUserid(String userid) { this.userid = userid; }
	public void setName(String name) { this.name = name; }
	public void setGender(String gender) { this.gender = gender; }
	public void setCity(String city) { this.city = city; }
	
	@Override
	public String toString() {
		return "User [ userid=" + userid + ", name=" + name + ", gender=" + gender + ", city=" + city + " ]";
	}
}

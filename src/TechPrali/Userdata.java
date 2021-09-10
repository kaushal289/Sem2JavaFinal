package TechPrali;

public class Userdata {
	String username;
	String fullname;
	String email;
	String gender;
	String pass;
	String conpass;
	public Userdata(String username, String fullname, String email, String gender, String pass, String conpass) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.gender = gender;
		this.pass = pass;
		this.conpass = conpass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getConpass() {
		return conpass;
	}
	public void setConpass(String conpass) {
		this.conpass = conpass;
	}

}

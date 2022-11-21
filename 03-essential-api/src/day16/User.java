package day16;

public class User {

	private String name;
	private String Role;
	public User(String name, String role) {
		super();
		this.name = name;
		Role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	
	public boolean IsStaff() {
		return this.Role.equals("staff");
	}
	
}

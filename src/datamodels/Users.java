package datamodels;

public class Users implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2708559776383981928L;
	private Integer id;
	private String name;
	private String email;
	private Integer age;
	private String phone;
	private String password;
	private String city;
	
	public Users() {
		
	}

	public Users(Integer id, String name, String email, Integer age, String phone, String password, String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.phone = phone;
		this.password = password;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}

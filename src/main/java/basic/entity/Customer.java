package basic.entity;

public class Customer {
	private String fullName;
	private String address;
	private String phone;
	private String password;
	private String userName;
	
	public Customer() {
	}
	
	public Customer(String fullName, String address, String phone, String password, String userName) {
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
		this.password = password;
		this.userName = userName;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Customer [fullName=" + fullName + ", address=" + address + ", phone="
				+ phone + "]";
	}
	
}

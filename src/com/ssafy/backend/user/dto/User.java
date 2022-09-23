package com.ssafy.backend.user.dto;

public class User {
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private int delflag;
	private int role;
	
	public User() {}
	public User(String id, String password, String name, String address, String phone, int delflag, int role) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.delflag = delflag;
		this.role = role;
	}
	public User(String id, String password, String name, int delflag, int role) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.delflag = delflag;
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getDelflag() {
		return delflag;
	}
	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", delflag=" + delflag + ", role=" + role + "]";
	}
	
}

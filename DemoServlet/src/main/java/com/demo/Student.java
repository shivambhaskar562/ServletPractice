package com.demo;

public class Student {
	String fname;
	String lname;
	String email;
	int age;
	
	public Student(String fname, String lname, String email, int age) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.age = age;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

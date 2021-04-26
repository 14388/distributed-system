package model;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private String gender;
	private String age;
	private String idnum;

	
	public Student(String name, String gender, String age, String idnum) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.idnum = idnum;
	}
	
	public Student() {
		this("","","","");
	}
	
	public String getName() {
		return this.name;		
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public String getAge() {
		return this.age;		
	}
	
	public String getIdnum() {
		return this.idnum;
	}
	
	
}

package cn.jhc.entity;

import java.sql.Date;

public class Student {
	private Integer id;
	private String name;
	private String sex;
	private Date birth;
	
	public Student(Integer id, String name, String sex, Date birth) {
		
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
	}
	public Student() {
		// TODO Auto-generated constructor stub
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", birth=" + birth + "]";
	}
	
}

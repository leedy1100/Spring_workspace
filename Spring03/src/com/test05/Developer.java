package com.test05;

public class Developer {

	private Emp emp;
	private String dept;

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String toString() {
		return emp + "\t 부서 : " + dept;
	}
}

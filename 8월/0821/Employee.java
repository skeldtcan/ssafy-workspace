package com.ssafy.java.day0821;

public class Employee {
	private int empNo;
	private String name;
	private String position;
	private String dept;
	
	public Employee(int empNo, String name, String position, String dept) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.position = position;
		this.dept = dept;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [empNo=").append(empNo).append(", name=").append(name).append(", position=")
				.append(position).append(", dept=").append(dept).append("]");
		return builder.toString();
	}
	
	

}

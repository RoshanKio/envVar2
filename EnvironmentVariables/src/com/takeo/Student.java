package com.takeo;

import java.io.Serializable;

import java.time.Year;

public class Student implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	private int student_Id;
	private String department;
	private String first_Name;
	private String last_Name;
	private Year passOutYear;
	private int universityRank;
	
	@Override
	public String toString() {
		return "[student_Id="+student_Id+", department="+department+", first_Name="+first_Name+", last_Name="+last_Name+", passOutYear="+passOutYear+", universityRank="+universityRank+"]";
	}

	public int getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}

	public String getDepartmrnt() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFirst_Name() {
		return this.first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public Year getPassOutYear() {
		return passOutYear;
	}

	public void setPassOutYear(Year passOutYear) {
		this.passOutYear = passOutYear;
	}

	public int getUniversityRank() {
		return universityRank;
	}

	public void setUniversityRank(int universityRank) {
		this.universityRank = universityRank;
	}

	public void setInt(int i) {
		int j = (this.student_Id == 0) ? (0) : (1);
		if (j == 0) {
			this.student_Id = i;
		} else {
			this.universityRank = i;
		}

	}

	public void setString(String str) {
		int i = (this.department == null) ? (0) : (1);
		if (i == 0) {
			this.department = str;
		} else {
			int j = (this.first_Name == null) ? (0) : (1);
			if (j == 0) {
				this.first_Name = str;
			} else {
				this.last_Name = str;
			}
		}

	}

	public void setYear(Year year) {
		this.setPassOutYear(year);
	}

	
	
	public Student() {

	}

	public Student(int student_Id, String department, String first_Name, String last_Name, Year passOutYear,
			int universityRank) {
		this.student_Id = student_Id;
		this.department = department;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.passOutYear = passOutYear;

	}

}

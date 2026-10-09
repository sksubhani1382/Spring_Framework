package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_gardian_infor")
public class StudentGardianInfo
{
	@Id
	@Column(name="gid")
	private int gid;
	
	@Column(name="gfirstName")
	private String gfirstName;
	
	@Column(name="gmiddleName")
	private String gmiddleString;
	
	@Column(name="glastName")
	private String glastName;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGfirstName() {
		return gfirstName;
	}

	public void setGfirstName(String gfirstName) {
		this.gfirstName = gfirstName;
	}

	public String getGmiddleString() {
		return gmiddleString;
	}

	public void setGmiddleString(String gmiddleString) {
		this.gmiddleString = gmiddleString;
	}

	public String getGlastName() {
		return glastName;
	}

	public void setGlastName(String glastName) {
		this.glastName = glastName;
	}
	
	

}

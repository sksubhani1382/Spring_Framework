package com.dest.dto;

public class InterviewBean 
{
	private String IName;
	private String IType;
	private int noOfVac;
	
	private RoundBean bean;

	public String getIName() {
		return IName;
	}

	public void setIName(String iName) {
		IName = iName;
	}

	public String getIType() {
		return IType;
	}

	public void setIType(String iType) {
		IType = iType;
	}

	public int getNoOfVac() {
		return noOfVac;
	}

	public void setNoOfVac(int noOfVac) {
		this.noOfVac = noOfVac;
	}

	public RoundBean getBean() {
		return bean;
	}

	public void setBean(RoundBean bean) {
		this.bean = bean;
	}
	
	
	

}

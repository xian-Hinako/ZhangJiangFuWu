package com.VolunServices.tools;

public class WriteRecordToExcel {
	
	private Integer WRuid;
	
	private String WRuiname;
	
	private String WRtel;
	
	private float WRpersonduration;
	
	private String WRremark;

	public Integer getWRuid() {
		return WRuid;
	}

	public void setWRuid(Integer wRuid) {
		WRuid = wRuid;
	}

	public String getWRuiname() {
		return WRuiname;
	}

	public void setWRuiname(String wRuiname) {
		WRuiname = wRuiname;
	}

	public String getWRtel() {
		return WRtel;
	}

	public void setWRtel(String wRtel) {
		WRtel = wRtel;
	}

	public float getWRpersonduration() {
		return WRpersonduration;
	}

	public void setWRpersonduration(float wRpersonduration) {
		WRpersonduration = wRpersonduration;
	}

	public String getWRremark() {
		return WRremark;
	}

	public void setWRremark(String wRremark) {
		WRremark = wRremark;
	}

	public WriteRecordToExcel() {
		super();
	}

	public WriteRecordToExcel(Integer wRuid, String wRuiname, String wRtel, float wRpersonduration, String wRremark) {
		super();
		WRuid = wRuid;
		WRuiname = wRuiname;
		WRtel = wRtel;
		WRpersonduration = wRpersonduration;
		WRremark = wRremark;
	}
		
}

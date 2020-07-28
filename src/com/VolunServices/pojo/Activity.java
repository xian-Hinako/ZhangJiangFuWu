package com.VolunServices.pojo;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Activity {
    private Integer aid;

    private String aname;

    private String introduce;

    private String actaddress;

    private Timestamp day;

    private Float duration;

    private Integer number;

    private Integer status;

    private String remark;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getActaddress() {
        return actaddress;
    }

    public void setActaddress(String actaddress) {
        this.actaddress = actaddress == null ? null : actaddress.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Timestamp getDay() {
        return day;
    }

    public void setDay(Timestamp day) {
        this.day = day;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Activity(){
    	
    }
    
	public Activity(Integer aid, String aname, String introduce, String actaddress, Timestamp day, Float duration,
			Integer number, Integer status, String remark) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.introduce = introduce;
		this.actaddress = actaddress;
		this.day = day;
		this.duration = duration;
		this.number = number;
		this.status = status;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Activity [aid=" + aid + ", aname=" + aname + ", introduce=" + introduce + ", actaddress=" + actaddress
				+ ", day=" + day + ", duration=" + duration + ", number=" + number + ", status=" + status + ", remark="
				+ remark + "]";
	}
    
    
}
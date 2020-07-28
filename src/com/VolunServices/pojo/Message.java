package com.VolunServices.pojo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Message {
    private Integer mid;

    private Integer uid;

    private String content;
    
    private Timestamp time;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
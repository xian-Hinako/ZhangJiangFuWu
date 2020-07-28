package com.VolunServices.pojo;

public class Record {
    private Integer reacordid;

    private Integer uid;

    private Integer actid;

    private Float duration;

    public Integer getReacordid() {
        return reacordid;
    }

    public void setReacordid(Integer reacordid) {
        this.reacordid = reacordid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getActid() {
        return actid;
    }

    public void setActid(Integer actid) {
        this.actid = actid;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Record(){
    	
    }
    
	public Record(Integer uid, Integer actid, Float duration) {
		super();
		this.uid = uid;
		this.actid = actid;
		this.duration = duration;
	}
	
	public Record(Integer reacordid,Integer uid, Integer actid, Float duration) {
		super();
		this.reacordid = reacordid;
		this.uid = uid;
		this.actid = actid;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Record [reacordid=" + reacordid + ", uid=" + uid + ", actid=" + actid + ", duration=" + duration + "]";
	}
    
    
}
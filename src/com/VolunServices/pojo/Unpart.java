package com.VolunServices.pojo;

public class Unpart {
    private Integer unpartid;

    private Integer uid;

    private Integer actid;

    private Integer status;


	public Integer getUnpartid() {
        return unpartid;
    }

    public void setUnpartid(Integer unpartid) {
        this.unpartid = unpartid;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public Unpart() {
		
	}
    
	public Unpart(Integer unpartid, Integer uid, Integer actid, Integer status) {
		super();
		this.unpartid = unpartid;
		this.uid = uid;
		this.actid = actid;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Unpart [unpartid=" + unpartid + ", uid=" + uid + ", actid=" + actid + ", status=" + status + "]";
	}
    
	
    
}
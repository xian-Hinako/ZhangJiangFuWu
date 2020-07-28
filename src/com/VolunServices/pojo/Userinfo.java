package com.VolunServices.pojo;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class Userinfo {
    private Integer uiid;

    private String uiname;

    private Integer sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String aladdress;

    private String tel;

//    private byte[] picture;
    private String picture;
    
    private MultipartFile file;

	public Integer getUiid() {
        return uiid;
    }

    public void setUiid(Integer uiid) {
        this.uiid = uiid;
    }

    public String getUiname() {
        return uiname;
    }

    public void setUiname(String uiname) {
        this.uiname = uiname == null ? null : uiname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAladdress() {
        return aladdress;
    }

    public void setAladdress(String aladdress) {
        this.aladdress = aladdress == null ? null : aladdress.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
           
    public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Userinfo(){
    	
    }   
    
	public Userinfo(String uiname, String tel) {
		super();
		this.uiname = uiname;
		this.tel = tel;
	}

	public Userinfo(Integer uiid, String uiname, Integer sex, Date birthday, String aladdress, String tel,
			String picture) {
		super();
		this.uiid = uiid;
		this.uiname = uiname;
		this.sex = sex;
		this.birthday = birthday;
		this.aladdress = aladdress;
		this.tel = tel;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Userinfo [uiid=" + uiid + ", uiname=" + uiname + ", sex=" + sex + ", birthday=" + birthday
				+ ", aladdress=" + aladdress + ", tel=" + tel + ", picture=" + picture + ", file=" + file + "]";
	}
	    
    
}
package com.VolunServices.pojo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class people {
	 private Integer uiid;

	    private String uiname;

	    private Integer sex;

	    private int age;

	    private String aladdress;

	    private String tel;

	    private String picture;

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

	    public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
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

	    public people(){
	    	
	    }
	    
		public people(Integer uiid, String uiname, Integer sex, int age, String aladdress, String tel, String picture) {
			super();
			this.uiid = uiid;
			this.uiname = uiname;
			this.sex = sex;
			this.age = age;
			this.aladdress = aladdress;
			this.tel = tel;
			this.picture = picture;
		}

		@Override
		public String toString() {
			return "people [uiid=" + uiid + ", uiname=" + uiname + ", sex=" + sex + ", age=" + age + ", aladdress="
					+ aladdress + ", tel=" + tel + ", picture=" + picture + "]";
		}
	    
	    
}

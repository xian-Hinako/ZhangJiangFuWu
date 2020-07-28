package com.VolunServices.controller;

import java.util.List;

import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.Record;
import com.VolunServices.pojo.Unpart;
import com.VolunServices.pojo.User;

public class ToordinaryHome {
	
	private User findUserByName;
	
	private Float total;
	
	private List<Record> findPreFour;
	
	private List<Unpart> selUnpartByuidPreTwoS;
	
	private List<Activity> preActivity;

	public User getFindUserByName() {
		return findUserByName;
	}

	public void setFindUserByName(User findUserByName) {
		this.findUserByName = findUserByName;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public List<Record> getFindPreFour() {
		return findPreFour;
	}

	public void setFindPreFour(List<Record> findPreFour) {
		this.findPreFour = findPreFour;
	}
	
	public List<Unpart> getSelUnpartByuidPreTwoS() {
		return selUnpartByuidPreTwoS;
	}

	public void setSelUnpartByuidPreTwoS(List<Unpart> selUnpartByuidPreTwoS) {
		this.selUnpartByuidPreTwoS = selUnpartByuidPreTwoS;
	}	

	public List<Activity> getPreActivity() {
		return preActivity;
	}

	public void setPreActivity(List<Activity> preActivity) {
		this.preActivity = preActivity;
	}

	public ToordinaryHome(){
		
	}

	public ToordinaryHome(User findUserByName, Float total, List<Record> findPreFour,
			List<Unpart> selUnpartByuidPreTwoS, List<Activity> preActivity) {
		super();
		this.findUserByName = findUserByName;
		this.total = total;
		this.findPreFour = findPreFour;
		this.selUnpartByuidPreTwoS = selUnpartByuidPreTwoS;
		this.preActivity = preActivity;
	}
	

}

package com.watchdogs.dto;

public class DtoAdmin {
	String adId;
	String adEmail;
	String adTel;
	
	
	public DtoAdmin(String adId, String adEmail, String adTel) {
		super();
		this.adId = adId;
		this.adEmail = adEmail;
		this.adTel = adTel;
	}

	public DtoAdmin() {
		// TODO Auto-generated constructor stub
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getAdEmail() {
		return adEmail;
	}

	public void setAdEmail(String adEmail) {
		this.adEmail = adEmail;
	}

	public String getAdTel() {
		return adTel;
	}

	public void setAdTel(String adTel) {
		this.adTel = adTel;
	}

	

	
	
	
}

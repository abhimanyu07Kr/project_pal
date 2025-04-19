package com.abhi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PalData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer palId;
	private String palStr;
	private String yes;
	private String no;
	
	
	public Integer getPalId() {
		return palId;
	}
	public void setPalId(Integer palId) {
		this.palId = palId;
	}
	public String getPalStr() {
		return palStr;
	}
	public void setPalStr(String palStr) {
		this.palStr = palStr;
	}
	public String getYes() {
		return yes;
	}
	public void setYes(String yes) {
		this.yes = yes;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	

}

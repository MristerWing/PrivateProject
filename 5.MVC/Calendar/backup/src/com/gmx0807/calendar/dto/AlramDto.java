package com.gmx0807.calendar.dto;

import java.util.Date;

public class AlramDto {
	private int alramCode;
	private String id;
	private Date workDate;
	private String isReat;
	private String title;

	public AlramDto() {
	}

	public AlramDto(int alramCode, String id, Date workDate, String isReat, String title) {
		super();
		this.alramCode = alramCode;
		this.id = id;
		this.workDate = workDate;
		this.isReat = isReat;
		this.title = title;
	}

	public int getAlramCode() {
		return alramCode;
	}

	public void setAlramCode(int alramCode) {
		this.alramCode = alramCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getIsReat() {
		return isReat;
	}

	public void setIsReat(String isReat) {
		this.isReat = isReat;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "AlramDto [alramCode=" + alramCode + ", id=" + id + ", workDate=" + workDate + ", isReat=" + isReat
				+ ", title=" + title + "]";
	}

}

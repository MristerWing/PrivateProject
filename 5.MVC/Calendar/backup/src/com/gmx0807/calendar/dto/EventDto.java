package com.gmx0807.calendar.dto;

import java.util.Date;

public class EventDto {
	private int eventCode;
	private String id;
	private Date startDate;
	private Date endDate;
	private String attendee;
	private String loc;
	private String explan;
	private String title;

	public EventDto() {
	}

	public EventDto(int eventCode, String id, Date startDate, Date endDate, String attendee, String loc, String explan,
			String title) {
		super();
		this.eventCode = eventCode;
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.attendee = attendee;
		this.loc = loc;
		this.explan = explan;
		this.title = title;
	}

	public int getEventCode() {
		return eventCode;
	}

	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAttendee() {
		return attendee;
	}

	public void setAttendee(String attendee) {
		this.attendee = attendee;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getExplan() {
		return explan;
	}

	public void setExplan(String explan) {
		this.explan = explan;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "EventDto [eventCode=" + eventCode + ", id=" + id + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", attendee=" + attendee + ", loc=" + loc + ", explan=" + explan + ", title=" + title + "]";
	}

}

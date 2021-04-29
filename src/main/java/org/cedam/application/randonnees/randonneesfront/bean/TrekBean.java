package org.cedam.application.randonnees.randonneesfront.bean;

import java.util.ArrayList;
import java.util.List;

public class TrekBean {

	private long id;

	private String name;

	private int year;

	private String location;

	private List<DayBean> daysBean = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<DayBean> getDays() {
		return daysBean;
	}

	public void setDays(List<DayBean> daysBean) {
		this.daysBean = daysBean;
	}


}

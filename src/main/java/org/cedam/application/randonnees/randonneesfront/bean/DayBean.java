package org.cedam.application.randonnees.randonneesfront.bean;

public class DayBean {

	private long id;

	private String number;

	private TrekBean trekBean;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public TrekBean getTrek() {
		return trekBean;
	}

	public void setTrek(TrekBean trekBean) {
		this.trekBean = trekBean;
	}

}

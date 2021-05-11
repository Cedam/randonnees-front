package org.cedam.application.randonnees.front.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class TrekBean {
	
	private long id;

	private String name;

	private int year;

	private String location;
	
	private String url;

	private List<DayBean> days = new ArrayList<>();
	
}

package org.cedam.application.randonnees.front.bean;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class DayBean {

	private long id;

	private String number;

	private String url;
	
	private TrekBean trek;


}

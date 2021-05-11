package org.cedam.application.randonnees.front.bean;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class Post {
	
	private long id;

	private String name;

	private int year;

	private String location;
	
	private String url;

}

package com.sbs.java.crud.dto;

public class Article {
	public int id;
	public String title;
	public String body;
	public String date;
	public int hit;

	public Article() {
		this(0, null, null, null, 0);
	}

	public Article(int id, String title, String body, String date, int hit) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.hit = hit;
	}
}
package com.finad23.DTO;

public class BoardDTO {
	private int number;
	private String writer;
	private String name;
	private String text;
	private String date;
	private int view;
	
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}

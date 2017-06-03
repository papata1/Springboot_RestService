package com.arms.rs.model;

public class Todo {
	
	private Long id;
	private String titles;
	private String contents;
	private String createAt;
	private String updateAt;
	
	public Todo(Long id, String titles, String contents, String createAt, String updateAt) {
		super();
		this.id = id;
		this.titles = titles;
		this.contents = contents;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	
	
	public Todo() {
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public String getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
	
	
	

}

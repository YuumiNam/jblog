package com.bitacademy.jblog.vo;

public class CategoryVo {
	private Long no;
	private String title;
	private String expla;
	private String id;
	private Long postCount;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExpla() {
		return expla;
	}
	public void setExpla(String expla) {
		this.expla = expla;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getPostCount() {
		return postCount;
	}
	public void setPostCount(Long postCount) {
		this.postCount = postCount;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", title=" + title + ", expla=" + expla + ", id=" + id + ", postCount="
				+ postCount + "]";
	}
}

package com.bitacademy.jblog.vo;

public class BlogVo {
	private String id;
	private String title;
	private String profile;
	private String userName;
	private Long categoryNo;
	private String categoryTitle;
	private Long postNo;
	private String postContents;
	private String postDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public Long getPostNo() {
		return postNo;
	}
	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}
	public String getPostContents() {
		return postContents;
	}
	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", title=" + title + ", profile=" + profile + ", userName=" + userName
				+ ", categoryNo=" + categoryNo + ", categoryTitle=" + categoryTitle + ", postNo=" + postNo
				+ ", postContents=" + postContents + ", postDate=" + postDate + "]";
	}
}
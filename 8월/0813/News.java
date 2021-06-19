package com.ssafy.java.day0813.hw;

public class News {
	private String title;
	private String desc;
	private String link;
	
	public News() {
		super();
	}

	public News(String title, String desc, String link) {
		super();
		this.title = title;
		this.desc = desc;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("News [title=").append(title).append(", desc=").append(desc).append(", link=").append(link)
				.append("]");
		return builder.toString();
	}
	
	

}

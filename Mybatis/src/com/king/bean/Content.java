package com.king.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * Content实体类
 * 类名: Content.java
 * 创建人: king 
 * 创建时间：2016年4月7日 下午5:13:48 
 * @version 1.0.0
 */
public class Content implements Serializable{
	//实现IO序列化 可以以流的形式输出
	private static final long serialVersionUID = 1L;
	//主键
	private Integer id;
	//内容
	private String content;
	//标题
	private String title;
	//图片
	private String pic;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	
	//无参构造器
	public Content() {
	}
	//有参构造器
	public Content(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

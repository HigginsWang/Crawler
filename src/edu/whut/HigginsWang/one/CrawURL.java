package edu.whut.HigginsWang.one;

import java.io.Serializable;
import java.sql.Date;

public class CrawURL implements Serializable
{

	private static final long serialVersionUID = -456814114515996211L;

	private String oriUrl = null;//网页的原始url值，主机部分是域名
	
	private String url = null;//网页的url值，主机部分是ip，为了防止重复主机的出现
	
	private String charSet = null;//网页编码格式
	
	private String abstractText = null;//网页的摘要
	
	private String author = null;//网页的作者
	
	private String description = null;//网页的描述
	
	private String title = null;//网页的标题
	
	private String type = null;//网页的类型

	private String[] urlReferences;//网页的引用链接
	
	private int urlNum = 0;//网页编号
	
	private int statusCode = -0;//访问网页的状态码
	
	private int weight = 0;//网页的权重

	private int layer = 0;//网页的层次
	
	private int fileSize = 0;//网页的大小
	
	private int hitNum = 0;//网页的命中次数
	
	private Date lastUpdateTime = null;//网页的最后更新时间
	
	private Date timeToLive = null;//网页的过期时间

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCharSet() {
		return charSet;
	}

	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}

	public String getOriUrl() {
		return oriUrl;
	}

	public void setOriUrl(String oriUrl) {
		this.oriUrl = oriUrl;
	}

	public String getAbstractText() {
		return abstractText;
	}

	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getUrlReferences() {
		return urlReferences;
	}

	public void setUrlReferences(String[] urlReferences) {
		this.urlReferences = urlReferences;
	}

	public int getUrlNum() {
		return urlNum;
	}

	public void setUrlNum(int urlNum) {
		this.urlNum = urlNum;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getHitNum() {
		return hitNum;
	}

	public void setHitNum(int hitNum) {
		this.hitNum = hitNum;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Date getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(Date timeToLive) {
		this.timeToLive = timeToLive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CrawURL() {
		
	}
}

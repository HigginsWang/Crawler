package edu.whut.HigginsWang.one;

import java.io.Serializable;
import java.sql.Date;

public class CrawURL implements Serializable
{

	private static final long serialVersionUID = -456814114515996211L;

	private String oriUrl = null;//��ҳ��ԭʼurlֵ����������������
	
	private String url = null;//��ҳ��urlֵ������������ip��Ϊ�˷�ֹ�ظ������ĳ���
	
	private String charSet = null;//��ҳ�����ʽ
	
	private String abstractText = null;//��ҳ��ժҪ
	
	private String author = null;//��ҳ������
	
	private String description = null;//��ҳ������
	
	private String title = null;//��ҳ�ı���
	
	private String type = null;//��ҳ������

	private String[] urlReferences;//��ҳ����������
	
	private int urlNum = 0;//��ҳ���
	
	private int statusCode = -0;//������ҳ��״̬��
	
	private int weight = 0;//��ҳ��Ȩ��

	private int layer = 0;//��ҳ�Ĳ��
	
	private int fileSize = 0;//��ҳ�Ĵ�С
	
	private int hitNum = 0;//��ҳ�����д���
	
	private Date lastUpdateTime = null;//��ҳ��������ʱ��
	
	private Date timeToLive = null;//��ҳ�Ĺ���ʱ��

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

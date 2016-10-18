package edu.whut.HigginsWang.one;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class MySQLDatabaseTest 
{
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsert() throws ClassNotFoundException, SQLException {
		MySQLDatabase mySQLDatabase = null;
		MySQLDatabaseCore mySQLDatabaseCore = null;
		mySQLDatabaseCore = new MySQLDatabaseCore("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/menagerie", "root", "1234");
		mySQLDatabase = new MySQLDatabase(mySQLDatabaseCore);
		mySQLDatabase.init();
		boolean result = true;
		for(int i = 0 ; i < 50000 ; i++)
		{
			result = mySQLDatabase.insert("insert into pet " + "value(?,?,?,?,?,?)","Kate","Mike","cat","f","1998-02-04","2018-02-04");
		}

	}
	
	@Test
	public void testGetNextCrawURL1() throws SQLException, ClassNotFoundException
	{
		MySQLDatabase mySQLDatabase = null;
		MySQLDatabaseCore mySQLDatabaseCore = null;
		mySQLDatabaseCore = new MySQLDatabaseCore("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/crawlerdatabase", "root", "1234");
		mySQLDatabase = new MySQLDatabase(mySQLDatabaseCore);
		mySQLDatabase.init();
		CrawURL crawURL = mySQLDatabase.getNextCrawURL();
		assertEquals(null, crawURL);
		mySQLDatabase.destroy();
	}
	
	@Test
	public void testGetNextCrawURL2() throws ClassNotFoundException, SQLException
	{
		MySQLDatabase mySQLDatabase = null;
		MySQLDatabaseCore mySQLDatabaseCore = null;
		mySQLDatabaseCore = new MySQLDatabaseCore("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/crawlerdatabase", "root", "1234");
		mySQLDatabase = new MySQLDatabase(mySQLDatabaseCore);
		mySQLDatabase.init();
		
		CrawURL crawURL = new CrawURL();
		crawURL.setOriUrl("www.baidu.com");
		crawURL.setUrl("www.baidu.com");
		crawURL.setCharSet("utf-8");
		crawURL.setAbstractText("中国人");
		crawURL.setAuthor("鲁迅");
		crawURL.setDescription("写的真烂");
		crawURL.setTitle("good good study");
		crawURL.setType("新闻");
		crawURL.setUrlNum(1);
		crawURL.setStatusCode(2);
		crawURL.setWeight(3);
		crawURL.setLayer(4);
		crawURL.setFileSize(5);
		crawURL.setHitNum(6);
		//Date date1 = new Date(1995-1900, 7, 11);
		crawURL.setLastUpdateTime(new Date(1995-1900, 7, 11));
		crawURL.setTimeToLive(new Date(2016-1900, 7, 11));
		
		mySQLDatabase.addCrawURL(crawURL);
		
		CrawURL crawURL2 = mySQLDatabase.getNextCrawURL();
		assertEquals("www.baidu.com", crawURL2.getOriUrl());
		assertEquals("www.baidu.com", crawURL2.getUrl());
		assertEquals("utf-8",crawURL2.getCharSet());
		assertEquals("中国人", crawURL2.getAbstractText());
		
		assertEquals("鲁迅", crawURL2.getAuthor());
		assertEquals("写的真烂", crawURL2.getDescription());
		assertEquals("good good study",crawURL2.getTitle());
		assertEquals("新闻", crawURL2.getType());
		
		assertEquals(1, crawURL2.getUrlNum());
		assertEquals(2, crawURL2.getStatusCode());
		assertEquals(3,crawURL2.getWeight());
		assertEquals(4, crawURL2.getLayer());
		
		assertEquals(5, crawURL2.getFileSize());
		assertEquals(6, crawURL2.getHitNum());
		assertEquals(new Date(1995-1900, 7, 11),crawURL2.getLastUpdateTime());
		assertEquals(new Date(2016-1900, 7, 11), crawURL2.getTimeToLive());
	}
	

}

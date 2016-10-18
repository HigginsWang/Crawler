package edu.whut.HigginsWang.one;

import static org.junit.Assert.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Before;
import org.junit.Test;

public class BerkeleyDBDatabaseTest 
{
	private BerkeleyDBDatabase berkeleyDBDatabase;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBerkeleyDBDatabase() 
	{
		berkeleyDBDatabase = new BerkeleyDBDatabase(
				"forTestDatabase", 
				"C:"+File.separator 
				+ "Users" + File.separator 
				+ "Administrator" 
				+ File.separator 
				+ "Desktop" 
				+ File.separator+"test"
				);
		assertEquals("forTestDatabase", berkeleyDBDatabase.getDatabase().getDatabaseName());
	}

	@Test
	public void testPut()
	{
		berkeleyDBDatabase = new BerkeleyDBDatabase(
				"forTestDatabase", 
				"C:"+File.separator 
				+ "Users" + File.separator 
				+ "Administrator" 
				+ File.separator 
				+ "Desktop" 
				+ File.separator+"test"
				);
		
		CrawURL crawurl1 = new CrawURL();
		crawurl1.setCharSet("utf-8");
		crawurl1.setUrl("www.baidu.com");
		berkeleyDBDatabase.put(crawurl1);
		
		CrawURL crawurl2 = new CrawURL();
		crawurl2.setCharSet("gbk");
		crawurl2.setUrl("www.google.com");
		berkeleyDBDatabase.put(crawurl2);
		
		CrawURL crawurl3 = new CrawURL();
		crawurl3.setCharSet("gbk");
		crawurl3.setUrl("www.sina.com");
		berkeleyDBDatabase.put(crawurl3);
		
		
		berkeleyDBDatabase.getNext();

//		class down implements Callable
//		{
//			@Override
//			public String call() throws Exception
//			{
//				for(int i = 0 ; i < 100 ; i++)
//				{
//					CrawURL crawurl2 = new CrawURL();
//					crawurl2.setCharSet("gbk");
//					crawurl2.setUrl("www.google.com");
//					berkeleyDBDatabase.put(crawurl2);
//				}
//				return null;
//			}
//		}
		
//		int threas = 2;
//		ExecutorService es = Executors.newFixedThreadPool(threas);
//		Set<Future<String>> set = new HashSet<Future<String>>();
//		down djk = new down();
//		for(int i = 0 ; i < 2 ; i++)
//		{
//			
//			Future<String> future = es.submit(djk);
//			set.add(future);
//		}
//		for(Future<String> future:set)
//		{
//			try {
//				future.get();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		
//		CrawURL aNewOne1 = berkeleyDBDatabase.get(crawurl1.getUrl());
//		assertEquals(crawurl1.getCharSet(), aNewOne1.getCharSet());
//		assertEquals(crawurl1.getUrl(),aNewOne1.getUrl());
//		//System.out.println(aNewOne1);
//		//System.out.prinltn(berkeleyDBDatabase.getDatabase().)
//		
//		CrawURL aNewOne2 = berkeleyDBDatabase.get(crawurl2.getUrl());
//		assertEquals(crawurl2.getCharSet(), aNewOne2.getCharSet());
//		assertEquals(crawurl2.getUrl(),aNewOne2.getUrl());
//		//System.out.println(aNewOne2);
//		System.out.println(berkeleyDBDatabase.getJj());
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

}

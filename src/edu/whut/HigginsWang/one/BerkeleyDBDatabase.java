package edu.whut.HigginsWang.one;


import java.io.UnsupportedEncodingException;
import java.util.Set;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.collections.StoredMap;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;

public class BerkeleyDBDatabase extends NoMyDatabase
{
	private BerkeleyDBDatabaseCore berkeleyDBDatabaseCore = null;
	
	private DatabaseConfig databaseConfig = null;
	
	private Database database = null;
	
	private StoredMap<String, CrawURL> storedMap = null;
	
	private EntryBinding keyBinding = null;
	
	private EntryBinding valueBinding = null;
	
	StoredClassCatalog storedClassCatalog = null;
	BerkeleyDBDatabase(String name, String fileName) 
	{
		databaseConfig = new DatabaseConfig();
		databaseConfig.setAllowCreate(true);
		databaseConfig.setTransactional(true);
		
		this.berkeleyDBDatabaseCore = new BerkeleyDBDatabaseCore(fileName);
		this.database = berkeleyDBDatabaseCore.createDatabase(name, databaseConfig);

		storedClassCatalog = new StoredClassCatalog(database);
		keyBinding = new SerialBinding(storedClassCatalog,String.class);
		valueBinding = new SerialBinding(storedClassCatalog,CrawURL.class);
		storedMap = new StoredMap(database, keyBinding, valueBinding, true);
	}
	
	
	public BerkeleyDBDatabaseCore getBerkeleyDBDatabaseCore() {
		return berkeleyDBDatabaseCore;
	}


	public void setBerkeleyDBDatabaseCore(BerkeleyDBDatabaseCore berkeleyDBDatabaseCore) {
		this.berkeleyDBDatabaseCore = berkeleyDBDatabaseCore;
	}


	public DatabaseConfig getDatabaseConfig() {
		return databaseConfig;
	}


	public void setDatabaseConfig(DatabaseConfig databaseConfig) {
		this.databaseConfig = databaseConfig;
	}


	public Database getDatabase() {
		return database;
	}


	public void setDatabase(Database database) {
		this.database = database;
	}

	/**
	 * ²åÈë
	 * @param key
	 * @param crawURL
	 * @throws UnsupportedEncodingException
	 */
	synchronized public void put(CrawURL value)
	{
		storedMap.put(value.getUrl(), value);
	}

	/**
	 * È¡³ö
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	synchronized public CrawURL get(String key)
	{
		return (CrawURL)storedMap.get(key);
	}
	
	synchronized public CrawURL getNext()
	{
		CrawURL result = null;
		if(!storedMap.isEmpty())
		{
			Set entrys = storedMap.entrySet();
			//Entry entry = (Entry) storedMap.entrySet().iterator().next();
			System.out.println(entrys);
		}
		return result;
	}
}

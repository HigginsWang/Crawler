package edu.whut.HigginsWang.one;

import java.io.File;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.StoreConfig;

public class BerkeleyDBDatabaseCore extends DatabaseCore
{
	private EnvironmentConfig envConfig;
	private EntityStore store;
	private Environment env;
	private File fileHome;
	BerkeleyDBDatabaseCore(String fileName) 
	{
		fileHome = new File(fileName);
		envConfig = new EnvironmentConfig();
		envConfig.setAllowCreate(true);
		envConfig.setSharedCache(true);
		envConfig.setTransactional(true);
		env = new Environment(fileHome, envConfig);
		
		StoreConfig storeConfig = new StoreConfig();
		storeConfig.setAllowCreate(true);
		store = new EntityStore(env, "storeEntity", storeConfig);
	}
	
	public Database createDatabase(String name,DatabaseConfig databaseConfig)
	{
		return env.openDatabase(null, name,databaseConfig);
	}
}

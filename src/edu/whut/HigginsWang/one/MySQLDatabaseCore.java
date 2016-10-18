package edu.whut.HigginsWang.one;

public class MySQLDatabaseCore extends DatabaseCore
{
	private String driver;
	private String database_url;
	private String user;
	private String password;
	
	public MySQLDatabaseCore() 
	{
		
	}
	public MySQLDatabaseCore(String driver,String database_url,String user,String password) 
	{
		this.driver = driver;
		this.database_url = database_url;
		this.user = user;
		this.password = password;
	}
	public String getDriver() {
		return driver;
	}
	public String getDatabase_url() {
		return database_url;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setDatabase_url(String database_url) {
		this.database_url = database_url;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

package edu.whut.HigginsWang.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库类，该类中的属性databaseCore指定了所使用的数据库
 * 该类封装了对databaseCore所代表的数据库的基本操作
 * @since 1.0.2
 * @author HigginsWang
 *
 */
public class MySQLDatabase extends RelationalMyDatabase
{
	/**
	 * 数据库内核，本类封装了对databaseCore所代表的数据库的基本操作
	 */
	private MySQLDatabaseCore mySQLDatabaseCore;
	
	private Connection connection;
	
	/**
	 * @author HigginsWang
	 * @since 1.0.2
	 * @param databaseCore_p
	 */
	public MySQLDatabase(MySQLDatabaseCore myDatabaseCore_p) 
	{
		this.mySQLDatabaseCore = myDatabaseCore_p;
	}
	
	/**
	 * @author HigginsWang
	 * @since  1.0.2
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public void init() throws ClassNotFoundException, SQLException
	{
		Class.forName(this.mySQLDatabaseCore.getDriver());
		connection = DriverManager.getConnection(
				this.mySQLDatabaseCore.getDatabase_url(),
				this.mySQLDatabaseCore.getUser(),
				this.mySQLDatabaseCore.getPassword()
				);
	}
	
	/**
	 * @author HigginsWang
	 * @since 1.0.2
	 */
	@Override
	public void destroy() throws SQLException
	{
		connection.close();
	}
	@Override
	public ResultSet query(String queryStatement,Object... args) throws SQLException
	{
		PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
		preparedStatement.clearBatch();
		for(int i = 0 ; i < args.length ; i++)
		{
			preparedStatement.setObject(i+1, args[i]);
		}
		preparedStatement.executeQuery();
		
		//preparedStatement.close();
		return preparedStatement.getResultSet();
	}
	@Override
	synchronized public boolean insert(String insertStatement,Object... args) throws SQLException
	{
		PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
		for(int i = 0 ; i < args.length ; i++)
		{
			preparedStatement.setObject(i+1, args[i]);
		}
		return preparedStatement.executeUpdate() == 0 ? false : true;
	}
	@Override
	synchronized public boolean modify(String modifyStatement, Object... args) throws SQLException
	{
		PreparedStatement preparedStatement = connection.prepareStatement(modifyStatement);
		for(int i = 0 ; i < args.length ; i++)
		{
			preparedStatement.setObject(i+1, args[i]);
		}
		return preparedStatement.executeUpdate() == 0 ? false : true;
	}
	@Override
	synchronized public boolean delete(String deleteStatement, Object... args) throws SQLException
	{
		PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);
		for(int i = 0 ; i < args.length ; i++)
		{
			preparedStatement.setObject(i+1, args[i]);
		}
		return preparedStatement.executeUpdate() == 0 ? false :true;
	}
	
	synchronized public CrawURL getNextCrawURL() throws SQLException
	{
		ResultSet resultSet = this.query("select *from url limit 1");
		if(resultSet.next())
		{
			CrawURL crawURL = new CrawURL();
			crawURL.setOriUrl(resultSet.getString(2));
			crawURL.setUrl(resultSet.getString(3));
			crawURL.setCharSet(resultSet.getString(4));
			crawURL.setAbstractText(resultSet.getString(5));
			crawURL.setAuthor(resultSet.getString(6));
			crawURL.setDescription(resultSet.getString(7));
			crawURL.setTitle(resultSet.getString(8));
			crawURL.setType(resultSet.getString(9));
			//System.out.println(resultSet.getString(9));
			crawURL.setUrlNum(resultSet.getInt(10));
			crawURL.setStatusCode(resultSet.getInt(11));
			crawURL.setWeight(resultSet.getInt(12));
			crawURL.setLayer(resultSet.getInt(13));
			crawURL.setFileSize(resultSet.getInt(14));
			crawURL.setHitNum(resultSet.getInt(15));
			crawURL.setLastUpdateTime(resultSet.getDate(16));
			//System.out.println(resultSet.getDate(16).getTime());
			crawURL.setTimeToLive(resultSet.getDate(17));
			//System.out.println(resultSet.getDate(17).getTime());
			return crawURL;
		}else
		{
			return null;
		}
	}
	
	synchronized public boolean addCrawURL(CrawURL crawURL) throws SQLException
	{
		return this.insert(
				"insert into url values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 
				crawURL.getOriUrl(),
				crawURL.getUrl(),
				crawURL.getCharSet(),
				crawURL.getAbstractText(),
				crawURL.getAuthor(),
				crawURL.getDescription(),
				crawURL.getTitle(),
				crawURL.getType(),
				//crawURL.getUrlReferences().toString(),
				crawURL.getUrlNum(),
				crawURL.getStatusCode(),
				crawURL.getWeight(),
				crawURL.getLayer(),
				crawURL.getFileSize(),
				crawURL.getHitNum(),
				crawURL.getLastUpdateTime(),
				crawURL.getTimeToLive()
				);
	}
}

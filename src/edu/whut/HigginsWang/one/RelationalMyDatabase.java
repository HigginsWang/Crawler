package edu.whut.HigginsWang.one;

import java.sql.ResultSet;

public abstract class RelationalMyDatabase 
{
	/**
	 * @author HigginsWang
	 * @since 1.0.2
	 * @throws Exception
	 */
	abstract public void init() throws Exception;
	/**
	 * 
	 * @param insertStatement
	 * @param argc
	 * @return ResultSet
	 * @throws Exception
	 * @author HigginsWang
	 * @since 1.0.2
	 */
	abstract public ResultSet query(String queryStatement,Object... args) throws Exception;
	/**
	 * 
	 * @param insertStatement
	 * @param args
	 * @return
	 * @throws Exception
	 */
	abstract public boolean insert(String insertStatement,Object... args) throws Exception;
	/**
	 * 
	 * @param modifyStatement
	 * @param args
	 * @return
	 * @throws Exception
	 */
	abstract public boolean modify(String modifyStatement,Object...args) throws Exception;
	/**
	 * 
	 * @param deleteStatement
	 * @param args
	 * @return
	 * @throws Exception
	 */
	abstract public boolean delete(String deleteStatement,Object...args) throws Exception;
	/**
	 * 
	 * @throws Exception
	 */
	abstract public void destroy() throws Exception;
}

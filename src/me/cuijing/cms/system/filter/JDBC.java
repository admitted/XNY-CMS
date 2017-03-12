package me.cuijing.cms.system.filter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>Title: JDBC</p>
 * <p>Description: 数据库操作类</p>
 * <p>Company: </p> 
 * @author cui
 * @date 2017年3月12日
 */
public class JDBC {
	// 创建静态全局变量
	private Connection conn=null;// 生成连接对象
	private Statement st=null;// 生成执行SQL语言的对象
	private ResultSet rs=null;// 结果集

	/**
	 * <p>Title: getConnection</p>
	 * <p>Description: 获取数据库连接的函数</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param driver
	 * @param url
	 * @param user
	 * @param password
	 * @return Connection
	 */
	public Connection getConnection(String driver, String url, String user, String password) {
		try {
			Class.forName(driver);// 加载Mysql数据驱动
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn; // 返回所建立的数据库连接
	}

	/**
	 * <p>Title: Select</p>
	 * <p>Description: select方法</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param conn
	 * @param sql
	 * @return ResultSet
	 */
	public ResultSet Select(Connection conn,String sql) {
		try {
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			rs = st.executeQuery(sql); // 执行sql查询语句，返回查询数据的结果集
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * <p>Title: Update</p>
	 * <p>Description: 更新符合要求的记录，并返回更新的记录数目</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日 
	 * @param conn
	 * @param table
	 * @param id
	 * @param state
	 * @return int
	 */
	public int Update(Connection conn, String table, int id, int state) {
		int count = 0;
		try {
			String sql = "update " + table + " set state=" + state + " where id=" + id + ";";// 更新数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量
			count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * <p>Title: </p>
	 * <p>Description: 关闭数据库连接</p>
	 * <p>Company: </p> 
	 * @author cui
	 * @date 2017年3月12日  void
	 */
	public void Close() {
		try {
			if (rs != null) {// 如果rs不为空关闭，直接关闭可能导致空指针
				rs.close();
			}
			if (st != null) {// 如果st不为空关闭，直接关闭可能导致空指针
				st.close();
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
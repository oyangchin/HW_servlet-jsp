package tw.com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class BaseDao {

	public Calendar now = Calendar.getInstance();

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
//		Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		conn = DriverManager.getConnection(
				"jdbc:db2://127.0.0.1:50000/hwdb2:retrieveMessagesFromServerOnGetMessage=true;",
//				"jdbc:mysql://35.234.60.116:3306/eipdev?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&requireSSL=false",
				"DB2INST1", "588588");
		System.out.println("資料庫連線成功");
		return conn;
	}

}

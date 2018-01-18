package dao;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDao {
	static Logger logger = LoggerFactory.getLogger(BaseDao.class);

	static BasicDataSource ds = null;
	
	static {
		Properties prop = new Properties();
		InputStream is = null;
		String host = "localhost";
		String port = "5433";
		String username = "postgres";
		String password = "aaaa1111";
		try {
			URL url = ClassLoader.getSystemResource("database.properties");
			if(url != null) {
				is = url.openStream();
				prop.load(is);
				host = prop.getProperty("host");
				port = prop.getProperty("port");
				username = prop.getProperty("username");
				password = prop.getProperty("password");
			}
			ds = new BasicDataSource();
			ds.setDriverClassName("org.postgresql.Driver");
	        ds.setUsername(username);
	        ds.setPassword(password);
	        ds.setUrl("jdbc:postgresql://" + host + ":" + port + "/stock");
	        ds.setInitialSize(2);
	        ds.setConnectionProperties("charSet=UTF8");
	        ds.setDefaultAutoCommit(true);
	        ds.setInitialSize(120);
		} catch ( Exception e ) { e.printStackTrace(); }
	}
	
	public static Connection getConnection() throws SQLException {
		Connection rtn = null;
		try {
			rtn = ds.getConnection();
		} catch ( Exception e ) {
			// 만약 에러가 일어나면 한번더 하게 해줌.
			rtn = ds.getConnection();
		}
		return rtn; 
	}
	
	public static void main(String[] args) {
		BaseDao dao = new BaseDao();
		try {
			dao.getConnection();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println(sqle.getErrorCode());
			logger.error(sqle.getMessage());
		}
	}
}

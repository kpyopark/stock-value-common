package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDao {
	static Logger logger = LoggerFactory.getLogger(BaseDao.class);

	static BasicDataSource ds = null;
	
	static {
		try {
			ds = new BasicDataSource();
			ds.setDriverClassName("org.postgresql.Driver");
	        ds.setUsername("postgres");
	        ds.setPassword("aaaa1111");
	        ds.setUrl("jdbc:postgresql://localhost:5433/stock");
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

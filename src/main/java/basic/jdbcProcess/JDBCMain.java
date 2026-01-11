package basic.jdbcProcess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import basic.dbConnection.JDBCMySQLConnection;

public class JDBCMain {
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public JDBCMain() {
		try {
			connection = JDBCMySQLConnection.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeDBConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public ResultSet executeQueryWithParams(String sql, List paramList) throws SQLException {
		PreparedStatement preState = this.connection.prepareStatement(sql);
		int i = 1; 
		for(Object obj : paramList) {
			if(obj instanceof Integer)
				preState.setInt(i, (Integer)obj);
			if(obj instanceof String)
				preState.setString(i, obj.toString());
			
			i ++;
		}
		
		return preState.executeQuery();
//		preState.setstrin
		
	}
	
	public void insertData(String tableName, Map<String, Object> columns) throws SQLException {
		StringBuilder sql = new StringBuilder("insert into ");
		StringBuffer values = new StringBuffer(" values (");
		
		sql.append(tableName).append(" (");
		
		Set<String> cls = columns.keySet();
		int i = 1;
		for(String cl : cls) {
			sql.append(cl);
			values.append("?");
			if(i < cls.size() ) {
				sql.append(",");
				values.append(",");
			}
			i ++ ;
		}
		sql.append(") ");
		values.append(")");
		
		sql.append(values);
		
		System.out.println(sql.toString());
		
		PreparedStatement preState = this.connection.prepareStatement(sql.toString());
		i = 1;
		Object obj = null; 
		for(String cl : cls) {
			obj = columns.get(cl);
			if(obj instanceof Integer)
				preState.setInt(i, (Integer)obj);
			if(obj instanceof String)
				preState.setString(i, obj.toString());
			
			i ++;
		}
		
		preState.executeUpdate();
		
	}
	
	public ResultSet executeQuery(String sql) throws SQLException {
		Statement state = this.connection.createStatement();
		return state.executeQuery(sql);
	}
}

package basic.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import basic.entity.Customer;
import basic.jdbcProcess.JDBCMain;

public class CustomerRepo extends JDBCMain {

	private Customer convertToObj(ResultSet rs) throws SQLException {
		Customer cus = null;
		cus =  new Customer();
		cus.setAddress(rs.getString("address"));
		cus.setFullName(rs.getString("fullName"));
		cus.setPassword(rs.getString("password"));
		cus.setPhone(rs.getString("phone"));
		cus.setUserName(rs.getString("userName"));

		return cus;
	}

	public List<Customer> getAllCustomer(){
		List<Customer> cusList = new ArrayList<Customer>();
		String sql = "select * from customer";
		try {
			ResultSet rs = executeQuery(sql);

			while(rs.next()) {
				cusList.add(this.convertToObj(rs));
			}

			System.out.println(cusList);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cusList;
	}

	public Customer customerLogin(String userName, String password) throws SQLException {
		Customer cus = null;
		StringBuilder sql = new StringBuilder("SELECT * FROM ecom.customer ");
		sql.append("where ").
			append("userName = ? ").
			append("and ").
			append("password = sha2(?, 256);");
		
		List<String> paramList = new ArrayList<String>();
		paramList.add(userName);
		paramList.add(password);
		ResultSet rs = this.executeQueryWithParams(sql.toString(), paramList);
		while(rs.next()) {
			cus = this.convertToObj(rs );
		}
		return cus;
	}
	
	public void insertCust() throws SQLException {
		Customer cus = new Customer("Nguyen Van A-2026", "Ha NOi", 
				"123456", "Ab@123456", "NVA202601");
		
		Map<String, Object> cm = new HashMap<String, Object>();
		cm.put("fullName", cus.getFullName());
		cm.put("address", cus.getAddress());
		cm.put("password", cus.getPassword());
		cm.put("phone", cus.getPhone());
		cm.put("userName", cus.getUserName());
		
		this.insertData("customer", cm);
		
	}
}

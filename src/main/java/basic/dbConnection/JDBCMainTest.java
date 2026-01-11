package basic.dbConnection;

import java.sql.SQLException;

import basic.entity.Customer;
import basic.repository.CustomerRepo;

public class JDBCMainTest {
	public static void main(String[] args) throws SQLException {
		CustomerRepo cRepo  = new CustomerRepo();
		cRepo.insertCust();
		
//		System.out.println(cRepo.getAllCustomer());
//		
//		Customer cus = cRepo.customerLogin("nvsu16", "Ab@123456");
//		
//		System.out.println("Login: \n\t" + cus.toString());
	}
}

package basic.dbConnection;

import basic.entity.Customer;
import basic.repository.CustomerRepo;
import java.sql.SQLException;
import java.util.List;

public class JDBCMainTest {
	public static void main(String[] args) throws SQLException {
		//Thêm
		CustomerRepo cRepo  = new CustomerRepo();
		cRepo.insertCust();
		
		// Lấy
		List<Customer> customers = cRepo.getAllCustomer();
		System.out.println(customers);

		//Delete
		cRepo.delete("Vit");

		//update 
		cRepo.customerLogin("nvsu16", "Ab@123456");
//		System.out.println(cRepo.getAllCustomer());
//		
//		Customer cus = cRepo.customerLogin("nvsu16", "Ab@123456");
//		
//		System.out.println("Login: \n\t" + cus.toString());
	}
}

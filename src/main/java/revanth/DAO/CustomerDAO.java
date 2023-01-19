package revanth.DAO;

import java.util.List;

import revanth.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}

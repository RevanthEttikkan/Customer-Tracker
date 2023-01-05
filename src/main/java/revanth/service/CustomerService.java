package revanth.service;

import java.util.List;

import revanth.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}

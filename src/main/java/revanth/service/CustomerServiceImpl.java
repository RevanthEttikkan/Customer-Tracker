package revanth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import revanth.DAO.CustomerDAO;
import revanth.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
    
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		customerDAO.saveCustomer(thecustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Customer theCustomer=customerDAO.getCustomer(id);
		
		return theCustomer;
	}

	@Transactional
	@Override
	public void deleteCustomer(int id) {
	
		customerDAO.deleteCustomer(id);
	}

}

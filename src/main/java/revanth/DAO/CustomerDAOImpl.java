package revanth.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import revanth.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	
	@Override
	
	public List<Customer> getCustomers() {
		
		Session currentsession=sessionfactory.getCurrentSession();
		
		Query<Customer> query=currentsession.createQuery("from Customer",Customer.class);
		
		List<Customer> customer=query.getResultList();
		
		return customer;
	}


	@Override
	public void saveCustomer(Customer thecustomer) {
		
		Session currentSession=sessionfactory.getCurrentSession();
		
		currentSession.saveOrUpdate(thecustomer);

		
	}


	@Override
	public Customer getCustomer(int id) {
		Session currentSession=sessionfactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class,id);
		return theCustomer;
	}


	@Override
	public void  deleteCustomer(int id) {
		Session currentSession=sessionfactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class,id);
		currentSession.delete(theCustomer);
		
	}

}

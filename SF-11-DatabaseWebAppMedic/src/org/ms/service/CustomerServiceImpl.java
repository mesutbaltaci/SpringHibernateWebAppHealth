package org.ms.service;

import java.util.List;

import org.ms.dao.CustomerDAO;
import org.ms.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
			
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		customerDAO.deleteUser(theId);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String theCustomerName) {
		
		return customerDAO.searchCustomers(theCustomerName);
	}

}

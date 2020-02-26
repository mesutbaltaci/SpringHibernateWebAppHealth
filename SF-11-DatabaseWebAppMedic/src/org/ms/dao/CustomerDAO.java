package org.ms.dao;

import java.util.List;

import org.ms.entity.Customer;


public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}

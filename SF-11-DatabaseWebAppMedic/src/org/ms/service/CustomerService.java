package org.ms.service;

import java.util.List;

import org.ms.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteUser(int theId);

	public List<Customer> searchCustomer(String theCustomerName);
}

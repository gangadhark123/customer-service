package com.customer.service;

import com.customer.domain.Customer;

public interface CustomerService {

	public void createCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int customerId);

	public Customer findByCustomerId(int customerId);

}

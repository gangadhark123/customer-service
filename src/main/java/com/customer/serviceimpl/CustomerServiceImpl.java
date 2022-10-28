package com.customer.serviceimpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.domain.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void createCustomer(Customer customer) {
		if (customer != null) {
			customerRepository.save(customer);
		} else {
			System.out.println("Invalid Customer Information");
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		Optional<Customer> customerOptional = customerRepository.findById(customer.getCustomerId());
		if (customerOptional.isPresent()) {
			customerRepository.save(customer);
		} else {
			System.out.println("No Customer Found in Database");
		}
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);
	}

	@Override
	public Customer findByCustomerId(int customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent()) {
			return customerOptional.get();
		} else {
			System.out.println("No Customer Found in Database");
			return new Customer();
		}
	}

}

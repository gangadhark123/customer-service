package com.customer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.domain.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customer/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/create")
	public void createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
	}

	@PutMapping("/update")
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}

	@DeleteMapping("/deleteById/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
	}

	@GetMapping("/findById/{customerId}")
	public Customer findByCustomerId(@PathVariable int customerId) {
		return customerService.findByCustomerId(customerId);
	}

}

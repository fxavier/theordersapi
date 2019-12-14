package com.xavier.theordersapi.service;

import com.xavier.theordersapi.model.Customer;
import com.xavier.theordersapi.model.ShippingAddress;
import com.xavier.theordersapi.repository.CustomerRepository;
import com.xavier.theordersapi.repository.ShippingAddressRepository;
import com.xavier.theordersapi.service.exception.CustomerNotFoundException;
import com.xavier.theordersapi.service.exception.EmailExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShippingAddressRepository addressRepository;

    public CustomerService(@Autowired CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(final Customer customer) {
        verifyIfExists(customer);
        Customer savedCustomer = customerRepository.save(customer);
        addressRepository.saveAll(customer.getAddresses());
        return savedCustomer;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findCustomer(Long id) {
        verifyIfCustomerExists(id);
        return customerRepository.getOne(id);
    }

    public void delete(Long id) {
        verifyIfCustomerExists(id);
        customerRepository.deleteById(id);
    }

    private void verifyIfCustomerExists(Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if (!foundCustomer.isPresent()) {
            throw new CustomerNotFoundException();
        }
    }

    private void verifyIfExists(Customer customer) {
        Optional<Customer> foundCustomer = customerRepository.findByEmail(customer.getEmail());
        if (foundCustomer.isPresent() && ((customer.getCustomerId() == null) || isUpdatingToADifferentCustomer(customer, foundCustomer))) {
            throw new EmailExistException();
        }
    }

    private boolean isUpdatingToADifferentCustomer(Customer customer, Optional<Customer> foundCustomer) {
        return ((customer.getCustomerId() != null) && !customer.equals(foundCustomer));
    }
}

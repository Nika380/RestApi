package project.rest.restapi.services.customers;

import org.springframework.stereotype.Service;
import project.rest.restapi.entity.Customer;
import project.rest.restapi.exceptions.NotFoundException;
import project.rest.restapi.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService implements CustomerInterface{
    private  final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Customer Not Found"));
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) {
        var update = getCustomerById(id);
        update.setBirthDate(customer.getBirthDate());
        update.setFirstName(customer.getFirstName());
        update.setLastName(customer.getLastName());
        update.setPrivateNumber(customer.getPrivateNumber());
        return customerRepository.save(update);
    }
}

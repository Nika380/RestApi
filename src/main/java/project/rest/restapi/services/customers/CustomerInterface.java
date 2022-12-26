package project.rest.restapi.services.customers;

import project.rest.restapi.entity.Customer;

import java.util.List;

public interface CustomerInterface {
    List<Customer> getCustomers();
    Customer getCustomerById(int id);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer, int id);
}

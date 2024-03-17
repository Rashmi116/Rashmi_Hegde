package com.bank;

import java.util.List;

public interface Idao {
    void saveAllCustomers(List<Customer> customers);
    List<Customer> retrieveAllCustomers();
}

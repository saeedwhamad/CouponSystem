package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import beans.Company;



public interface CompanyRepository extends JpaRepository<Company, Integer>{

}

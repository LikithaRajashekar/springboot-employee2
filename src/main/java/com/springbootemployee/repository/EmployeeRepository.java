package com.springbootemployee.repository;

import org.springframework.data.repository.CrudRepository;

import com.springbootemployee.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer > {

}

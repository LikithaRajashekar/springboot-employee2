package com.springbootemployee.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootemployee.entity.Employee;
import com.springbootemployee.exception.EmployeeAlreadyExistsException;
import com.springbootemployee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	

	@Autowired
	private EmployeeRepository repo;
	
	public Employee saveEmployee(Employee e) throws EmployeeAlreadyExistsException {
	
		List<Employee> l = (List<Employee>) repo.findAll();
		for (Employee s : l) {
			 if(e.getId() == s.getId()){
				 throw new EmployeeAlreadyExistsException("Employee with the given ID already Exists in the database");
				 
			 }
			
		}
	    return repo.save(e);
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> l = (List<Employee>) repo.findAll();
		Collections.sort(l, new ComparatorSalary());
		return l;
		
	}
	
	public Employee updateEmployee(Employee d, Double salary) {
	      List<Employee> l = (List<Employee>) repo.findAll();
	      Integer id = 0;
	      for (Employee s : l) {
	    	  if (s.getSalary() == salary) {
	    		  id = s.getId();
	    	  }
	      }
	      Optional<Employee> employeeDb = this.repo.findById(id);
	      Employee employeeUpdate = employeeDb.get();
	      employeeUpdate.setSalary(d.getSalary());
	      repo.save(d);
	      return employeeUpdate;
	}

	

	
	


}

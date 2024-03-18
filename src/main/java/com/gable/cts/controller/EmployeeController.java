package com.gable.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gable.cts.model.Employee;
import com.gable.cts.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee" )
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping(path = "/")
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Employee findOne(@PathVariable Long id) {
		return service.findOne(id);
	}
	
	@PostMapping(path = "/")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@PostMapping(path = "/addall")
	public List<Employee> add_Add_Update_Employee(@RequestBody List<Employee> employee) {
		return service.addAndUpdateEmployee(employee);
	}
	
	@PutMapping(path = "/{id}")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@GetMapping(path = "/get-emp-by-user/{id}")
	public Employee GetEmployeeByUserId(@PathVariable Long id) {
		return service.getEmployeeByUserId(id);
	}
}

package com.nagarro.javafreshertraining.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.javafreshertraining.entity.Employee;
import com.nagarro.javafreshertraining.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	 
	@GetMapping("ListEmployee")
	public Employee[] list(Employee employee) {
		List<Employee> empList = service.findAll();
		Employee[] employeeArray = new Employee[empList.size()];
		empList.toArray(employeeArray);
		return employeeArray;

	}

	 
	@GetMapping("UpdateEmployee")
	public Employee edit(@RequestParam("id") int Id) {
		Employee employee = service.findById(Id);
		return employee;

	}

 	@PostMapping("addEmployee")
	public @ResponseBody Employee[] addData(@RequestBody Employee employee) {
		service.save(employee);
		List<Employee> empList = service.findAll();
		Employee[] employeeArray = new Employee[empList.size()];
		empList.toArray(employeeArray);
		return employeeArray;
	}

	 
	@PostMapping("updateEmployee")
	public Employee[] updateData(@RequestBody Employee employee) {
		service.update(employee);
		List<Employee> empList = service.findAll();
		Employee[] employeeArray = new Employee[empList.size()];
		empList.toArray(employeeArray);
		return employeeArray;

	}
	
}
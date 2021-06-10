package com.example.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrest.model.Emp;
import com.example.springbootrest.service.EmpService;

@RestController
@RequestMapping("emp")
public class EmpController {
	@Autowired
	private EmpService empService;
	
	//모든 사원 조회
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Emp>> getAllEmps(){
		List<Emp> emps = empService.findAll();
		return new ResponseEntity<List<Emp>>(emps, HttpStatus.OK);
	}
}

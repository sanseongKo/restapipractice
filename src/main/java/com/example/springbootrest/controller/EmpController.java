package com.example.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrest.model.Emp;
import com.example.springbootrest.service.EmpService;

@RestController
@RequestMapping("emp")
public class EmpController {
	@Autowired
	private EmpService empService;

	//모든 사원 조회, localhost:8080/emp
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Emp>> getAllEmps(){
		List<Emp> emps = empService.findAll();
		return new ResponseEntity<List<Emp>>(emps, HttpStatus.OK);
	}

	//한명의 사원 조회
	@GetMapping(value="/{empno}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Emp> getEmp(@PathVariable("empno")int empno){
		return new ResponseEntity<Emp>(empService.findById(empno), HttpStatus.OK);
	}
	//한명의 사원 삭제
	@DeleteMapping(value="/{empno}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deleteEmp(@PathVariable("empno")int empno){
		empService.deleteById(empno);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	//사원 수정
	@PutMapping(value="/{empno}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Emp> updateEmp(@PathVariable("empno")int empno, @RequestBody Emp emp){
		empService.updateById(empno, emp);
		return new ResponseEntity<Emp>(emp, HttpStatus.OK);
	}
	//사원 입력
	@PostMapping
	public ResponseEntity<Emp> save(@RequestBody Emp emp){
		return new ResponseEntity<Emp>(empService.save(emp), HttpStatus.OK);
	}

}




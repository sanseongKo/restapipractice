package com.example.springbootrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springbootrest.model.Emp;
import com.example.springbootrest.repository.EmpRepository;

@SpringBootApplication
public class SpringbootrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestApplication.class, args);
	}

	@Autowired
	EmpRepository empRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		empRepository.save(new Emp(1, "asd", 9000));
		empRepository.save(new Emp(2, "exc", 10000));
		empRepository.save(new Emp(3, "wsd", 100002));
		empRepository.save(new Emp(4, "이순신", 7000000));
		empRepository.save(new Emp(5, "김유신", 20000000 ));
	}
}

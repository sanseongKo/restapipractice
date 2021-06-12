package com.example.springbootrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootrest.model.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
	List<Emp> findBySalBetween(int sal1, int sal2);
}

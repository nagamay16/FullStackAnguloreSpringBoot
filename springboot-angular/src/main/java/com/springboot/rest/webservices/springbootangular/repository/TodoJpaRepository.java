package com.springboot.rest.webservices.springbootangular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.webservices.springbootangular.bean.Todo;

public interface TodoJpaRepository extends JpaRepository<Todo,Long>{

	List<Todo> findByUsername(String username);
}

package com.springboot.rest.webservices.springbootangular.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.rest.webservices.springbootangular.bean.Todo;

@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static long idCounter;
	
	static {
		 
		System.out.println("TodoHardCodedService");
		todos.add(new Todo(++idCounter,"in28minutes", "Learn to Spring Boot", new Date(),false));
		todos.add(new Todo(++idCounter,"in28minutes", "Learn about Microservices", new Date(),false));
		todos.add(new Todo(++idCounter,"in28minutes", "Learn about Angular", new Date(),false));
		
	}
	
	public List<Todo> findAll(){
		
		return todos;
	}
	
	public Todo deleteById(long id) {
		
		Todo todo = findById(id);
		
		if(todo==null) return null;
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
	}
    public Todo saveTodo(Todo todo) {
    	
    	if(todo.getId()==-1 || (todo.getId()==0)) {
    		
    		todo.setId(++idCounter);
    		todos.add(todo);
    	}
    	else {
    		
    		deleteById(todo.getId());
    		todos.add(todo);
    	}
    return todo;
    }
	public Todo findById(Long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
}

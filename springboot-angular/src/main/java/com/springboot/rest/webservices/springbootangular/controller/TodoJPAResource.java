package com.springboot.rest.webservices.springbootangular.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.webservices.springbootangular.bean.Todo;
import com.springboot.rest.webservices.springbootangular.repository.TodoJpaRepository;
import com.springboot.rest.webservices.springbootangular.service.TodoHardCodedService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJPAResource {

	@Autowired
	private TodoHardCodedService todoService;
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		
		//System.out.println("getAllTodos service");
		return todoJpaRepository.findByUsername(username);
		//return todoService.findAll();
			  
	}   
	
    @GetMapping("/jpa/users/{username}/todos/{id}")
	
	public Todo getTodo(@PathVariable String username,@PathVariable long id){
		
		System.out.println("getAllTodos service");
		return todoJpaRepository.findById(id).get();
		//return todoService.findById(id);
			  
	}
	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(
			@PathVariable String username, @PathVariable long id){
		
		      //Todo todo = todoService.deleteById(id);
		       
		          todoJpaRepository.deleteById(id);		   
		      
		    	  return ResponseEntity.noContent().build();
		     
	}    
	
      @PutMapping("/jpa/users/{username}/todos/{id}")
      public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
    	  
    	  Todo todoUpdated =todoJpaRepository.save(todo);
    	  return new ResponseEntity<Todo>(todo, HttpStatus.OK);
      }
      
      @PostMapping("/jpa/users/{username}/todos")
      public ResponseEntity<Todo> createTodo(@PathVariable String username,@RequestBody Todo todo) {
    	  
    	  todo.setUsername(username);
    	  Todo createdTodo = todoJpaRepository.save(todo);
    	  
    	  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
    	  
    	  return ResponseEntity.created(uri).build();
      }
}  



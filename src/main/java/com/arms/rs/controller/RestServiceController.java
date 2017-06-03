package com.arms.rs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arms.dao.TodoDao;
import com.arms.rs.model.Todo;

@RestController
public class RestServiceController {
	
	@Autowired
	TodoDao todoDao;
	@GetMapping("/todos")
	public List<Todo> list(){
		
		return todoDao.list() ;
	}
	
	@GetMapping("/todos/{id}")
	public ResponseEntity  getTodo(@PathVariable("id")Long id){
		Todo todo = todoDao.get(id);
		if(todo == null){
			return new ResponseEntity("no Todo Found for id "+id,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(todo ,HttpStatus.OK);
	}
	
	@PostMapping(value = "/todos")
	public ResponseEntity createTodo(@RequestBody Todo todo){
		
		todoDao.create(todo);
		System.out.println(todo.getContents()+"was add.");
		return new ResponseEntity(todo ,HttpStatus.OK);
	}
	@PutMapping("/todos/{id}")
	public ResponseEntity updateTodo(@PathVariable("id")Long id , @RequestBody Todo todo){
		todo = todoDao.update(id,todo);
		if(null == todo){
			return new ResponseEntity("no todo found for id"+id ,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(todo ,HttpStatus.OK);
	}
	@DeleteMapping("/todos/{id}")
	public ResponseEntity deleteTodo(@PathVariable("id")Long id){
		if(null == todoDao.delete(id)){
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(id,HttpStatus.OK);
	}

}

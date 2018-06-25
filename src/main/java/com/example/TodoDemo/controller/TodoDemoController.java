package com.example.TodoDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TodoDemo.entity.TodoDemoEntity;
import com.example.TodoDemo.service.TodoDemoService;

@RestController
public class TodoDemoController {

	@Autowired
	TodoDemoService todoService;
	
	@GetMapping("/api/read")
	public List<TodoDemoEntity> getAll() {
		return todoService.getList();
	}
	
	@PostMapping("/api/create") 
	public String createList( @RequestParam("title") String title,@RequestParam("detail") String detail) {
		todoService.createList(title, detail);
		return "success";
	}
	
	@PutMapping("/api/update/{id}")
	public String updateList(@PathVariable(value="id") Long id,@RequestBody TodoDemoEntity  todoentity) {
		todoService.updateList(id,todoentity);
		return "update success";
	}

	  
	 @DeleteMapping("/api/delete/{id}")
	 public ResponseEntity<?> deleteList(@PathVariable(value="id") Long idList){ 	
		 todoService.deleleteList(idList);
		 return ResponseEntity.ok().build();
	  }
}

package com.example.TodoDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TodoDemo.entity.TodoDemoEntity;
import com.example.TodoDemo.exception.ResourceNotFoundException;
import com.example.TodoDemo.repository.TodoDemoRepository;


@Service
public class TodoDemoService {

	@Autowired
	TodoDemoRepository todoRepository;
	
	public void createList(String title, String detail) {
		TodoDemoEntity list = new TodoDemoEntity(title,detail,false);
		todoRepository.save(list);
	}

	public List<TodoDemoEntity> getList() {
		return todoRepository.findAll();
	}
	
	public TodoDemoEntity updateList(Long id,TodoDemoEntity todoentity) {
		TodoDemoEntity todo = todoRepository.findById(id).orElseThrow(
				 () -> new ResourceNotFoundException("List", "id", id)
				 );
		todo.setTitle(todoentity.getTitle());
		todo.setDetail(todoentity.getDetail());
	
		TodoDemoEntity tododetails = todoRepository.save(todo);
		return tododetails;	
				 
	}
	public void deleleteList(Long id) {
		  todoRepository.deleteById(id);

	}
}

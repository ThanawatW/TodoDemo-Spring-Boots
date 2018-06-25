package com.example.TodoDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TodoDemo.entity.TodoDemoEntity;

@Repository
public interface TodoDemoRepository extends JpaRepository<TodoDemoEntity, Long> {

}

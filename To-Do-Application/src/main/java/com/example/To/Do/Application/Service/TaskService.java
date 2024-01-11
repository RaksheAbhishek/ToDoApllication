package com.example.To.Do.Application.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.To.Do.Application.Entity.Task;
import com.example.To.Do.Application.Repositaries.TaskRepositaries;

@Service
public class TaskService {
	
	@Autowired
	TaskRepositaries taskRepositaries;
	
	
	public List<Task> getAllTasks()
	{
		return taskRepositaries.findAll();
	}
	
	
	public Optional<Task> getTaskById(Long id)
	{
		return taskRepositaries.findById(id);
	}
	
	
	// TaskService.java
	public Task SaveTask(Task task) {
	    return taskRepositaries.save(task);
	}

	
	
	public void DeleteTask(Long id)
	{
		 taskRepositaries.deleteById(id);
	}

	
	
}

package com.example.To.Do.Application.Repositaries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.To.Do.Application.Entity.Task;

public interface TaskRepositaries  extends JpaRepository<Task, Long>{
	
	

}

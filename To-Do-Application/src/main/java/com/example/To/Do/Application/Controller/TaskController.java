// TaskController.java
package com.example.To.Do.Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.To.Do.Application.Entity.Task;
import com.example.To.Do.Application.Service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("newTask", new Task()); // Add this line to create a new task instance
        return "tasks";
    }

    
  

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id).orElse(null);
        model.addAttribute("task", task);
        return "tasks";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {
        taskService.SaveTask(task);
        return "redirect:/tasks";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.DeleteTask(id);
        return "redirect:/tasks";
    }
}

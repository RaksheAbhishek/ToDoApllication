// todo.js
const taskForm = document.querySelector('form');
const taskList = document.querySelector('tbody');

function renderTask(task) {
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${task.id}</td>
        <td>${task.title}</td>
        <td>${task.description}</td>
        <td>${task.status}</td>
        <td>${task.dueDate}</td>
        <td><a href="/{id}/delete(id=${task.id})">Delete</a></td>
    `;
    taskList.appendChild(row);
}

async function fetchTasks() {
    const response = await fetch('/');
    const tasks = await response.json();

    taskList.innerHTML = '';
    tasks.forEach(task => {
        renderTask(task);
    });
}

async function addTask() {
    const title = document.querySelector('[name="title"]').value;
    const description = document.querySelector('[name="description"]').value;
    const status = document.querySelector('[name="status"]').value;
    const dueDate = document.querySelector('[name="dueDate"]').value;

    const response = await fetch('/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ title, description, status, dueDate }),
    });

    if (response.ok) {
        const newTask = await response.json();
        renderTask(newTask);
        taskForm.reset();
    } else {
        console.error('Failed to add task');
    }
}

async function deleteTask(id) {
    const response = await fetch(`/${id}/delete`, {
        method: 'DELETE',
    });

    if (response.ok) {
        fetchTasks();
    } else {
        console.error('Failed to delete task');
    }
}

document.addEventListener('DOMContentLoaded', fetchTasks);

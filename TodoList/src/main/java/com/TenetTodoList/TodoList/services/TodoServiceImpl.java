package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.Dao.TodoRepository;
import com.TenetTodoList.TodoList.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {

        return  todoRepository.findAll();
    }

    @Override
    public Todo findById(int theId) {
        Optional<Todo> result = todoRepository.findById(theId);
        Todo theTodo;
        theTodo=null;
        if (result.isPresent()) {
            theTodo= result.get();
        } else {
            throw new RuntimeException("Did not find Todo with the id of " + theId);
        }
        return theTodo;
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteById(int theId) {
     todoRepository.deleteById(theId);
    }
}

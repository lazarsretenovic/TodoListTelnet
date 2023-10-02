package services;

import Dao.TodoRepository;
import domain.Todo;
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
        Optional<Todo> result = todoRepository.findById((long) theId);

        Todo theTodo = null;

        if (result.isPresent()) {
            theTodo = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find Todolist with the id of- " + theId);
        }

        return theTodo;
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteById(int theId) {
     todoRepository.deleteById((long) theId);
    }
}

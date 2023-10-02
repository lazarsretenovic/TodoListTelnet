package services;

import domain.Todo;
import domain.User;

import java.util.List;
import java.util.Optional;

public abstract class TodoRepositoryImpl implements  TodoRepository{
    private TodoRepository todoRepository;

    public TodoRepositoryImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return  todoRepository.findAll();
    }

    @Override
    public Todo findById(int theId) {
        Optional<Todo> result = Optional.ofNullable(todoRepository.findById(theId));

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
    public Object save(Todo theTodo) {
        todoRepository.save(theTodo);
        return theTodo;
    }

    @Override
    public void deleteById(int theId) {
        todoRepository.deleteById(theId);
    }
}

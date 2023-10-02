package services;

import domain.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();

    Todo findById(int theId);

    Todo save(Todo todo);

    void deleteById(int theId);
}

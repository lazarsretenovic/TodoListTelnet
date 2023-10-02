package services;

import domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findAll();

    Todo findById(int theId);

    Object save(Todo todo);

    void deleteById(int theId);
}

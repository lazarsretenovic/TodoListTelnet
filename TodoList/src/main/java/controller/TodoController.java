package controller;

import domain.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Dao.TodoRepository;
import Dao.UserRepository;
import services.TodoService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class TodoController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }

}


package com.TenetTodoList.TodoList.domain;

import com.TenetTodoList.TodoList.dto.UserDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "todo_list")
public class TodoList{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH }, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserTodos userTodos;

    public TodoList() {
    }

    public TodoList(int id, String description, String status, UserDTO user) {
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserTodos getUser() {
        return userTodos;
    }

    public void setUser(UserTodos userTodos) {
        this.userTodos = userTodos;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.User;

public class TodoListDTO {
    private int id;
    private String description;
    private String status;

    private User user;

    public TodoListDTO() {
    }

    public TodoListDTO(int id_Dto, String description_Dto, String statusDto, User userDto) {
        this.id = id_Dto;
        this.description = description_Dto;
        this.status = statusDto;
        this.user = userDto;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

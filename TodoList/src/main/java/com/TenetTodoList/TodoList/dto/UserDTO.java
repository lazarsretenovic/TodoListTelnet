package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.domain.UserDetail;

public class UserDTO {
    private int id;
    private String username;
    private String password;
    private UserDetail user_detail;


    public UserDTO() {
    }

    public UserDTO(int id_Dto, String username_Dto, String password_Dto, UserDetail user_detail, User user) {
        this.id = id_Dto;
        this.username = username_Dto;
        this.password = password_Dto;
        this.user_detail = user_detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetail getUser_detail() {
        return user_detail;
    }

    public void setUser_detail(UserDetail user_detail) {
        this.user_detail = user_detail;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userDetail=" + user_detail +
                '}';
    }
}

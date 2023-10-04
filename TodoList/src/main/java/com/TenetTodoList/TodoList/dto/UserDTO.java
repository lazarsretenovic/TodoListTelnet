package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.domain.UserDetail;

public class UserDTO {
    private int id;
    private String username;
    private String password;
    private UserDetail userDetail;


    public UserDTO() {
    }

    public UserDTO(int id, String username, String password, UserDetail userDetail, User user) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userDetail = userDetail;
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

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userDetail=" + userDetail +
                '}';
    }
}

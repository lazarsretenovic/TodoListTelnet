package com.TenetTodoList.TodoList.dto.dtobcrytpt;

import com.TenetTodoList.TodoList.domain.UserDetail;

public class UserDTOBcrypt{
    private int id;
    private String username;
    private String password;
    private UserDetail user_detail;
    public UserDTOBcrypt(int id, String username, String password, UserDetail user_detail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.user_detail = user_detail;
    }

    public UserDTOBcrypt() {
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
        return "UserDTOBcrypt{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_detail=" + user_detail +
                '}';
    }
}


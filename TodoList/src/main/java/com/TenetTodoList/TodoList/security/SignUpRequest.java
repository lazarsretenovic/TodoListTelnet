package com.TenetTodoList.TodoList.security;

import lombok.Builder;

@Builder
public class SignUpRequest {
    private String username;
    private String password;

    public SignUpRequest() {
    }

    public SignUpRequest(String firstName, String lastName, String username, String password) {

        this.username = username;
        this.password = password;
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

    public SignUpRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

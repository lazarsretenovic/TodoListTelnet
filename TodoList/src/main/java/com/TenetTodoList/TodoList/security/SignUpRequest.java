package com.TenetTodoList.TodoList.security;

import lombok.Builder;

@Builder
public class SignUpRequest {
    private String login_name;
    private String password;

    public SignUpRequest() {
    }

    public SignUpRequest(String firstName, String lastName, String login_name, String password) {

        this.login_name = login_name;
        this.password = password;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignUpRequest(String login_name, String password) {
        this.login_name = login_name;
        this.password = password;
    }
}

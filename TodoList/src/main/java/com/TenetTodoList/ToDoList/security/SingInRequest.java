package com.TenetTodoList.ToDoList.security;

import lombok.Builder;

@Builder
public class SingInRequest {
    private String login_name;
    private String password;

    public SingInRequest() {
    }

    public SingInRequest(String login_name, String password) {
        this.login_name = login_name;
        this.password = password;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void getLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

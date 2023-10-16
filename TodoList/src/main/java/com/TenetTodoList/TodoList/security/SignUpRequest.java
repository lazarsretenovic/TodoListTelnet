package com.TenetTodoList.TodoList.security;

import com.TenetTodoList.TodoList.domain.UserDetail;
import lombok.Builder;

@Builder
public class SignUpRequest {
    private String login_name;
    private String password;
    private UserDetail userDetail;

    public SignUpRequest() {
    }


    public SignUpRequest(String login_name, String password,UserDetail userDetail) {

        this.login_name = login_name;
        this.password = password;
        this.userDetail = userDetail;
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


    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}

package com.TenetTodoList.TodoList.domain;

import java.util.List;

public class UserBuilder {
    private int id;
    private String login_name;
    private String password;
    private UserDetail userDetail;
    private Role role;
    private List<TodoList> todoList;

    public UserBuilder(String login_name, String password, Role role) {
        this.login_name = login_name;
        this.password = password;
        this.role = role;
    }

    public UserBuilder id(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder userDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
        return this;
    }

    public UserBuilder todoList(List<TodoList> todoList) {
        this.todoList = todoList;
        return this;
    }

    public User build() {
        User user = new User(login_name, password, role);
        user.setId(id);
        user.setUserDetail(userDetail);
        user.setTodoList(todoList);
        return user;
    }
}

package com.TenetTodoList.TodoList.domain;

import com.TenetTodoList.TodoList.dto.TodoListDTO;
import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Builder
@Entity
@Table(name = "user")
public class UserTodos implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username",unique = true)
    private String user_name;
    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail_id")
    private UserDetail userDetail;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH })
    private List<TodoList> todoList;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        // email in our case
        return user_name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserTodos() {
    }
    public UserTodos(Role role) {
        this.role = role;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public UserDetail getUserDetail() {
        return userDetail;
    }
    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
    public UserTodos(int id, String user_name, String password, UserDetail userDetail, TodoListDTO todoListDTO) {
    }
    public UserTodos(int id, String user_name, String password, UserDetail userDetail, Role role, List<TodoList> todoList) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.userDetail = userDetail;
        this.role = role;
        this.todoList = todoList;
    }

    public UserTodos(int id, String user_name, String password, UserDetail userDetail) {
        this.user_name = user_name;
        this.password = password;
        this.userDetail = userDetail;
    }
    public UserTodos(List<TodoList> todoList) {
        this.todoList = todoList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public void setTodoList(List<TodoList> todoList) {
        this.todoList = todoList;
    }

    public List<TodoList> getTodoList() {
        return todoList;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", userDetail='" + userDetail + '\'' +

                '}';
    }
    public void setTodos(List<TodoList> todoList){
        this.todoList= todoList;
    }
    public void add(TodoList tempTodoList){
        if(todoList==null){
            todoList= new ArrayList<>();
        }
        todoList.add(tempTodoList);
        tempTodoList.setUser(this);
    }
}
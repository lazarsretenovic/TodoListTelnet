        package com.TenetTodoList.TodoList.domain;

        import com.TenetTodoList.TodoList.dto.TodoListDTO;
        import jakarta.persistence.*;
        import org.springframework.context.annotation.Bean;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;
        //    import org.springframework.security.crypto.bcrypt.BCrypt;

        import java.util.ArrayList;
        import java.util.List;
        @Entity
        @Table(name = "user")
        public class User {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
            private int id;
            @Column(name = "username")
            private String username;
            @Column(name = "password")
            private String password;
            @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "user_detail_id")
            private UserDetail userDetail;

            @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH })
            private List<TodoList> todoList;

            public User() {
            }

            public UserDetail getUserDetail() {
                return userDetail;
            }

            public void setUserDetail(UserDetail userDetail) {
                this.userDetail = userDetail;
            }

            public User(int id, String username, String password, UserDetail userDetail, TodoListDTO todoListDTO) {
            }

            public User(int id, String username, String password, UserDetail userDetail) {
                this.username = username;
                this.password = password;
            }

            public User(List<TodoList> todoList) {
                this.todoList = todoList;
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
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                this.password = passwordEncoder.encode(password);

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
                        ", username='" + username + '\'' +
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
           @Bean
           public PasswordEncoder passwordEncoder() {
               return new BCryptPasswordEncoder();
           }
        }

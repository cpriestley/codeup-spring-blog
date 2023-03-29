package com.code.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    public User (User copy) {
        id = copy.id;
        email = copy.email;
        password = copy.password;
        username = copy.username;
        name = copy.name;
        posts = copy.posts;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 50)
    private String username;
    @Column(nullable = false, length = 50)
    private String name;
    @OneToMany(mappedBy="owner", targetEntity=Post.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Post> posts;

}
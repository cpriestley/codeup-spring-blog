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
        fullName = copy.fullName;
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
    @Column(name = "fullname", nullable = false, length = 50)
    private String fullName;
    @OneToMany(mappedBy="user", targetEntity=Post.class, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Post> posts;

}
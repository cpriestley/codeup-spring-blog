package com.code.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
        role = copy.role;
        accountVerified = copy.accountVerified;
        failedLoginAttempts = copy.failedLoginAttempts;
        loginDisabled = copy.loginDisabled;
        userGroup = copy.userGroup;
        isAccountNonExpired = copy.isAccountNonExpired;
        isAccountNonLocked = copy.isAccountNonLocked;
        isCredentialsNonExpired = copy.isCredentialsNonExpired;
        posts = copy.posts;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;
    @Column(columnDefinition = "varchar(100) not null")
    private String password;
    @Column(columnDefinition = "varchar(50) not null unique")
    private String username;
    @Column(name = "fullname", columnDefinition = "varchar(50) null")
    private String fullName;
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "role_id", referencedColumnName = "id", columnDefinition = "int unsigned default '1' null")
    private Role role;
    @Column(name = "account_verified", columnDefinition = "bit not null")
    private boolean accountVerified;
    @Column(name = "failed_login_attempts", columnDefinition = "int not null")
    private int failedLoginAttempts;
    @Column(name = "login_disabled", columnDefinition = "bit not null")
    private boolean loginDisabled;
    @Column(name = "account_non_expired", columnDefinition = "bit default true not null")
    private boolean isAccountNonExpired;
    @Column(name = "account_non_locked", columnDefinition = "bit default true not null")
    private boolean isAccountNonLocked;
    @Column(name = "credentials_non_expired", columnDefinition = "bit default true not null")
    private boolean isCredentialsNonExpired;

    @OneToMany(mappedBy="user", targetEntity=Post.class, fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Post> posts;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinTable(name = "user_groups",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private Group userGroup;
}

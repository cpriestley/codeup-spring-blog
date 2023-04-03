package com.code.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "role", columnDefinition = "varchar(50) not null unique")
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Set<User> users;
}

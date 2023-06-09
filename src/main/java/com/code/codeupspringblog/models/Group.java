package com.code.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "principle_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "group")
    private String group;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "userGroup")
    private Set<User> users;
}
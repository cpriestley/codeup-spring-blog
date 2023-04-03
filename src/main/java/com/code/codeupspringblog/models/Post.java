package com.code.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "slug", columnDefinition = "varchar(250) not null")
    private String slug;
    @Column(name = "title", columnDefinition = "varchar(150) not null")
    private String title;
    @Column(nullable = false, length = 5000)
    private String body;
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User user;
}

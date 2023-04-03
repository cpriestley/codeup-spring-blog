package com.code.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "body", columnDefinition = "longtext not null")
    private String body;
    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", columnDefinition = "int not null")
    private User user;
    @Column(name = "created_at", insertable = false, updatable = false,
            columnDefinition = "timestamp default CURRENT_TIMESTAMP not null")
    private String createdAt;
    @Column(name = "modified_at", insertable = false, updatable = false,
            columnDefinition = "timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP")
    private String modifiedAt;
}

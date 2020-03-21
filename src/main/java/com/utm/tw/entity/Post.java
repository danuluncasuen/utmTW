package com.utm.tw.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @ManyToOne
    private Chatter author;

}

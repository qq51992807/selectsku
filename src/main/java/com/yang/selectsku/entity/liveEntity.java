package com.yang.selectsku.entity;

import javax.persistence.*;

@Entity
@Table(name = "liveEntity")
public class liveEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "authorId")
    private String authorId;


    @Column(name = "authorName")
    private String authorName;

    @Column(name = "time")
    private int time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

package com.yang.selectsku.entity;

import javax.persistence.*;

@Entity
@Table(name = "snItemSc")
public class snItemSc {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "firstItemId")
    private String firstItemId;

    @Column(name = "secondItemId")
    private String secondItemId;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "time")
    private int time;

    @Column(name = "status")
    private int  status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstItemId() {
        return firstItemId;
    }

    public void setFirstItemId(String firstItemId) {
        this.firstItemId = firstItemId;
    }

    public String getSecondItemId() {
        return secondItemId;
    }

    public void setSecondItemId(String secondItemId) {
        this.secondItemId = secondItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

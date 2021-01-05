package com.yang.selectsku.entity;

import javax.persistence.*;

@Entity
@Table(name = "dyItem")
public class dyItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "itemId")
    private String itemId;


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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

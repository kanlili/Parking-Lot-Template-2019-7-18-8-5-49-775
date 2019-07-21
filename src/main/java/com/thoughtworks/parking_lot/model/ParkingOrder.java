package com.thoughtworks.parking_lot.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ParkingOrder {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private  int id;
   @Column
   private  String name;
   @Column
   private  String number;
   @Column
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private Date createTime;
   @Column
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private  Date endTime;
   @Column(columnDefinition = "open")
    private  boolean status;

    public ParkingOrder(String name, String number, Date createTime, Date endTime, boolean status) {
        this.name = name;
        this.number = number;
        this.createTime = createTime;
        this.endTime = endTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

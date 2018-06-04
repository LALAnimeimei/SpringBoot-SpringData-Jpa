package com.boottest.fortest.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="UserDao")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -5957276912242111881L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private  String password;

    @Column
    private  String address;

    @Column(name="department_id")
    private int departmentId;

    @Column(name="create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    private Timestamp createDate;
    @Override
    public String toString() {
        return "{\"id\":" + id + ", \"name\":" + name + ",\"address\":"+ address +", \"departmentId\":=" + departmentId + ", \"createDate\":" + createDate + "}";
    }

    // Setter 和 Getter 方法


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDepartmentId(){
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
package com.boottest.fortest.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="UserDao")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 8886402739972726962L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name="department_id")
    private int departmentId;

    @Column(name="create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "zh" , timezone="GMT+8")
    private Date createDate;

    @Override
    public String toString() {
        return "UserEntity [id=" + id + ", name=" + name + ", departmentId=" + departmentId + ", createDate=" + createDate + "]";
    }

    // Setter 和 Getter 方法
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId(){
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
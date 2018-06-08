package com.boottest.fortest.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RoleModule")
public class RoleModule implements Serializable{

    private static final long serialVersionUID = -8691029681237262921L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int rid;

    @Column
    private  int moduleid;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setModuleid(int moduleid) {
        this.moduleid = moduleid;
    }

    public int getModuleid() {
        return moduleid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getRid() {
        return rid;
    }
}

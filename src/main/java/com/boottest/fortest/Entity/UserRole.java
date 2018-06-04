package com.boottest.fortest.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_user")
public class UserRole implements Serializable{

    private static final long serialVersionUID = -4007752569293916009L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private int uid;

    @Column
    private int rid;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString(){
        return "{\"id\":"+id+",\"uid\":"+uid+",\"rid\":"+rid+"}";
    }
}

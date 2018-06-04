package com.boottest.fortest.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Module")
public class Module implements Serializable {
    private static final long serialVersionUID = -6735949098533146567L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int  id;

    @Column
    private String url;

    @Column
    private String name;

    @Column
    private int parentid;

    @Column
    private int moduleid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getModuleid() {
        return moduleid;
    }

    public void setModuleid(int moduleid) {
        this.moduleid = moduleid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString(){
        return "{\"id\":"+id+",\"moduleid\":"+moduleid+"\"name\":"+name+"\"parentid\":"+parentid+"\"url\":"+url+"}";
    }
}

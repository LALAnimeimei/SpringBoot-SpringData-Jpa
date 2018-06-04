package com.boottest.fortest.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Role")
public class Role implements Serializable{
    private static final long serialVersionUID = -5729344223722545911L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String roleName;

    @Column
    private  String roleNameZh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNameZh() {
        return roleNameZh;
    }

    public void setRoleNameZh(String roleNameZh){
        this.roleNameZh=roleNameZh;
    }

    @Override
    public String toString(){
        return "{\"id\":"+ id +",\"RoleName\":" + roleName +",\"RoleNameZh\":" + roleNameZh + "}";
    }
}

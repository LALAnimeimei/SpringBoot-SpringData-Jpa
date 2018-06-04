package com.boottest.fortest.Service.Interface;

import com.boottest.fortest.Entity.Role;
import com.boottest.fortest.Entity.UserEntity;
import com.boottest.fortest.Entity.UserRole;

import java.sql.Timestamp;
import java.util.List;


public interface IGetInfo {

    //----------------------------User--------------------------------------------
    List<UserEntity> getUserInfo(String name);

    List<UserEntity> getUserList();

    UserEntity getUser(int id);

    void UpdataUser(Timestamp create_time, int dep_id, String name,String address, String password, int id);

    void addUser(Timestamp create_time,int dep_id,String name,String address,String password);

    void deleteUser(UserEntity userEntity);

    //-----------------------------Role----------------------------------------------
    List<Role> getRoleInfo(String RoleName);

    Role getRole(int id);

    void UpdataRole(String RoleName,String RoleNameZh,int id);

    void addRole(Role role);

    void addRoles(List<Role> roleList);

    void deleteRole(Role role);

    //---------------------------UserRole-------------------------------------------
    UserRole getUserRole(int uid);

    void addUserRole(UserRole userRole);

    void deleteUserRole(UserRole userRole);

    void updataUserRole(int uid,int rid);

}

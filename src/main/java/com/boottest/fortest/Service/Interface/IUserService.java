package com.boottest.fortest.Service.Interface;

import com.boottest.fortest.Entity.Module;
import com.boottest.fortest.Entity.UserEntity;
import com.boottest.fortest.Entity.UserRole;
import java.sql.Timestamp;
import java.util.List;

public interface IUserService {

    //----------------------------User--------------------------------------------
    List<UserEntity> getUserInfo(String name);

    List<UserEntity> getUserList();

    UserEntity getUser(int id);

    void UpdataUser(Timestamp create_time, int dep_id, String name, String address, String password, int id);

    void addUser(Timestamp create_time,int dep_id,String name,String address,String password);

    void deleteUser(UserEntity userEntity);

    //---------------------------UserRole-------------------------------------------
    List<UserRole> getUserRole(int uid);

    void addUserRole(UserRole userRole);

    void deleteUserRole(UserRole userRole);

    void updataUserRole(int uid,int rid);

    //-------------------------UserModule------------------------------------------
    List<Module> getModuleByUser(int uid);
}

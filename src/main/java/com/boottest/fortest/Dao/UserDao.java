package com.boottest.fortest.Dao;

import com.boottest.fortest.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.sql.Timestamp;
import  java.util.List;

public interface UserDao extends JpaRepository<UserEntity,Integer>{
    List<UserEntity> findByName(String name);

    UserEntity findUserEntitiesById(int id);

    @Query("select  u from UserEntity u ")
    List<UserEntity> UserList();

    @Modifying
    @Query(value="update user_dao set create_time=?1 , department_id=?2 , name=?3, address=?4 , password=?5 where id=?6",nativeQuery = true)
    void Updata(Timestamp create_time, int dep_id, String name, String address, String password, int id);





}

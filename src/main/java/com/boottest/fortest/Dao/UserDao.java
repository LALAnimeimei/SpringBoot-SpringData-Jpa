package com.boottest.fortest.Dao;

import com.boottest.fortest.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.sql.Date;
import  java.util.List;

public interface UserDao extends JpaRepository<UserEntity,Integer>{
    UserEntity findByName(String name);
//    UserEntity findByNameAndDepart(String name,int departmentid);
//    List<UserEntity> queryByCreateDateGreaterThanEqual(Date start);

    @Query("select u from UserEntity u where u.name=?1 and u.departmentId=?2")
    public UserEntity findUser(String name, Integer departmentId);

}

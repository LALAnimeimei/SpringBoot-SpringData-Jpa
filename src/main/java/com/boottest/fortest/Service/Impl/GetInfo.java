package com.boottest.fortest.Service.Impl;

import com.boottest.fortest.Dao.UserDao;
import com.boottest.fortest.Entity.UserEntity;
import com.boottest.fortest.Service.Interface.IGetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GetInfo implements IGetInfo{
    @Autowired
    private  UserDao userDao;

    @Override
    public UserEntity getInfo(String name) {
        UserEntity user=userDao.findByName(name);
        return user;
    }
}

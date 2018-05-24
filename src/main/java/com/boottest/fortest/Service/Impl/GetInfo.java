package com.boottest.fortest.Service.Impl;

import com.boottest.fortest.Dao.UserDao;
import com.boottest.fortest.Entity.UserEntity;
import com.boottest.fortest.Service.Interface.IGetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//业务层Bean
@Service
public class GetInfo implements IGetInfo{
    @Autowired
    private  UserDao userDao;

    /**
     *   @author 390766
     *   @date   2018/5/18  10:54
     *   @content    获取用户信息
     */
    @Override
    public UserEntity getInfo(String name) {
        UserEntity user=userDao.findByName(name);
        return user;
    }
}

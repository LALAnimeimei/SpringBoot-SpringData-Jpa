package com.boottest.fortest.Service.Impl;

import com.boottest.fortest.Dao.ModuleDao;
import com.boottest.fortest.Dao.RoleModuleDao;
import com.boottest.fortest.Dao.UserDao;
import com.boottest.fortest.Dao.UserRoleDao;
import com.boottest.fortest.Entity.Module;
import com.boottest.fortest.Entity.UserEntity;
import com.boottest.fortest.Entity.UserRole;
import com.boottest.fortest.Service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private ModuleDao moduleDao;

    @Autowired
    private RoleModuleDao roleModuleDao;

    @Override
    public List<UserEntity> getUserInfo(String name) {
        List<UserEntity> user=userDao.findByName(name);
        return user;
    }

    @Override
    public UserEntity getUser(int id){
        UserEntity userEntity=userDao.findUserEntitiesById(id);
        return  userEntity;
    }

    @Override
    public void UpdataUser(Timestamp create_time, int dep_id, String name, String address, String password, int id){
        userDao.Updata(create_time,dep_id,name,address,password,id);
    }

    @Override
    public void addUser(Timestamp create_time,int dep_id,String name,String address,String password){
        UserEntity user=new UserEntity();
        user.setCreateDate(create_time);
        user.setDepartmentId(dep_id);
        user.setAddress(address);
        user.setName(name);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public void deleteUser(UserEntity userEntity){
        userDao.delete(userEntity);
    }

    @Override
    public  List<UserEntity> getUserList(){
        List<UserEntity> userEntityList=userDao.UserList();
        return userEntityList;
    }

    @Override
    public UserRole getUserRole(int uid){
        return userRoleDao.findByUid(uid);
    }

    @Override
    public void addUserRole(UserRole userRole){
        userRoleDao.save(userRole);
    }

    @Override
    public void deleteUserRole(UserRole userRole){
        userRoleDao.delete(userRole);
    }

    @Override
    public void updataUserRole(int uid,int rid){
        userRoleDao.updataUserRole(uid, rid);
    }

    @Override
    public List<Module> getModuleByUser(int uid){
        int rid=userRoleDao.findByUid(uid).getRid();
       return moduleDao.getModulesByRole(rid);
//        return  roleModuleDao.getModulesByUser(uid);
    }
}

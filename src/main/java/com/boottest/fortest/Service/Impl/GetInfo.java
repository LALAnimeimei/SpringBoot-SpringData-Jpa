package com.boottest.fortest.Service.Impl;

import com.boottest.fortest.Dao.ModuleDao;
import com.boottest.fortest.Dao.RoleDao;
import com.boottest.fortest.Dao.UserDao;
import com.boottest.fortest.Dao.UserRoleDao;
import com.boottest.fortest.Entity.Module;
import com.boottest.fortest.Entity.Role;
import com.boottest.fortest.Entity.UserEntity;
import com.boottest.fortest.Entity.UserRole;
import com.boottest.fortest.Service.Interface.IGetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.List;

//业务层Bean
@Service
@Transactional
public class GetInfo implements IGetInfo{
    @Autowired
    private  UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private ModuleDao moduleDao;
    /**
     *   @author 390766
     *   @date   2018/5/18  10:54
     *   @content    获取用户信息
     */
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
    public List<Role> getRoleInfo(String RoleName){
        List<Role> roleList=roleDao.findRolesByRoleName(RoleName);
        return roleList;
    }

    @Override
    public Role getRole(int id){
        Role role=roleDao.findRoleById(id);
        return role;
    }

    @Override
    public void UpdataRole(String RoleName,String RoleNameZh,int id){
        roleDao.UpData(RoleName,RoleNameZh,id);
    }

    @Override
    public void addRole(Role role){
        roleDao.save(role);
    }

    @Override
    public void addRoles(List<Role> rolelist){
        roleDao.saveAll(rolelist);
    }

    @Override
    public  void deleteRole(Role role){
        roleDao.delete(role);
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
    public List<Module> getModuleList(){
        return moduleDao.findAll();
    }

    @Override
    public Module getModule(int moduleid){
        return moduleDao.findModuleByModuleid(moduleid);
    }

    @Override
    public void addModule(Module module){
        moduleDao.save(module);
    }

    @Override
    public void deleteModule(Module module){
        moduleDao.delete(module);
    }

    @Override
    public void updataModule(int moduleid,int parentid,String url,String name,int id){
        moduleDao.updataModule(moduleid,parentid,url,name,id);
    }

}

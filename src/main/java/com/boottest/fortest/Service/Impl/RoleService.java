package com.boottest.fortest.Service.Impl;

import com.boottest.fortest.Dao.RoleDao;
import com.boottest.fortest.Dao.RoleModuleDao;
import com.boottest.fortest.Entity.Role;
import com.boottest.fortest.Entity.RoleModule;
import com.boottest.fortest.Service.Interface.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService implements IRoleService{

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleModuleDao roleModuleDao;

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
    public List<RoleModule> getModuleByRole(int rid){
        return roleModuleDao.getRoleModulesByRid(rid);
    }

    @Override
    public void addRoleModule(List<RoleModule> roleModuleList){
        roleModuleDao.saveAll(roleModuleList);
    }

    @Override
    public void updataRoleModule(int rid,List<RoleModule> roleModuleList){
        deleteRoleModules(rid);
        addRoleModule(roleModuleList);
    }

    @Override
    public void deleteRoleModules(int rid){
        roleModuleDao.deleteAll(getModuleByRole(rid));
    }
}

package com.boottest.fortest.Service.Interface;

import com.boottest.fortest.Entity.Role;
import com.boottest.fortest.Entity.RoleModule;

import java.util.List;

public interface IRoleService {

    //-----------------------------Role----------------------------------------------
    List<Role> getRoleInfo(String RoleName);

    Role getRole(int id);

    void UpdataRole(String RoleName,String RoleNameZh,int id);

    void addRole(Role role);

    void addRoles(List<Role> roleList);

    void deleteRole(Role role);

    //--------------------------RoleModule-------------------------------------------
    List<RoleModule> getModuleByRole(int rid);

    void addRoleModule(List<RoleModule> roleModuleList);

    void updataRoleModule(int rid,List<RoleModule> roleModuleList);

    void deleteRoleModules(int rid);
}

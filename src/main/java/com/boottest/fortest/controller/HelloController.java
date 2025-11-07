package com.boottest.fortest.controller;


import com.boottest.fortest.Entity.Role;
import com.boottest.fortest.Entity.RoleModule;
import com.boottest.fortest.Entity.UserEntity;
import com.boottest.fortest.Entity.UserRole;
import com.boottest.fortest.Service.Interface.IModuleService;
import com.boottest.fortest.Service.Interface.IRoleService;
import com.boottest.fortest.Service.Interface.IUserService;
import com.boottest.fortest.util.BaseUtil;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import  net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

//以下映射拦截均为方法测试集
@Controller
public class HelloController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IModuleService moduleService;


    @RequestMapping("/user/name/{name}")
    public @ResponseBody JSON GetUser(@PathVariable("name") String name){
        List<UserEntity> userEntityList=userService.getUserInfo(name);
        System.out.println("进入Controller      ");
        JSONArray jsonArray=new JSONArray();
        JSONObject json=new JSONObject();
        for(int i=0;i<userEntityList.size();i++){
            UserEntity userEntity=userEntityList.get(i);
            json.put("name",userEntity.getName());
            json.put("DepartmentId",userEntity.getDepartmentId());
            json.put("CreateDate",userEntity.getCreateDate().toString());
            jsonArray.add(json);
            json.clear();
        }
        return jsonArray;
    }

    @RequestMapping("/user/updata")
    public void UpdataUser(){
        Timestamp currenttime=new Timestamp(System.currentTimeMillis());

        userService.UpdataUser(currenttime,3,"hxupdata","123","123321",1);
    }

    @RequestMapping("/user/add")
    public void addUser(HttpServletResponse response){
        Timestamp currenttime=new Timestamp(System.currentTimeMillis());
        userService.addUser(currenttime,3,"newuser","newaddress","npass");
        List<UserEntity> userEntityList=userService.getUserInfo("newuser");
        int uid=userEntityList.get(0).getId();
        int rid=roleService.getRoleInfo("sjrole").get(0).getId();
        UserRole userRole=new UserRole();
        userRole.setUid(uid);
        userRole.setRid(rid);
        userService.addUserRole(userRole);
        BaseUtil.httpResponse(response,"用户角色保存成功");
    }

    @RequestMapping("/user/delete")
    public void deleteUser(){
        UserEntity userEntity=userService.getUser(11);
        userService.deleteUser(userEntity);
    }

    @RequestMapping("/user/list")
    public @ResponseBody JSON GetUserList(){
        List<UserEntity> userEntityList=userService.getUserList();
        JSONArray jsonArray=new JSONArray();
        JSONObject json=new JSONObject();
        for(int i=0;i<userEntityList.size();i++){
            UserEntity userEntity=userEntityList.get(i);
            json.put("name",userEntity.getName());
            json.put("DepartmentId",userEntity.getDepartmentId());
            json.put("CreateDate",userEntity.getCreateDate().toString());
            jsonArray.add(json);
            json.clear();
        }
        return jsonArray;
    }

    @RequestMapping("/Role/{RoleName}")
    public @ResponseBody JSON GetRole(@PathVariable("RoleName")String RoleName){
        List<Role> roleList=roleService.getRoleInfo(RoleName);
        System.out.println("进入Controller");
        JSONArray jsonArray=new JSONArray();
        JSONObject json=new JSONObject();
        for(int i=0;i<roleList.size();i++){
            Role role=roleList.get(i);
            json.put("id",role.getId());
            json.put("rolename",role.getRoleName());
            json.put("rolezh",role.getRoleNameZh());
            jsonArray.add(json);
            json.clear();
        }
        return jsonArray;
    }

    @RequestMapping("/Role/updata")
    public void UpdataRole(){
        roleService.UpdataRole("hxnew","hxnew",1);
    }

    @RequestMapping("/Role/add/newrole")
    public void AddRole(){
        Role role=new Role();
        role.setRoleName("newrole");
        role.setRoleNameZh("newzh");
        roleService.addRole(role);
    }

    @RequestMapping("/Role/add/addRoles")
    public void AddRoles(){
        Role role=new Role();
        role.setRoleName("role1");
        role.setRoleNameZh("rolezh1");
        List<Role> roleList=new ArrayList<>();
        Role role2=new Role();
        role2.setRoleName("role2");
        role2.setRoleNameZh("rolezh2");
        roleList.add(role);
        roleList.add(role2);
        roleService.addRoles(roleList);
    }

    @RequestMapping("/Role/delete/{id}")
    public void deleteRole(@PathVariable("id")int id, HttpServletResponse response){
        Role role=roleService.getRole(id);
        roleService.deleteRole(role);
        BaseUtil.httpResponse(response,"{\"status\":1,\"success\":1,\"message\":\"角色"+role.getRoleName()+"删除成功\"}");
    }

    @RequestMapping("/RoleModule/addRoleModule")
    public void addRoleModule(HttpServletResponse response){
        RoleModule roleModule=new RoleModule();
        roleModule.setModuleid(1);
        roleModule.setRid(5);
        RoleModule roleModule1=new RoleModule();
        roleModule1.setModuleid(2);
        roleModule1.setRid(5);
        List<RoleModule> list=new ArrayList<>();
        list.add(roleModule);
        list.add(roleModule1);
        roleService.addRoleModule(list);
        BaseUtil.httpResponse(response,"ok,已添加角色拥有模块");
    }

    @RequestMapping("/RoleModule/deleteRoleModule")
    public void deleteRoleModule(HttpServletResponse response){
        roleService.deleteRoleModules(5);
        BaseUtil.httpResponse(response,"ok,已删除角色拥有模块");
    }

}

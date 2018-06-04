package com.boottest.fortest.controller;


import com.boottest.fortest.Entity.Role;
import com.boottest.fortest.Entity.UserEntity;
import com.boottest.fortest.Entity.UserRole;
import com.boottest.fortest.Service.Interface.IGetInfo;
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
    IGetInfo iGetInfo;


    @RequestMapping("/user/name/{name}")
    public @ResponseBody JSON GetUser(@PathVariable("name") String name){
        List<UserEntity> userEntityList=iGetInfo.getUserInfo(name);
        System.out.println("进入Controller");
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

        iGetInfo.UpdataUser(currenttime,3,"hxupdata","123","123321",1);
    }

    @RequestMapping("/user/add")
    public void addUser(HttpServletResponse response){
        Timestamp currenttime=new Timestamp(System.currentTimeMillis());
        iGetInfo.addUser(currenttime,3,"newuser","newaddress","npass");
        List<UserEntity> userEntityList=iGetInfo.getUserInfo("newuser");
        int uid=userEntityList.get(0).getId();
        int rid=iGetInfo.getRoleInfo("sjrole").get(0).getId();
        UserRole userRole=new UserRole();
        userRole.setUid(uid);
        userRole.setRid(rid);
        iGetInfo.addUserRole(userRole);
        BaseUtil.httpResponse(response,"用户角色保存成功");
    }

    @RequestMapping("/user/delete")
    public void deleteUser(){
        UserEntity userEntity=iGetInfo.getUser(11);
        iGetInfo.deleteUser(userEntity);
    }

    @RequestMapping("/user/list")
    public @ResponseBody JSON GetUserList(){
        List<UserEntity> userEntityList=iGetInfo.getUserList();
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
        List<Role> roleList=iGetInfo.getRoleInfo(RoleName);
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
        iGetInfo.UpdataRole("hxnew","hxnew",1);
    }

    @RequestMapping("/Role/add/newrole")
    public void AddRole(){
        Role role=new Role();
        role.setRoleName("newrole");
        role.setRoleNameZh("newzh");
        iGetInfo.addRole(role);
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
        iGetInfo.addRoles(roleList);
    }

    @RequestMapping("/Role/delete/{id}")
    public void deleteRole(@PathVariable("id")int id, HttpServletResponse response){
        Role role=iGetInfo.getRole(id);
        iGetInfo.deleteRole(role);
        BaseUtil.httpResponse(response,"{\"status\":1,\"success\":1,\"message\":\"角色"+role.getRoleName()+"删除成功\"}");
    }

}

package com.boottest.fortest.controller;


import com.boottest.fortest.Entity.UserEntity;
import com.boottest.fortest.Service.Impl.GetInfo;
import com.boottest.fortest.Service.Interface.IGetInfo;
import net.sf.json.JSON;
import  net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class HelloController {
    @Autowired
    IGetInfo iGetInfo;

    @RequestMapping("/hello1/{name}")
    public @ResponseBody JSON HelloWorld(@PathVariable("name") String name){
        UserEntity user=iGetInfo.getInfo(name);
        System.out.println("进入Controller");
        JSONObject json=new JSONObject();
        json.put("name",user.getName());
        json.put("DepartmentId",user.getDepartmentId());
        json.put("CreateDate",user.getCreateDate().toString());
        return json;
    }
}

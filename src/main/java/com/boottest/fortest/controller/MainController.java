package com.boottest.fortest.controller;


import com.boottest.fortest.Entity.Module;
import com.boottest.fortest.Service.Interface.IUserService;
import com.boottest.fortest.util.BaseUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/menu/gettree")
    public void getTree(HttpServletRequest request, HttpServletResponse response){
        //从session中获取用户
        //int user_id=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        int user_id=1;

        //返回菜单列表
        List<Module> moduleList=userService.getModuleByUser(user_id);

        //返回菜单树
        JSONArray json=BaseUtil.getModuleTree(moduleList,0);
        BaseUtil.httpResponse(response,json.toString());

        //返回菜单列表
//        BaseUtil.httpResponse(response,moduleList.toString());
    }

}

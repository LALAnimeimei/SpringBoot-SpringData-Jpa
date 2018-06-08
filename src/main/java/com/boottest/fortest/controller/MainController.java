package com.boottest.fortest.controller;

import com.boottest.fortest.Dao.RoleModuleDao;
import com.boottest.fortest.Entity.Module;
import com.boottest.fortest.Service.Interface.IUserService;
import com.boottest.fortest.util.BaseUtil;
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
//         int user_id=Integer.parseInt(request.getSession().getAttribute("user_id").toString());
        int user_id=1;
        List<Module> moduleList=userService.getModuleByUser(user_id);
        BaseUtil.httpResponse(response,moduleList.toString());
    }

}

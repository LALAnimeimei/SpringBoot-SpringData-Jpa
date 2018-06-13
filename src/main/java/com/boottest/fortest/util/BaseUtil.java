package com.boottest.fortest.util;

import com.boottest.fortest.Entity.Module;
import com.boottest.fortest.Entity.TreeNode;
import net.sf.json.JSONArray;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseUtil {
    public static void httpResponse(HttpServletResponse response,String str){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setHeader("Cache-Control","no-store");

        try{
            response.getWriter().write(str);
            response.getWriter().close();
        }catch (IOException var2){
            var2.printStackTrace();
        }
    }

    //考虑是直接在后台写成树状还是前台根据id 和parentid 拼凑成 树状结构
    public static JSONArray getModuleTree(List<Module> moduleList,int root){
        TreeNode treeNode=new TreeNode();
        treeNode.setId(root);

        for(int i=0;i<moduleList.size();i++){
            if(moduleList.get(i).getModuleid()==root)
                treeNode.setText(moduleList.get(i).getName());
        }

        if (moduleList.size()>0 && moduleList!=null)
            createNode(moduleList,treeNode);

        JSONArray jsonArray=JSONArray.fromObject(treeNode.getChildren());
        return jsonArray;
    }

    public static void createNode(List<Module> list,TreeNode treeNode){
        long parentid=treeNode.getId();
        List<TreeNode> children=new ArrayList<>();

        for(int i=0;i<list.size();i++){
            Module module=list.get(i);

            if(module.getParentid()==parentid){
                TreeNode node=new TreeNode();
                node.setId(module.getModuleid());
                node.setText(module.getName());
                node.setUrl(module.getUrl());
                node.setPid(module.getParentid());

                createNode(list,node);
                children.add(node);
            }
        }

        if(children.size()>0){
            treeNode.setChildren(children);
        }
    }
}

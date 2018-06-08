package com.boottest.fortest.Service.Interface;

import com.boottest.fortest.Entity.Module;

import java.util.List;

public interface IModuleService {
    //--------------------------Module------------------------------------------------
    List<Module> getModuleList();

    Module getModule(int moduleid);

    void addModule(Module module);

    void deleteModule(Module module);

    void updataModule(int moduleid,int parentid,String url,String name,int id);
}

package com.boottest.fortest.Service.Impl;

import com.boottest.fortest.Dao.ModuleDao;
import com.boottest.fortest.Entity.Module;
import com.boottest.fortest.Service.Interface.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ModuleService implements IModuleService {

    @Autowired
    private ModuleDao moduleDao;

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

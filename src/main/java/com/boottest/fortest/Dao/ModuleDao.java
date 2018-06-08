package com.boottest.fortest.Dao;

import com.boottest.fortest.Entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *   @author 390766
 *   @date   2018/6/4  18:09
 *   @content  模块的dao层操作
 */
public interface ModuleDao extends JpaRepository<Module,Integer>{
//简单的底层实现机制
      Module findModuleByModuleid(int moduleid);

      @Query(value="select m.* from Module m,Role_module rm where m.moduleid=rm.moduleid and rm.rid=?1",nativeQuery = true)
      List<Module> getModulesByRole(int rid);

      @Modifying
      @Query(value = "update Module set moduleid=?1 , parentid=?2 , url=?3 , name=?4 where id=?5")
      void updataModule(int moduleid,int parentid,String url,String name,int id);
}

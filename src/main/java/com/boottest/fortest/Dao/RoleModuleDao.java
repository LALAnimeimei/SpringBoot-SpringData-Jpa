package com.boottest.fortest.Dao;

import com.boottest.fortest.Entity.Module;
import com.boottest.fortest.Entity.RoleModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleModuleDao extends JpaRepository<RoleModule,Integer> {
    List<RoleModule> getRoleModulesByRid(int rid);

//    @Query(value="select m.* from Module m,Role_module rm,Role_user ur where m.moduleid=rm.moduleid and rm.rid=ur.rid  and ur.uid=?1",nativeQuery = true)
//    List<Module> getModulesByUser(int uid);
}

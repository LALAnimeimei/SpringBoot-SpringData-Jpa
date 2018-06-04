package com.boottest.fortest.Dao;

import com.boottest.fortest.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RoleDao extends JpaRepository<Role,Integer>{
    List<Role> findRolesByRoleName(String RoleName);

    Role findRoleByRoleName(String RoleName);

    Role findRoleById(int id);

    @Query(value="Select * from Role where id = ?1",nativeQuery = true)
    public List<Role> QueryRole(int id);

    //其实感觉这种方式 跟save方法更新差不多
    @Modifying
    @Query(value = "update  Role r set r.role_name=?1 , r.role_name_zh=?2 where id=?3",nativeQuery = true)
    public void UpData(String RoleName,String RoleNameZh,int id);
}

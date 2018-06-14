package com.boottest.fortest.Dao;

import com.boottest.fortest.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleDao extends JpaRepository<UserRole,Integer> {
    UserRole findByUid(int uid);

    List<UserRole> findUserRolesByUid(int uid);

    @Query(value = "updata user_role set uid=?1 , rid=?2 ",nativeQuery = true)
    void updataUserRole(int uid,int rid);
}

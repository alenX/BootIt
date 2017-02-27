package org.wangss.Daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.wangss.Models.BootUser;

import java.util.List;

/**
 * Created by wangss on 2017/2/24.
 */
public interface BootUserDao extends JpaRepository<BootUser,Long> {
    public BootUser getBootUserByid(Long id);
    public List<BootUser> getBootUserByname(String username);
}

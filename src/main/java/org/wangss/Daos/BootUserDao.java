package org.wangss.Daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wangss.Models.BootUser;

/**
 * Created by wangss on 2017/2/24.
 */
public interface BootUserDao extends JpaRepository<BootUser,Long> {
    public BootUser getBootUserByid(Long id);
    public BootUser getBootUserByname(String username);
}

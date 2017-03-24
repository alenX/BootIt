package org.wangss.Daos;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.wangss.Models.BootUser;

import java.util.List;

/**
 * Created by wangss on 2017/2/24.
 */
@Mapper
public interface IBootUserMapper {
    @Select("select * from boot_user where id=#{id} ")
    public BootUser getBootUserByid(Long id);
    @Select("select * from boot_user where name =#{username}")
    public List<BootUser> getBootUserByname(String username);
}

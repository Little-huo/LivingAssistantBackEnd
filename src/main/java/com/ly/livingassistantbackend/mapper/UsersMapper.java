package com.ly.livingassistantbackend.mapper;

import com.ly.livingassistantbackend.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author 霍如意
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-09-15 15:10:07
* @Entity com.ly.livingassistantbackend.pojo.User
*/
@Mapper
public interface UsersMapper extends BaseMapper<User> {
    @Select("SELECT * FROM users WHERE email = #{email}")
    User selectByEmail(String email);
}





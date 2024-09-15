package com.ly.livingassistantbackend.service;

import com.ly.livingassistantbackend.pojo.PasswordUpdateDTO;
import com.ly.livingassistantbackend.pojo.Result;
import com.ly.livingassistantbackend.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 霍如意
* @description 针对表【users】的数据库操作Service
* @createDate 2024-09-15 15:10:07
*/
public interface UsersService extends IService<User> {

    Result register(User userData);

    Result login(User loginData);

    Result updatePassword(PasswordUpdateDTO updateDTO);
}

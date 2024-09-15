package com.ly.livingassistantbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.livingassistantbackend.pojo.PasswordUpdateDTO;
import com.ly.livingassistantbackend.pojo.Result;
import com.ly.livingassistantbackend.pojo.User;
import com.ly.livingassistantbackend.service.UsersService;
import com.ly.livingassistantbackend.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
* @author 霍如意
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-09-15 15:10:07
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, User>
    implements UsersService{

    @Override
    public Result register(User userData) {
        userData.setCreatedAt(LocalDateTime.now());
        userData.setUpdatedAt(LocalDateTime.now());
        try {
            save(userData);
            return Result.success("创建成功");
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return Result.success("创建失败");
        }
    }

    @Override
    public Result login(User loginData) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getEmail,loginData.getEmail());
        User user = getOne(wrapper);
        if (user == null) {
            return Result.error("用户名不存在");
        }

        if (!user.getPassword().equals(loginData.getPassword())) {
            return Result.error("密码错误");
        }

        // 登录成功，返回成功结果，可以返回一些用户信息或者 token
        return Result.success(user);
    }

    @Override
    public Result updatePassword(PasswordUpdateDTO updateDTO) {
        User user = baseMapper.selectByEmail(updateDTO.getEmail());
        if (user == null) {
            return Result.error("用户不存在");
        }

        // 验证旧密码
        if (!user.getPassword().equals(updateDTO.getOldPassword())) {
            return Result.error("旧密码错误");
        }

        // 更新密码
        user.setPassword(updateDTO.getNewPassword());
        user.setUpdatedAt(LocalDateTime.now());
        baseMapper.updateById(user);
        return Result.success("密码更新成功");
    }

}





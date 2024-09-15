package com.ly.livingassistantbackend.Controller;

import com.ly.livingassistantbackend.pojo.PasswordUpdateDTO;
import com.ly.livingassistantbackend.pojo.Result;
import com.ly.livingassistantbackend.pojo.User;
import com.ly.livingassistantbackend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public Result register(@RequestBody User userData){
        return usersService.register(userData);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User loginData) {

        return usersService.login(loginData);
    }

    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestBody PasswordUpdateDTO updateDTO) {
        return usersService.updatePassword(updateDTO);
    }

}

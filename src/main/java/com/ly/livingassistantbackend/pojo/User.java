package com.ly.livingassistantbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName users
 */
@TableName(value ="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String email;

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
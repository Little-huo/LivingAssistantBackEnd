package com.ly.livingassistantbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordUpdateDTO {
    private String email;
    private String oldPassword;
    private String newPassword;
}

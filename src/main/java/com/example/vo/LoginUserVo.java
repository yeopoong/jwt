package com.example.vo;

import lombok.Data;

@Data
public class LoginUserVo {

    private String userId;
    private String password;

    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
}
package com.example.vo;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class AuthorityVo implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String authority;
}
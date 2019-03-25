package com.example.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.example.vo.LoginUserVo;

@Mapper
public interface LoginDao {

    public LoginUserVo getUser(String userId);

    public Set<GrantedAuthority> getAuthority(String userId);
}
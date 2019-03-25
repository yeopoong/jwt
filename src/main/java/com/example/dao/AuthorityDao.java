package com.example.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.example.vo.AuthorityVo;

@Mapper
public interface AuthorityDao {

    public List<AuthorityVo> getAuthoritys();

    public Set<GrantedAuthority> getAuthority(String userId);

    public void addAuthority(AuthorityVo authorityVo);

    public void updateAuthority(AuthorityVo authorityVo);

    public void deleteAuthority(int id);
}

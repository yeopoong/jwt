package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

import lombok.Data;

@Data
@Entity
@Proxy(lazy = false)
public class User {

    @Id
    private String userId;
    private String password;
    private String userName;

    private String birthDay;
    private String phone;
    private String address;

    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
}
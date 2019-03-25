package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.annotations.Proxy;

import com.example.domain.Authority.PK;

import lombok.Data;

@Data
@Entity
@IdClass(PK.class)
@Proxy(lazy = false)
public class Authority {

    public Authority(String userId, String authority) {
        this.userId = userId;
        this.authority = authority;
        
    }

    @Id
    @Column(insertable = false, updatable = false)
    private String userId;
   
    @Id
    @Column(insertable = false, updatable = false)
    private String authority;
    
    @Data
    public class PK implements Serializable {

        private static final long serialVersionUID = 1L;

        private String userId;
        private String authority;

        public PK(String userId, String authority) {
            this.userId = userId;
            this.authority = authority;
        }
    }
}
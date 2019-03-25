package com.example.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.security.AuthenticationToken;
import com.example.service.LoginService;
import com.example.vo.LoginVo;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public AuthenticationToken login(@RequestBody LoginVo loginVo, HttpSession session) {

        String userId = loginVo.getUserId();
        String password = loginVo.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userId, password);

        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext());
        
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return new AuthenticationToken(user.getUsername(), user.getAuthorities(), session.getId());
    }
}
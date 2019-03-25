package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class LoginService implements UserDetailsService {

/*    
    @Resource
    private AuthorityDao authorityDao;

    @Resource
    private LoginDao loginDao;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        
        LoginUserVo loginUser = loginDao.getUser(userId); 

        if (loginUser != null) {
            Set<GrantedAuthority> authority = authorityDao.getAuthority(userId);
            return new User(loginUser.getUserId(), loginUser.getPassword(), authority);
        }

        throw new UsernameNotFoundException("User '" + userId + "' not found.");
    }
    
*/    
    @Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		final User user = userRepository.findByUserName(userName);

		if (user == null) {
			throw new UsernameNotFoundException("User '" + userName + "' not found");
		}

		return org.springframework.security.core.userdetails.User//
				.withUsername(userName)
				.password(user.getPassword())
//				.authorities(user.getRoles())
				.accountExpired(false)
				.accountLocked(false)
				.credentialsExpired(false)
				.disabled(false)
				.build();
	}
}

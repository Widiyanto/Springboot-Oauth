package wot.auth.server.service.impl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import wot.auth.server.CommonPasswordEncoder;
import wot.auth.server.UserDetailOauth;
import wot.auth.server.domain.RoleUser;
import wot.auth.server.service.SecurityService;




@Service("Order2")
public class UserDetailServiceIOauthImpl implements UserDetailsService{
	
	@Autowired
    private SecurityService securityService;
	
	@Autowired
	private CommonPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RoleUser roleUser = securityService.getRoleUser(username);
		
		return new UserDetailOauth(roleUser.getUserOra().getUsername(), passwordEncoder.encode(roleUser.getUserOra().getPassword()), true, true, true, true,new ArrayList<GrantedAuthority>(), roleUser.getLstRole());
	}

}

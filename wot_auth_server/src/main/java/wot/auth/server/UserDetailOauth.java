package wot.auth.server;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import wot.auth.server.domain.RoleOra;



public class UserDetailOauth extends User {

	private static final long serialVersionUID = 1L;
	private List<RoleOra> roleUser;

	public UserDetailOauth(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	public UserDetailOauth(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, List<RoleOra> grantedAuthorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.roleUser=grantedAuthorities;
	}

	public List<RoleOra> getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(List<RoleOra> roleUser) {
		this.roleUser = roleUser;
	}	
	
}

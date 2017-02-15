package wot.auth.server.service;

import java.util.List;

import wot.auth.server.domain.RoleOra;
import wot.auth.server.domain.RoleUser;


public interface SecurityService {
	List<RoleOra> listRole(String username);
    RoleUser getRoleUser(String username);
}

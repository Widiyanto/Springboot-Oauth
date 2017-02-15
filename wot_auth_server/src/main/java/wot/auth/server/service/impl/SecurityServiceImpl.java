package wot.auth.server.service.impl;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wot.auth.server.dao.RoleMapper;
import wot.auth.server.dao.UserMapper;
import wot.auth.server.domain.RoleOra;
import wot.auth.server.domain.RoleUser;
import wot.auth.server.domain.UserOra;
import wot.auth.server.service.SecurityService;



@Transactional
@MapperScan(basePackages={"wot.auth.server.dao"})
@Service("securityService")
public class SecurityServiceImpl implements SecurityService {

	@Autowired
    private UserMapper userMapper;
	
	@Autowired
    private RoleMapper roleMapper;
	
	@Override
	public List<RoleOra> listRole(String username) {
		List<RoleOra> roleOras = roleMapper.getRoles(username);
		return roleOras ;
	}

	@Override
	public RoleUser getRoleUser(String username) {
		UserOra userOra = userMapper.findByUsernameCaseInsensitive(username);
		List<RoleOra> roleOras = roleMapper.getRoles(username);
		
		RoleUser roleUser = new RoleUser(userOra, roleOras);
		
		return roleUser;
	}
	
}

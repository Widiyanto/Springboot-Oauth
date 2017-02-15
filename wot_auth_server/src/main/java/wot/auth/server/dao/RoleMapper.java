package wot.auth.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import wot.auth.server.domain.RoleOra;



public interface RoleMapper {
	@Select("SELECT USERNAME, ROLE FROM USER_ROLES WHERE USERNAME=#{username}")
	List<RoleOra> getRoles(String username);
}

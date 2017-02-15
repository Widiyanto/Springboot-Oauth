package wot.auth.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import wot.auth.server.domain.UserOra;


public interface UserMapper {
	@Select("SELECT USERNAME,  PASSWORD FROM USERS")
	public List<UserOra> getUser();
	
	@Select("SELECT USERNAME, PASSWORD FROM USERS WHERE USERNAME = #{username}")
    UserOra findByUsernameCaseInsensitive(String username);

}

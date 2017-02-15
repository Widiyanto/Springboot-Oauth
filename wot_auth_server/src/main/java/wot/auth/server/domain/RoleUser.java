package wot.auth.server.domain;

import java.util.List;

public class RoleUser {
	private UserOra userOra;
	private List<RoleOra> lstRole;
	public RoleUser(UserOra userOra, List<RoleOra> lstRole) {
		super();
		this.userOra = userOra;
		this.lstRole = lstRole;
	}
	public RoleUser() {
		super();
	}
	public UserOra getUserOra() {
		return userOra;
	}
	public void setUserOra(UserOra userOra) {
		this.userOra = userOra;
	}
	public List<RoleOra> getLstRole() {
		return lstRole;
	}
	public void setLstRole(List<RoleOra> lstRole) {
		this.lstRole = lstRole;
	}
	
	
}

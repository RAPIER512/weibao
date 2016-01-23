package ccu.Realm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ccu.model.system.Role;
import ccu.model.system.UserInfo;
import ccu.model.system.UserReRole;
import ccu.springDataDao.system.RoleRepo;
import ccu.springDataDao.system.UserInfoRepo;
import ccu.springDataDao.system.UserReRoleRepo;

public class GetRole {
	
	@Autowired
	private UserInfoRepo userInfoRepo;
	
	@Autowired
	private UserReRoleRepo userReRoleRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public List<String> getRole(String account){
		UserInfo userInfo = userInfoRepo.findByAccount(account);
		UserReRole userReRole = userReRoleRepo.findByUserId(userInfo.getId());
		Role role = roleRepo.findOne(userReRole.getRoleId());
		
		List<String> list = new ArrayList<String>();
		list.add(role.getRoleName());
		return list;
	}

}

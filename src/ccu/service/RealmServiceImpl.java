package ccu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ccu.model.system.Role;
import ccu.model.system.UserInfo;
import ccu.model.system.UserReRole;
import ccu.springDataDao.system.RoleRepo;
import ccu.springDataDao.system.UserInfoRepo;
import ccu.springDataDao.system.UserReRoleRepo;

@Service("realmService")
public class RealmServiceImpl implements RealmService {
	
//	@Autowired
//	private UserInfoRepo userInfoRepo;
//	
//	@Autowired
//	private UserReRoleRepo userReRoleRepo;
//	
//	@Autowired
//	private RoleRepo roleRepo;

	@Autowired(required=false)
	private UserInfoRepo userInfoRepo;
	
	@Autowired(required=false)
	private UserReRoleRepo userReRoleRepo;
	
	@Autowired(required=false)
	private RoleRepo roleRepo;
	
	
	
	public List<String> getRole(String account){
		UserInfo userInfo = userInfoRepo.findByAccount(account);
		UserReRole userReRole = userReRoleRepo.findByUserId(userInfo.getId());
		Role role = roleRepo.findOne(userReRole.getRoleId());
		
		List<String> list = new ArrayList<String>();
		list.add(role.getRoleName());
		return list;
	}

	@Override
	public UserInfo findByAccount(String username) {
		System.out.println("当前已经注入："+userInfoRepo);
		System.out.println("传递的username："+username);
		return userInfoRepo.findByAccount(username);
	}

}

package ccu.service;

import java.util.List;

import ccu.model.system.UserInfo;

public interface RealmService {
	
	public List<String> getRole(String account);
	
	public UserInfo findByAccount(String username);

}

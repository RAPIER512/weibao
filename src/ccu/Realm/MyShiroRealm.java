package ccu.Realm;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import ccu.model.system.UserInfo;
import ccu.service.RealmService;

public class MyShiroRealm extends AuthorizingRealm {
	
	@Resource
	private RealmService realmService;
	
//	@Autowired
//	private GetRole getRole; 
//	@Autowired
//	private UserInfoRepo userInfoRepo;
//
//		public UserInfoRepo getUserInfoRepo() {
//		return userInfoRepo;
//	}
//	public void setUserInfoRepo(UserInfoRepo userInfoRepo) {
//		this.userInfoRepo = userInfoRepo;
//	}
//	public GetRole getGetRole() {
//		return getRole;
//	}
//	public void setGetRole(GetRole getRole) {
//		this.getRole = getRole;
//	}
	
	
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) 
	{
		String account = (String)principals.fromRealm(getName()).iterator().next();
		if( account != null )
		{ 
			// ��ѯ�û���Ȩ��Ϣ
			Collection<String> pers=realmService.getRole(account); 
		    if( pers != null && !pers.isEmpty() )
		    { 
			    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
			    for(String e :pers)
			    {
			    	info.addRole(e);
			    }
			            
			    return info; 
		    } 
		} 
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		 UsernamePasswordToken token = (UsernamePasswordToken) authcToken; 
	      // ͨ�������յ��û���
	      String username = token.getUsername(); 
	      System.out.println("用户名"+username+"正在进行授权处理");
	      if( username != null && !"".equals(username) ){ 
	    	  System.out.println("正在查询查询："+username);
	         UserInfo userInfo = realmService.findByAccount(username); 
	         System.out.println("查询到："+userInfo.getAccount());
	         if( userInfo != null ){
	        	System.out.println("授予用户"+username+"登录权限");
	            return new SimpleAuthenticationInfo(userInfo.getAccount(),userInfo.getPassword(),getName()); 
	         } 
	      } 
		return null;
	}
}

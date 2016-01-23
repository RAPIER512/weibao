package ccu.springDataDao.system;

import ccu.model.system.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Courage on 2015/10/23.
 */


public interface UserInfoRepo extends JpaRepository<UserInfo,String>
{
    //根据Account, Password查询先关信息
    public UserInfo findByAccountAndPassword(String account,String password);

    public UserInfo findByAccount(String account);
}

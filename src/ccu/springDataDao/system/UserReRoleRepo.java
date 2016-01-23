package ccu.springDataDao.system;

import ccu.model.system.UserReRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Courage on 2015/10/31.
 */
public interface UserReRoleRepo extends JpaRepository<UserReRole,String> {

    public UserReRole findByUserId(String userId);

}

package ccu.springDataDao.system;

import ccu.model.system.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Courage on 2015/10/23.
 */
public interface RoleRepo extends JpaRepository<Role,String> {
}

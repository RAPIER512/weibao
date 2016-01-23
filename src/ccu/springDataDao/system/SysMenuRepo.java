package ccu.springDataDao.system;

import ccu.model.system.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;


/**
 * Created by Courage on 2015/10/23.
 */
public interface SysMenuRepo extends JpaRepository<SysMenu,String> {

    public Set<SysMenu> findByRoleId(String roleId);

}

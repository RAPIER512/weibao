package ccu.springDataDao.system;

import ccu.model.system.RoleReMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Courage on 2015/10/31.
 */
public interface RoleReMenuRepo extends JpaRepository<RoleReMenu,String> {

//    public Set<RoleReMenu> findByRoleId(String oleId);

    public List<RoleReMenu> findByRoleId(String roleId);
}

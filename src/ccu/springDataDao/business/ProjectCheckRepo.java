package ccu.springDataDao.business;

import ccu.model.business.ProjectCheck;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Courage on 2015/10/23.
 */
public interface ProjectCheckRepo extends JpaRepository<ProjectCheck,String> {
}

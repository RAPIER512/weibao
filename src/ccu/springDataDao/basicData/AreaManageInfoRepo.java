package ccu.springDataDao.basicData;

import ccu.model.basicData.AreaManageInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Courage on 2015/10/23.
 */
public interface AreaManageInfoRepo extends JpaRepository<AreaManageInfo, String> {
}

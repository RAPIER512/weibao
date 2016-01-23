package ccu.springDataDao.basicData;

import ccu.model.basicData.AreaInfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by Courage on 2015/10/23.
 */
public interface AreaInfoRepo extends JpaRepository<AreaInfo, String> {

    public List<AreaInfo> findByAreaManageId(String areaManageId);

    public List<AreaInfo> findByRepairDepartmentId(String repairDepartmentId);

}

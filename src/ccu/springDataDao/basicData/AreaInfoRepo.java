package ccu.springDataDao.basicData;

import ccu.model.basicData.AreaInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

/**
 * Created by Courage on 2015/10/23.
 */
public interface AreaInfoRepo extends JpaRepository<AreaInfo, String>,JpaSpecificationExecutor<AreaInfo> {

    public List<AreaInfo> findByAreaManageId(String areaManageId);

    public List<AreaInfo> findByRepairDepartmentId(String repairDepartmentId);

}

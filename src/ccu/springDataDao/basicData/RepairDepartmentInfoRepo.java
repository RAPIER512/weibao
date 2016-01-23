package ccu.springDataDao.basicData;

import ccu.model.basicData.RepairDepartmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Courage on 2015/10/23.
 */
public interface RepairDepartmentInfoRepo extends JpaRepository<RepairDepartmentInfo, String> {
}

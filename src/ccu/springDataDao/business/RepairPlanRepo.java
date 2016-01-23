package ccu.springDataDao.business;

import ccu.model.business.RepairPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Courage on 2015/10/23.
 */
public interface RepairPlanRepo extends JpaRepository<RepairPlan,String> {

    public List<RepairPlan> findByAppIdAndPlanType(String appId,String planType);

    public RepairPlan findByAppCodeAndId(String appCode,String planId);
}

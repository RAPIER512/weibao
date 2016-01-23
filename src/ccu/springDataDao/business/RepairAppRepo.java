package ccu.springDataDao.business;

import ccu.model.business.RepairApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


/**
 * Created by Courage on 2015/10/23.
 */
public interface RepairAppRepo extends CrudRepository<RepairApp,String>
{
    public List<RepairApp> findByStep(int step);

    public List<RepairApp> findByMachineId(String machineId);


    public List<RepairApp> findByAreaIdAndAppUserIdAndStep(String areaId,String appUserId,int step);


    public List<RepairApp> findByRepairDepartmentIdAndStep(String repairDepartmentId,int step);


    public List<RepairApp> findByAppCode(String appcode);


    public List<RepairApp> findByAreaIdAndStepAndRepairDepartmentId(String areaId,int step,String repairDepartmentId);


    public List<RepairApp> findByAreaIdAndStep(String areaId ,int step);


    public List<RepairApp> findByPlanId(String planId);

    //public void updateStepAndPlanId(int step,String planId);
    @Modifying
    @Transactional
    @Query("update RepairApp re set re.step = ?1,re.planId =?2,re.appStatus = ?3 where re.id =?4")
    public int setFixedStepAndPlanIdAndAppStatus(int step,String planId,String appStatus,String id);

    @Modifying
    @Transactional
    @Query("update RepairApp  re set re.step = ?1,re.appStatus = ?2,re.planId = ?3 where re.id =?4")
    public int setFixedStepAndAppStatusAndPlanIdById(int step,String status,String planId,String id);
    
    @Modifying
    @Transactional
    @Query("update RepairApp  re set re.appStatus = ?1,re.step = ?2 where re.appCode=?3")
    public int setFixedAppStatusAndStep(String appStatus,int step,String appcode);


}

package ccu.springDataDao.business;

import ccu.model.business.PlanSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * Created by Courage on 2015/10/23.
 */
public interface PlanScheduleRepo extends JpaRepository<PlanSchedule,String> {



}

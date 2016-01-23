package ccu.springDataDao.business;

import ccu.model.business.PlanExam;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Courage on 2015/10/23.
 */
public interface PlanExamRepo  extends JpaRepository<PlanExam,String> {
}

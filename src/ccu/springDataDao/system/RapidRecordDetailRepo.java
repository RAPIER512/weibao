package ccu.springDataDao.system;

import ccu.model.system.RapidRecordDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;


/**
 * Created by Courage on 2015/10/23.
 */
public interface RapidRecordDetailRepo extends JpaRepository<RapidRecordDetail,String>
{

    public List<RapidRecordDetail> findByTypeId(String TypeId);
}

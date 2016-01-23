package ccu.springDataDao.system;

import ccu.model.system.RapidRecordType;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Courage on 2015/10/23.
 */
public interface RapidRecordTypeRepo extends JpaRepository<RapidRecordType,String> {

    public RapidRecordType findByTypeName(String typeName);
}

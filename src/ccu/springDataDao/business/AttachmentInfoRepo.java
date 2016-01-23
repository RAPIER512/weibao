package ccu.springDataDao.business;

import ccu.model.business.AttachmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Courage on 2015/10/23.
 */
public interface AttachmentInfoRepo extends JpaRepository<AttachmentInfo,String> {
}

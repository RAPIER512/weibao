package ccu.springDataDao.basicData;

import ccu.model.basicData.MachineInfo;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Courage on 2015/10/23.
 */
public interface MachineInfoRepo extends JpaRepository<MachineInfo, String> {

    public MachineInfo findByMachineCode(String machineCode);
}

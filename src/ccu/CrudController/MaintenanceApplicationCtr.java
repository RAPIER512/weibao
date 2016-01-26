package ccu.CrudController;

import ccu.model.basicData.AreaInfo;
import ccu.model.basicData.MachineInfo;
import ccu.model.business.RepairApp;
import ccu.model.system.RapidRecordDetail;
import ccu.model.system.RapidRecordType;
import ccu.springDataDao.basicData.AreaInfoRepo;
import ccu.springDataDao.basicData.MachineInfoRepo;
import ccu.springDataDao.business.RepairAppRepo;
import ccu.springDataDao.system.RapidRecordDetailRepo;
import ccu.springDataDao.system.RapidRecordTypeRepo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Courage on 2015/10/28.
 */

@RestController
@Transactional
public class MaintenanceApplicationCtr {
    @Autowired
    AreaInfoRepo areaInfoRepo;

    @Autowired
    RapidRecordDetailRepo rapidRecordDetailRepo;

    @Autowired
    RapidRecordTypeRepo rapidRecordTypeRepo;

    @Autowired
    MachineInfoRepo machineInfoRepo;

    @Autowired
    RepairAppRepo repairAppRepo;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "getMachineInfo", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String getMachineInfo(@RequestBody String str) throws JsonProcessingException {
        JSONObject jsonObject = JSON.parseObject(str);
        MachineInfo machineInfo = machineInfoRepo.findOne(jsonObject.getString("machineId"));
        if (machineInfo.equals("") || machineInfo == null) {
            return "null";
        } else {
            System.out.println(JSON.toJSONString(machineInfo));
            return JSON.toJSONString(machineInfo);
        }
    }

    /**
     * @return
     * @throws JsonProcessingException
     */

    @RequestMapping(value = "getDetailNameByTypeName", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String getDetailNameByTypeName(@RequestBody String str) throws JsonProcessingException {

        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        RapidRecordType rapidRecordType = rapidRecordTypeRepo.findByTypeName(str);
        List<RapidRecordDetail> rapidRecordDetails = new ArrayList<RapidRecordDetail>();
        rapidRecordDetails = rapidRecordDetailRepo.findByTypeId(rapidRecordType.getId());
        List<String> list = new ArrayList<String>();
        if (rapidRecordDetails.size() > 0) {
            for (int i = 0; i < rapidRecordDetails.size(); i++) {
                list.add(rapidRecordDetails.get(i).getDetailName());
            }
            System.out.println(JSON.toJSONString(list));
            return JSON.toJSONString(list);
        } else {
            System.out.println("结果为空！");
            return "null";
        }

    }

    @RequestMapping(value = "getAreaInfoById", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String getAreaInfoById(@RequestBody String str) throws JsonProcessingException {
        AreaInfo areaInfo = areaInfoRepo.findOne(str);
        System.out.println(JSON.toJSONString(areaInfo));
        return JSON.toJSONString(areaInfo);
    }

    @RequestMapping(value = "postRepairApp", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String postRepairApp(@RequestBody String str) {
        try {
            str = URLDecoder.decode(str,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        RepairApp repairApp1 = new RepairApp();
        repairApp1 = JSON.parseObject(str,RepairApp.class);

        System.out.println(repairApp1.getMachineType()+" "+repairApp1.getAreaId()+" "+repairApp1.getMachineId()+" "+repairApp1.getAppUserId());

        //保存客户提交的repairApp
        RepairApp repairApp2 = new RepairApp();
        try {
            repairApp2 = repairAppRepo.save(repairApp1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (repairApp2.getAppCode() == null) {
            System.out.println("failed");
            return "failed";
        } else {
            System.out.println("success");
            return "success";
        }
    }


    @RequestMapping(value = "getMachineInfoByMachineCode", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String getMachineInfoByMachineCode(@RequestBody String str) throws JsonProcessingException {
        MachineInfo machineInfo = machineInfoRepo.findByMachineCode(str);
        System.out.println(JSON.toJSONString(machineInfo));
        return JSON.toJSONString(machineInfo);
    }

}

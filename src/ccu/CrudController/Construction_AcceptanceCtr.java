package ccu.CrudController;

import ccu.model.business.ProjectCheck;
import ccu.model.business.RepairApp;
import ccu.springDataDao.business.ProjectCheckRepo;
import ccu.springDataDao.business.RepairAppRepo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Courage on 2015/11/11.
 */

@RestController
@Transactional

public class Construction_AcceptanceCtr {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RepairAppRepo repairAppRepo;

    @Autowired
    private ProjectCheckRepo projectCheckRepo;
    /**
     * 根据状态获得维修申请单
     * 输入数据：step userid
     * 输出数据：lsit 的json串
     */
    @RequestMapping(value = "getRepairAppByStep",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getRepairAppByStep(@RequestBody String str)
    {
        JSONObject jsonObject = JSON.parseObject(str);
        List<RepairApp> list = new ArrayList<RepairApp>();
        try {
             list = repairAppRepo.findByStep(jsonObject.getInteger("step"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(list.size()>0)
        {
            return JSON.toJSONString(list);
        }
        else
        {
            return "null";
        }
    }

    /**
     * 根据客户端传来的数据来确认验收通过
     *
     * 输入数据：
     * 输出数据：
     */
    @RequestMapping(value = "checkProjectAccept",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String CheckProjectAccept(@RequestBody String str)
    {
        JSONObject jsonObject = JSON.parseObject(str);
        JSONObject jsonObject1 = JSON.parseObject(jsonObject.getString("projectcheck"));
        ProjectCheck projectCheck = JSON.toJavaObject(jsonObject1,ProjectCheck.class);
        int a=0;
        ProjectCheck projectCheck1 = new ProjectCheck();
        try
        {
            a=repairAppRepo.setFixedAppStatusAndStep("检验通过",6,jsonObject.getString("appcode"));
            projectCheck1 = projectCheckRepo.save(projectCheck);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if(a==0||projectCheck1==null)
        {
            return "failed";
        }
        else
        {
            return "success";
        }

    }
    /**
     * 根据客户端传来的数据来确认拒绝通过
     *
     * 输入数据：
     * 输出数据：
     */
    @RequestMapping(value = "checkProjectReject",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String CheckProjectReject(@RequestBody String str) {
        JSONObject jsonObject = JSON.parseObject(str);
        JSONObject jsonObject1 = JSON.parseObject(jsonObject.getString("projectcheck"));
        ProjectCheck projectCheck = JSON.toJavaObject(jsonObject1, ProjectCheck.class);
        int a = 0;
        ProjectCheck projectCheck1 = new ProjectCheck();
        try {
            a = repairAppRepo.setFixedAppStatusAndStep("检验未通过", 5, jsonObject.getString("appcode"));
            projectCheck1 = projectCheckRepo.save(projectCheck);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a == 0 || projectCheck1 == null) {
            return "failed";
        } else {
            return "success";
        }
    }
}


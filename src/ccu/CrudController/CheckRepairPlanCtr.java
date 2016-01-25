package ccu.CrudController;

import ccu.model.business.PlanExam;
import ccu.model.business.RepairApp;
import ccu.model.business.RepairPlan;
import ccu.springDataDao.business.PlanExamRepo;
import ccu.springDataDao.business.RepairAppRepo;
import ccu.springDataDao.business.RepairPlanRepo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Courage on 2015/10/31.
 */
@RestController
@Transactional

public class CheckRepairPlanCtr {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    RepairAppRepo repairAppRepo;

    @Autowired
    RepairPlanRepo repairPlanRepo;

    @Autowired
    PlanExamRepo planExamRepo;

    /**
     * 根据  地区 id 状态 和  为修部门   查询     维修申请信息
     * 输入数据: areaId  step  repairDepartmentId
     * 输出数据：repairApp 对象的josn 窜
     * @param str
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "getAllRepairApp",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getAllRepairApp(@RequestBody String str)throws JsonProcessingException
    {
        JSONObject jsonObject = JSON.parseObject(str);
        List<RepairApp> repairApp=repairAppRepo.findByAreaIdAndStepAndRepairDepartmentId(jsonObject.getString("areaId"), jsonObject.getInteger("step"), jsonObject.getString("repairDepartmentId"));
        return JSON.toJSONString(repairApp);
    }

    /**
     * 根据申请 ID 和 类型 查询             维修申请方案
     * 输入数据：appId  planType
     * 输出数据：返回的是  该申请单的   最新的维修方案
     * @param str
     * @return
     * @throws JsonProcessingException
     */

    @RequestMapping(value = "getAllRepairPlain",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getAllRepairPlain(@RequestBody String str)throws  JsonProcessingException
    {
        JSONObject jsonObject =JSON.parseObject(str);
        List<RepairPlan> repairPlan = repairPlanRepo.findByAppIdAndPlanType(jsonObject.getString("appId"),jsonObject.getString("planType"));
        //查询的计划可能是有多个，按时间比较提出最新的一个
        int a=0;
        for(int i=1;i<repairPlan.size();i++)
        {
            if(repairPlan.get(a).getSubmitTime().compareTo(repairPlan.get(i).getSubmitTime())<0)
                a=i;
        }
        return JSON.toJSONString(repairPlan.get(a));
    }

    /**
     * 提交  维修 检验
     * 输入数据：维修检验的相关数据
     * 输出数据：succeed  failed
     * @param str
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "postPlanExam",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public  String postPlanExam(@RequestBody String str)throws JsonProcessingException
    {
        JSONObject json =JSON.parseObject(str);
        PlanExam planExam = JSON.toJavaObject(json,PlanExam.class);
        PlanExam planExam1 = planExamRepo.save(planExam);
        if(planExam1==null)
        {
            return JSON.toJSONString("failed");
        }
        else return JSON.toJSONString("success");
    }

    /**
     * 根据 appcode 和planId  查询 待审核的    维保方案
     * 输入数据： appCode  planId
     * 输出数据： 待审核方案
     * 操作：根据repairApp 查询相关的planId
     */
    @RequestMapping(value = "getRepairPlanByAppCodeAndPlanId",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getRepairPlanByAppCodeAndPlanId(@RequestBody String str)
    {
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.getString("appcode")+"    "+jsonObject.getString("planid"));
        RepairPlan repairPlan = repairPlanRepo.findByAppCodeAndId(jsonObject.getString("appcode"), jsonObject.getString("planid"));
        return JSON.toJSONString(repairPlan);
    }
}

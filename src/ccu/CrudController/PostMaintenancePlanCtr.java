package ccu.CrudController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ccu.model.business.PlanExam;
import ccu.model.business.RepairApp;
import ccu.model.business.RepairPlan;
import ccu.model.system.UserInfo;
import ccu.springDataDao.basicData.AreaInfoRepo;
import ccu.springDataDao.business.PlanExamRepo;
import ccu.springDataDao.business.RepairAppRepo;
import ccu.springDataDao.business.RepairPlanRepo;
import ccu.springDataDao.system.RapidRecordDetailRepo;
import ccu.springDataDao.system.RapidRecordTypeRepo;
import ccu.springDataDao.system.UserInfoRepo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Courage on 2015/10/29.
 */


@RestController
@Transactional

public class PostMaintenancePlanCtr {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    RepairAppRepo repairAppRepo;

    @Autowired
    RapidRecordDetailRepo rapidRecordDetailRepo;

    @Autowired
    RapidRecordTypeRepo rapidRecordTypeRepo;

    @Autowired
    RepairPlanRepo repairPlanRepo;

    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    PlanExamRepo planExamRepo;

    @Autowired
    AreaInfoRepo areaInfoRepo;

    /**
     * 根据地区ID   申请用户ID  和状态  查询维修申请
     * @param repairApp
     * @return
     */
    @RequestMapping(value = "getRepairApp",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getRepairApp(@RequestBody String repairApp){
        JSONObject jsonObject = JSON.parseObject(repairApp);
        List<RepairApp> repairApp1 = new ArrayList<RepairApp>();
        try {
            repairApp1 =repairAppRepo.findByAreaIdAndAppUserIdAndStep(jsonObject.getString("areaId"),jsonObject.getString("appUserId"),jsonObject.getInteger("step"));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(repairApp1.size()>0)
            return JSON.toJSONString(repairApp1);
        else
            return "null";
    }
    /**
     * 维保用户查询维修申请
     * 通过维保用户ID查询到 自己的部门ID  之后通过部门ID和状态就在repairApp 中查询相关的维修申请
     * 传入数据   状态 step    维保用户userdi
     * 传出数据   json  串
     */
    @RequestMapping(value = "getRepairApp1",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getRepairApp1(@RequestBody String str ){
    	int pageNum = 0;
		int pageSize = 0;
        JSONObject jsonObject = JSON.parseObject(str);
        pageNum = jsonObject.getIntValue("pageNum");
        pageSize = jsonObject.getIntValue("pageSize");
        final int step = jsonObject.getInteger("step");
        UserInfo userInfo = new UserInfo();
        List<RepairApp> list =new ArrayList<RepairApp>();
        System.out.println(jsonObject.getString("userid")+"   " + jsonObject.getString("step"));
        userInfo = userInfoRepo.findOne(jsonObject.getString("userid"));
        final String repairDepartmentId =  userInfo.getRepairDepartmentId();
        Specification<RepairApp> specification = new Specification<RepairApp>() {
			
        	public Predicate toPredicate(Root<RepairApp> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				
        		Path path = root.get("repairDepartmentId");
        		Path path1 = root.get("step");
				query.where(cb.equal(path, repairDepartmentId),cb.equal(path1, step));
				return null;
			}
		};
        Pageable pageable = new PageRequest(pageNum,pageSize);
        
        Page page =repairAppRepo.findAll(specification, pageable);
        list = page.getContent();
        if(list.size()>=1)
            return JSON.toJSONString(list);
        else
            return "null";
    }
    /**
     * 根据 申请单号  查询  维修申请
     * 输入数据：给appcode 返回repairapp
     * 输出数据：
     * @param repairApp
     * @return
     */
    @RequestMapping(value = "getRepairApp2",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getRepairApp2(@RequestBody String repairApp){
        List<RepairApp> repairApp1 = new ArrayList<RepairApp>();
        try {
            repairApp1 =repairAppRepo.findByAppCode(repairApp);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if(repairApp1==null)
        {
            return "null";
        }
        else{
            return JSON.toJSONString(repairApp1);
        }
    }

    /**
     * 监管用户查询维修申请
     *
     * 传入数据   (状态 step userid) 现在操作是根据step 直接查询
     * 传出数据   json  串
     */
    @RequestMapping(value = "getRepairApp3", method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getRepairApp3(@RequestBody String str)
    {
    	int pageNum = 0;
		int pageSize = 0;
        JSONObject jsonObject = JSON.parseObject(str);
        pageNum = jsonObject.getIntValue("pageNum");
        pageSize = jsonObject.getIntValue("pageSize");
        final int step = jsonObject.getInteger("step");
        List<RepairApp> list = new ArrayList<RepairApp>();
        Specification<RepairApp> specification = new Specification<RepairApp>() {
			
        	public Predicate toPredicate(Root<RepairApp> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
        		Path path = root.get("step");
        		Predicate predicate =cb.equal(path, step);
        		return predicate;
        	}
		};
        Pageable pageable = new PageRequest(pageNum,pageSize);
        Page page = repairAppRepo.findAll(specification, pageable);
        list = page.getContent();
        if(list.size()>0)
            return JSON.toJSONString(list);
        else
            return "null";
    }
     
    /**
     * 提交维保方案
     * 输入数据：维保方案相关信息对象
     * 输出数据：返回是否成功  failed  success
     * @param str
     * @return
     */
    @RequestMapping(value = "postRepairPlan",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String postRepairPlan(@RequestBody String str){
        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        JSON json =JSON.parseObject(str);
        RepairPlan repairPlan =JSON.toJavaObject(json,RepairPlan.class);
        RepairPlan repairPlan1=new RepairPlan();
        List<RepairApp> list =new ArrayList<RepairApp>();
        try {
            repairPlan1 = repairPlanRepo.save(repairPlan);
            list = repairAppRepo.findByAppCode(repairPlan.getAppCode());
          //更新数据 step 和 planId  和 appStatus
            System.out.println("aaaaaaaaaaaaaaaa        "+list.get(0).getId());
            int p =repairAppRepo.setFixedStepAndPlanIdAndAppStatus(1,repairPlan1.getId(),"审核中",list.get(0).getId());
            System.out.println("dddddddddddddddd        "+p);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(repairPlan1==null)
        {
            return "failed";
        }
        else return "success";
    }

    /**
     * 驳回方案的操作
     * 输入数据： userid planid examdescription
     * 输出数据： success failed
     * 1 将step置为0
     * 2 将appStatus 设置为 “申请中”
     * 3 保存 方案审核表  ————用户输入审核用户标识
     */
    @RequestMapping(value = "DenyRepairPlan",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String  DenyRepairPlan(@RequestBody String str ){
        try
        {
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSON.parseObject(str);

        RepairPlan repairPlan = repairPlanRepo.findOne(jsonObject.getString("planid"));

        System.out.println(repairPlan.getId()+" ghghgdfgdfg    "+ repairPlan.getAppId());
        int p = repairAppRepo.setFixedStepAndAppStatusAndPlanIdById(0, "申请中",repairPlan.getId(),repairPlan.getAppId());
        List<RepairApp> repairApps = repairAppRepo.findByPlanId(jsonObject.getString("planid"));
        PlanExam planExam = new PlanExam();
        planExam.setAppCode(repairApps.get(0).getAppCode());
        planExam.setAppId(repairApps.get(0).getId());
        planExam.setPlanId(repairApps.get(0).getPlanId());
        planExam.setExamUserID(jsonObject.getString("userid"));
        planExam.setExamStatus("驳回");
        planExam.setExamTime(new java.util.Date());
      //如果需要就在考虑
        planExam.setExamDescription(jsonObject.getString("examdescription"));
        PlanExam planExam1 = planExamRepo.save(planExam);
        if(p>0||(planExam1!=null))
            return "success";
        else
            return "failed";
    }
    /**
     * 通过方案的操作
     * 输入数据： userid planid examdescription
     * 输出数据： success failed
     * 1 将step置为4
     * 2 将appStatus 设置为 “施工中”
     * 3 保存 方案审核表  ————用户输入审核用户标识
     */
    @RequestMapping(value = "AcceptRepairPlan",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String  AcceptRepairPlan(@RequestBody String str ){
        try
        {
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSON.parseObject(str);
        RepairPlan repairPlan = repairPlanRepo.findOne(jsonObject.getString("planid"));
        int p = repairAppRepo.setFixedStepAndAppStatusAndPlanIdById(4, "施工中",repairPlan.getId(), repairPlan.getAppId());
        List<RepairApp> repairApps = repairAppRepo.findByPlanId(jsonObject.getString("planid"));
        PlanExam planExam = new PlanExam();
        planExam.setAppCode(repairApps.get(0).getAppCode());
        planExam.setAppId(repairApps.get(0).getId());
        planExam.setPlanId(repairApps.get(0).getPlanId());
        planExam.setExamUserID(jsonObject.getString("userid"));
        planExam.setExamStatus("通过");
        planExam.setExamTime(new java.util.Date());
      //如果需要就在考虑
        planExam.setExamDescription(jsonObject.getString("examdescription"));
        PlanExam planExam1 = planExamRepo.save(planExam);
        if(p>0||(planExam1!=null))
            return "success";
        else
            return "failed";
    }
}

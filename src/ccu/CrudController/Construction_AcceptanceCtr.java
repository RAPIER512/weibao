package ccu.CrudController;

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

import ccu.model.business.ProjectCheck;
import ccu.model.business.RepairApp;
import ccu.springDataDao.business.ProjectCheckRepo;
import ccu.springDataDao.business.RepairAppRepo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
    	List<RepairApp> list = new ArrayList<RepairApp>();
    	int pageNum = 0;
    	int pageSize = 0;
        JSONObject jsonObject = JSON.parseObject(str);
		pageNum = jsonObject.getIntValue("pageNum");
		pageSize = jsonObject.getIntValue("pageSize");
        final int step = jsonObject.getInteger("step");
        Specification<RepairApp> specification = new Specification<RepairApp>() {
			
        	public Predicate toPredicate(Root<RepairApp> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Path path = root.get("step");
				Predicate predicate = cb.equal(path,step);
				return predicate;
			}
		};
        Pageable pageable = new PageRequest(pageNum,pageSize);
        Page page = repairAppRepo.findAll(specification, pageable);
        list = page.getContent();
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


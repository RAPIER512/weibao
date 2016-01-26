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

import ccu.model.business.RepairApp;
import ccu.springDataDao.business.RepairAppRepo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Courage on 2015/10/31.
 */


@RestController
@Transactional


public class Inspection_maintenance {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    RepairAppRepo repairAppRepo;

    /**
     * 根据地区Id  和状态查询维修申请
     *
     * 输入数据：维修申请的相关信息
     * 输出数据：维修申请的记录（list格式）
     *
     * @param str
     * @return
     */

    @RequestMapping(value = "getRepairAppResult",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public  String getRepairAppResult(@RequestBody String str)
    {
    	int pageNum = 0;
		int pageSize = 0;
    	List<RepairApp> list=new ArrayList<RepairApp>();
        JSONObject jsonObject = JSON.parseObject(str);
        pageNum = jsonObject.getIntValue("pageNum");
        pageSize = jsonObject.getIntValue("pageSize");
        final String areaId = jsonObject.getString("areaId");
        final int step = jsonObject.getInteger("step");
        Specification<RepairApp> specification = new Specification<RepairApp>() {
			
        	public Predicate toPredicate(Root<RepairApp> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				
        		Path path = root.get("areaId");
        		Path path1 = root.get("step");
				query.where(cb.equal(path, areaId),cb.equal(path1, step));
				return null;
			}
		};
        Pageable pageable = new PageRequest(pageNum,pageSize);
        Page page = repairAppRepo.findAll(specification, pageable);
        list = page.getContent();
        return  JSON.toJSONString(list);
    }




}

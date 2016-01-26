package ccu.CrudController;

import ccu.model.basicData.AreaInfo;
import ccu.model.system.UserInfo;
import ccu.springDataDao.basicData.AreaInfoRepo;
import ccu.springDataDao.system.UserInfoRepo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;

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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Courage on 2015/11/8.
 */
@RestController
@Transactional
public class AreaMessageCtr {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AreaInfoRepo areaInfoRepo;

    @Autowired
    private UserInfoRepo userInfoRepo;


    @RequestMapping(value = "getAreaInfos",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public String getAreaInfos(@RequestBody String str )throws JsonProcessingException{
        JSONObject jsonObject = JSON.parseObject(str);
        int pageNum = 0;
		int pageSize = 0;
		pageNum = jsonObject.getIntValue("pageNum");
		pageSize = jsonObject.getIntValue("pageSize");
        List<AreaInfo> list = new ArrayList<AreaInfo>();
        //普通用户
        if(jsonObject.getInteger("flag")==0)
        {
            UserInfo userInfo = userInfoRepo.findOne(jsonObject.getString("userid"));
            final String id = userInfo.getAreaId();
            Specification<AreaInfo> specification = new Specification<AreaInfo>() {
            	public Predicate toPredicate(Root<AreaInfo> root,
    					CriteriaQuery<?> query, CriteriaBuilder cb) {
    				
    				Path path = root.get("id");
    				Predicate predicate = cb.equal(path,id);
    				return predicate;
    			}
			};
            Pageable pageable = new PageRequest(pageNum,pageSize);
            
            
            Page page = areaInfoRepo.findAll(specification, pageable);
            list = page.getContent();
            System.out.println("普通用户     查询结果："+list);
        }
        //维保用户
        else if(jsonObject.getInteger("flag")==1)
        {
            UserInfo userInfo = userInfoRepo.findOne(jsonObject.getString("userid"));
            final String repairDepartmentId = userInfo.getRepairDepartmentId();
            Specification<AreaInfo> specification = new Specification<AreaInfo>() {
            	public Predicate toPredicate(Root<AreaInfo> root,
    					CriteriaQuery<?> query, CriteriaBuilder cb) {
    				
    				Path path = root.get("repairDepartmentId");
    				Predicate predicate = cb.equal(path,repairDepartmentId);
    				return predicate;
    			}
			};
            Pageable pageable = new PageRequest(pageNum,pageSize);
            
            Page page = areaInfoRepo.findAll(specification, pageable);
            list = page.getContent();
            System.out.println("维保用户    查询结果： "+list);
        }
        //监管用户
        else if(jsonObject.getInteger("flag")==2)
        {
            UserInfo userInfo = userInfoRepo.findOne(jsonObject.getString("userid"));
            final String areaManageId = userInfo.getAreaManageId();
            Specification<AreaInfo> specification =new Specification<AreaInfo>() {
				
            	public Predicate toPredicate(Root<AreaInfo> root,
    					CriteriaQuery<?> query, CriteriaBuilder cb) {
    				
    				Path path = root.get("areaManageId");
    				Predicate predicate = cb.equal(path,areaManageId);
    				return predicate;
    			}
			};
            Pageable pageable = new PageRequest(pageNum, pageSize);
            
            Page page = areaInfoRepo.findAll(specification, pageable);
            list = page.getContent();
            System.out.println("监管用户    查询结果： "+list);
        }
        else{
            return "flag输入有误";
        }
        if(list.size()>0) {
            return JSON.toJSONString(list);
        }else
            return "null";
    }
}

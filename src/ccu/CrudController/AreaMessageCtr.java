package ccu.CrudController;

import ccu.model.basicData.AreaInfo;
import ccu.model.system.UserInfo;
import ccu.springDataDao.basicData.AreaInfoRepo;
import ccu.springDataDao.system.UserInfoRepo;
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
        System.out.println("kaishi ");
        JSONObject jsonObject = JSON.parseObject(str);
        List<AreaInfo> list = new ArrayList<AreaInfo>();
        //普通用户
        System.out.println("dd0      "+jsonObject.getInteger("flag"));
        if(jsonObject.getInteger("flag")==0)
        {
            UserInfo userInfo = userInfoRepo.findOne(jsonObject.getString("userid"));
            AreaInfo areaInfo = areaInfoRepo.findOne(userInfo.getAreaId());
            list.add(areaInfo);
            System.out.println("dd1     "+list);
        }
        //维保用户
        else if(jsonObject.getInteger("flag")==1)
        {
            UserInfo userInfo = userInfoRepo.findOne(jsonObject.getString("userid"));
            list = areaInfoRepo.findByRepairDepartmentId(userInfo.getRepairDepartmentId());
            System.out.println("dd2     "+list);
        }
        //监管用户
        else if(jsonObject.getInteger("flag")==2)
        {
            UserInfo userInfo = userInfoRepo.findOne(jsonObject.getString("userid"));
            list = areaInfoRepo.findByAreaManageId(userInfo.getAreaManageId());
            System.out.println("dd3    "+list);
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

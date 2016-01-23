package ccu.CrudController;

import ccu.model.business.RepairApp;
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
        JSONObject jsonObject = JSON.parseObject(str);
        List<RepairApp> repairApp=new ArrayList<RepairApp>();
        try {
            repairApp=repairAppRepo.findByAreaIdAndStep(jsonObject.getString("areaId"),jsonObject.getInteger("step"));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return  JSON.toJSONString(repairApp);
    }




}

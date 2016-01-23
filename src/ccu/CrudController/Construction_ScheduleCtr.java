package ccu.CrudController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import ccu.model.business.PlanSchedule;
import ccu.model.business.RepairApp;
import ccu.springDataDao.business.PlanScheduleRepo;
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

/**
 * Created by Courage on 2015/11/11.
 */


@RestController
@Transactional

public class Construction_ScheduleCtr {

    @Autowired
    RepairAppRepo repairAppRepo;

    @Autowired
    PlanScheduleRepo planScheduleRepo;

    @Autowired
    private HttpServletRequest request;

    /**
     *提交施工进度
     *输入数据：PlanSchedl(对象)
     *输出数据：success  failed
     */
    @RequestMapping(value = "postConstruction_Schedule",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public  String postConstruction_Schedule(@RequestBody String str)
    {
    	try 
    	{
			str=URLDecoder.decode(str,"utf-8");
		} catch (UnsupportedEncodingException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject jsonObject = JSON.parseObject(str);
        PlanSchedule planSchedule = JSON.toJavaObject(jsonObject,PlanSchedule.class);
        PlanSchedule planSchedule1 = planScheduleRepo.save(planSchedule);

        if(planSchedule!=null)
        {
            return "success";
        }
        else
        {
            return "failed";
        }
    }

    /**
     *确认完工
     *输入数据：PlanSchedl(对象)
     *输出数据：success  failed
     */
    @RequestMapping(value = "finishedConstruction",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public  String finishedConstruction(@RequestBody String str)
    {
    	try 
    	{
			str=URLDecoder.decode(str,"utf-8");
		} catch (UnsupportedEncodingException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("appcoede shi "+str);
    	
    	JSONObject jsonObject = JSON.parseObject(str);
        PlanSchedule planSchedule = JSON.toJavaObject(jsonObject,PlanSchedule.class);
        PlanSchedule planSchedule1 = planScheduleRepo.save(planSchedule);
        int a =repairAppRepo.setFixedAppStatusAndStep("完工，待验收",5,planSchedule.getAppCode());
        if(a>0)
        {
        	System.out.println("成功提交");
            return "success";
        }
        else
        {
        	System.out.println("提交失败");
            return "failed";
        }
    }
}


package ccu.CrudController;

import ccu.model.business.Report;
import ccu.springDataDao.business.ReportRepo;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Courage on 2015/10/31.
 */
@RestController
@Transactional

public class ComplaintReportCtr_qudiao {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    ReportRepo reportRepo;

    /**
     * 提交维修举报（就是申报需要维修的相关设备）
     *
     * 输入数据：举报的相关信息
     * 输出数据：succeed  failed
     *
     * @param str
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "postReport",method = RequestMethod.POST,produces =  "text/plain;charset=UTF-8")
    public  String postReport(@RequestBody String str)throws JsonProcessingException
    {
        JSON json = JSON.parseObject(str);

        Report report = JSON.toJavaObject(json,Report.class);

        Report report1=reportRepo.save(report);

        if(report1.equals("null"))
        {
            return "failed";
        }
        else
            return "success";
    }
}

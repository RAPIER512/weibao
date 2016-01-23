package test;

import ccu.model.business.Report;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.*;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.util.Date;

/**
 * Created by Courage on 2015/10/31.
 */
public class testReport {

    @org.junit.Test
    public void postReport()
    {
        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/postReport");

        Report report = new Report();
        report.setReportName("sss");
        report.setReportTime(new Date());
        report.setReportDescription("dsdfsdf");
        report.setHandleResult("sdfs");
        report.setRecordTime(new Date());
        report.setRecordUserId("2ecbcfdb-d09a-42db-9059-ae43961a4376");

        String str = JSON.toJSONString(report);

        Representation s=clientResource.post(str);
        System.out.println(s);
    }
}

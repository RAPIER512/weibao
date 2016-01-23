package test;

import ccu.model.basicData.MachineInfo;
import ccu.model.business.RepairApp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.*;
import org.junit.Test;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;

/**
 * Created by Courage on 2015/10/31.
 */
public class Maintenance_application {
    @org.junit.Test
    public void testGetMachineInfo()
    {
        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getMachineInfo");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("machineId","9e1b551e-960d-4226-81b1-65b0408bf48f");

        String jsonString = jsonObject.toJSONString();

        System.out.println(jsonString);

        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println(resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test(){
        MachineInfo machineInfo = new MachineInfo();
        System.out.println(JSON.toJSONString(machineInfo));
    }
    @org.junit.Test
    public void testGetAppCode()
    {
        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getAppCode");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("machineId","9e1b551e-960d-4226-81b1-65b0408bf48f");

        String jsonString = jsonObject.toJSONString();

        System.out.println(jsonString);

        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println(resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void testGetRepairRecordDetail()
    {
        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getRepairRecordDetail");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("typeName","鏁呴殰绫诲瀷");

        String jsonString = jsonObject.toJSONString();

        System.out.println(jsonString);

        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println(resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @org.junit.Test
    public void testGetAreaInfo()
    {
        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getAreaInfo");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("areaId","9a7e1929-9035-405b-b736-0a4bf34fe911");

        String jsonString = jsonObject.toJSONString();

        System.out.println(jsonString);

        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println(resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @org.junit.Test
    public void testPostRepairApp()
    {
        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/postRepairApp");
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("areaId","9a7e1929-9035-405b-b736-0a4bf34fe911");
        RepairApp repairApp = new RepairApp();
        repairApp.setAppCode("0343");
        repairApp.setMachineId("9e1b551e-960d-4226-81b1-65b0408bf48f");
        repairApp.setMachineName("鎺㈠ご");
        repairApp.setMachineType("");
        repairApp.setErrorType("璁惧鐘舵��");
        repairApp.setIsRapadRepair(true);
        repairApp.setAreaId("f48516ed-0766-44c7-84cf-9fc39cf291cf");
        repairApp.setRepairDepartmentId("874ab533-ede4-4fdf-b54d-bc17a73b333e");
        repairApp.setStep(1);

        String jsonString = JSON.toJSONString(repairApp);

        System.out.println(jsonString);

        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println(resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

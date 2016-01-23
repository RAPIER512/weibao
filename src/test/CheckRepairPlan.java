package test;

import com.alibaba.fastjson.JSONObject;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;

/**
 * Created by Courage on 2015/11/7.
 */
public class CheckRepairPlan {

    @org.junit.Test
    public void getAllRepairApp()
    {
        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getAllRepairApp");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("areaId","188BCA81-8ED7-421B-BD96-7ECF75A1A1BB");
        jsonObject.put("step","0");
        jsonObject.put("repairDepartmentId","");

        String jsonString = jsonObject.toJSONString();

        System.out.println(jsonString);

        Representation resource = clientResource.post(jsonString);
        try {
            System.out.println(resource.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

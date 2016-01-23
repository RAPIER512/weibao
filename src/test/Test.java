package test;

import ccu.model.system.UserInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Courage on 2015/10/23.
 */
public class Test {

    @org.junit.Test
    public void testGet() {
        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getUserInfo");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","a");
        jsonObject.put("password","1");

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

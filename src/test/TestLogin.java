package test;

import ccu.model.system.UserInfo;
import com.alibaba.fastjson.JSONObject;
import org.hibernate.annotations.SourceType;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;

/**
 * Created by Courage on 2015/10/30.
 */
public class TestLogin {

    @org.junit.Test
    public void testLogin()
    {
//        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getSysmenus");
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("id","2ecbcfdb-d09a-42db-9059-ae43961a4376");
//        String str=jsonObject.toJSONString();
//        Representation s=clientResource.post(str);
//        System.out.println(s);

        ClientResource clientResource = new ClientResource("http://localhost:8888/weibao/getAreaInfos");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("flag","0");
        jsonObject.put("userid","d4059ebc-3585-48e3-ac20-58997ced6c65");
        String str=jsonObject.toJSONString();
        Representation s=clientResource.post(str);
        try {
            System.out.println(s.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
